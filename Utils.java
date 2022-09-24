package studentManagementSystem;

import studentManagementSystem.dataBase.AbstractDB;
import studentManagementSystem.schedule.Schedule;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static studentManagementSystem.University.students;
import static studentManagementSystem.University.teachers;


public class Utils {
    public static String teacherSurname;
    private static Teachers teacher;
    private static Students student;
    static Scanner scanner = new Scanner(System.in);
    public static boolean validationAllLine(String line){
        if(line.equals("")) return false;
        try{
            int choice = Integer.parseInt(line);
            if(choice > 3 || choice <= 0){
                System.err.println("Выберите пункт от 1 до 3");
                return false;
            }
            return true;
        } catch (Exception e){
            System.err.println("Введите корректное число!");
            return false;
        }
    }
    public static boolean bdIsEmpty(List<? extends AbstractDB> AbstractDB) throws InterruptedException {
        if(AbstractDB.isEmpty()){
            System.err.println("В базе данных нет ни одного зарегистрированного студента");
            Thread.sleep(100);
            return false;
        }
        return true;
    }
    public static boolean lineIsEmpty(String line){
        if(line.isEmpty() || line.isBlank()){
            System.err.println("Пустая строка");
            return false;
        }
        return true;
    }
    public static boolean validationOfLineForStudent(String line)  {
        char[] character = line.toCharArray();
        for(char ch : character){
            if(Character.isDigit(ch)){
                System.err.println("Тут не может быть цифр");
                return false;
            }
        }
        if(line.length() < 4){
            System.err.println("Необходимо как минимум 4 символа!");
            return false;
        }
        return true;
    }
    public static boolean loginNotAlreadyExists(List<? extends AbstractDB> AbstractDB, String log) throws InterruptedException {
        for(AbstractDB person : AbstractDB){
            if(person.getLogin().equals(log)){
                return true;
            }
        }
        System.err.println("Такой логин не зарегистрирован");
        Thread.sleep(100);
        return false;
    }
    public static boolean loginAlreadyExists(List<? extends AbstractDB> AbstractDB,String log){
        for(AbstractDB person : AbstractDB){
            if(person.getLogin().equals(log)){
                System.err.println("Такой студент уже зарегистрирован!");
                return false;
            }
        }
        return true;
    }

    public static boolean checkPassword(List<? extends AbstractDB> AbstractDB,String log,String password) throws InterruptedException {
        for(AbstractDB person: AbstractDB){
            if(person.getLogin().equals(log)){
                if(Arrays.equals(person.getPassword(), password.toCharArray())){
                    return true;
                }
                System.err.println("Неверный пароль!");
                Thread.sleep(100);
                return false;
            }
        }
        return true;
    }
    public static void menuForStudent(){
        String choice;
        while (true){
            System.out.println("1. Узнать свой факультет");
            System.out.println("2. Посмотреть свое расписание");
            System.out.println("3. Посмотреть список одногруппников");
            while (!Utils.validationAllLine((choice = scanner.nextLine()))){
            }
            switch (Integer.parseInt(choice)) {
                case 1 -> searchFaculty();
                case 2 -> getTimetable();
                case 3 -> getClassmates();
            }
        }
    }
    public static void getClassmates() {
        if (checkingForNull()) {
            students.forEach((a) -> {
                if (a.getSpecialization().getName().equals(student.getSpecialization().getName())
                        && a.getCourse() == student.getCourse()) {
                    System.out.println(a);
                    System.out.println("---------------------------------------");
                }
            });
        }
    }


    public static void getTimetable(){
        if(checkingForNull()){
            new Schedule(student);
        }
    }

    public static boolean checkingForNull(){
        if(student == null){
            System.err.println("Сначала узнайте свой факультет!");
            return false;
        }
        return true;
    }



    public static boolean searchFaculty(){
        if(student != null){
            System.out.print("Ваш факультет : ");
            System.out.println(student.getSpecialization().getName());
            return false;
        }
        String name,surname,courseLine;
        int course1;
        System.out.print("Введите ваше имя : ");
        name = scanner.nextLine().toLowerCase().trim();
        if(name.isEmpty()){
            System.err.println("Пустая строка!");
            return false;
        }
        System.out.print("Введите вашу фамилию : ");
        surname = scanner.nextLine().toLowerCase().trim();
        if(surname.isEmpty()){
            System.err.println("Пустая строка!");
            return false;
        }
        System.out.print("Введите ваш курс : ");
        try{
            courseLine = scanner.nextLine();
            course1 = Integer.parseInt(courseLine);
            if(course1 < 1 || course1 > 3){
                System.err.println("У нас всего 3 курса");
                return false;
            }
        } catch (Exception e){
            System.err.println("Неверно указан курс!");
            return false;
        }
        Students student = students.stream().
                filter((a) -> a.getName().equals(name) && a.getSurname().equals(surname)).
                findAny().
                orElse(null);
        if(student != null){
            if(student.getCourse() == course1){
                System.out.print("Ваш факультет : ");
                System.out.println(student.getSpecialization().getName());
                Utils.student = student;
                return true;
            }
        }
        System.err.println("Такого студента нет в нашем вузе");
        return false;
    }





    public static void menuForTeacher(){
        teacher = teachers.stream().filter((a) -> a.getSurname().equals(teacherSurname)).findFirst().orElse(null);
        if(teacher == null){
            return;
        }
        System.out.println("Здравствуйте, " + teacher.getName() + " " + teacher.getPatronymic());
        String choice;
        while (true){
            System.out.println("1. Добавить ученика на свой факультет");
            System.out.println("2. Исключить ученика с факультета");
            System.out.println("3. Посмотреть список студентов на факультете");
            while (!Utils.validationAllLine((choice = scanner.nextLine()))){
            }
            switch (Integer.parseInt(choice)) {
                case 1 -> {
                    if (!addStudent()) {
                        System.err.println("Попробуйте еще раз");
                    }
                }
                case 2 -> {
                    if(!deleteStudent()){
                        System.err.println("Попробуйте еще раз");
                    }
                }
                case 3 -> {
                    if (teacher.getSubject().studentsList() == null) {
                        System.err.println("На вашем факультете никто не учится");
                    } else {
                        System.out.println(teacher.getSubject().studentsList());
                    }
                }
            }
            }
        }

        public static boolean addStudent(){
            System.out.print("Укажите имя студента: ");
            String name = scanner.nextLine();
            if(validationOfLineForStudent(name)){
                System.out.print("Укажите фамилию студента: ");
                String surname = scanner.nextLine();
                if(validationOfLineForStudent(surname)){
                    try{
                        System.out.print("Укажите курс студента: ");
                        String course = scanner.nextLine();
                        if(Integer.parseInt(course) < 1 || Integer.parseInt(course) > 3){
                            System.err.println("Неверно указан курс (от 1 до 3!)");
                            return false;
                        }
                        if(teacher.getSubject().addNewStudent(new Students(name,surname,Integer.parseInt(course),teacher.getSubject()))){
                            System.out.println("Студент был добавлен!");
                            return true;
                        } else {
                            return false;
                        }
                    } catch (NumberFormatException e){
                        System.err.println("Неккоректно указан курс (1-3)");
                        return false;
                    }
                }
                return false;
            }
            return false;

        }
        public static boolean deleteStudent(){
            List<Students> list = teacher.getSubject().studentsList();
          if(list.isEmpty()){
            System.err.println("На вашем факультете никто не учится!");
            return false;
        }
            int count = 1;
            for (Students value : list) {
                System.out.print(count + ". " + value);
                count++;
            }
            System.out.println("Укажите цифру студента, которого хотите исключить: ");
          try{
              int numb = scanner.nextInt();
              if(numb > list.size()){
                  System.err.println("Такого студента нет");
                  return false;
              }
              if(teacher.getSubject().studentExpulsion(list.get(numb - 1))){
                  System.out.println("Студент был отчислен!");
                  return true;
              } else {
                  return false;
              }
          } catch (Exception e){
              System.err.println("Укажите корректно цифру!");
              return false;
          }
        }


}

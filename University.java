package studentManagementSystem;

import studentManagementSystem.dataBase.BaseStudent;
import studentManagementSystem.dataBase.BaseTeachers;
import studentManagementSystem.specialties.Economy;
import studentManagementSystem.specialties.Engineers;
import studentManagementSystem.specialties.Programming;
import studentManagementSystem.specialties.Specialties;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class University {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String GREEN_UNDERLINED = "\033[4;32m";
    private static final String NAME = "ВГТУ";
    Scanner scanner = new Scanner(System.in);
    Specialties economy = new Economy();
    Specialties programming = new Programming();
    Specialties engineers = new Engineers();
    BaseStudent baseStudent = new BaseStudent();
    BaseTeachers baseTeachers = new BaseTeachers();
    static List<Students> students = new ArrayList<>();
    static List<Teachers> teachers = new ArrayList<>();
    /*
    Заранее добавляются преподаватели, которые являются кураторами.
    Только они могут добавлять студентов на свой курс или исключать их.
    Важно отличать студентов находящихся в базе данных, и студентов находящихся на обучении
    baseStudent != students
     */
    {
        teachers.add(new Teachers("Ольга","Виноградова","Петровна",economy));
        teachers.add(new Teachers("Иван","Миленный","Сергеевич", engineers));
        teachers.add(new Teachers("Максим","Иванов","Николаевич",programming));
        students.add(new Students("максим","виноградов",3,economy));
        economy.addNewStudent(students.get(0));
        students.add(new Students("иван","строков",2,engineers));
        engineers.addNewStudent(students.get(1));
        students.add(new Students("олег","кириешкин",1,programming));
        programming.addNewStudent(students.get(2));
    }

    University() throws InterruptedException {
        System.out.println("Приветствуем вас в " + NAME);
        switch (mainValidation()) {
            case 1 -> Utils.menuForTeacher();
            case 2 -> Utils.menuForStudent();
        }
    }

    public int mainValidation() throws InterruptedException {
        String choice;
        while (true) {
            System.out.println("Авторизоваться как преподаватель или как студент?");
            System.out.println("1. Преподаватель");
            System.out.println("2. Студент");
            System.out.println("3. Я еще не зарегистрирован на сайте (для студентов)");
            while (!Utils.validationAllLine((choice = scanner.nextLine()))){
                System.err.println("Попробуйте еще раз");
            }
            switch (Integer.parseInt(choice)) {
                case 1 -> {
                    if (!baseTeachers.Authorization()) {
                        break;
                    }
                    System.out.println(GREEN_UNDERLINED + "Вы авторизовались как преподаватель!" + ANSI_RESET);

                    return 1;
                }
                case 2 -> {
                    if (!baseStudent.Authorization()) {
                        break;
                    }
                    System.out.println(GREEN_UNDERLINED + "Вы авторизовались как студент!" + ANSI_RESET);
                    return 2;
                }
                case 3 -> baseStudent.addNewAccount();
            }
        }
    }
}

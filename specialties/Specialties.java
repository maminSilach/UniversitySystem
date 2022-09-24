package studentManagementSystem.specialties;

import studentManagementSystem.Students;

import java.util.ArrayList;
import java.util.List;

abstract public class Specialties {
    protected String name;
    List<Students> students = new ArrayList<>();

    public boolean studentExpulsion(Students student) {
        if(students.contains(student)){
            students.remove(student);
            return true;
        }
            System.out.println("Такого студента нет в списке");
            return false;

    }

    public boolean addNewStudent(Students student) {
        for (Students students : students){
            if (students.equals(student) ||
                    (students.getCourse() == student.getCourse() && students.getSurname().equals(student.getSurname()))){
                System.err.println("Такой студент уже сущесвует на данном курсе!");
                return false;
            }
        }
        students.add(student);
        return true;
    }


    public List<Students> studentsList() {
        return students;
    }

    public String getName() {
        return name;
    }
}

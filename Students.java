package studentManagementSystem;

import studentManagementSystem.specialties.Specialties;

public class Students {
    private String name;
    private String surname;
    private int course;
    private Specialties specialization;

    public Students() {
    }

    public Students(String name, String surname, int course, Specialties specialization) {
        this.name = name;
        this.surname = surname;
        this.course = course;
        this.specialization = specialization;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public Specialties getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialties specialization) {
        this.specialization = specialization;
    }


    @Override
    public String toString() {
        return "Информация о студенте: " +
                "Имя: '" + name + '\'' +
                " Фамилия: " + surname + '\'' +
                " Курс: " + course +
                " Специальность: " + specialization.getName() + "\n";
    }

}

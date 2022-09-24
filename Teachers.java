package studentManagementSystem;

import studentManagementSystem.specialties.Specialties;

public class Teachers {
    private String name;
    private String surname;
    private String patronymic;
    private Specialties subject;

    public Teachers(String name,String surname, String patronymic, Specialties subject) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Specialties getSubject() {
        return subject;
    }

    public void setSubject(Specialties subject) {
        this.subject = subject;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
}

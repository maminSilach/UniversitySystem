package studentManagementSystem.dataBase;


import studentManagementSystem.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Автоматически в базу данных добавляются кураторы.
Под этими данными можно зайти как преподаватель.
 */

public class BaseTeachers extends AbstractDB{
     List<BaseTeachers> teachersDB = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    public BaseTeachers(){
        teachersDB.add(new BaseTeachers("Виноградова", "qwerty".toCharArray()));
        teachersDB.add(new BaseTeachers("Миленный", "qwerty1".toCharArray()));
        teachersDB.add(new BaseTeachers("Иванов", "qwerty12".toCharArray()));
        teachersDB.add(new BaseTeachers("Сергеев", "qwerty123".toCharArray()));
    }
    public BaseTeachers(String login,char[] password){
        this.login = login;
        this.password = password;
    }

    @Override
    public boolean Authorization() throws InterruptedException {
        if (Utils.bdIsEmpty(teachersDB)) {
            System.out.print("Укажите ваш логин : ");
            String log = scanner.nextLine().trim();
            if (Utils.lineIsEmpty(log)) {
                if (Utils.loginNotAlreadyExists(teachersDB, log)) {
                    System.out.print("Укажите ваш пароль : ");
                    String pass = scanner.nextLine().trim();
                    if (Utils.checkPassword(teachersDB, log, pass)) {
                        Utils.teacherSurname = log;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "login='" + login;
    }
}

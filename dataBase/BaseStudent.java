package studentManagementSystem.dataBase;


import studentManagementSystem.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseStudent extends AbstractDB{
    List<BaseStudent> studentsDB = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public BaseStudent(){}
    private BaseStudent(String login, char[] password) {
        this.login = login;
        this.password = password;
    }



    public boolean addNewAccount() {
            System.out.println( "Укажите логин,который хотели бы использовать" );
            String log  = scanner.nextLine().trim();
            if(Utils.lineIsEmpty(log)){
                if(Utils.loginAlreadyExists(studentsDB,log)){
                    System.out.println("Теперь укажите пароль");
                    String pass = scanner.nextLine().trim();
                    if(pass.length() < 4){
                        System.err.println("Пароль должен состоять как минимум из 4 символов!");
                        return false;
                    }
                    password = pass.toCharArray();
                    studentsDB.add(new BaseStudent(log,password));
                    System.out.println(GREEN_UNDERLINED + "Ваш аккаунт был добавлен!" + ANSI_RESET);
                    return true;
                }
            }
            return false;
    }

    @Override
    public boolean Authorization() throws InterruptedException {
        if(Utils.bdIsEmpty(studentsDB)){
            System.out.print("Укажите ваш логин : ");
            String log = scanner.nextLine().trim();
            if(Utils.lineIsEmpty(log)){
                if(Utils.loginNotAlreadyExists(studentsDB,log)){
                    System.out.print("Укажите ваш пароль : ");
                    String pass = scanner.nextLine().trim();
                    return Utils.checkPassword(studentsDB,log, pass);
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "login='" + login + '\'' + '}';
    }


}

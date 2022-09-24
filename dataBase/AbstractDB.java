package studentManagementSystem.dataBase;

abstract public class AbstractDB {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String GREEN_UNDERLINED = "\033[4;32m";
    protected String login;
    protected char [] password;
    abstract public boolean Authorization() throws InterruptedException;

    public String getLogin() {
        return login;
    }

    public char[] getPassword() {
        return password;
    }
}

package studentManagementSystem.schedule.course1.Engineers;

import studentManagementSystem.schedule.Schedule;



public class TimeTableOfEngineersCourse1 extends Schedule {
    public static void getTimeTableOfEngineers(){
        System.out.println(localDateTime.getDayOfMonth() + " " + localDateTime.getMonth());
        System.out.println("Ваше расписание на неделю: ");
        monday();tuesday();wednesday();thursday();friday();saturday();sunday();
    }
    public static void monday(){
        System.out.println(ANSI_BLUE + "                  Понедельник " + ANSI_RESET);
        System.out.println("1-я пара(8:30 - 10:00)");
        System.out.println("Элементы теории фредгольмовых отображений [аудитория 3304]");
        System.out.println("2-я пара(10:15-11:50)");
        System.out.println("Физкультура [спортзал]");
        System.out.println("3-я пара(12:00 - 13:35)");
        System.out.println("Обратные задачи для динамических систем  [аудитория 1420]");
    }
    public static void tuesday(){
        System.out.println(ANSI_BLUE + "                  Вторник " + ANSI_RESET);
        System.out.println("1-я пара(8:30 - 10:00)");
        System.out.println("Элементы теории фредгольмовых отображений [аудитория 2304]");
        System.out.println("4-я пара(14:20 - 15:55)");
        System.out.println("Об одномерных вариационных задачах Бахтина  [аудитория 4405]");
    }
    public static void wednesday(){
        System.out.println(ANSI_BLUE + "                  Среда " + ANSI_RESET);
        System.out.println("6-я пара(17:50 - 19:25)");
        System.out.println("Эконометрические модели [аудитория 2420]");
        System.out.println("7-я пара(19:35 - 21:10)");
        System.out.println("Физкультура [спортзал]");
    }
    public static void thursday(){
        System.out.println(ANSI_BLUE + "                  Четверг " + ANSI_RESET);
        System.out.println("Выходной");
    }
    public static void friday(){
        System.out.println(ANSI_BLUE + "                  Пятница " + ANSI_RESET);
        System.out.println("2-я пара(10:15-11:50)");
        System.out.println("Философия [аудитория 5305]");
        System.out.println("4-я пара(14:20 - 15:55)");
        System.out.println("Об одномерных вариационных задачах Бахтина  [аудитория 4405]");
    }
    public static void saturday(){
        System.out.println(ANSI_BLUE + "                  Суббота " + ANSI_RESET);
        System.out.println("Выходной");
    }
    public static void sunday(){
        System.out.println(ANSI_BLUE + "                  Воскресенье " + ANSI_RESET);
        System.out.println("Выходной");
        System.out.println();
    }
}

package studentManagementSystem.schedule.course3.Economy;

import studentManagementSystem.schedule.Schedule;

public class TimeTableOfEconomyCourse3 extends Schedule {
    public static void getTimeTableOfEconomy(){
        System.out.println(localDateTime.getDayOfMonth() + " " + localDateTime.getMonth());
        System.out.println("Ваше расписание на неделю: ");
        monday();tuesday();wednesday();thursday();friday();saturday();sunday();
    }
    public static void monday(){
        System.out.println(ANSI_BLUE + "                  Понедельник " + ANSI_RESET);
        System.out.println("5-я пара(16:05 - 17:40)");
        System.out.println("Анализ и проектирование [аудитория 6146]");
    }
    public static void tuesday(){
        System.out.println(ANSI_BLUE + "                  Вторник " + ANSI_RESET);
        System.out.println("1-я пара(8:30 - 10:00)");
        System.out.println("Экономика [аудитория 2305]");
        System.out.println("2-я пара(10:15-11:50)");
        System.out.println("Физкультура [спортзал]");
        System.out.println("4-я пара(14:20 - 15:55)");
        System.out.println("Теория экономических систем [аудитория 4505]");

    }
    public static void wednesday(){
        System.out.println(ANSI_BLUE + "                  Среда " + ANSI_RESET);
        System.out.println("3-я пара(12:00 - 13:35)");
        System.out.println("Проектирование [аудитория 2420]");
        System.out.println("4-я пара(14:20 - 15:55)");
        System.out.println("Физкультура [спортзал]");

    }
    public static void thursday(){
        System.out.println(ANSI_BLUE + "                  Четверг " + ANSI_RESET);
        System.out.println("1-ая пара(8:30 - 10:00");
        System.out.println("Математика [аудитория 1420]");

    }
    public static void friday(){
        System.out.println(ANSI_BLUE + "                  Пятница " + ANSI_RESET);
        System.out.println("Выходной");
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

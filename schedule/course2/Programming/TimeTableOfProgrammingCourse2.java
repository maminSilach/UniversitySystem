package studentManagementSystem.schedule.course2.Programming;

import studentManagementSystem.schedule.Schedule;

public class TimeTableOfProgrammingCourse2 extends Schedule {
    public static void getTimeTableOfProgramming(){
        System.out.println(localDateTime.getDayOfMonth() + " " + localDateTime.getMonth());
        System.out.println("Ваше расписание на неделю: ");
        monday();tuesday();wednesday();thursday();friday();saturday();sunday();
    }
    public static void monday(){
        System.out.println(ANSI_BLUE + "                  Понедельник " + ANSI_RESET);
        System.out.println("3-я пара(12:00 - 13:35)");
        System.out.println("Математика [аудитория 2420]");
        System.out.println("4-я пара(14:20 - 15:55)");
        System.out.println("Физкультура [спортзал]");
    }
    public static void tuesday(){
        System.out.println(ANSI_BLUE + "                  Вторник " + ANSI_RESET);
        System.out.println("2-я пара(14:20 - 15:55)");
        System.out.println("Анализ и проектирование на UML  [аудитория 4303]");
    }
    public static void wednesday(){
        System.out.println(ANSI_BLUE + "                  Среда " + ANSI_RESET);
        System.out.println("2-я пара(14:20 - 15:55)");
        System.out.println("Концептуальное, функциональное и логическое проектирование информационных систем [аудитория 1606]");

    }
    public static void thursday(){
        System.out.println(ANSI_BLUE + "                  Четверг " + ANSI_RESET);
        System.out.println("1-я пара(8:30 - 10:00)");
        System.out.println("Основы алгоритмизации и структур данных [аудитория 2420]");
        System.out.println("2-я пара(14:20 - 15:55)");
        System.out.println("Концептуальное, функциональное и логическое проектирование информационных систем [аудитория 1606]");
        System.out.println("3-я пара(12:00 - 13:35)");
        System.out.println("Математика [аудитория 2420]");
    }
    public static void friday(){
        System.out.println(ANSI_BLUE + "                  Пятница " + ANSI_RESET);
        System.out.println("1-я пара(8:30 - 10:00)");
        System.out.println("Теория информационных процессов и систем [аудитория 4420]");
        System.out.println("2-я пара(14:20 - 15:55)");
        System.out.println("Анализ и проектирование на UML  [аудитория 4403]");
        System.out.println("3-я пара(12:00 - 13:35)");
        System.out.println("Математика [аудитория 2420]");

    }
    public static void saturday(){
        System.out.println(ANSI_BLUE + "                  Суббота " + ANSI_RESET);
        System.out.println("Суббота");
    }
    public static void sunday(){
        System.out.println(ANSI_BLUE + "                  Воскресенье " + ANSI_RESET);
        System.out.println("Выходной");
        System.out.println();
    }
}

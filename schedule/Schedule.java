package studentManagementSystem.schedule;

import studentManagementSystem.Students;
import studentManagementSystem.schedule.course1.Economy.TimeTableOfEconomyCourse1;
import studentManagementSystem.schedule.course1.Engineers.TimeTableOfEngineersCourse1;
import studentManagementSystem.schedule.course1.Programming.TimeTableOfProgrammingCourse1;
import studentManagementSystem.schedule.course2.Economy.TimeTableOfEconomyCourse2;
import studentManagementSystem.schedule.course2.Engineers.TimeTableOfEngineersCourse2;
import studentManagementSystem.schedule.course2.Programming.TimeTableOfProgrammingCourse2;
import studentManagementSystem.schedule.course3.Economy.TimeTableOfEconomyCourse3;
import studentManagementSystem.schedule.course3.Engineers.TimeTableOfEngineersCourse3;
import studentManagementSystem.schedule.course3.Programming.TimeTableOfProgrammingCourse3;
import java.time.LocalDateTime;


public class Schedule {
    protected static final String ANSI_RESET = "\u001B[0m";
    protected static final String ANSI_BLUE = "\u001B[34m";
    protected static LocalDateTime localDateTime = LocalDateTime.now();
    public String name2 = "";
    public Schedule(){}
    public Schedule(Students student) {
        if(student.getCourse()==1){
                switch (student.getSpecialization().getName()){
                    case "Экономика" -> TimeTableOfEconomyCourse1.getTimeTableOfEconomy();
                    case "Инженерика" -> TimeTableOfEngineersCourse1.getTimeTableOfEngineers();
                    case "Информатика" -> TimeTableOfProgrammingCourse1.getTimeTableOfProgramming();
                }
            }
        if(student.getCourse()==2){
            switch (student.getSpecialization().getName()){
                case "Экономика" -> TimeTableOfEconomyCourse2.getTimeTableOfEconomy();
                case "Инженерика" -> TimeTableOfEngineersCourse2.getTimeTableOfEngineers();
                case "Информатика" -> TimeTableOfProgrammingCourse2.getTimeTableOfProgramming();
            }
        }
        if(student.getCourse()==3){
            switch (student.getSpecialization().getName()){
                case "Экономика" -> TimeTableOfEconomyCourse3.getTimeTableOfEconomy();
                case "Инженерика" -> TimeTableOfEngineersCourse3.getTimeTableOfEngineers();
                case "Информатика" -> TimeTableOfProgrammingCourse3.getTimeTableOfProgramming();
            }
        }

    }
}




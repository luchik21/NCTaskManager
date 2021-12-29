package ua.edu.sumdu.j2se.zalotov.tasks.View;

import ua.edu.sumdu.j2se.zalotov.tasks.Controller.Controller;
import ua.edu.sumdu.j2se.zalotov.tasks.Model.AbstractTaskList;
import ua.edu.sumdu.j2se.zalotov.tasks.Model.Task;
import ua.edu.sumdu.j2se.zalotov.tasks.Model.Tasks;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.SortedMap;

public class CalendarView implements View {
    @Override
    public int printInfo(AbstractTaskList taskList) {
        LocalDateTime startTime = timeTaskStart();
        if(startTime.isBefore(LocalDateTime.now())){
            System.out.println("entered date is earlier than now");
            return Controller.CALENDAR_ACTION;
        }
        LocalDateTime endTime = timeTaskEnd();
        if ((endTime.isBefore(LocalDateTime.now()))) {
            System.out.println("entered date is earlier than now");
            return Controller.CALENDAR_ACTION;
        }
        SortedMap<LocalDateTime, Set<Task>> calendarView = Tasks.calendar(taskList, startTime, endTime);
        for (SortedMap.Entry<LocalDateTime, Set<Task>> element : calendarView.entrySet()) {
            for (Task task : element.getValue()) {
                System.out.print("Task -> " + task.getTitle() + ", scheduled time = ");
            }
            System.out.println(element.getKey() + "\n");
        }
        return Controller.MAIN_MENU_ACTION;
    }

    public int taskChoose() {
        System.out.println("Calendar");
        System.out.println("1 - calendar (from - to),  2 - calendar for week, 3 - back to menu");
        int taskType = 0;
        try {
            taskType = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return taskType;
    }

    public LocalDateTime timeTaskStart() {
        System.out.println("Start date (example: 2021-12-12 12:00)");
        String date = "";
        try {
            date = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime start = LocalDateTime.parse(date, formatter);
        return start;
    }

    public LocalDateTime timeTaskEnd() {
        System.out.println("End date (example: 2021-12-12 12:00)");
        String date = "";
        try {
            date = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime end = LocalDateTime.parse(date, formatter);
        return end;
    }

    public int calendarFor7Days(AbstractTaskList taskList) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = startTime.plusDays(7);
        System.out.println("Your calendar from " + startTime.format(formatter) + " to " + endTime.format(formatter));
        SortedMap<LocalDateTime, Set<Task>> calendarView = Tasks.calendar(taskList, startTime, endTime);
        for (SortedMap.Entry<LocalDateTime, Set<Task>> element : calendarView.entrySet()) {
            for (Task task : element.getValue()) {
                System.out.print("Task -> " + task.getTitle() + ", scheduled time = ");
            }
            System.out.println(element.getKey() + "\n");//ключ=время
        }
        return Controller.MAIN_MENU_ACTION;
    }
}


package ua.edu.sumdu.j2se.zalotov.tasks.View;

import ua.edu.sumdu.j2se.zalotov.tasks.Controller.Controller;
import ua.edu.sumdu.j2se.zalotov.tasks.Model.AbstractTaskList;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddTaskView implements View{
    @Override
    public int printInfo(AbstractTaskList taskList) {
        System.out.println("New task added");
        return Controller.MAIN_MENU_ACTION;
    }

    public int taskChoose() {
        System.out.println("Task type");
        System.out.println("1 - non repeatable");
        System.out.println("2 - repeatable");
        int taskType = 0;
        try {
            String indexIn = reader.readLine();
            taskType = Integer.parseInt(indexIn);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return taskType;
    }

    public String nameTask() {
        System.out.println("Task title");
        String name = "";
        try {
            name = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }

    public LocalDateTime timeTask() {
        System.out.println("Date (example: 2021-12-12 12:00)");
        String date = "";
        try {
            date = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime time = LocalDateTime.parse(date, formatter);
        return time;
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

    public int repeatInterval() {
        System.out.println("Interval");
        int interval = 0;
        try {
            String time = reader.readLine();
            interval = Integer.parseInt(time);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return interval;
    }
}

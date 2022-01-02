package ua.edu.sumdu.j2se.zalotov.tasks.View;

import ua.edu.sumdu.j2se.zalotov.tasks.Controller.Controller;
import ua.edu.sumdu.j2se.zalotov.tasks.Model.AbstractTaskList;
import ua.edu.sumdu.j2se.zalotov.tasks.Model.Error;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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
        System.out.println("3 - back to menu");
        int taskType;
        try {
            String indexIn = reader.readLine();
            taskType = Integer.parseInt(indexIn);
        } catch (IOException | NumberFormatException e) {
            return -1;
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
        return time();
    }

    public LocalDateTime timeTaskStart() {
        System.out.println("Start date (example: 2021-12-12 12:00)");
        return time();
    }

    public LocalDateTime timeTaskEnd() {
        System.out.println("End date (example: 2021-12-12 12:00)");
        return time();
    }

    public int repeatInterval() {
        System.out.println("Interval");
        int interval = 0;
        try {
            String time = reader.readLine();
            interval = Integer.parseInt(time);
        } catch (IOException e) {
            System.out.println(Error.UNEXPECTED_INTERVAL);
        }
        return interval;
    }

    private LocalDateTime time(){
        String date = "";
        try {
            date = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        LocalDateTime time = LocalDateTime.of(1,1,1,1,1);
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            time = LocalDateTime.parse(date, formatter);
        } catch (DateTimeParseException e) {
            return time;
        }
        return time;
    }
}

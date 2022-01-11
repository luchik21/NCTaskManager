package ua.edu.sumdu.j2se.zalotov.tasks.View;

import ua.edu.sumdu.j2se.zalotov.tasks.Controller.Controller;
import ua.edu.sumdu.j2se.zalotov.tasks.Model.AbstractTaskList;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ChangeTaskView implements View {
    @Override
    public int printInfo(AbstractTaskList taskList) {
        System.out.println("task changed");
        return Controller.MAIN_MENU_ACTION;
    }

    public int taskChoose() {//выбор пункта меню
        System.out.println("1 change task param,  2 back to menu");
        int taskType = 0;
        try {
            String indexIn = reader.readLine();
            taskType = Integer.parseInt(indexIn);
        } catch (IOException | NumberFormatException e) {
            return -1;
        }
        return taskType;
    }

    public int index() {//индекс задания
        System.out.print("Enter task index: ");
        int index = 0;
        try {
            String indexIn = reader.readLine();
            index = Integer.parseInt(indexIn);
        } catch (IOException | NumberFormatException e) {
            return -1;
        }
        return index;
    }

    public int taskChooseNon() {//не повтор задание
        System.out.println("1 - change name,  2 - change date,  3 - back");
        int taskType = 0;
        try {
            String indexIn = reader.readLine();
            taskType = Integer.parseInt(indexIn);
        } catch (IOException | NumberFormatException e) {
            return -1;
        }
        return taskType;
    }

    public int taskChooseRep() {//повтор задание
        System.out.println("1 - change name,  2 - change date,  3 - change interval,  4 - back");
        int taskType = 0;
        try {
            String indexIn = reader.readLine();
            taskType = Integer.parseInt(indexIn);
        } catch (IOException | NumberFormatException e) {
            return -1;
        }
        return taskType;
    }

    public int interval() {//задаем интервал
        System.out.print("Enter interval: ");
        int interval = 0;
        try {
            String indexIn = reader.readLine();
            interval = Integer.parseInt(indexIn);
        } catch (IOException | NumberFormatException e) {
            return -1;
        }
        return interval;
    }

    public LocalDateTime timeTask() {//задаем время
        System.out.print("Enter new date (example: 2021-12-12 12:00): ");
        return time();
    }

    public LocalDateTime timeTaskStart() {//задаем время
        System.out.print("Enter new start date (example: 2021-12-12 12:00): ");
        return time();
    }

    public LocalDateTime timeTaskEnd() {//задаем время
        System.out.print("Enter new end date (example: 2021-12-12 12:00): ");
        return time();
    }

    public String titleNew() {//задаем новое название
        System.out.print("Enter new title: ");
        String name = "";
        try {
            name = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }

    private LocalDateTime time() {//время
        String date = "";
        try {
            date = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        LocalDateTime time = LocalDateTime.of(1, 1, 1, 1, 1);
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            time = LocalDateTime.parse(date, formatter);
        } catch (DateTimeParseException e) {
            return time;
        }
        return time;
    }
}
package ua.edu.sumdu.j2se.zalotov.tasks.View;

import ua.edu.sumdu.j2se.zalotov.tasks.Controller.Controller;
import ua.edu.sumdu.j2se.zalotov.tasks.Model.AbstractTaskList;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChangeTaskView implements View{
    @Override
    public int printInfo(AbstractTaskList taskList) {
        System.out.println("task changed");
        return Controller.MAIN_MENU_ACTION;
    }


    public int taskChoose() {
        System.out.println("1 change task param,  2 back to menu");
        int taskType = 0;
        try {
            String indexIn = reader.readLine();
            taskType = Integer.parseInt(indexIn);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return taskType;
    }

    public int index() {
        System.out.print("enter task id: ");
        int index = 0;
        try {
            String indexIn = reader.readLine();
            index = Integer.parseInt(indexIn);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return index;
    }

    public int taskChooseNon() {
        System.out.println("1 - change name,  2 - change date,  3 - back");
        int taskType = 0;
        try {
            String indexIn = reader.readLine();
            taskType = Integer.parseInt(indexIn);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return taskType;
    }

    public int taskChooseRep() {
        System.out.println("1 - change name,  2 - change date,  3 - change interval,  4 - back");
        int taskType = 0;
        try {
            String indexIn = reader.readLine();
            taskType = Integer.parseInt(indexIn);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return taskType;
    }

    public int interval() {
        System.out.print("enter interval ");
        int interval = 0;
        try {
            String indexIn = reader.readLine();
            interval = Integer.parseInt(indexIn);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return interval;
    }

    public LocalDateTime time() {
        System.out.print("Date (example: 2021-12-12 12:00)");
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

    public LocalDateTime startTime() {
        System.out.print("Start date (example: 2021-12-12 12:00)");
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

    public LocalDateTime endTime() {
        System.out.print("End date (example: 2021-12-12 12:00)");
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

    public String titleNew() {
        System.out.print("New title:");
        String name = "";
        try {
            name = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }
}
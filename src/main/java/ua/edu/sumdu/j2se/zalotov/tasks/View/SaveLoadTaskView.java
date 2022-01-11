package ua.edu.sumdu.j2se.zalotov.tasks.View;

import ua.edu.sumdu.j2se.zalotov.tasks.Controller.Controller;
import ua.edu.sumdu.j2se.zalotov.tasks.Model.AbstractTaskList;

import java.io.IOException;

public class SaveLoadTaskView implements View {
    int info;
    @Override
    public int printInfo(AbstractTaskList taskList) {//инфо
        if (info == 1) {
            System.out.println("Tasks saved");
            return Controller.FINISH_ACTION;
        } else {
            System.out.println("Tasks loaded");
        }
        return Controller.MAIN_MENU_ACTION;
    }

    public int taskChoose() {//выбор из пунктов меню
        System.out.println("Save and load");
        System.out.println("1 - save to file and exit,  2 - load from file,  3 - back to menu");
        int taskType=0;
        try {
            taskType = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.info = taskType;
        return taskType;
    }

    public String fileName() {//задаем имя файла
        String name = "";
        try {
            System.out.println("enter file name");
            name = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }
}


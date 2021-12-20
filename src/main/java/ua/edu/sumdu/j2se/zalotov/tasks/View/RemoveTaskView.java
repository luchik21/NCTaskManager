package ua.edu.sumdu.j2se.zalotov.tasks.View;

import ua.edu.sumdu.j2se.zalotov.tasks.Controller.Controller;
import ua.edu.sumdu.j2se.zalotov.tasks.Model.AbstractTaskList;

import java.io.IOException;

public class RemoveTaskView implements View{
    @Override
    public int printInfo(AbstractTaskList taskList) {
        System.out.println("task removed");
        return Controller.MAIN_MENU_ACTION;
    }

    public int removeTask() {
        System.out.println("Index, from 0");
        int index = 0;
        try {
            String indexIn = reader.readLine();
            index = Integer.parseInt(indexIn);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return index;
    }
}


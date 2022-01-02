package ua.edu.sumdu.j2se.zalotov.tasks.View;

import ua.edu.sumdu.j2se.zalotov.tasks.Controller.Controller;
import ua.edu.sumdu.j2se.zalotov.tasks.Model.AbstractTaskList;

import java.io.IOException;

public class RemoveTaskView implements View{
    int index;
    @Override
    public int printInfo(AbstractTaskList taskList) {
        if(index!=-1) {
            System.out.println("task removed");
        }
        return Controller.MAIN_MENU_ACTION;
    }

    public int removeTask() {
        System.out.println("Index of task, from 0");
        int index = 0;
        try {
            String indexIn = reader.readLine();
            index = Integer.parseInt(indexIn);
        } catch (IOException | NumberFormatException e) {
            return this.index=-1;
        }
        return index;
    }
}


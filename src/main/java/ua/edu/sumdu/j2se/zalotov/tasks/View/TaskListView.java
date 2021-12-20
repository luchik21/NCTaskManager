package ua.edu.sumdu.j2se.zalotov.tasks.View;

import ua.edu.sumdu.j2se.zalotov.tasks.Controller.Controller;
import ua.edu.sumdu.j2se.zalotov.tasks.Model.AbstractTaskList;

public class TaskListView implements View{
    @Override
    public int printInfo(AbstractTaskList taskList) {
        System.out.println("task list");
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println("№"+i + ". " + taskList.getTask(i));
        }
        return Controller.MAIN_MENU_ACTION;
    }
}


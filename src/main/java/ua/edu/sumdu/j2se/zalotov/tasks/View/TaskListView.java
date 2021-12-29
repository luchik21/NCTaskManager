package ua.edu.sumdu.j2se.zalotov.tasks.View;

import ua.edu.sumdu.j2se.zalotov.tasks.Controller.Controller;
import ua.edu.sumdu.j2se.zalotov.tasks.Model.AbstractTaskList;

public class TaskListView implements View {
    @Override
    public int printInfo(AbstractTaskList taskList) {
        if (taskList.size() == 0) {
            System.out.println("dont have any tasks");
            return Controller.MAIN_MENU_ACTION;
        } else {
            System.out.println("Your task list:");
            for (int i = 0; i < taskList.size(); i++) {
                System.out.println("Index:" + i + ", " + taskList.getTask(i));
            }
        }
        return Controller.MAIN_MENU_ACTION;
    }
}


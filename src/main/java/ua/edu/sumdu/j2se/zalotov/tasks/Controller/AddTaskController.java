package ua.edu.sumdu.j2se.zalotov.tasks.Controller;

import ua.edu.sumdu.j2se.zalotov.tasks.Model.AbstractTaskList;
import ua.edu.sumdu.j2se.zalotov.tasks.Model.Task;
import ua.edu.sumdu.j2se.zalotov.tasks.View.AddTaskView;
import ua.edu.sumdu.j2se.zalotov.tasks.View.View;

import java.time.LocalDateTime;

public class AddTaskController extends Controller{

    public AddTaskController(View view, int actionToPerForm) {
        super(view, actionToPerForm);
    }

    @Override
    public int process(AbstractTaskList taskList) {
        int taskChoose = ((AddTaskView) view).taskChoose();
        if (taskChoose == 1) {
            String title = ((AddTaskView) view).nameTask();
            LocalDateTime time = ((AddTaskView) view).timeTask();
            Task task1 = new Task(title, time);
            taskList.add(task1);
        } else if (taskChoose == 2) {
            String title = ((AddTaskView) view).nameTask();
            LocalDateTime timeStart = ((AddTaskView) view).timeTaskStart();
            LocalDateTime timeEnd = ((AddTaskView) view).timeTaskEnd();
            int interval = ((AddTaskView) view).repeatInterval();
            Task task2 = new Task(title, timeStart, timeEnd, interval);
            taskList.add(task2);
        } else {
            System.out.println("wrong number");
            return Controller.MAIN_MENU_ACTION;
        }
        return view.printInfo(taskList);
    }
}

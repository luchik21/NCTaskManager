package ua.edu.sumdu.j2se.zalotov.tasks.Controller;

import ua.edu.sumdu.j2se.zalotov.tasks.Model.AbstractTaskList;
import ua.edu.sumdu.j2se.zalotov.tasks.Model.Task;
import ua.edu.sumdu.j2se.zalotov.tasks.View.AddTaskView;
import ua.edu.sumdu.j2se.zalotov.tasks.View.View;

import java.time.LocalDateTime;

public class AddTaskController extends Controller {

    public AddTaskController(View view, int actionToPerform) {
        super(view, actionToPerform);
    }

    @Override
    public int process(AbstractTaskList taskList) {
        int taskChoose = ((AddTaskView) view).taskChoose();
        if (taskChoose == 1) {
            String title = ((AddTaskView) view).nameTask();
            if (title.isEmpty()) {
                System.out.println("empty name");
                return ADD_TASK_ACTION;
            }
            LocalDateTime time = ((AddTaskView) view).timeTask();
            if (time.isBefore(LocalDateTime.now())) {
                System.out.println("wrong date");
                return ADD_TASK_ACTION;
            }
            Task task1 = new Task(title, time);
            taskList.add(task1);
        } else if (taskChoose == 2) {
            String title = ((AddTaskView) view).nameTask();
            if (title.isEmpty()) {
                System.out.println("empty name");
                return ADD_TASK_ACTION;
            }
            LocalDateTime timeStart = ((AddTaskView) view).timeTaskStart();
            if (timeStart.isBefore(LocalDateTime.now())) {
                System.out.println("date before now");
                return ADD_TASK_ACTION;
            }
            LocalDateTime timeEnd = ((AddTaskView) view).timeTaskEnd();
            if (timeStart.isBefore(timeStart)) {
                System.out.println("date before start date");
                return ADD_TASK_ACTION;
            }
            int interval = ((AddTaskView) view).repeatInterval();
            Task task2 = new Task(title, timeStart, timeEnd, interval);
            taskList.add(task2);
        } else if (taskChoose == 3) { //выход в меню
            return MAIN_MENU_ACTION;
        } else {
            System.out.println("wrong number");
            return Controller.MAIN_MENU_ACTION;
        }
        return view.printInfo(taskList);
    }
}

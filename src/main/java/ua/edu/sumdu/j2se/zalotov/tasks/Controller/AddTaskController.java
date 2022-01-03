package ua.edu.sumdu.j2se.zalotov.tasks.Controller;

import org.apache.log4j.Logger;
import ua.edu.sumdu.j2se.zalotov.tasks.Model.AbstractTaskList;
import ua.edu.sumdu.j2se.zalotov.tasks.Model.Task;
import ua.edu.sumdu.j2se.zalotov.tasks.View.AddTaskView;
import ua.edu.sumdu.j2se.zalotov.tasks.View.View;
import ua.edu.sumdu.j2se.zalotov.tasks.Model.Error;

import java.time.LocalDateTime;

public class AddTaskController extends Controller {

    private static final Logger logger = Logger.getLogger(AddTaskController.class);
    public AddTaskController(View view, int actionToPerform) {
        super(view, actionToPerform);
    }

    @Override
    public int process(AbstractTaskList taskList) {
        logger.debug("enter to add task controller");
        int taskChoose = ((AddTaskView) view).taskChoose();
        if (taskChoose == 1) {//не повторяемое
            logger.debug("add not repeated task");
            String title = ((AddTaskView) view).nameTask();
            if (title.isEmpty()) {
                System.out.println(Error.EMPTY_NAME);
                return ADD_TASK_ACTION;
            }
            LocalDateTime time = ((AddTaskView) view).timeTask();
            if (time.isBefore(LocalDateTime.now())) {
                System.out.println(Error.UNEXPECTED_TIME);
                return ADD_TASK_ACTION;
            }
            Task task1 = new Task(title, time);
            task1.setActive(true);
            taskList.add(task1);
            logger.debug("exit from add task controller with new task");
        } else if (taskChoose == 2) {//повтор
            logger.debug("add repeated task");
            String title = ((AddTaskView) view).nameTask();
            if (title.isEmpty()) {
                System.out.println(Error.EMPTY_NAME);
                return ADD_TASK_ACTION;
            }
            LocalDateTime timeStart = ((AddTaskView) view).timeTaskStart();
            if (timeStart.isBefore(LocalDateTime.now())) {
                System.out.println(Error.UNEXPECTED_TIME);
                return ADD_TASK_ACTION;
            }
            LocalDateTime timeEnd = ((AddTaskView) view).timeTaskEnd();
            if (timeStart.isBefore(timeStart)) {
                System.out.println(Error.UNEXPECTED_TIME);
                return ADD_TASK_ACTION;
            }
            int interval = ((AddTaskView) view).repeatInterval();
            Task task2 = new Task(title, timeStart, timeEnd, interval);
            task2.setActive(true);
            taskList.add(task2);
            logger.debug("exit from add task controller with new task");
        } else if (taskChoose == 3) { //выход в меню
            logger.debug("exit from add task controller");
            return MAIN_MENU_ACTION;
        } else {
            System.out.println(Error.WRONG_NUMBER);
            logger.debug("exit from add task controller");
            return Controller.MAIN_MENU_ACTION;
        }
        return view.printInfo(taskList);
    }
}

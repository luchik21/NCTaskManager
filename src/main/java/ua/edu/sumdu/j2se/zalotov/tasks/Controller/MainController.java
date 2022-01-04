package ua.edu.sumdu.j2se.zalotov.tasks.Controller;

import ua.edu.sumdu.j2se.zalotov.tasks.Model.AbstractTaskList;
import ua.edu.sumdu.j2se.zalotov.tasks.View.*;

import java.util.ArrayList;
import java.util.List;


public class MainController extends Controller {
    private AbstractTaskList taskList;
    private List<Controller> controllers = new ArrayList<>();

    public MainController(AbstractTaskList taskList, View mainView) {
        super(mainView, Controller.MAIN_MENU_ACTION);
        this.taskList = taskList;

        controllers.add(this);
        controllers.add(new AddTaskController(new AddTaskView(), Controller.ADD_TASK_ACTION));
        controllers.add(new RemoveTaskController(new RemoveTaskView(), Controller.REMOVE_TASK_ACTION));
        controllers.add(new TaskListController(new TaskListView(), Controller.TASK_LIST_ACTION));
        controllers.add(new CalendarController(new CalendarView(), Controller.CALENDAR_ACTION));
        controllers.add(new ChangeTaskController(new ChangeTaskView(), Controller.CHANGE_TASK_ACTION));
        controllers.add(new SaveLoadTaskController(new SaveLoadTaskView(),Controller.SAVE_LOAD_ACTION));
        NotificationController notification = new NotificationController(new NotificationView(), taskList);
        notification.setDaemon(true);
        notification.start();
    }

    @Override
    public int process(AbstractTaskList taskList) {
        int action = view.printInfo(taskList);
        for (; ;) {
            for (Controller controller : controllers) {
                if (controller.canProcess(action)) {
                    action = controller.process(this.taskList);
                }
            }
            if (action == FINISH_ACTION) {
                break;
            }
        }
        return FINISH_ACTION;
    }
}


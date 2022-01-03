package ua.edu.sumdu.j2se.zalotov.tasks.Controller;

import org.apache.log4j.Logger;
import ua.edu.sumdu.j2se.zalotov.tasks.Model.AbstractTaskList;
import ua.edu.sumdu.j2se.zalotov.tasks.View.View;

public class TaskListController extends Controller{

    private static final Logger logger = Logger.getLogger(TaskListController.class);

    public TaskListController(View view, int actionToPerform) {
        super(view, actionToPerform);
    }

    @Override
    public int process(AbstractTaskList taskList) {
        logger.debug("see all tasks");
        return view.printInfo(taskList);
    }
}

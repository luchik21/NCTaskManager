package ua.edu.sumdu.j2se.zalotov.tasks.Controller;

import org.apache.log4j.Logger;
import ua.edu.sumdu.j2se.zalotov.tasks.Model.AbstractTaskList;
import ua.edu.sumdu.j2se.zalotov.tasks.View.RemoveTaskView;
import ua.edu.sumdu.j2se.zalotov.tasks.View.View;
import ua.edu.sumdu.j2se.zalotov.tasks.Model.Error;

public class RemoveTaskController extends Controller {

    private static final Logger logger = Logger.getLogger(RemoveTaskController.class);

    public RemoveTaskController(View view, int actionToPerform) {
        super(view, actionToPerform);
    }

    @Override
    public int process(AbstractTaskList taskList) {
        logger.debug("enter to remove task controller");
        int index = ((RemoveTaskView) view).removeTask();
        if (taskList.size() > 0 & index >= 0 & taskList.getTask(index) != null) {
            taskList.remove(taskList.getTask(index));
            logger.debug("remove task");
        } else {
            System.out.println(Error.WRONG_INDEX);
            logger.debug("exit from remove task controller");
        }
        logger.debug("exit from remove task controller");
        return view.printInfo(taskList);
    }
}

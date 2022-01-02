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
        int index = ((RemoveTaskView) view).removeTask();
        if (taskList.size() > 0 & index >= 0 & taskList.getTask(index) != null) {
            taskList.remove(taskList.getTask(index));
        } else {
            System.out.println(Error.WRONG_INDEX);
        }
        return view.printInfo(taskList);
    }
}

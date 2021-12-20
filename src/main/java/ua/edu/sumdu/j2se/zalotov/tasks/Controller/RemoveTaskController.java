package ua.edu.sumdu.j2se.zalotov.tasks.Controller;

import ua.edu.sumdu.j2se.zalotov.tasks.Model.AbstractTaskList;
import ua.edu.sumdu.j2se.zalotov.tasks.View.RemoveTaskView;
import ua.edu.sumdu.j2se.zalotov.tasks.View.View;

public class RemoveTaskController extends Controller{
    public RemoveTaskController(View view, int actionToPerform) {
        super(view, actionToPerform);
    }

    @Override
    public int process(AbstractTaskList taskList) {
        int index = ((RemoveTaskView) view).removeTask();
        taskList.remove(taskList.getTask(index));
        return view.printInfo(taskList);
    }
}

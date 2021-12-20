package ua.edu.sumdu.j2se.zalotov.tasks.Controller;

import ua.edu.sumdu.j2se.zalotov.tasks.Model.AbstractTaskList;
import ua.edu.sumdu.j2se.zalotov.tasks.View.View;

public class CalendarController extends Controller {

    public CalendarController(View view, int actionToPerform) {
        super(view, actionToPerform);
    }

    @Override
    public int process(AbstractTaskList taskList) {
        return view.printInfo(taskList);
    }
}

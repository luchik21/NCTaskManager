package ua.edu.sumdu.j2se.zalotov.tasks.Controller;

import org.apache.log4j.Logger;
import ua.edu.sumdu.j2se.zalotov.tasks.Model.AbstractTaskList;
import ua.edu.sumdu.j2se.zalotov.tasks.View.CalendarView;
import ua.edu.sumdu.j2se.zalotov.tasks.View.View;
import ua.edu.sumdu.j2se.zalotov.tasks.Model.Error;

public class CalendarController extends Controller {

    private static final Logger logger = Logger.getLogger(CalendarController.class);
    public CalendarController(View view, int actionToPerform) {
        super(view, actionToPerform);
    }

    @Override
    public int process(AbstractTaskList taskList) {
        int taskChoose = ((CalendarView) view).taskChoose();
        if (taskChoose == 1) {
            return view.printInfo(taskList);
        } else if (taskChoose == 2) {
            return  ((CalendarView) view).calendarFor7Days(taskList);
        }  else if (taskChoose == 3) {
            return MAIN_MENU_ACTION;
        } else {
            System.out.println(Error.WRONG_NUMBER);
            return CALENDAR_ACTION;
        }
    }
}

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
        logger.debug("enter to calendar controller");
        int taskChoose = ((CalendarView) view).taskChoose();
        if (taskChoose == 1) {//календарь на промежуток времени(от и до)
            logger.debug("see calendar from () to ()");
            return view.printInfo(taskList);
        } else if (taskChoose == 2) {//календарь на неделю
            logger.debug("see calendar for 7 days");
            return  ((CalendarView) view).calendarFor7Days(taskList);
        }  else if (taskChoose == 3) {//выход в меню
            logger.debug("exit from calendar controller");
            return MAIN_MENU_ACTION;
        } else {
            System.out.println(Error.WRONG_NUMBER);//ошибка введеного значения
            logger.debug("exit from calendar controller");
            return CALENDAR_ACTION;
        }
    }
}

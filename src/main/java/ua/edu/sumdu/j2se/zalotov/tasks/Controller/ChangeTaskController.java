package ua.edu.sumdu.j2se.zalotov.tasks.Controller;

import org.apache.log4j.Logger;
import ua.edu.sumdu.j2se.zalotov.tasks.Model.AbstractTaskList;
import ua.edu.sumdu.j2se.zalotov.tasks.View.ChangeTaskView;
import ua.edu.sumdu.j2se.zalotov.tasks.View.View;
import ua.edu.sumdu.j2se.zalotov.tasks.Model.Error;

import java.time.LocalDateTime;

public class ChangeTaskController extends Controller {

    private static final Logger logger = Logger.getLogger(ChangeTaskController.class);
    public ChangeTaskController(View view, int actionToPerform) {
        super(view, actionToPerform);
    }

    @Override
    public int process(AbstractTaskList taskList) {
        logger.debug("enter to change task controller");
        int taskChoose = ((ChangeTaskView) view).taskChoose();
        if (taskChoose == 1) {
            logger.debug("change repeated task param");
            int index = ((ChangeTaskView) view).index(); //индекс задания
            if (taskList.size() <= 0 || taskList.size() - 1 < index) {
                System.out.println(Error.WRONG_INDEX);
                return CHANGE_TASK_ACTION;
            }
            if (taskList.getTask(index).isRepeated()) { // повторяемое
                int taskChooseRep = ((ChangeTaskView) view).taskChooseRep();//меню
                if (taskChooseRep == 1) {
                    nameChange(index, taskList);//имя
                } else if (taskChooseRep == 2) {
                    LocalDateTime startTime = ((ChangeTaskView) view).timeTaskStart();//время старта
                    if (startTime.isBefore(LocalDateTime.now())) {
                        System.out.println(Error.UNEXPECTED_TIME);
                        return CHANGE_TASK_ACTION;
                    }
                    LocalDateTime endTime = ((ChangeTaskView) view).timeTaskEnd(); //время конца
                    if ((endTime.isBefore(LocalDateTime.now()))) {
                        System.out.println(Error.WRONG_NUMBER);
                        return CHANGE_TASK_ACTION;
                    }
                    taskList.getTask(index).setTime(startTime, endTime, taskList.getTask(index).getInterval());// изменяем время
                } else if (taskChooseRep == 3) {
                    int interval = ((ChangeTaskView) view).interval();// вводим интевал
                    if (interval <= 0) {  //ошибка
                        System.out.println(Error.UNEXPECTED_INTERVAL);
                        return CHANGE_TASK_ACTION;
                    }
                    taskList.getTask(index).setInterval(interval);
                } else if (taskChooseRep == 4) {//выход в меню
                    logger.debug("exit from change task controller");
                    return MAIN_MENU_ACTION;
                }
            } else {//задание без повтора
                logger.debug("change non repeated task param");
                int taskChooseNon = ((ChangeTaskView) view).taskChooseNon();
                if (taskChooseNon == 1) {
                    nameChange(index, taskList);//имя
                } else if (taskChooseNon == 2) {
                    LocalDateTime time = ((ChangeTaskView) view).timeTask(); // изменяем время
                    if (time.isBefore(LocalDateTime.now())) { //ошибка
                        System.out.println(Error.UNEXPECTED_TIME);
                        return CHANGE_TASK_ACTION;
                    }
                    taskList.getTask(index).setTime(time);//время
                    return CHANGE_TASK_ACTION;
                } else if (taskChooseNon == 3) {//выход в меню
                    logger.debug("exit from change task controller");
                    return Controller.MAIN_MENU_ACTION;
                } else {
                    System.out.println(Error.WRONG_NUMBER);
                    return CHANGE_TASK_ACTION;
                }
                return CHANGE_TASK_ACTION;
            }
        } else if (taskChoose == 2) { //выход в меню
            logger.debug("exit from change task controller");
            return MAIN_MENU_ACTION;
        } else {
            System.out.println(Error.WRONG_NUMBER);
            logger.debug("exit from change task controller");
            return CHANGE_TASK_ACTION;
        }
        return view.printInfo(taskList);
    }

    private void nameChange(int index, AbstractTaskList taskList) {//получаем новое имя и заменяем
        String titleNew = ((ChangeTaskView) view).titleNew();
        taskList.getTask(index).setTitle(titleNew);
    }
}

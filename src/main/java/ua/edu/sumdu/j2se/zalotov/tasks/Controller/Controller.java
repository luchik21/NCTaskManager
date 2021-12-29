package ua.edu.sumdu.j2se.zalotov.tasks.Controller;

import ua.edu.sumdu.j2se.zalotov.tasks.Model.AbstractTaskList;
import ua.edu.sumdu.j2se.zalotov.tasks.View.View;

public abstract class Controller {

    public static final int MAIN_MENU_ACTION = 0;
    public static final int ADD_TASK_ACTION = 1;
    public static final int REMOVE_TASK_ACTION = 2;
    public static final int TASK_LIST_ACTION = 3;
    public static final int CALENDAR_ACTION = 4;
    public static final int CHANGE_TASK_ACTION = 5;
    public static final int SAVE_LOAD_ACTION = 6;
    public static final int FINISH_ACTION = 7;

    protected View view;
    protected int actionToPerform;

    public Controller(View view, int actionToPerform) {
        this.view = view;
        this.actionToPerform = actionToPerform;
    }

    public boolean canProcess(int action) {
        return action == actionToPerform;
    }

    public abstract int process(AbstractTaskList taskList);

}


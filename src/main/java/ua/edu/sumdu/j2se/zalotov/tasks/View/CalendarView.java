package ua.edu.sumdu.j2se.zalotov.tasks.View;

import ua.edu.sumdu.j2se.zalotov.tasks.Controller.Controller;
import ua.edu.sumdu.j2se.zalotov.tasks.Model.AbstractTaskList;

public class CalendarView implements View{
    @Override
    public int printInfo(AbstractTaskList taskList) {
        System.out.println("calendar view");
        return Controller.MAIN_MENU_ACTION;
    }
}


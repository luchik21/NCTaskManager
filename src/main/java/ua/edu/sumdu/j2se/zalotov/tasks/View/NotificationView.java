package ua.edu.sumdu.j2se.zalotov.tasks.View;


import ua.edu.sumdu.j2se.zalotov.tasks.Controller.Controller;

import java.time.LocalDateTime;

public class NotificationView {
    public int printInfo(LocalDateTime time, String title) {
        System.out.println("Notification:  Task " + title + " must be done at " + time);
        return Controller.MAIN_MENU_ACTION;
    }
}

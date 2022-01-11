package ua.edu.sumdu.j2se.zalotov.tasks.Controller;

import ua.edu.sumdu.j2se.zalotov.tasks.Model.AbstractTaskList;
import ua.edu.sumdu.j2se.zalotov.tasks.Model.Task;
import ua.edu.sumdu.j2se.zalotov.tasks.Model.Tasks;
import ua.edu.sumdu.j2se.zalotov.tasks.View.NotificationView;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.SortedMap;

public class NotificationController extends Thread {

    private NotificationView view;
    private AbstractTaskList taskList;

    public NotificationController(NotificationView view, AbstractTaskList taskList) {
        this.view = view;
        this.taskList = taskList;
    }

    @Override
    public void run() {
        while (true) {
            boolean flag = false;
            LocalDateTime now = LocalDateTime.now().withSecond(0).withNano(0);//текущее время
            LocalDateTime end = LocalDateTime.now().withSecond(0).withNano(0).plusYears(1);
            String title;
            SortedMap<LocalDateTime, Set<Task>> calendarView = Tasks.calendar(taskList, now, end);
            for (SortedMap.Entry<LocalDateTime, Set<Task>> element : calendarView.entrySet()) {
                for (Task task : element.getValue()) {
                    title = task.getTitle();
                    if (element.getKey().isEqual(now)) {//сравнение текущего и времени выполнения заданий
                        view.printInfo(element.getKey(), title);
                        flag = true;
                    }
                }
            }
            if (flag) {
                try {
                    Thread.sleep(Duration.between(LocalDateTime.now(), LocalDateTime.now().plusMinutes(1)).toMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

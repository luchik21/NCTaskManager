package ua.edu.sumdu.j2se.zalotov.tasks;

import ua.edu.sumdu.j2se.zalotov.tasks.Controller.Controller;
import ua.edu.sumdu.j2se.zalotov.tasks.Controller.MainController;
import ua.edu.sumdu.j2se.zalotov.tasks.Model.AbstractTaskList;
import ua.edu.sumdu.j2se.zalotov.tasks.Model.ArrayTaskList;
import ua.edu.sumdu.j2se.zalotov.tasks.View.MainView;
import ua.edu.sumdu.j2se.zalotov.tasks.View.View;

public class Main {

    public static void main(String[] args) {
        System.out.println("Start manager");
        AbstractTaskList taskList = new ArrayTaskList();
        View mainView = new MainView();
        Controller mainController = new MainController(taskList, mainView);
        mainController.process(null);
        System.out.println("Manager close");
    }
}


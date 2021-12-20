package ua.edu.sumdu.j2se.zalotov.tasks.View;

import ua.edu.sumdu.j2se.zalotov.tasks.Model.AbstractTaskList;

import java.io.IOException;

public class MainView implements View {

    @Override
    public int printInfo(AbstractTaskList taskList) {
        System.out.println("choose action");
        System.out.println("1 add new task");
        System.out.println("2 remove task");
        System.out.println("3 see tasks");
        System.out.println("4 calendar");
        System.out.println("5 change task param");
        System.out.println("6 exit");
        int variant = 0;
        try {
            variant = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return variant;
    }
}


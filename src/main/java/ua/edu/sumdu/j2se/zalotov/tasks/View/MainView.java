package ua.edu.sumdu.j2se.zalotov.tasks.View;

import ua.edu.sumdu.j2se.zalotov.tasks.Model.AbstractTaskList;
import ua.edu.sumdu.j2se.zalotov.tasks.Model.Error;

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
        System.out.println("6 save and load");
        System.out.println("7 exit");
        int variant = 0;
        try {
            variant = Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            System.out.println(Error.WRONG_NUMBER);
        }
        if (variant >= 0 && variant <= 7) {
            return variant;
        } else {
            System.out.println(Error.WRONG_NUMBER);
            return 0;
        }
    }
}


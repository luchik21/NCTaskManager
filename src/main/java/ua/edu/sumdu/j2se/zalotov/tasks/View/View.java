package ua.edu.sumdu.j2se.zalotov.tasks.View;

import ua.edu.sumdu.j2se.zalotov.tasks.Model.AbstractTaskList;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public interface View {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int printInfo(AbstractTaskList taskList);
}


package ua.edu.sumdu.j2se.zalotov.tasks;

import java.util.Arrays;

public class ArrayTaskList {
    Task[] tasks = new Task[0];

    public void add(Task task) {
        tasks = Arrays.copyOf(tasks, tasks.length + 1);
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] == null) {
                tasks[i] = task;
                i++;
            }
        }
    }

    public boolean remove(Task task) {
        for (int i = 0; i < tasks.length; i++) {
            if(tasks[i]==task){
            System.arraycopy(tasks, i + 1, tasks, i, tasks.length - 1 - i);
            tasks = Arrays.copyOf(tasks, tasks.length - 1);
            return true;
            }
        }
        return false;
    }

    public int size() {
        return tasks.length;
    }

    public Task getTask(int index) {
        return tasks[index];
    }

    public ArrayTaskList incoming(int from, int to) {
        ArrayTaskList arrayTaskList = new ArrayTaskList();
        for (Task task : tasks) {
            if (task.isActive()) {
                if (task.getStartTime() > from && task.getEndTime() < to || task.getTime() > from && task.getTime() < to) {
                    arrayTaskList.add(task);
                }
            }
        }
        return arrayTaskList;
    }
}

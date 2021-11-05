package ua.edu.sumdu.j2se.zalotov.tasks;

import java.util.Arrays;

public class ArrayTaskList {

    private int size = 0;

    Task[] tasks = new Task[10];

    public void add(Task task) {
        if (tasks[tasks.length - 1] != null) {
            tasks = Arrays.copyOf(tasks, tasks.length * 2);
        }
        size++;
        for (int i = 0; i < size; i++) {
            if (tasks[i] == null) {
                tasks[i] = task;
            }
        }
    }

    public boolean remove(Task task) {
        for (int i = 0; i < size; i++) {
            if (tasks[i].equals(task)) {
                System.arraycopy(tasks, i + 1, tasks, i, tasks.length - 1 - i);
                size--;
                return true;

            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public Task getTask(int index) {
        if (index > tasks.length) {
            throw new IndexOutOfBoundsException("Index greater than the length of the array");
        }
        return tasks[index];
    }

    public ArrayTaskList incoming(int from, int to) {
        ArrayTaskList arrayTaskList = new ArrayTaskList();
        for (int i = 0; i < size; i++) {
            if (tasks[i].nextTimeAfter(tasks[i].getTime()) > from && tasks[i].nextTimeAfter(tasks[i].getTime()) < to) {
                arrayTaskList.add(tasks[i]);
            }
        }
        return arrayTaskList;
    }
}

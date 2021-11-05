package ua.edu.sumdu.j2se.zalotov.tasks;

public class Main {

    public static void main(String[] args) {

        Task task = new Task("name", 10);
        LinkedTaskList list = new LinkedTaskList();
        list.add(task);
        Task task1 = list.getTask(0);

    }

}

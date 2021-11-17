package ua.edu.sumdu.j2se.zalotov.tasks;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        Task task1 = new Task("name1", 10);
        Task task2 = new Task("name2", 10);
        Task task3 = new Task("name3", 10);
        task1.setActive(true);

        LinkedTaskList list1 = new LinkedTaskList();
        list1.add(task1);
        list1.add(task2);
        list1.add(task3);
        System.out.println("test");
        System.out.println(list1.iterator().next()); //1
        System.out.println(list1.iterator().next()); //2
        System.out.println(list1.iterator().next()); //3
        System.out.println(list1.iterator().hasNext()); //3
        System.out.println(list1.iterator().next()); //4

        for (Task t: list1
             ) {
            System.out.println(t);

        }

    }

}

package ua.edu.sumdu.j2se.zalotov.tasks;

public class Main {

    public static void main(String[] args) {

        Task task = new Task("name", 10);
        Task taskrep = new Task("name", 10,30,10);
        task.setActive(true);
        taskrep.setActive(true);
        LinkedTaskList list = new LinkedTaskList();

        list.add(task);
//        list.add(taskrep);
//
//        System.out.println(list.incoming(0,100));

        LinkedTaskList list1 = new LinkedTaskList();
        System.out.println(list);
        System.out.println(list1);
        
    }

}

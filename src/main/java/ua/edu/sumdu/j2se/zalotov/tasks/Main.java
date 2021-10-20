package ua.edu.sumdu.j2se.zalotov.tasks;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello");

		Task task1= new Task("1", 1);
		Task task2= new Task("2", 1);
		Task task3= new Task("3", 1);

		ArrayTaskList arrayTaskList = new ArrayTaskList();
		arrayTaskList.add(task1);
		arrayTaskList.add(task2);
		arrayTaskList.add(task3);
		System.out.println(arrayTaskList.size());
	}

}

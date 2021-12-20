package ua.edu.sumdu.j2se.zalotov.tasks.Model;

public class TaskListFactory {
    public static AbstractTaskList createTaskList(ListTypes.types type) {
        switch (type) {
            case ARRAY:
                return new ArrayTaskList();
            case LINKED:
                return new LinkedTaskList();
            default:
                throw new IllegalArgumentException("Incorrect type! Pls enter type: ARRAY or LINKED");
        }
    }
}

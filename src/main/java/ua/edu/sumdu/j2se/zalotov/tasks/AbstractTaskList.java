package ua.edu.sumdu.j2se.zalotov.tasks;

abstract class AbstractTaskList {

    public abstract void add(Task task);

    public abstract Task getTask(int index);

    public abstract boolean remove(Task task);

    public abstract int size();

    public AbstractTaskList incoming(int from, int to) {
        AbstractTaskList taskList = TaskListFactory.createTaskList(getType());
        Task task;
        for (int i = 0; i < taskList.size(); i++) {
            task = taskList.getTask(i);
            if (task.nextTimeAfter(task.getStartTime()) > from && task.nextTimeAfter(task.getEndTime()) < to) {
                taskList.add(task);
            }
        }
        return taskList;
    }

    public abstract ListTypes.types getType();
}


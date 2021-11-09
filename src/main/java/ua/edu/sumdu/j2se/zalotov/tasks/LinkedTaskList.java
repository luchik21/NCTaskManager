package ua.edu.sumdu.j2se.zalotov.tasks;

public class LinkedTaskList extends AbstractTaskList {

    static class Node {
        Task task;
        Node next;
        public Node(Task task) {
            this.task = task;
        }

        public Task getTaskData() {
            return this.task;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public void add(Task task) {
        if (task != null) {
            Node newNode = new Node(task);
            if (first == null) {
                first = last = newNode;
            } else {
                last.next = newNode;
                last = newNode;
            }
            size++;
        } else {
            throw new IllegalArgumentException("Tasks cant be null!");
        }
    }

    public Task getTask(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        if (index < size() - 1) {
            Node current = first;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.getTaskData();
        }
        return last.getTaskData();
    }

    public boolean remove(Task task) {
        Node curr = first;
        Node prev = null;
        for (int i = 0; i < size; i++) {
            if (getTask(i).equals(task)) {
                if (prev != null) {
                    prev.next = curr.next;
                    if (curr.next == null)
                        last = prev;
                } else {
                    first = first.next;
                }
                size--;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    @Override
    public ListTypes.types getType() {
        return ListTypes.types.LINKED;
    }

}

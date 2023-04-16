package hinter;


import java.util.LinkedList;

public class StringQueue {
    private final LinkedList<String> queue;

    public StringQueue() {
        queue = new LinkedList();
    }

    public int size() {
       return queue.size();
    }

    public void add(String item) {
        queue.add(item);
    }
    public String dequeue() {
        if (queue.isEmpty()) {
            return null;
        }
        String next = queue.get(0);
        queue.remove(0);
        return next;
    }

    // Added a toString method to MyStack to make debugging easy
    public String toString() {
        return queue.toString();
    }

}
package Hinter;


import java.util.LinkedList;

public class MyQueue {
    private final LinkedList<String> queue;

    public MyQueue() {
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
            return  "No hints available";
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
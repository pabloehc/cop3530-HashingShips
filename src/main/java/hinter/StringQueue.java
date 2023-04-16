package hinter;


import java.util.LinkedList;

public class StringQueue {
    private final LinkedList<String> queue;

    /**
     * Initialize StringQueue
     */
    public StringQueue() {
        queue = new LinkedList();
    }

    /**
     * get the current size of the queue
     * @return int with current queue size
     */
    public int size() {
       return queue.size();
    }

    /**
     * Add element to queue
     * @param item to add
     */
    public void add(String item) {
        queue.add(item);
    }

    /**
     * Returns the next item in the queue
     */
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
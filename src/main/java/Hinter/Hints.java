package Hinter;

import interfaces.Hinter;

public class Hints implements Hinter{

    MyQueue nextHint;

    /**
     * @Constructor initializes nextHint and populates it with 3 hints
     */
    public Hints() {
        nextHint = new MyQueue();
        populateHints();
    }


    @Override
    public int getSize() {
        return nextHint.size();
    }

    @Override
    public void populateHints() {
        nextHint.add("hint 1\n");
        nextHint.add("hint 2\n");
        nextHint.add("hint 3\n");
    }

    /**
     * Retrieves the next element from nextHint class and inserts it into a string GetHint and then removes that element
     * @return returns a string value from inside nextHint Queue class
     */
    @Override
    public String printNextHint() {

        String getHint;
        getHint = nextHint.dequeue();
       return getHint;
    }
}

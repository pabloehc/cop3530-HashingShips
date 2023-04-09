package interfaces;

public interface Hinter {

    /**
     * @return size of the Queue
     */
    int getSize();


    /**
     * Add 3 string values into the Queue class
     */
    void populateHints();

    /**
     * Retrieves the next element from nextHint class and inserts it into a string GetHint and then removes that element
     *
     * @return returns a string value from inside nextHint Queue class
     */
    String getNextHint();

}

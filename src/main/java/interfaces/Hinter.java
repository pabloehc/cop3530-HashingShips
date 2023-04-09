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
     * Prints the next hint from the queue to the command line.
     * If there are no hints in the queue, display a message indicating the absence of hints.
     */
    String printNextHint();
}

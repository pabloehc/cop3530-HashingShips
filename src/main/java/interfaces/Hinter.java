package interfaces;

public interface Hinter {

    /**
     * Prints the next hint from the queue to the command line.
     * If the queue is out of hints, do nothing.
     */
    void printNextHint();
}

package hinter;

import interfaces.Hinter;


/**
 * Responsible for given the user hints when they're needed.
 */
public class Hints implements Hinter {

    StringQueue hints;
    private final String HINT_ONE = "Your input hashes to a position in the map.";

    private final String HINT_TWO = "When typing 2 letters [ab] or [ca] each letter's value will add to each other creating a new position in the map";

    private final String HINT_3 = "In the map, every letter has a designated position." +
            " For example, due to our hashing method, 'a' is hashed to position '1', 'b' to '2', and so on," +
            " until we reach the map size, which is currently '4'." +
            " After that, the counting restarts. As a result, 'd' is equal to 0, e to 1, and so forth." +
            " Don't forget however that letters will add their values: a + b = 3";

    private final String NO_HINTS = "There are no hints available left";

    /**
     * @Constructor initializes nextHint and populates it with 3 hints
     */
    public Hints() {
        hints = new StringQueue();
        populateHints();
    }

    /**
     * @return size of the Queue
     */
    @Override
    public int getSize() {
        return hints.size();
    }

    /**
     * Add 3 string values into the Queue class
     */
    @Override
    public void populateHints() {
        hints.add(HINT_ONE);
        hints.add(HINT_TWO);
        hints.add(HINT_3);
    }

    /**
     * Retrieves the next element from nextHint class and inserts it into a string GetHint and then removes that element
     * @return returns a string value from inside nextHint Queue class
     */
    @Override
    public String getNextHint() {
        String getHint;
        getHint = hints.dequeue();
        if(getHint == null)
            return NO_HINTS;
        return getHint;
    }

}
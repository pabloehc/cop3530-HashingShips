package hinter;

import interfaces.Hinter;



public class Hints implements Hinter {


    StringQueue Hint;
    private final String hint_1 = "Each letter holds a position in the map",

    hint_2 = "When typing 2 letters [ab] or [ca] each letter will add to each other creating a new position in the map",


    hint_3 = "In the map, every letter has a designated position." +
            " For example, a is represented by 1, b by 2, and so on," +
            " until we reach the map size, which is currently 3." +
            " After that, the counting restarts. As a result, d is equal to 0, e to 1, and so forth." +
            "Don't forget however that letters will add their values: a + b = 3",

    noHints = "There are no hints available left";

    /**
     * @Constructor initializes nextHint and populates it with 3 hints
     */
    public Hints() {
        Hint = new StringQueue();
        populateHints();
    }


    @Override
    public int getSize() {
        return Hint.size();
    }

    @Override
    public void populateHints() {
        Hint.add(hint_1);
        Hint.add(hint_2);
        Hint.add(hint_3);
    }


    @Override
    public String getNextHint() {
        String getHint;
        getHint = Hint.dequeue();
        if(getHint == null)
            return noHints;
        return getHint;
    }

}
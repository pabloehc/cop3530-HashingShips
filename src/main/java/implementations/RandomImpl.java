package implementations;

import java.util.ArrayList;
import java.util.Random;
import interfaces.RandomShips;
import java.util.List;

public class RandomImpl implements RandomShips {

    public static final Random rand = new Random();


    public static final int MIN_LIVES = 1;
    public static final int MAX_LIVES = 5;
    public static final int MIN_SHIPS = 1;
    public static final int MAX_SHIPS = 5;

    @Override
    public List<String> randomValues(int numberOfShips) {
        return null;
    }

    /**
     * Creates a list of length numberOfShips up to MAX_SHIPS.
     * Where each value is a random number from MIN_LIVES to MAX_LIVES.
     * @param numberOfShips is the length of the list.
     * @return a list of integers.
     */
    @Override
    public List<Integer> randomLives(int numberOfShips) {

        if (numberOfShips> MAX_SHIPS || numberOfShips < MIN_SHIPS) {
            return null;
        }
        List<Integer> randomLives = new ArrayList<>();

        for (int i=0; i < numberOfShips; i++){
            int randomNumber = rand.nextInt(MAX_LIVES) + MIN_LIVES; // generates a random integer between 1 and 5 (inclusive)
            randomLives.add(randomNumber);
        }
        return randomLives;
    }
}

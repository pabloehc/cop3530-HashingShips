package random;

import java.util.*;

import hashing.InputHashImpl;
import interfaces.InputHash;
import interfaces.RandomShips;

public class RandomShipsImpl implements RandomShips {

    private static final Random rand = new Random();
    public static final InputHash inputHash = new InputHashImpl();


    public static final int MIN_LIVES = 2;
    public static final int MAX_LIVES = 3;
    public static final int MIN_SHIPS = 1;
    public static final int MAX_SHIPS = 5;

    /**
     * Create a list of strings that has 2 random characters from a-z.
     * They hash to unique keys.
     * @param numberOfShips is the length of the list.
     * @return a list of strings.
     */
    @Override
    public List<String> randomValues(int numberOfShips, int tableSize) {
        List<String> shipNames = new ArrayList<>();
        Random random = new Random();
        Set<Integer> keys = new HashSet<>();

        if (numberOfShips >= tableSize) {
            throw new RuntimeException(
                    String.format("Table size %s should be higher tha number of ships %s", numberOfShips, tableSize));
        }

        for (int i = 0; i < numberOfShips; i++) {
            char firstChar = (char) (random.nextInt(26) + 'a');
            char secondChar = (char) (random.nextInt(26) + 'a');
            String shipName = firstChar + String.valueOf(secondChar);

            int hash = inputHash.hashInput(shipName, tableSize);
            if (keys.contains(hash)){
                i--;
                continue;
            }
            keys.add(hash);
            shipNames.add(shipName);
        }

        return shipNames;
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

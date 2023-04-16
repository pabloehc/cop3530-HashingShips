package interfaces;

import java.util.List;

public interface RandomShips {
     /**
      * Create a list of strings that has 2 random characters from a-z.
      * They hash to unique keys.
      * @param numberOfShips is the length of the list.
      * @return a list of strings.
      */
     List<String> randomValues(int numberOfShips, int tableSize);

     /**
      * Creates a list of length numberOfShips up to MAX_SHIPS.
      * Where each value is a random number from MIN_LIVES to MAX_LIVES.
      * @param numberOfShips is the length of the list.
      * @return a list of integers.
      */
     List<Integer> randomLives(int numberOfShips);

}

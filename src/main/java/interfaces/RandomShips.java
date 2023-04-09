package interfaces;

import java.util.List;

public interface RandomShips {
     List<String> randomValues(int numberOfShips, int tableSize);

     List<Integer> randomLives(int numberOfShips);

}

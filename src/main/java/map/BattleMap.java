package map;

import interfaces.BasicHashMap;
import random.RandomShipsImpl;
import interfaces.RandomShips;
import interfaces.ShipHashMap;

import java.util.List;

/**
 * BattleMap is an implementation of ShipHashMap that manages a map of ships.
 * It generates ships randomly, assigns them random lives, and allows for attacking them.
 * When a ship is attacked, its lives are decreased. A ship is considered destroyed when its lives reach zero.
 * The class provides a method to check if there are still ships remaining on the map.
 */
public class BattleMap implements ShipHashMap {

    private final RandomShips randomShips = new RandomShipsImpl();
    private final BasicHashMap battleMap;
    private int numberOfShips;
    private final List<String> shipKeys;
    private int size;

    public BattleMap(int mapSize, int numberOfShips) {
        this.size = mapSize;
        this.numberOfShips = numberOfShips;
        this.shipKeys = randomShips.randomValues(numberOfShips, size);
        this.battleMap = BasicHashMapImpl.createNewMap(size);
        initShips();
    }

    /**
     * Initializes the battleMap. We select random keys to have ships. Each ship has a random number of lives.
     */
    private void initShips() {
        List<Integer> randomLives = randomShips.randomLives(numberOfShips);
        // Set lives number for each random ship.
        for(int i = 0; i < shipKeys.size(); i++) {
            battleMap.put(shipKeys.get(i), randomLives.get(i));
        }
    }

    /**
     * Attacks a certain key. If the key has a ship it decreases its lives counter by one.
     * @param key to attack.
     * @return true if the attack hit a ship, false otherwise.
     */
    @Override
    public boolean attack(String key) {
        // Check if there is a ship at the location
        int shipLives = battleMap.get(key);
        if (shipLives <= 0) {
            return false;
        }

        // If there is a valid ship, decrease lives by 1 and insert into map.
        shipLives--;
        battleMap.put(key, shipLives);

        // If ship was destroyed, decrease ship count;
        if (shipLives == 0) {
            numberOfShips--;
        }

        return true;
    }

    /**
     * Check if there are still ships in the battle map.
     * @return true if there are ships, false otherwise.
     */
    @Override
    public boolean hasShips() {
        return numberOfShips > 0;
    }

    public int getNumberOfShips() {
        return numberOfShips;
    }

    public int getSize() {
        return size;
    }
}

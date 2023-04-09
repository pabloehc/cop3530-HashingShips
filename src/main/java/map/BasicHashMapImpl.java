package map;

import hashing.InputHashImpl;
import interfaces.BasicHashMap;
import interfaces.InputHash;

/**
 * An implementation of a BasicHashMap that maps string keys to integer values.
 * This implementation uses a hash function to determine the index in an array
 * where the corresponding value is stored.
 */
public class BasicHashMapImpl implements BasicHashMap {
    private final int[] values;
    private final int mapSize;
    private final InputHash hashing;

    /**
     * Constructs a BasicMapImpl with the specified size.
     * @param size the size of the map
     */
    public BasicHashMapImpl(int size, InputHash hashing) {
        this.hashing = hashing;
        this.mapSize = size;
        this.values = new int[mapSize];
    }

    /**
     * Puts the specified key-value pair into the hash map.
     * @param key the key to be inserted into the map.
     * @param value the value to be associated with the key.
     * @throws IllegalArgumentException if the key is out of range (less than 0 or greater than or equal to the map size)
     */
    @Override
    public void put(String key, int value) {
        int hashedKey = hashing.hashInput(key, mapSize);
        values[hashedKey] = value;
    }

    /**
     * Retrieves the value associated with the specified key from the hash map.
     * @param key the key whose associated value is to be returned
     * @return the value associated with the specified key
     * @throws IllegalArgumentException if the key is out of range (less than 0 or greater than or equal to the map size)
     */
    @Override
    public int get(String key) {
        int hashedKey = hashing.hashInput(key, mapSize);
        return values[hashedKey];
    }

    /**
     * Creates a new custom hash map with the specified size.
     * @param size the size of the new map.
     * @return a new BasicHashMap with the specified size.
     */
    public static BasicHashMap createNewMap(int size) {
        return new BasicHashMapImpl(size, new InputHashImpl());
    }

    /**
     * Retrieves the size of the map.
     * @return the size of the map
     */
    @Override
    public int getMapSize() {
        return mapSize;
    }
}


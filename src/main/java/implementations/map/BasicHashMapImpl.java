package implementations.map;

import interfaces.map.BasicHashMap;

/**
 * An implementation of a custom hash map that maps integer keys to integer values.
 * This implementation uses a hash function to determine the index in an array
 * where the corresponding value is stored.
 */
public class BasicHashMapImpl implements BasicHashMap {
    private final int[] values;
    private final int mapSize;

    /**
     * Constructs a BasicMapImpl with the specified size.
     * @param size the size of the map
     */
    public BasicHashMapImpl(int size) {
        // TODO: take a hashing object
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
        int hashedKey = hash(key, mapSize); // TODO: Replace with OBJ
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
        int hashedKey = hash(key, mapSize); // TODO: replace with OBJ
        return values[hashedKey];
    }

    /**
     * Creates a new custom hash map with the specified size.
     * @param size the size of the new map.
     * @return a new BasicMap with the specified size.
     */
    @Override
    public BasicHashMap createNewMap(int size) {
        return new BasicHashMapImpl(size);
    }

    /**
     * Retrieves the size of the map.
     * @return the size of the map
     */
    @Override
    public int getMapSize() {
        return mapSize;
    }

    // TODO: remove
    public static int hash(String key, int tableSize)
    {
        int hashVal = 0;

        for( int i = 0; i < key.length(); i++ )
            hashVal += key.charAt(i);

        return hashVal % tableSize;
    }
}


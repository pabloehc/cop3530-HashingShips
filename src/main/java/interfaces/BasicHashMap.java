package interfaces;

/**
 * BasicHashMap maps string keys to integer values.
 */
public interface BasicHashMap {
    /**
     * Put a key and value into the hashmap
     * @param key to put
     * @param value to put in the key
     */
    void put(String key, int value);

    /**
     * Gets a value from the hash map
     * @param key of the value to get
     * @return the value at that key
     */
    int get(String key);

    /**
     * Get the map size
     * @return int of the size
     */
    int getMapSize();
}

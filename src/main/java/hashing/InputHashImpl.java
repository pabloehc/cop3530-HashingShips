package hashing;

import interfaces.InputHash;

public class InputHashImpl implements InputHash {

    /**
     * Hashes the given input
     * @param key to hash
     * @param hashMapSize hashmap size to use in hashing function
     * @return the value of the hash
     */
    public int hashInput(String key, int hashMapSize)
    {
        int hashVal = 0;

        for( int i = 0; i < key.length(); i++ )
            hashVal += key.charAt(i);

        return hashVal % hashMapSize;
    }

}
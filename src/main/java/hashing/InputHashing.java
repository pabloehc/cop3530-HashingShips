package hashing;

import interfaces.InputHash;

public class InputHashing implements InputHash {

    public int hashCode(String key, int hashMapSize)
    {
        int hashVal = 0;

        for( int i = 0; i < key.length(); i++ )
            hashVal += key.charAt(i);

        return hashVal % hashMapSize;
    }

}
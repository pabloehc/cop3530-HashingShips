package Hashing;

public interface InputHash {

    //The size of the hash map needed in order to hash the code
    public final int hashMapSize = 0;

    //Hashes a value entered and returns a key of the size Hashmap
    public int hashCode(String key, int hashMapSize);
}

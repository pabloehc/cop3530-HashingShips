package Hashing;

public class UserInputHashing implements inputHash {

    public int hashCode(String key) {
        int hash = key.hashCode();
        hash = hash % hashMapSize;
        return hash;
    }

}
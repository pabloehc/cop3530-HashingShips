package interfaces.map;

public interface BasicHashMap {
    BasicHashMap createNewMap(int size);
    void put(String key, int value);
    int get(String key);
    int getMapSize();
}

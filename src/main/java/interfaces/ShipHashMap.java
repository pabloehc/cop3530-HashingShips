package interfaces;

public interface ShipHashMap {

    /**
     * Attacks a certain key. If the key has a ship it decreases its lives counter by one.
     * @param key to attack.
     * @return true if the attack hit a ship, false otherwise.
     */
    boolean attack(String key);

    /**
     * Check if there are still ships in the battle map.
     * @return true if there are ships, false otherwise.
     */
    boolean hasShips();
}

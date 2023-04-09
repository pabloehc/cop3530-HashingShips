package game;

import interfaces.GameFlow;

/**
 * All void methods that print to the console to keep the game flow going.
 */
public class GameFlowImpl implements GameFlow {

    private final boolean devMode;

    GameFlowImpl(boolean devMode) {
        this.devMode = devMode;
    }

    public void showIntro() throws InterruptedException {
        System.out.println("Welcome to the HashingShips game!");
        if (!devMode) Thread.sleep(1000);
        System.out.println("There are 2 ships hidden in the map...");
        if (!devMode) Thread.sleep(2000);
        System.out.println("You write a 1 to 2 char string to attack (e.g.,'a', 'ab')...");
        if (!devMode) Thread.sleep(3000);
        System.out.println("Your input hashes to a position on the map...");
        if (!devMode) Thread.sleep(3000);
        System.out.println("No repeated input allowed!...");
        if (!devMode) Thread.sleep(2000);
        System.out.println("You have access to 3 hints available at any time, simply write [hint] in the box...");
        if (!devMode) Thread.sleep(2000);
        System.out.println("Try to sink all the ships to win the game!");
        if (!devMode) Thread.sleep(1000);
        System.out.println("--------------------------------------------------");
        if (!devMode) Thread.sleep(1000);
        System.out.println("Building map...");
        if (!devMode) Thread.sleep(1000);
        System.out.println("Ready!");
        if (!devMode) Thread.sleep(1000);
    }

    public void showAttackResult(boolean attackResult) {
        if (attackResult) {
            System.out.println("Hit! You hit a ship!");
        } else {
            System.out.println("Missed! Try again.");
        }
        System.out.println();
    }

    public void showFinalMessage() throws InterruptedException {
        System.out.println("Congratulations! You have sunk all the ships!");
        if (!devMode) Thread.sleep(1000);
    }
}

package game;

import interfaces.InputValidator;
import map.BattleMap;

import java.util.Scanner;

public class Main {

    public static boolean devMode = false;
    public static InputValidator validator;

    public static void main(String[] args) throws InterruptedException {
        BattleMap battleMap = new BattleMap(4, 2);
        Scanner scanner = new Scanner(System.in);

        intro();

        while (battleMap.hasShips()) {
            String attackKey = askForInput(scanner);

            if (!validator.isValid(attackKey)) {
                continue;
            }

            boolean attackResult = attack(battleMap, attackKey);
            showAttackResult(attackResult);
        }

        finalMessage();
        scanner.close();
    }

    private static void intro() throws InterruptedException {
        System.out.println("Welcome to the HashingShips game!");
        if (!devMode) Thread.sleep(2000);
        System.out.println("There are 2 ships hidden in the map.");
        if (!devMode) Thread.sleep(2000);
        System.out.println("Enter a 2-character string (e.g., 'ab') to attack!");
        if (!devMode) Thread.sleep(3000);
        System.out.println("Your input hashes to a position on the map.");
        if (!devMode) Thread.sleep(3000);
        System.out.println("Try to sink all the ships to win the game!");
        if (!devMode) Thread.sleep(1000);
        System.out.println("--------------------------------------------------");
        if (!devMode) Thread.sleep(1000);
        System.out.println("Building map...");
        if (!devMode) Thread.sleep(1000);
        System.out.println("Ready!");
        if (!devMode) Thread.sleep(1000);
    }

    private static String askForInput(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Enter a position to attack: ");
        return scanner.nextLine();
    }

    private static boolean attack(BattleMap battleMap, String attackKey) {
        System.out.println("Attacking position ..."); // Update to show hashcode
        return battleMap.attack(attackKey);
    }

    private static void showAttackResult(boolean attackResult) {
        if (attackResult) {
            System.out.println("Hit! You hit a ship!");
        } else {
            System.out.println("Missed! Try again.");
        }
        System.out.println();
    }

    private static void finalMessage() throws InterruptedException {
        System.out.println("Congratulations! You have sunk all the ships!");
        if (!devMode) Thread.sleep(1000);
    }
}


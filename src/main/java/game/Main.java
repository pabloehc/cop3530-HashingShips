package game;

import hashing.InputHashImpl;
import interfaces.GameFlow;
import interfaces.InputHash;
import interfaces.InputValidator;
import map.BattleMap;

import java.util.Scanner;

public class Main {

    public static boolean devMode = false;
    public static InputValidator validator;

    public static GameFlow gameFlow = new GameFlowImpl(devMode);
    public static InputHash inputHash = new InputHashImpl();

    public static void main(String[] args) throws InterruptedException {
        BattleMap battleMap = new BattleMap(4, 2);
        Scanner scanner = new Scanner(System.in);

        gameFlow.showIntro();

        while (battleMap.hasShips()) {
            String attackKey = askForInput(scanner);

            if (!validator.isValid(attackKey)) {
                continue;
            }

            boolean isSuccessfulAttack = attack(battleMap, attackKey);
            gameFlow.showAttackResult(isSuccessfulAttack, inputHash.hashInput(attackKey, battleMap.getSize()));
        }

        gameFlow.showFinalMessage();
        scanner.close();
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
}


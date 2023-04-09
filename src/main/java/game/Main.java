package game;

import hashing.InputHashImpl;
import interfaces.GameFlow;
import interfaces.InputHash;
import map.BattleMap;
import Hinter.Hints;

import java.util.Scanner;

public class Main {

    public static boolean devMode = true;
//    public static InputValidator validator;
    public static GameFlow gameFlow = new GameFlowImpl(devMode);
    public static InputHash inputHash = new InputHashImpl();



    public static void main(String[] args) throws InterruptedException {
        Hints nextHint = new Hints();
        BattleMap battleMap = new BattleMap(4, 2);
        Scanner scanner = new Scanner(System.in);

        gameFlow.showIntro();

        while (battleMap.hasShips()) {

            String attackKey = askForInput(scanner);
            if(attackKey.equalsIgnoreCase("hint")) {
               System.out.println(nextHint.getNextHint());
               System.out.println("You have " + nextHint.getSize() + " hints left.\n");
               continue;
            }
                boolean isSuccessfulAttack = attack(battleMap, attackKey);
                gameFlow.showAttackResult(isSuccessfulAttack);

//            if (!validator.isValid(attackKey)) {
//                continue;
//            }
        }

        gameFlow.showFinalMessage();
        scanner.close();
    }

    private static String askForInput(Scanner scanner) {
        System.out.println("Enter a position to attack: ");
        return scanner.nextLine();
    }

    private static boolean attack(BattleMap battleMap, String attackKey) throws InterruptedException {
        int attackPosition = inputHash.hashInput(attackKey, battleMap.getSize());
        System.out.printf("Your attack is directed to position %s...", attackPosition);
        System.out.println();
        if (!devMode) Thread.sleep(1000);
        return battleMap.attack(attackKey);
    }
}


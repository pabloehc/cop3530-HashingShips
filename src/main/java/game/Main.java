package game;

import hashing.InputHashImpl;
import interfaces.GameFlow;
import interfaces.InputHash;
import map.BattleMap;
import hinter.Hints;

import java.util.Scanner;

public class Main {

    // If true, it will skip all sleep commands for faster development
    public static boolean devMode = false;
    // Used for input validation
    public static InputValidatorImpl validator = new InputValidatorImpl();
    // Handles the game's messages to the user
    public static GameFlow gameFlow = new GameFlowImpl(devMode);
    public static InputHash inputHash = new InputHashImpl();
    // Used for providing hints to the user
    public static Hints hints = new Hints();

    /**
     * This is the main flow of our game. This method takes care of initializing the necessary dependencies,
     * asking the user for input, validating it, and attacking if necessary.
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        BattleMap battleMap = new BattleMap(4, 2);
        Scanner scanner = new Scanner(System.in);

        gameFlow.showIntro();

        while (battleMap.hasShips()) {

            String attackKey = askForInput(scanner);
            if(attackKey.equalsIgnoreCase("hint")) {
               gameFlow.showHintMessage(hints.getNextHint(), hints.getSize());
               continue;
            }

            if (!validator.isValid(attackKey)) {
                continue;
            }

            int previousNumberOfShips = battleMap.getNumberOfShips();
            boolean isSuccessfulAttack = attack(battleMap, attackKey);
            gameFlow.showAttackResult(isSuccessfulAttack, previousNumberOfShips != battleMap.getNumberOfShips());
        }

        gameFlow.showFinalMessage();
        scanner.close();
    }

    /**
     * Asks the user for input
     * @param scanner
     * @return user's input
     */
    private static String askForInput(Scanner scanner) {
        System.out.println("Enter a position to attack: ");
        return scanner.nextLine();
    }

    /**
     * Handles attacking the map at the specified position.
     * @param battleMap where the ships are placed
     * @param attackKey to attack
     * @return true if the attack was successful, false otherwise
     * @throws InterruptedException
     */
    private static boolean attack(BattleMap battleMap, String attackKey) throws InterruptedException {
        int attackPosition = inputHash.hashInput(attackKey, battleMap.getSize());
        System.out.printf("Your attack is directed to position %s...", attackPosition);
        System.out.println();
        if (!devMode) Thread.sleep(1000);
        return battleMap.attack(attackKey);
    }
}


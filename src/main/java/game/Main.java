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
        // Creates a battle map of size 4 with 2 ships in it
        BattleMap battleMap = new BattleMap(4, 2);
        Scanner scanner = new Scanner(System.in);

        // Outputs the intro to the terminal to introduce the user to the game
        gameFlow.showIntro();

        // While the map still has ships, we keep the player in the game
        while (battleMap.hasShips()) {
            int numberOfShipsBeforeAttack = battleMap.getNumberOfShips();

            // Ask the user for input
            String attackKey = askForInput(scanner);

            // Check if the user asked for a hint, if so, give one and continue
            if(attackKey.equalsIgnoreCase("hint")) {
               gameFlow.showHintMessage(hints.getNextHint(), hints.getSize());
               continue;
            }

            // Check if the input is valid, if not, continue
            if (!validator.isValid(attackKey)) {
                continue;
            }

            // Attacks at the given position
            boolean isSuccessfulAttack = attack(battleMap, attackKey);

            // Shows the attack result and checks if a ship was sunk by comparing the previous number of ships with the current one
            gameFlow.showAttackResult(isSuccessfulAttack, numberOfShipsBeforeAttack != battleMap.getNumberOfShips());
        }

        // The user won and we show the final message
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


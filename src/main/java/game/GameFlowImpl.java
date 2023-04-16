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

    /**
     * Intro message that explains the game flow and rules
     * @throws InterruptedException
     */
    public void showIntro() throws InterruptedException {
        System.out.println("Welcome to the HashingShips game!");
        System.out.println(getCoolShip());
        if (!devMode) Thread.sleep(2000);
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

    /**
     * Shows the result of the users attack
     * @param attackResult true if attack was successful else false.
     * @param sunkShip true if the sink was sunk, else false
     * @throws InterruptedException
     */
    public void showAttackResult(boolean attackResult, boolean sunkShip) throws InterruptedException {
        if (attackResult) {
            System.out.println(getCoolExplosion());
            Thread.sleep(500);
            System.out.println("Wow! You hit a ship!");
        } else {
            System.out.println("Missed! Try again.");
        }

        if (sunkShip){
            Thread.sleep(500);
            System.out.println("You sank this ship! You're so smart :)");
        }

        System.out.println();
    }

    /**
     * Message for the game ends
     * @throws InterruptedException
     */
    public void showFinalMessage() throws InterruptedException {
        System.out.println(getCoolTrophy());
        System.out.println("Congratulations! You have sunk all the ships!");
        if (!devMode) Thread.sleep(1000);
    }

    /**
     * Formats and shows the hints
     * @param hint to show.
     * @param hintsLeft in the queue.
     * @throws InterruptedException
     */
    public void showHintMessage(String hint, int hintsLeft) throws InterruptedException {
        System.out.println("You asked for a hint! Let's get one...");
        if (!devMode) Thread.sleep(1000);
        System.out.println();
        System.out.println(hint);
        System.out.println();
        if (!devMode) Thread.sleep(2000);
        System.out.println("You have " + hintsLeft + " hints left!\n");
    }

    /**
     * Cool ascii ship
     * @return the ship as a string of ascii values.
     */
    private String getCoolShip() {
        return "                __/___            \n" +
                "          _____/______|           \n" +
                "  _______/_____\\_______\\_____     \n" +
                "  \\              < < <       |    \n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
    }

    /**
     * Cool explosion ascii
     * @return the explosion as a string of ascii values
     */
    private String getCoolExplosion() {
        return "          _ ._  _ , _ ._\n" +
                "        (_ ' ( `  )_  .__)\n" +
                "      ( (  (    )   `)  ) _)\n" +
                "     (__ (_   (_ . _) _) ,__)\n" +
                "         `~~`\\ ' . /`~~`\n" +
                "              ;   ;\n" +
                "              /   \\\n" +
                "_____________/_ __ \\_____________";
    }

    /**
     * Cool trophy ascii
     * @return a trophy as a string of ascii values
     */
    private String getCoolTrophy() {
        return "                                  ___________\n" +
                "                             .---'::'        `---.\n" +
                "                            (::::::'              )\n" +
                "                            |`-----._______.-----'|\n" +
                "                            |              :::::::|\n" +
                "                           .|               ::::::!-.\n" +
                "                           \\|               :::::/|/\n" +
                "                            |               ::::::|\n" +
                "                            |   Best HashSinker  :|\n" +
                "                            |       in town   ::::|\n" +
                "                            |               ::::::|\n" +
                "                            |              .::::::|\n" +
                "                            J              :::::::F\n" +
                "                             \\            :::::::/\n" +
                "                              `.        .:::::::'\n" +
                "                                `-._  .::::::-'\n" +
                "____________________________________|  \"\"\"|\"_________________________________________\n" +
                "                                    |  :::|\n" +
                "                                    F   ::J\n" +
                "                                   /     ::\\                                        \n" +
                "                              __.-'      :::`-.__\n" +
                "                             (_           ::::::_)\n" +
                "                               `\"\"\"---------\"\"\"'";
    }
}

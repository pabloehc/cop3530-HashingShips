package interfaces;


public interface GameFlow {

    /**
     * Intro message that explains the game flow and rules
     * @throws InterruptedException
     */
    void showIntro() throws InterruptedException;

    /**
     * Shows the result of the users attack
     * @param attackResult true if attack was successful else false.
     * @param sunkShip true if the sink was sunk, else false
     * @throws InterruptedException
     */
    void showAttackResult(boolean attackResult, boolean sunkShip) throws InterruptedException;

    /**
     * Message for the game ends
     * @throws InterruptedException
     */
    void showFinalMessage() throws InterruptedException;

    /**
     * Formats and shows the hints
     * @param hint to show.
     * @param hintsLeft in the queue.
     * @throws InterruptedException
     */
    void showHintMessage(String hint, int hintsLeft) throws InterruptedException;
}

package interfaces;


public interface GameFlow {

    void showIntro() throws InterruptedException;
    void showAttackResult(boolean attackResult);
    void showFinalMessage() throws InterruptedException;

    void showHintMessage(String getHint, int HintsLeft) throws InterruptedException;
}

package interfaces;


public interface GameFlow {

    void showIntro() throws InterruptedException;
    void showAttackResult(boolean attackResult);
    void showFinalMessage() throws InterruptedException;
}

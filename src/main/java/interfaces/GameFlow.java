package interfaces;


public interface GameFlow {

    void showIntro() throws InterruptedException;
    void showAttackResult(boolean attackResult, int position);
    void showFinalMessage() throws InterruptedException;
}

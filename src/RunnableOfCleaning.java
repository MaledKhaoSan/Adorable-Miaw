
public class RunnableOfCleaning implements Runnable{
    private int countdown;
    private MiniGameCleaning targetFrame;
    private ActionHandlerOfTyping targetActionHandler;

    public RunnableOfCleaning(int countdown, MiniGameCleaning targetFrame, ActionHandlerOfTyping targetActionHandler) {
        this.countdown = countdown;
        this.targetFrame = targetFrame;
        this.targetActionHandler = targetActionHandler;
    }
    public RunnableOfCleaning(int countdown, MiniGameCleaning targetFrame) {
        this.countdown = countdown;
        this.targetFrame = targetFrame;
    }

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("TypingCountDown")) {
            try {
                while (countdown > 0) {
                    System.out.println("Game Start in "+countdown);
                    countdown--;
                    Thread.sleep(1000); // wait for 1 second
                }
                targetActionHandler.startGameTimer();

            } catch (InterruptedException e) {}
        }
    }

}

public class RunnableOfTyping implements Runnable{
    private int countdown;
    private MiniGameTyping targetFrame;
    private ActionHandlerOfTyping targetActionHandler;

    public RunnableOfTyping(int countdown, MiniGameTyping targetFrame, ActionHandlerOfTyping targetActionHandler) {
        this.countdown = countdown;
        this.targetFrame = targetFrame;
        this.targetActionHandler = targetActionHandler;
    }
    public RunnableOfTyping(int countdown, MiniGameTyping targetFrame) {
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

        else if (Thread.currentThread().getName().equals("Thread1")) {
            try {
                while (countdown > 0) {
                    System.out.println(countdown + " seconds remaining.");
                    countdown--;
                    Thread.sleep(1000); // wait for 1 second
                }
                targetActionHandler.endGameTimer();

            } catch (InterruptedException e) {}
        }
    }

}
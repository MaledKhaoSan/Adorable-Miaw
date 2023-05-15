
public class RunnableOfMainMenu implements Runnable{
    private int countdown;
    private MainMenu targetFrame;
    private ActionHandlerOfMenu targetActionHandler;

    public RunnableOfMainMenu(int countdown, MainMenu targetFrame, ActionHandlerOfMenu targetActionHandler) {
        this.countdown = countdown;
        this.targetFrame = targetFrame;
        this.targetActionHandler = targetActionHandler;
    }


    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Button1Transition")) {
            try {
                while (countdown > 0) {
                    countdown--;
                    Thread.sleep(1000);
                }
                targetActionHandler.stageScene();

            } catch (InterruptedException ignored) {}
        }
    }

}
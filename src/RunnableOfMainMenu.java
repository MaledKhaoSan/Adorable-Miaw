
public class RunnableOfMainMenu implements Runnable{
    private int countdown;
    private MainMenu targetFrame;
    private ActionHandlerOfMenu targetActionHandler;
    public RunnableOfMainMenu(){};

    public RunnableOfMainMenu(int countdown, MainMenu targetFrame, ActionHandlerOfMenu targetActionHandler) {
        this.countdown = countdown;
        this.targetFrame = targetFrame;
        this.targetActionHandler = targetActionHandler;
    }
    public RunnableOfMainMenu(int countdown, MainMenu targetFrame) {
        this.countdown = countdown;
        this.targetFrame = targetFrame;
    }

//    public synchronized void printAAndWait() {
//        System.out.println("A");
//        try {
//            Thread.sleep(3000); // sleep for 3 seconds
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }



    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Button1Transition")) {
            try {
                while (countdown > 0) {
                    countdown--;
                    Thread.sleep(1000);
                }
                targetActionHandler.nextScene();

            } catch (InterruptedException ignored) {}
        }
    }

}

public class RunnableOfTyping implements Runnable{
    private int countdown;
    private MiniGameTyping targetFrame;
    private ActionHandlerOfTyping targetActionHandler;

    public RunnableOfTyping(int countdown, MiniGameTyping targetFrame, ActionHandlerOfTyping targetActionHandler) {
        this.countdown = countdown;
        this.targetFrame = targetFrame;
        this.targetActionHandler = targetActionHandler;
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

        else if (Thread.currentThread().getName().equals("TypingStart")) {
            try {
                while (countdown > 0) {
                    if (countdown == 59){
                        //Upcasting ประกาศแม่สร้างลูก
                        CatAnimated cat = new CatCreated().CatSelected(new CatPlaying());
                        cat.setBounds(0, 0, 1280, 720);
                        targetFrame.layer.add(cat, Integer.valueOf(8));
                    }
                    if (countdown == 59){
                        //Upcasting ประกาศแม่สร้างลูก
                        CatAnimated cat = new CatCreated().CatSelected(new CatWalking());
                        cat.setBounds(0, 0, 1280, 720);
                        targetFrame.layer.add(cat, Integer.valueOf(9));
                    }
                    System.out.println(countdown + " seconds remaining.");
                    countdown--;
                    Thread.sleep(1000); // wait for 1 second
                }
                targetActionHandler.endGameTimer();

            } catch (InterruptedException e) {}
        }
    }

}
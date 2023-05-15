import canvas_modify.SceneFadeIn;
import canvas_modify.SceneModify;

public class RunnableOfMainStage implements Runnable{
    private int countdown;
    private String difficulty;
    private MainStage targetFrame;
    private int cleaningCoolDown;

    public RunnableOfMainStage(MainStage targetFrame) {
        this.targetFrame = targetFrame;

    }


    public RunnableOfMainStage(int countdown, MainStage targetFrame) {
        this.countdown = countdown;
        this.targetFrame = targetFrame;
    }

    public RunnableOfMainStage(int countdown, MainStage targetFrame, String difficulty) {
        this.countdown = countdown;
        this.targetFrame = targetFrame;
        this.difficulty = difficulty;
    }
    @Override
    public void run() {
        // Non-synchronized
        if (Thread.currentThread().getName().equals("MiniGameCleaningCountDown")) {
            try {
                while (targetFrame.isVisible()) {
                    if ((cleaningCoolDown = new AccountSaved().load().getCooldown()) > 0){
                        int minutes = (cleaningCoolDown % 3600) / 60;
                        int seconds = cleaningCoolDown % 60;
                        String formattedTime = String.format("%02d:%02d", minutes, seconds);
                        targetFrame.minigameCleaningCountDown.setText("Wait \n"+ formattedTime +"\n for the next cleaning session to begin.");

                    }
                    Thread.sleep(1000);
                    targetFrame.minigameCleaningCountDown.setText("Arghh, the cats made a mess again. Let's clean it up.");
                }
            } catch (InterruptedException ignored) {}
        }

        synchronized(this) {
            // Synchronized code
            if (Thread.currentThread().getName().equals("MiniGameTypingEnter")) {
                targetFrame.layer.add(new SceneModify().addJLayerPaneAnimate(new SceneFadeIn()), Integer.valueOf(10));
                try {
                    while (countdown > 0) {
                        countdown--;
                        Thread.sleep(1000);
                    }
                    new MiniGameTyping(difficulty);
                    targetFrame.dispose();

                } catch (InterruptedException ignored) {}
            }

            else if (Thread.currentThread().getName().equals("MiniGameCleaningEnter")) {
                targetFrame.layer.add(new SceneModify().addJLayerPaneAnimate(new SceneFadeIn()), Integer.valueOf(10));
                try {
                    while (countdown > 0) {
                        countdown--;
                        Thread.sleep(1000);
                    }
                    new MiniGameCleaning();
                    targetFrame.dispose();

                } catch (InterruptedException ignored) {}
            }
            else if (Thread.currentThread().getName().equals("MiniGameCookingEnter")) {
                targetFrame.layer.add(new SceneModify().addJLayerPaneAnimate(new SceneFadeIn()), Integer.valueOf(10));
                try {
                    while (countdown > 0) {
                        countdown--;
                        Thread.sleep(1000);
                    }
                    new MiniGameCooking();
                    targetFrame.dispose();

                } catch (InterruptedException ignored) {}
            }

            else if (Thread.currentThread().getName().equals("MainBuildingEnter")) {
                targetFrame.layer.add(new SceneModify().addJLayerPaneAnimate(new SceneFadeIn()), Integer.valueOf(10));
                try {
                    while (countdown > 0) {
                        countdown--;
                        Thread.sleep(1000);
                    }
                    new MainBuilding();
                    targetFrame.dispose();

                } catch (InterruptedException ignored) {}
            }
        }
    }

}
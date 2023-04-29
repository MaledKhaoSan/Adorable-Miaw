import canvas_modify.FadeInAnimate;
import canvas_modify.SceneModify;

public class RunnableOfMainStage implements Runnable{
    private int countdown;
    private String difficulty;
    private MainStage targetFrame;

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
    public synchronized void run() {
        if (Thread.currentThread().getName().equals("MiniGameTypingEnter")) {
            targetFrame.layer.add(new SceneModify().addJLayerPaneAnimate(new FadeInAnimate()), Integer.valueOf(10));
            try {
                while (countdown > 0) {
                    countdown--;
                    Thread.sleep(1000);
                }
                new MiniGameTyping(difficulty);
                targetFrame.dispose();

            } catch (InterruptedException ignored) {}
        }
        else if (Thread.currentThread().getName().equals("MiniGameCookingEnter")) {
            targetFrame.layer.add(new SceneModify().addJLayerPaneAnimate(new FadeInAnimate()), Integer.valueOf(10));
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
            targetFrame.layer.add(new SceneModify().addJLayerPaneAnimate(new FadeInAnimate()), Integer.valueOf(10));
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
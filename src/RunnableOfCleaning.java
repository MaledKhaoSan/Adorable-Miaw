import canvas_modify.SceneFadeInOut;
import canvas_modify.SceneModify;

import javax.swing.*;

public class RunnableOfCleaning implements Runnable{
    private int countdown;
    private MiniGameCleaning targetFrame;
    private ActionHandlerOfCleaning targetActionHandler;

    public RunnableOfCleaning(int countdown, MiniGameCleaning targetFrame, ActionHandlerOfCleaning targetActionHandler) {
        this.countdown = countdown;
        this.targetFrame = targetFrame;
        this.targetActionHandler = targetActionHandler;
    }
    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("tutorialTransition")) {
            JLabel tutorialTransition = new SceneModify().addJLayerPaneAnimate(new SceneFadeInOut());
            targetFrame.layer.add(tutorialTransition,  Integer.valueOf(11));
            try {
                while (countdown > 0) {
                    if (countdown == 1){
                        targetFrame.intro.setVisible(false);
                    }
                    countdown--;
                    Thread.sleep(1000);
                }
                targetFrame.remove(tutorialTransition);
            } catch (InterruptedException e) {}
        }

        else if (Thread.currentThread().getName().equals("stageTransition")) {
            try {
                while (countdown > 0) {
                    countdown--;
                    Thread.sleep(1000);
                }
                targetActionHandler.backToStage();
            } catch (InterruptedException ignored) {}
        }
    }
}
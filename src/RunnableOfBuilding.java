import canvas_modify.SceneFadeIn;
import canvas_modify.SceneFadeInOut;
import canvas_modify.SceneModify;

import javax.swing.*;

public class RunnableOfBuilding implements Runnable{
    private int countdown;
    private final MainBuilding targetFrame;
    private final ActionHandlerOfBuilding targetActionHandler;
    private JButton targetButton;

    public RunnableOfBuilding(int countdown, MainBuilding targetFrame, ActionHandlerOfBuilding targetActionHandler) {
        this.countdown = countdown;
        this.targetFrame = targetFrame;
        this.targetActionHandler = targetActionHandler;
    }

    public RunnableOfBuilding(int countdown, MainBuilding targetFrame, JButton targetButton, ActionHandlerOfBuilding targetActionHandler) {
        this.countdown = countdown;
        this.targetFrame = targetFrame;
        this.targetButton = targetButton;
        this.targetActionHandler = targetActionHandler;
    }


    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("HomeExit")) {
            targetFrame.layer.add(new SceneModify().addJLayerPaneAnimate(new SceneFadeIn()), Integer.valueOf(10));
            try {
                while (countdown > 0) {
                    countdown--;
                    Thread.sleep(1000);
                }
                new MainStage();
                targetFrame.dispose();

            } catch (InterruptedException ignored) {}


        }
        else if (Thread.currentThread().getName().equals("bentoFurTransition")) {
            targetButton.removeActionListener(targetActionHandler);
            JLabel tutorialTransition = new SceneModify().addJLayerPaneAnimate(new SceneFadeInOut());
            targetFrame.layer.add(tutorialTransition,  Integer.valueOf(11));
            try {
                while (countdown > 0) {
                    if (countdown == 1){
                        targetFrame.bentoFurPanel.setVisible(!targetFrame.bentoFurPanel.isVisible());
                    }
                    countdown--;
                    Thread.sleep(1000);
                }
                targetFrame.remove(tutorialTransition);
                targetButton.addActionListener(targetActionHandler);

            } catch (InterruptedException e) {}
        }

    }

}
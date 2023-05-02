import canvas_modify.FadeInAnimate;
import canvas_modify.SceneModify;

public class RunnableOfBuilding implements Runnable{
    private int countdown;
    private final MainBuilding targetFrame;
    private final ActionHandlerOfBuilding targetActionHandler;

    public RunnableOfBuilding(int countdown, MainBuilding targetFrame, ActionHandlerOfBuilding targetActionHandler) {
        this.countdown = countdown;
        this.targetFrame = targetFrame;
        this.targetActionHandler = targetActionHandler;
    }


    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("HomeExit")) {
            targetFrame.layer.add(new SceneModify().addJLayerPaneAnimate(new FadeInAnimate()), Integer.valueOf(10));
            try {
                while (countdown > 0) {
                    countdown--;
                    Thread.sleep(1000);
                }
                new MainStage();
                targetFrame.setVisible(false);

            } catch (InterruptedException ignored) {}


        }

    }

}
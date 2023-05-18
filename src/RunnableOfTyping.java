import canvas_modify.SceneModify;
import canvas_modify.SceneFadeInOut;

import javax.swing.*;

public class RunnableOfTyping implements Runnable{
    private int countdown;
    private final MiniGameTyping targetFrame;
    private final ActionHandlerOfTyping targetActionHandler;

    public RunnableOfTyping(int countdown, MiniGameTyping targetFrame, ActionHandlerOfTyping targetActionHandler) {
        this.countdown = countdown;
        this.targetFrame = targetFrame;
        this.targetActionHandler = targetActionHandler;
    }

    public void updateCountDown(int countdown){
        System.out.println(countdown + " seconds remaining.");
        targetFrame.typingCountdown.setText( Integer.toString(countdown));
    }


    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("prepareCountDown")) {
            try {
                while (countdown > 0) {
                    System.out.println("Game Start in "+countdown);
                    targetFrame.typingCountdown.setText( Integer.toString(countdown));
                    countdown--;
                    Thread.sleep(1000); // wait for 1 second
                }
                targetActionHandler.startGameTimer();

            } catch (InterruptedException e) {}
        }

        else if (Thread.currentThread().getName().equals("starter")) {
            try {
                while (countdown > 0) {
                    updateCountDown(--countdown);
                    if (countdown == 175){
                        //Upcasting ประกาศแม่สร้างลูก
                        CatAnimated cat = new CatCreated().CatGetType(2);
                        cat.setBounds(0, 0, 1280, 720);
                        targetFrame.layer.add(cat, Integer.valueOf(8));
                    }
                    if (countdown == 170){
                        //Upcasting ประกาศแม่สร้างลูก
                        CatAnimated cat = new CatCreated().CatGetType(0);
                        cat.setBounds(0, 0, 1280, 720);
                        targetFrame.layer.add(cat, Integer.valueOf(9));
                    }

                    if (countdown == 160){
                        //Upcasting ประกาศแม่สร้างลูก
                        CatAnimated cat = new CatCreated().CatGetType(1);
                        cat.setBounds(0, 0, 1280, 720);
                        targetFrame.layer.add(cat, Integer.valueOf(9));
                    }
                    Thread.sleep(1000); // wait for 1 second
                }
                targetActionHandler.endGameTimer(300);

            } catch (InterruptedException e) {}
        }

        else if (Thread.currentThread().getName().equals("normal")) {
            try {
                while (countdown > 0) {
                    updateCountDown(--countdown);
                    if (countdown == 115){
                        //Upcasting ประกาศแม่สร้างลูก
                        CatAnimated cat = new CatCreated().CatGetType(2);
                        cat.setBounds(0, 0, 1280, 720);
                        targetFrame.layer.add(cat, Integer.valueOf(8));
                    }

                    if (countdown == 100){
                        //Upcasting ประกาศแม่สร้างลูก
                        CatAnimated cat = new CatCreated().CatGetType(1);
                        cat.setBounds(0, 0, 1280, 720);
                        targetFrame.layer.add(cat, Integer.valueOf(9));
                    }
                    Thread.sleep(1000); // wait for 1 second
                }
                targetActionHandler.endGameTimer(300);

            } catch (InterruptedException e) {}
        }

        else if (Thread.currentThread().getName().equals("hard")) {
            try {
                while (countdown > 0) {
                    updateCountDown(--countdown);
                    if (countdown == 115){
                        //Upcasting ประกาศแม่สร้างลูก
                        CatAnimated cat = new CatCreated().CatGetType(2);
                        cat.setBounds(0, 0, 1280, 720);
                        targetFrame.layer.add(cat, Integer.valueOf(8));
                    }

                    if (countdown == 110){
                        //Upcasting ประกาศแม่สร้างลูก
                        CatAnimated cat = new CatCreated().CatGetType(1);
                        cat.setBounds(0, 0, 1280, 720);
                        targetFrame.layer.add(cat, Integer.valueOf(9));
                    }
                    Thread.sleep(1000); // wait for 1 second
                }
                targetActionHandler.endGameTimer(300);

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
        else if (Thread.currentThread().getName().equals("retryTransition")) {
            try {
                while (countdown > 0) {
                    countdown--;
                    Thread.sleep(1000);
                }
                targetActionHandler.retryNewGame();
            } catch (InterruptedException ignored) {}
        }



        else if (Thread.currentThread().getName().equals("tutorialTransition")) {
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
                targetActionHandler.prepareTimer();
                targetFrame.remove(tutorialTransition);
            } catch (InterruptedException e) {}
        }

    }

}
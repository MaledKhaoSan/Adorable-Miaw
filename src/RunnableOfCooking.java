import canvas_modify.*;
import javax.swing.*;
import java.util.Random;

public class RunnableOfCooking implements Runnable {
    private int countdown;
    private final MiniGameCooking targetFrame;
    private final ActionHandlerOfCooking targetActionHandler;
    private int score;
    private static String[][] puzzleSlideMenu = {
            {"Spam Musubi", "Karaage", "Japanese Pancake", "Musubi, Karaage, Pancake"},
            {"Yakisoba", "Saba Shioyaki", "Matcha Roll", "Yakisoba, Saba, Matcha"},
            {"Onigiri", "Steak", "Strawberry cake", "Onigiri, Steak, Strawberry Cake"}
    };
    private static String[] randomSlideMenu = new String[4];
    public void randomBentoSet(){
        int randomIndex = new Random().nextInt(puzzleSlideMenu.length);
        for (int i = 0; i < 4; i++) {
            randomSlideMenu[i] = puzzleSlideMenu[randomIndex][i];
        }
        targetFrame.BentoHint.setText(randomSlideMenu[3]);
    }
    public void checkingBentoSet(){
        if (randomSlideMenu[0].equals(targetFrame.mainFood.getName())
                && randomSlideMenu[1].equals(targetFrame.sideFood.getName())
                && randomSlideMenu[2].equals(targetFrame.dessertFood.getName())
           ){
            resetBentoSet();
            randomBentoSet();
            score++;
            System.out.println("YES");
        }
    }
    public void resetBentoSet(){
        targetFrame.mainFood.setIcon(null); targetFrame.mainFood.setName(null);
        targetFrame.sideFood.setIcon(null); targetFrame.sideFood.setName(null);
        targetFrame.dessertFood.setIcon(null); targetFrame.dessertFood.setName(null);
    }
    public RunnableOfCooking(MiniGameCooking targetFrame, ActionHandlerOfCooking targetActionHandler) {
        this(0, targetFrame, targetActionHandler);
    }
    public RunnableOfCooking(int countdown, MiniGameCooking targetFrame, ActionHandlerOfCooking targetActionHandler) {
        this.countdown = countdown;
        this.targetFrame = targetFrame;
        this.targetActionHandler = targetActionHandler;
    }
    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("gameChecking")) {
            randomBentoSet();
            try {
                while (true) {
                    checkingBentoSet();
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {}
        }
        if (Thread.currentThread().getName().equals("gameStart")) {
            new Thread(new RunnableOfCooking(targetFrame, targetActionHandler), "gameChecking").start();
            try {
                while (countdown > 0) {
                    System.out.println(countdown + " seconds remaining.");
                    countdown--;
                    Thread.sleep(1000); // wait for 1 second
                }
                //time out
                //ScoreChecking == false;
                //bentoChecking Interrupt
                //showScoreBoard formular by score
            } catch (InterruptedException e) {}
        }

        if (Thread.currentThread().getName().equals("tutorialTransition")) {
            targetFrame.layer.add(new SceneModify().addJLayerPaneAnimate(new introAnimate()),  Integer.valueOf(11));
            try {
                while (countdown > 0) {
                    if (countdown == 1){
                        targetFrame.intro.setVisible(false);
                    }
                    countdown--;
                    Thread.sleep(1000);
                }
                targetActionHandler.prepareTimer();
            } catch (InterruptedException e) {}
        }

        if (Thread.currentThread().getName().equals("prepareCountDown")) {
            try {
                while (countdown > 0) {
                    System.out.println("Game Start in "+countdown);
//                    targetFrame.typingCountdown.setText( Integer.toString(countdown));
                    countdown--;

                    Thread.sleep(1000); // wait for 1 second
                }
                targetActionHandler.startGameTimer();

            } catch (InterruptedException e) {}
        }
//        else if (Thread.currentThread().getName().equals("intro")) {
//            targetFrame.layer.add(new SceneModify().addJLayerPaneAnimate(new IntroFadeInAnimate(targetFrame, targetFrame.intro)), Integer.valueOf(20));
//            try {
//                while (countdown > 0) {
//                    countdown--;
//                    Thread.sleep(1000);
//                }
////                targetFrame.layer.add(new SceneModify().addJLayerPaneAnimate(new IntroFadeOutAnimate()), Integer.valueOf(20));
//                targetFrame.intro.setVisible(false);
//                randomBentoSet();
////                new Thread(new RunnableOfCooking(3, targetFrame, targetActionHandler), "gameStart").start();
//            } catch (InterruptedException ignored) {}
//        }
    }
}
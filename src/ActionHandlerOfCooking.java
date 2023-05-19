import canvas_modify.SceneFadeIn;
import canvas_modify.SceneModify;

import javax.swing.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class ActionHandlerOfCooking implements ActionListener, KeyListener, MouseListener, WindowListener{
    private final MiniGameCooking targetFrame;
    private int prepareTime = 3, tutorialsTime = 2, gameTime = 61, earnPoints;
    private static int currentIndex = 0;
    private static JLabel currentMenu;
    private static String[][] defaultSlideMenu = { {null,null,null},{null,null,null},{null,null,null} };
    private ImageIcon gameStarPath;
    public String[][] mainSlideMenu = {
            //mainIcon1
            {"Spam Musubi", "src/resource/cooking_game/mainIcon1.png", "src/resource/cooking_game/main1.png"},
            //mainIcon2
            {"Yakisoba", "src/resource/cooking_game/mainIcon2.png", "src/resource/cooking_game/main2.png"},
            //mainIcon3
            {"Onigiri", "src/resource/cooking_game/mainIcon3.png", "src/resource/cooking_game/main3.png"}
    };
    public String[][] sideSlideMenu = {
            //sideIcon1
            {"Karaage", "src/resource/cooking_game/sideIcon1.png", "src/resource/cooking_game/side1.png"},
            //sideIcon2
            {"Saba Shioyaki", "src/resource/cooking_game/sideIcon2.png", "src/resource/cooking_game/side2.png"},
            //sideIcon3
            {"Steak", "src/resource/cooking_game/sideIcon3.png", "src/resource/cooking_game/side3.png"}
    };
    public String[][] dessertSlideMenu = {
            //dessertIcon1
            {"Japanese Pancake", "src/resource/cooking_game/dessertIcon1.png", "src/resource/cooking_game/dessert1.png"},
            //dessertIcon2
            {"Matcha Roll", "src/resource/cooking_game/dessertIcon2.png", "src/resource/cooking_game/dessert2.png"},
            //dessertIcon3
            {"Strawberry cake", "src/resource/cooking_game/dessertIcon3.png", "src/resource/cooking_game/dessert3.png"}
    };

    private Account account;
    private AccountSaved accountSaved = new AccountSaved();
    public ActionHandlerOfCooking(MiniGameCooking targetFrame) {
        this.targetFrame = targetFrame;
        account = accountSaved.load();
    }
    public void prepareTimer() {
        new Thread(new RunnableOfCooking(prepareTime , targetFrame, this), "prepareCountDown").start();
    }
    public void startGameTimer() {
        new Thread(new RunnableOfCooking(gameTime, targetFrame, this), "gameStart").start();
    }

    public void backToStage(){ new MainStage(); targetFrame.dispose(); }
    public void retryNewGame(){ new MiniGameCooking(); targetFrame.dispose(); }

    public void endGameTimer(int finishedBento) {
        if (finishedBento >= 10){
            earnPoints =  finishedBento * 3; gameStarPath = new ImageIcon("src/resource/ui_transition/gameStar3.png");
        } else if (finishedBento >= 5) {
            earnPoints =  finishedBento * 2; gameStarPath = new ImageIcon("src/resource/ui_transition/gameStar2.png");
        } else {
            earnPoints =  finishedBento; gameStarPath = new ImageIcon("src/resource/ui_transition/gameStar1.png");
        }
        System.out.println("Bento:  " + "" + finishedBento);

        targetFrame.ScoreBoardStar.setIcon(gameStarPath);
        targetFrame.ScoreBoard_FinishedBento.setText(targetFrame.ScoreBoard_FinishedBento.getText() + finishedBento);
        targetFrame.ScoreBoard_EarnPoints.setText(targetFrame.ScoreBoard_EarnPoints.getText() + earnPoints);
        targetFrame.ScoreBoardBG.setVisible(true);
        account.setBalance(account.getBalance() + earnPoints);

        //Disable Area
        targetFrame.BentoHint.setVisible(false); targetFrame.BentoHintBox.setVisible(false); targetFrame.selectedFrame.setVisible(false); targetFrame.bentoArrow.setVisible(false);
        targetFrame.BentoHitBox1.setVisible(false); targetFrame.BentoHitBox2.setVisible(false); targetFrame.BentoHitBox3.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Selected Button
        if (e.getSource() == targetFrame.selectedFrameButton){
            currentMenu.setIcon(new ImageIcon(defaultSlideMenu[currentIndex][2]));
            currentMenu.setName(defaultSlideMenu[currentIndex][0]);
        }
        else if (e.getSource() == targetFrame.selectedFrameSlideRight){
            currentIndex = (currentIndex + 1) % defaultSlideMenu.length;
            targetFrame.selectedFrameName.setText(defaultSlideMenu[currentIndex][0]);
            targetFrame.selectedFrameFood.setIcon(new ImageIcon(defaultSlideMenu[currentIndex][1]));
        }
        else if (e.getSource() == targetFrame.selectedFrameSlideLeft){
            //currentIndex = (currentIndex - 1 + 3)% 3
            currentIndex = (currentIndex - 1 + defaultSlideMenu.length) % defaultSlideMenu.length;
            targetFrame.selectedFrameName.setText(defaultSlideMenu[currentIndex][0]);
            targetFrame.selectedFrameFood.setIcon(new ImageIcon(defaultSlideMenu[currentIndex][1]));
        }
        else if (e.getSource() == targetFrame.BentoHitBox1){
            updateSlideMenu(mainSlideMenu, targetFrame.mainFood, 185,160);
        }
        else if (e.getSource() == targetFrame.BentoHitBox2){
            updateSlideMenu(sideSlideMenu, targetFrame.sideFood, 425, 140);
        }
        else if (e.getSource() == targetFrame.BentoHitBox3){
            updateSlideMenu(dessertSlideMenu, targetFrame.dessertFood, 460, 335);
        }

        else if (e.getSource() == targetFrame.ScoreBoardButton1) {
            targetFrame.ScoreBoardButton1.removeActionListener(this);
            targetFrame.layer.add(new SceneModify().addJLayerPaneAnimate(new SceneFadeIn()), Integer.valueOf(30));
            new Thread(new RunnableOfCooking(prepareTime, targetFrame, this), "retryTransition").start();
        }
        else if (e.getSource() == targetFrame.ScoreBoardButton2) {
            targetFrame.ScoreBoardButton2.removeActionListener(this);
            targetFrame.layer.add(new SceneModify().addJLayerPaneAnimate(new SceneFadeIn()), Integer.valueOf(30));
            new Thread(new RunnableOfCooking(prepareTime, targetFrame, this), "stageTransition").start();
        }
    }
    public void updateSlideMenu(String[][] targetSlide, JLabel targetMenu, int arrowX, int arrowY){
        int numRows = 3;
        int numCols = 3;
        defaultSlideMenu = new String[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            System.arraycopy(targetSlide[i], 0, defaultSlideMenu[i], 0, numCols);
        }
        targetFrame.selectedFrameName.setText(defaultSlideMenu[currentIndex][0]);
        targetFrame.selectedFrameFood.setIcon(new ImageIcon(defaultSlideMenu[currentIndex][1]));
        targetFrame.selectedFrame.setVisible(true);
        targetFrame.bentoArrow.setLocation(arrowX,arrowY);
        currentMenu = targetMenu;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE & targetFrame.intro.isVisible()) {
            if (targetFrame.tutorial1.isVisible()) {
                targetFrame.tutorial1.setVisible(false);
            } else if (targetFrame.tutorial2.isVisible()) {
                targetFrame.intro.removeMouseListener(this);
                targetFrame.intro.removeKeyListener(this);
                new Thread(new RunnableOfCooking(tutorialsTime, targetFrame, this), "tutorialTransition").start();
            }
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == targetFrame.intro) {
            targetFrame.intro.requestFocusInWindow();
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Window is closing save");}

    @Override
    public void windowClosed(WindowEvent e) {
        targetFrame.soundPlayer.stopAudio();
        System.out.println("Window is closed");
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
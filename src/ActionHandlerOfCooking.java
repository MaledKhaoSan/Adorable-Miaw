import canvas_modify.IntroFadeInAnimate;
import canvas_modify.*;

import javax.swing.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class ActionHandlerOfCooking implements ActionListener, KeyListener, MouseListener{
    private final MiniGameCooking targetFrame;
    private int prepareTime = 3, tutorialsTime = 2, gameTime = 60;
    private static int currentIndex = 0;
    private static JLabel currentMenu;
    private static String[][] defaultSlideMenu = { {null,null,null},{null,null,null},{null,null,null} };
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
    public ActionHandlerOfCooking(MiniGameCooking targetFrame) {
        this.targetFrame = targetFrame;
    }


    public void prepareTimer() {
        new Thread(new RunnableOfCooking(prepareTime , targetFrame, this), "prepareCountDown").start();

    }
    public void startGameTimer() {
        new Thread(new RunnableOfCooking(gameTime, targetFrame, this), "gameStart").start();
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
                targetFrame.tutorial2.setVisible(false);
            } else if (targetFrame.tutorial3.isVisible()) {
                new Thread(new RunnableOfCooking(tutorialsTime, targetFrame, this), "tutorialTransition").start();
//                targetFrame.layer.add(new SceneModify().addJLayerPaneAnimate(new introAnimate()), Integer.valueOf(20));
////                new Thread(new RunnableOfCooking(waiter, targetFrame, this), "intro").start();
//
//                targetFrame.intro.setVisible(false);
//                new Thread(new RunnableOfCooking(3, targetFrame, ActionHandlerOfCooking.this), "gameStart").start();
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
}
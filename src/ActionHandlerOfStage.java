
import javax.swing.*;
import java.awt.event.*;


public class ActionHandlerOfStage implements ActionListener, MouseListener, MouseMotionListener, WindowListener {
    private MainStage targetFrame;
    private AccountSaved accountSaved = new AccountSaved();

    public ActionHandlerOfStage(MainStage targetFrame) {
        this.targetFrame = targetFrame;
    }

    public void mouseDragged(MouseEvent e) {}

    public void mouseMoved(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == targetFrame.minigameTypingEnter & (!targetFrame.isMinigameIsSelect())) {
            targetFrame.setMinigameIsSelect(true);
            targetFrame.minigameTypingUI.setVisible(true);
        } else if (e.getSource() == targetFrame.minigameCleaningEnter & (!targetFrame.isMinigameIsSelect())) {
            targetFrame.setMinigameIsSelect(true);
            targetFrame.minigameCleaningUI.setVisible(true);
        } else if (e.getSource() == targetFrame.minigameCookingEnter & (!targetFrame.isMinigameIsSelect())) {
            targetFrame.setMinigameIsSelect(true);
            targetFrame.minigameCookingUI.setVisible(true);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == targetFrame.minigameTypingEnter & (!targetFrame.isMinigameIsSelect())){
            ImageIcon newIcon = new ImageIcon("src/resource/stage_canvas/minigameTypingEnterAnimate.gif");
            targetFrame.minigameTypingEnter.setIcon(newIcon);

        }
        else if (e.getSource() == targetFrame.minigameCleaningEnter & (!targetFrame.isMinigameIsSelect())){
            ImageIcon newIcon = new ImageIcon("src/resource/stage_canvas/minigameCleaningEnterAnimate.gif");
            targetFrame.minigameCleaningEnter.setIcon(newIcon);
        }
        else if (e.getSource() == targetFrame.minigameCookingEnter & (!targetFrame.isMinigameIsSelect())){
            ImageIcon newIcon = new ImageIcon("src/resource/stage_canvas/minigameCookingEnterAnimate.gif");
            targetFrame.minigameCookingEnter.setIcon(newIcon);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == targetFrame.minigameTypingEnter & (!targetFrame.isMinigameIsSelect())){
            ImageIcon newIcon = new ImageIcon("src/resource/stage_canvas/minigameTypingEnter.png");
            targetFrame.minigameTypingEnter.setIcon(newIcon);
        }
        else if (e.getSource() == targetFrame.minigameCleaningEnter & (!targetFrame.isMinigameIsSelect())){
            ImageIcon newIcon = new ImageIcon("src/resource/stage_canvas/minigameCleaningEnter.png");
            targetFrame.minigameCleaningEnter.setIcon(newIcon);
        }
        else if (e.getSource() == targetFrame.minigameCookingEnter & (!targetFrame.isMinigameIsSelect())){
            ImageIcon newIcon = new ImageIcon("src/resource/stage_canvas/minigameCookingEnter.png");
            targetFrame.minigameCookingEnter.setIcon(newIcon);
//            targetFrame.setVisible(false);
//            Account.setBalance(Account.getBalance() + 10);
//            System.out.println(Account.getBalance());
//            new MiniGameCooking();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == targetFrame.minigameTypingUIButton1) {
            targetFrame.setMinigameIsSelect(false);
            targetFrame.minigameTypingUI.setVisible(false);
            targetFrame.minigameTypingEnter.setIcon(new ImageIcon("src/resource/stage_canvas/minigameTypingEnter.png"));
        } else if (e.getSource() == targetFrame.minigameTypingUIButton2) {
            targetFrame.minigameTypingUI.setIcon(new ImageIcon("src/resource/stage_canvas/minigameDifficultyUI.png"));
            targetFrame.minigameTypingUIButton1.setVisible(false);
            targetFrame.minigameTypingUIButton2.setVisible(false);
            targetFrame.minigameTypingUIButton3.setVisible(true);
            targetFrame.minigameTypingDifficulty1.setVisible(true);
            targetFrame.minigameTypingDifficulty2.setVisible(true);
            targetFrame.minigameTypingDifficulty3.setVisible(true);


        } else if (e.getSource() == targetFrame.minigameTypingUIButton3){
            targetFrame.minigameTypingUI.setIcon(new ImageIcon("src/resource/stage_canvas/minigameTypingUI.png"));
            targetFrame.minigameTypingUIButton1.setVisible(true);
            targetFrame.minigameTypingUIButton2.setVisible(true);
            targetFrame.minigameTypingUIButton3.setVisible(false);
            targetFrame.minigameTypingDifficulty1.setVisible(false);
            targetFrame.minigameTypingDifficulty2.setVisible(false);
            targetFrame.minigameTypingDifficulty3.setVisible(false);

        }else if (e.getSource() == targetFrame.minigameTypingDifficulty1){
            targetFrame.minigameTypingDifficulty1.removeActionListener(this);
            new Thread(new RunnableOfMainStage(1, targetFrame, "starter"), "MiniGameTypingEnter").start();

        }else if (e.getSource() == targetFrame.minigameTypingDifficulty2){
            targetFrame.minigameTypingDifficulty2.removeActionListener(this);
            new Thread(new RunnableOfMainStage(1, targetFrame, "normal"), "MiniGameTypingEnter").start();

        }else if (e.getSource() == targetFrame.minigameTypingDifficulty3){
            targetFrame.minigameTypingDifficulty3.removeActionListener(this);
            new Thread(new RunnableOfMainStage(1, targetFrame, "hard"), "MiniGameTypingEnter").start();




        //Cleaning Enter UX
        } else if (e.getSource() == targetFrame.minigameCleaningUIButton1) {
            targetFrame.setMinigameIsSelect(false);
            targetFrame.minigameCleaningUI.setVisible(false);
            targetFrame.minigameCleaningEnter.setIcon(new ImageIcon("src/resource/stage_canvas/minigameCleaningEnter.png"));

        } else if (e.getSource() == targetFrame.minigameCleaningUIButton2) {
            targetFrame.minigameCleaningUI.setIcon(new ImageIcon("src/resource/stage_canvas/minigameDifficultyUI.png"));
            targetFrame.minigameCleaningUIButton1.setVisible(false);
            targetFrame.minigameCleaningUIButton2.setVisible(false);
            targetFrame.minigameCleaningUIButton3.setVisible(true);
            targetFrame.minigameCleaningStart.setVisible(true);
            targetFrame.minigameCleaningCountDown.setVisible(true);
        } else if (e.getSource() == targetFrame.minigameCleaningUIButton3) {

            targetFrame.minigameCleaningUI.setIcon(new ImageIcon("src/resource/stage_canvas/minigameCleaningUI.png"));
            targetFrame.minigameCleaningUIButton1.setVisible(true);
            targetFrame.minigameCleaningUIButton2.setVisible(true);
            targetFrame.minigameCleaningUIButton3.setVisible(false);
            targetFrame.minigameCleaningStart.setVisible(false);
            targetFrame.minigameCleaningCountDown.setVisible(false);
        } else if (e.getSource() == targetFrame.minigameCleaningStart) {
            if (accountSaved.load().getCooldown() <= 0){
                new Thread(new RunnableOfMainStage(1, targetFrame), "MiniGameCleaningEnter").start();
            }

            //Cooking Enter UX
        } else if (e.getSource() == targetFrame.minigameCookingUIButton1) {
            targetFrame.setMinigameIsSelect(false);
            targetFrame.minigameCookingUI.setVisible(false);
            targetFrame.minigameCookingEnter.setIcon(new ImageIcon("src/resource/stage_canvas/minigameCookingEnter.png"));
        } else if (e.getSource() == targetFrame.minigameCookingUIButton2) {
            targetFrame.minigameCookingUI.setIcon(new ImageIcon("src/resource/stage_canvas/minigameDifficultyUI.png"));
            targetFrame.minigameCookingUIButton1.setVisible(false);
            targetFrame.minigameCookingUIButton2.setVisible(false);
            targetFrame.minigameCookingUIButton3.setVisible(true);
            targetFrame.minigameCookingDifficulty1.setVisible(true);
            targetFrame.minigameCookingDifficulty2.setVisible(true);
            targetFrame.minigameCookingDifficulty3.setVisible(true);

        } else if (e.getSource() == targetFrame.minigameCookingUIButton3){
            targetFrame.minigameCookingUI.setIcon(new ImageIcon("src/resource/stage_canvas/minigameCookingUI.png"));
            targetFrame.minigameCookingUIButton1.setVisible(true);
            targetFrame.minigameCookingUIButton2.setVisible(true);
            targetFrame.minigameCookingUIButton3.setVisible(false);
            targetFrame.minigameCookingDifficulty1.setVisible(false);
            targetFrame.minigameCookingDifficulty2.setVisible(false);
            targetFrame.minigameCookingDifficulty3.setVisible(false);

        }else if (e.getSource() == targetFrame.minigameCookingDifficulty1){
            targetFrame.minigameCookingDifficulty1.removeActionListener(this);
            new Thread(new RunnableOfMainStage(1, targetFrame, "starter"), "MiniGameCookingEnter").start();

        }else if (e.getSource() == targetFrame.minigameCookingDifficulty2){
            targetFrame.minigameCookingDifficulty2.removeActionListener(this);
            new Thread(new RunnableOfMainStage(1, targetFrame, "normal"), "MiniGameCookingEnter").start();

        }else if (e.getSource() == targetFrame.minigameCookingDifficulty3) {
            targetFrame.minigameCookingDifficulty3.removeActionListener(this);
            new Thread(new RunnableOfMainStage(1, targetFrame, "hard"), "MiniGameCookingEnter").start();
        }

        else if (e.getSource() == targetFrame.homeEnter) {
            targetFrame.homeEnter.removeActionListener(this);
            new Thread(new RunnableOfMainStage(1, targetFrame), "MainBuildingEnter").start();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        accountSaved.save();
        System.out.println("Window is closing save");}

    @Override
    public void windowClosed(WindowEvent e) {
        accountSaved.save();
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
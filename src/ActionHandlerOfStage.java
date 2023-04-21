
import javax.swing.*;
//import com.example.MainStage;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class ActionHandlerOfStage implements MouseListener, MouseMotionListener {
    private MainStage targetFrame;
    private String targetActionID;
    private String targetRequestID;
    private JLabel targetLabel;

    public ActionHandlerOfStage(MainStage targetFrame, JLabel targetLabel) {
        this.targetFrame = targetFrame;
        this.targetLabel = targetLabel;
    }
    public ActionHandlerOfStage(String targetActionID, MainStage targetFrame, JLabel targetLabel) {
        this.targetActionID = targetActionID;
        this.targetFrame = targetFrame;
        this.targetLabel = targetLabel;
    }

//    public ActionHandlerOfStage(String targetActionID, String targetRequestID, MainStage targetFrame, JLabel targetLabel) {
//        this.targetActionID = targetActionID;
//        this.targetRequestID = targetRequestID;
//        this.targetFrame = targetFrame;
//        this.targetLabel = targetLabel;
//    }
    public ActionHandlerOfStage(String targetActionID) {
        this.targetActionID = targetActionID;
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
        } else if (e.getSource() == targetFrame.minigameTypingUIButton1) {
            targetFrame.setMinigameIsSelect(false);
            targetFrame.minigameTypingUI.setVisible(false);
            ImageIcon newIcon = new ImageIcon("src/stage_canvas/minigameTypingEnter.png");
            targetFrame.minigameTypingEnter.setIcon(newIcon);
        } else if (e.getSource() == targetFrame.minigameTypingUIButton2) {
            targetFrame.setVisible(false);
            new MiniGameTyping();

        } else if (e.getSource() == targetFrame.minigameCleaningEnter & (!targetFrame.isMinigameIsSelect())) {
            targetFrame.setMinigameIsSelect(true);
            targetFrame.minigameCleaningUI.setVisible(true);
        } else if (e.getSource() == targetFrame.minigameCleaningUIButton1) {
            targetFrame.setMinigameIsSelect(false);
            targetFrame.minigameCleaningUI.setVisible(false);
            ImageIcon newIcon = new ImageIcon("src/stage_canvas/minigameCleaningEnter.png");
            targetFrame.minigameCleaningEnter.setIcon(newIcon);
        } else if (e.getSource() == targetFrame.minigameCleaningUIButton2) {
            targetFrame.setVisible(false);
            new MiniGameCleaning();

        } else if (e.getSource() == targetFrame.minigameCookingEnter & (!targetFrame.isMinigameIsSelect())) {
            targetFrame.setMinigameIsSelect(true);
            targetFrame.minigameCookingUI.setVisible(true);
        } else if (e.getSource() == targetFrame.minigameCookingUIButton1) {
            targetFrame.setMinigameIsSelect(false);
            targetFrame.minigameCookingUI.setVisible(false);
            ImageIcon newIcon = new ImageIcon("src/stage_canvas/minigameCookingEnter.png");
            targetFrame.minigameCookingEnter.setIcon(newIcon);
        } else if (e.getSource() == targetFrame.minigameCookingUIButton2) {
            targetFrame.setVisible(false);
            new MiniGameCooking();
        }


    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == targetFrame.minigameTypingEnter & (!targetFrame.isMinigameIsSelect())){
            ImageIcon newIcon = new ImageIcon("src/stage_canvas/minigameTypingEnterAnimate.gif");
            targetFrame.minigameTypingEnter.setIcon(newIcon);

        }
        else if (e.getSource() == targetFrame.minigameCleaningEnter & (!targetFrame.isMinigameIsSelect())){
            ImageIcon newIcon = new ImageIcon("src/stage_canvas/minigameCleaningEnterAnimate.gif");
            targetFrame.minigameCleaningEnter.setIcon(newIcon);
        }
        else if (e.getSource() == targetFrame.minigameCookingEnter & (!targetFrame.isMinigameIsSelect())){
            ImageIcon newIcon = new ImageIcon("src/stage_canvas/minigameCookingEnterAnimate.gif");
            targetFrame.minigameCookingEnter.setIcon(newIcon);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == targetFrame.minigameTypingEnter & (!targetFrame.isMinigameIsSelect())){
            ImageIcon newIcon = new ImageIcon("src/stage_canvas/minigameTypingEnter.png");
            targetFrame.minigameTypingEnter.setIcon(newIcon);
        }
        else if (e.getSource() == targetFrame.minigameCleaningEnter & (!targetFrame.isMinigameIsSelect())){
            ImageIcon newIcon = new ImageIcon("src/stage_canvas/minigameCleaningEnter.png");
            targetFrame.minigameCleaningEnter.setIcon(newIcon);
        }
        else if (e.getSource() == targetFrame.minigameCookingEnter & (!targetFrame.isMinigameIsSelect())){
            ImageIcon newIcon = new ImageIcon("src/stage_canvas/minigameCookingEnter.png");
            targetFrame.minigameCookingEnter.setIcon(newIcon);
//            targetFrame.setVisible(false);
//            Account.setBalance(Account.getBalance() + 10);
//            System.out.println(Account.getBalance());
//            new MiniGameCooking();
        }
    }
}
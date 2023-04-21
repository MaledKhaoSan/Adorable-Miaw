import canvas_modify.SceneModify;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ActionHandlerOfCleaning extends JFrame implements ActionListener, MouseListener {
    private MiniGameCleaning targetFrame;
    private CleaningMissionCreate cleaningMissionCreate;
    private String targetActionID;
    private String targetRequestID;
    private JLabel targetLabel;
    private JButton targetButton;
    private JLayeredPane targetLayer;

    //Heart Score
//    private RecieveAndBuy getAccount;
//    public ActionHandlerOfCooking(RecieveAndBuy getAccount){
//        this.getAccount = getAccount;
//    }


    public ActionHandlerOfCleaning(String targetActionID, MiniGameCleaning targetFrame, JButton targetButton) {
        this.targetActionID = targetActionID;
        this.targetFrame = targetFrame;
        this.targetButton = targetButton;
    }
    public ActionHandlerOfCleaning() {}
    public ActionHandlerOfCleaning(String targetActionID, MiniGameCleaning targetFrame, JLabel targetLabel) {this.targetActionID = targetActionID; this.targetFrame = targetFrame; this.targetLabel = targetLabel;}
    public ActionHandlerOfCleaning(String targetActionID) {
        this.targetActionID = targetActionID;
    }
    public ActionHandlerOfCleaning(MiniGameCleaning targetFrame, JLabel targetLabel){
        this.targetFrame = targetFrame;
        this.targetLabel = targetLabel;
    }

    public ActionHandlerOfCleaning(CleaningMissionCreate cleaningMissionCreate, JLabel targetLabel){
        this.cleaningMissionCreate = cleaningMissionCreate;
        this.targetLabel = targetLabel;
    }

    public void Cleaning_MiniGameFinished() {
        System.out.println("Minigame Finished");
    }

    @Override
    public void actionPerformed(ActionEvent event) {}

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == targetFrame.Button1) {
            System.out.println("Clicked on Label 1");
            targetFrame.Challenge1.setVisible(true);
            targetFrame.Challenge1.add(new CleaningMissionCreate(targetFrame, targetFrame.Challenge1));
        }
        else if (e.getSource() == targetFrame.Button2) {
            System.out.println("Clicked on Label 2");
            targetFrame.layer.add(new SceneModify().createAnimatedLabel());

//            targetFrame.layer.add(new CatWalking("src/typing_game/CatSpriteSheet2.png"){{
//                setBounds(0, 0, 1280, 720);
//            }},  Integer.valueOf(11));

        } else if (e.getSource() == targetFrame.scoreBoard) {
            System.out.println("Can Click");
//            targetFrame.Challenge1.setVisible(false);
//            targetFrame.Challenge2.setVisible(true);
//            targetFrame.Challenge2.add(new CleaningMissionCreate(targetFrame, targetFrame.Challenge2));
        }
//            targetFrame.add(new CleaningMissionCreate());
//            System.out.println(targetFrame.getBounds());
//            Account.setBalance(Account.getBalance() + 10);

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
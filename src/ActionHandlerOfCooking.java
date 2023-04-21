import javax.swing.*;
import java.awt.event.*;


public class ActionHandlerOfCooking implements ActionListener, MouseListener {
    private int mouseX, mouseY;

    private MiniGameCooking targetFrame;
    private String targetActionID;
    private String targetRequestID;
    private JLabel targetLabel;
    private JButton targetButton;

    //Heart Score
//    private RecieveAndBuy getAccount;
//    public ActionHandlerOfCooking(RecieveAndBuy getAccount){
//        this.getAccount = getAccount;
//    }
    public ActionHandlerOfCooking(String targetActionID, MiniGameCooking targetFrame, JButton targetButton) {
        this.targetActionID = targetActionID;
        this.targetFrame = targetFrame;
        this.targetButton = targetButton;
    }
    public ActionHandlerOfCooking(MiniGameCooking targetFrame, JLabel targetLabel) {
        this.targetFrame = targetFrame;
        this.targetLabel = targetLabel;
    }
    public ActionHandlerOfCooking(String targetActionID) {
        this.targetActionID = targetActionID;
    }

    public ActionHandlerOfCooking(MiniGameCooking miniGameCooking) {

    }

    @Override
    public void actionPerformed(ActionEvent event) {}

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == targetFrame.JLabelButton1 | e.getSource() == targetFrame.JLabelButton2){
            targetFrame.currentIndex = (targetFrame.currentIndex + 1) % targetFrame.array.length;
            int currentElement = targetFrame.array[targetFrame.currentIndex];
            System.out.println(currentElement); // Print the current element
//            Account.setBalance(Account.getBalance() + 10);
        }
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
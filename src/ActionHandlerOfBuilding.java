import javax.swing.*;
import java.awt.event.*;


public class ActionHandlerOfBuilding implements ActionListener{
    private final MainBuilding targetFrame;
    private JLabel targetLabel;
    private JButton targetButton;

    public ActionHandlerOfBuilding(MainBuilding targetFrame) {
        this.targetFrame = targetFrame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == targetFrame.homeExit) {
            new Thread(new RunnableOfBuilding(1, targetFrame, this), "HomeExit").start();
        }
    }
}
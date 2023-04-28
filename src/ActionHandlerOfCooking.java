import java.awt.event.*;


public class ActionHandlerOfCooking implements ActionListener {

    private MiniGameCooking targetFrame;

    public ActionHandlerOfCooking(MiniGameCooking targetFrame) {
        this.targetFrame = targetFrame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == targetFrame.JLabelButton1){
            main.setVisible(true);
            desert.setVisible(true);
            side.setVisible(true);
            box.setVisible(true);
        }
    }


}
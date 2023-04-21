import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ActionHandlerOfMenu implements ActionListener, MouseMotionListener{
    private MainMenu targetFrame;
    private String getActionID;
    private JLabel label;
    private JButton getButton;
    private int mouseX, mouseY;
    private boolean running;
    public ActionHandlerOfMenu(MainMenu targetFrame, JButton getButton) {
        this.targetFrame = targetFrame;
        this.getButton = getButton;
    }


    // Define the actionPerformed() method outside the anonymous inner class
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == targetFrame.menuButton1){
            targetFrame.menuIsSelected = true;
            targetFrame.panel.repaint();
            targetFrame.panel.repaint();
            targetFrame.menuButton1.setVisible(false); // Disables the button
            targetFrame.difficultyButton1.setVisible(true);
            targetFrame.difficultyButton2.setVisible(true);
            targetFrame.setVisible(true);
        } else if (e.getSource() == targetFrame.difficultyButton1){
            targetFrame.menuIsSelected = false;
            targetFrame.difficultyButton1.setVisible(false);
            targetFrame.difficultyButton2.setVisible(false);

            targetFrame.menuButton1.setVisible(true); // Disables the button
            targetFrame.panel.repaint();
        } else if (e.getSource() == targetFrame.difficultyButton2){
            targetFrame.setVisible(false);
            targetFrame.running = false;
            new MainStage();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
            mouseX = e.getX();
            mouseY = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
            mouseX = e.getX();
            mouseY = e.getY();
    }
}
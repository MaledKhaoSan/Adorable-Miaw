import canvas_modify.SceneModify;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ActionHandlerOfMenu implements ActionListener{
    private MainMenu targetFrame;
    private JButton targetButton;
    private String getActionID;
    private JLabel label;
    private int mouseX, mouseY;
    private boolean running;
    public ActionHandlerOfMenu(MainMenu targetFrame, JButton targetButton) {
        this.targetFrame = targetFrame;
        this.targetButton = targetButton;
    }


    // Define the actionPerformed() method outside the anonymous inner class
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == targetFrame.menuButton1) {
            targetFrame.layer.add(new SceneModify().addJLayerPaneFadeInAnimate());
            new Thread(new RunnableOfMainMenu(1, targetFrame, this), "Button1Transition").start();
        }
    }

    public void nextScene(){
        new MainStage();
        targetFrame.setVisible(false);
    }
}
import canvas_modify.FadeInAnimate;
import canvas_modify.SceneModify;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ActionHandlerOfMenu implements ActionListener{
    private final MainMenu targetFrame;

    public ActionHandlerOfMenu(MainMenu targetFrame) {
        this.targetFrame = targetFrame;
    }


    // Define the actionPerformed() method outside the anonymous inner class
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == targetFrame.menuButton1) {
            targetFrame.layer.add(new SceneModify().addJLayerPaneAnimate(new FadeInAnimate()));
            new Thread(new RunnableOfMainMenu(1, targetFrame, this), "Button1Transition").start();
        }
    }

    public void stageScene(){
        new MainStage();
        targetFrame.setVisible(false);
    }
}
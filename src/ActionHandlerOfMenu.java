import canvas_modify.SceneFadeIn;
import canvas_modify.SceneModify;
import java.awt.event.*;

public class ActionHandlerOfMenu implements WindowListener, ActionListener{
    private final MainMenu targetFrame;
    private Account account;
    private AccountSaved accountSaved = new AccountSaved();

    public ActionHandlerOfMenu(MainMenu targetFrame) {
        account = accountSaved.load();
        this.targetFrame = targetFrame;
    }


    // Define the actionPerformed() method outside the anonymous inner class
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == targetFrame.menuButton1) {
            targetFrame.menuButton1.removeActionListener(this);
            targetFrame.layer.add(new SceneModify().addJLayerPaneAnimate(new SceneFadeIn()));
            new Thread(new RunnableOfMainMenu(1, targetFrame, this), "Button1Transition").start();
        }
    }

    public void stageScene(){
        new MainStage();
        targetFrame.dispose();
    }
    @Override
    public void windowClosing(WindowEvent e) {
        accountSaved.save();
        System.out.println("Window is closing save");}

    @Override
    public void windowClosed(WindowEvent e) {
        accountSaved.save();
        targetFrame.soundPlayer.stopAudio();
        System.out.println("Window is closed");}
    @Override
    public void windowOpened(WindowEvent e) {

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
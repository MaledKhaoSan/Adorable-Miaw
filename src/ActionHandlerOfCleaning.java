import canvas_modify.SceneFadeIn;
import canvas_modify.SceneModify;
import java.awt.event.*;


public class ActionHandlerOfCleaning implements ActionListener, KeyListener, MouseListener, WindowListener{
    private MiniGameCleaning targetFrame;
    private final static int tutorialsTime = 1;
    private Account account;
    private final AccountSaved accountSaved = new AccountSaved();



    public ActionHandlerOfCleaning(MiniGameCleaning targetFrame) { this.targetFrame = targetFrame;}
    public void startGameTimer() { targetFrame.requestFocusInWindow();new CleaningMissionCreate(targetFrame, targetFrame.Challenge1, "");}
    public void endGameTimer(){
        System.out.println("[ already set Mini game Cleaning Cool down ]");
        account = accountSaved.load();
        account.setCooldown(300);
        account.setBalance(account.getBalance() + 100);
        accountSaved.save();
        Thread thread = new Thread(new CooldownAftergame()); thread.start();
    }
    public void backToStage(){ new MainStage(); targetFrame.dispose(); }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == targetFrame.ScoreBoardButton1) { targetFrame.ScoreBoardButton1.removeActionListener(this);

            endGameTimer();
            targetFrame.layer.add(new SceneModify().addJLayerPaneAnimate(new SceneFadeIn()), Integer.valueOf(30));
            new Thread(new RunnableOfCleaning(tutorialsTime, targetFrame, this), "stageTransition").start();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {
        //Tutorials <3
        if (e.getKeyCode() == KeyEvent.VK_SPACE & targetFrame.intro.isVisible()) {
            if (targetFrame.tutorial1.isVisible()) {
                targetFrame.tutorial1.setVisible(false);
            } else if (targetFrame.tutorial2.isVisible()) {
                targetFrame.intro.removeMouseListener(this);
                targetFrame.intro.removeKeyListener(this);
                int tutorialsTime = 2;
                startGameTimer();
                new Thread(new RunnableOfCleaning(tutorialsTime, targetFrame, this), "tutorialTransition").start();
            }
        }
    }
    @Override
    public void mousePressed(MouseEvent e) { if (e.getSource() == targetFrame.intro) { targetFrame.intro.requestFocusInWindow(); } }
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Window is closing save");}

    @Override
    public void windowClosed(WindowEvent e) {
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
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;


public class ActionHandlerOfTyping implements KeyListener, MouseListener, MouseMotionListener {
    private int mouseX, mouseY;
    private MiniGameTyping targetFrame;
    private String targetActionID;
    private String targetRequestID;
    private JLabel targetLabel;
    private int minigameTimmer;
    public ActionHandlerOfTyping(String targetActionID, MiniGameTyping targetFrame, JLabel targetLabel) {
        this.targetActionID = targetActionID;
        this.targetFrame = targetFrame;
        this.targetLabel = targetLabel;
    }

    public ActionHandlerOfTyping(String targetActionID, String targetRequestID, MiniGameTyping targetFrame, JLabel targetLabel) {
        this.targetActionID = targetActionID;
        this.targetRequestID = targetRequestID;
        this.targetFrame = targetFrame;
        this.targetLabel = targetLabel;
    }
    public ActionHandlerOfTyping(String targetActionID) {
        this.targetActionID = targetActionID;
    }
    public ActionHandlerOfTyping(MiniGameTyping targetFrame) {
        this.targetFrame = targetFrame;
    }
    public void startGameTimer() {
        targetFrame.generateNewWord();
        targetFrame.setCurrentWordRunning(true);


        CatAnimated cat = new CatType().CatCreated(new CatWalking());
        cat.setBounds(0, 0, 1280, 720);
        targetFrame.layer.add(cat, Integer.valueOf(11));






//        targetFrame.layer.add( new CatType.CatCreated(new CatAnimated()) {{
//            setBounds(0, 0, 1280, 720);
//        }},  Integer.valueOf(11));

        new Thread(new RunnableOfTyping(60, targetFrame, this), "Thread1").start();

    }
    public void endGameTimer() {
        targetFrame.ScoreBaordBG.setVisible(true);
    }



    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (targetFrame.isCurrentWordRunning()) {
            char typedChar = e.getKeyChar();
            if (typedChar == targetFrame.getCurrentWord().charAt(targetFrame.getCurrentWordStart())) {
                targetFrame.setCurrentWordStart(targetFrame.getCurrentWordStart() + 1);
                if (targetFrame.getCurrentWord().length() == targetFrame.getCurrentWordStart()) {
                    targetFrame.setCurrentWordRunning(false);
                    System.out.println("LAST WORD");
                }
                targetFrame.wordLabel.setText("<html><font style='font-family: Sabreen Regular Demo; font-size: 30px; color: gray'>" + targetFrame.getCurrentWord().substring(0, targetFrame.getCurrentWordStart()) + "<font style='font-family: Sabreen Regular Demo; font-size: 30px; color: black'>" + targetFrame.getCurrentWord().substring(targetFrame.getCurrentWordStart()) + "<html>");
            }
            else {
                targetFrame.wordLabel.setText("<html><font style='font-family: Sabreen Regular Demo; font-size: 30px; color: gray'>" + targetFrame.getCurrentWord().substring(0, targetFrame.getCurrentWordStart()) + "<font style='font-family: Sabreen Regular Demo; font-size: 30px; color: red'>" + targetFrame.getCurrentWord().substring(targetFrame.getCurrentWordStart(), targetFrame.getCurrentWordStart() + 1) + "<font style='font-family: Sabreen Regular Demo; font-size: 30px; color: black'>" + targetFrame.getCurrentWord().substring(targetFrame.getCurrentWordStart() + 1) + "<html>");
                System.out.println("Wrong");
            }
        }
        else {
            if (targetFrame.typingTutorials1.isVisible()) {
                targetFrame.typingTutorials1.setVisible(false);}
            else if (targetFrame.typingTutorials2.isVisible()) {
                targetFrame.typingTutorials2.setVisible(false);}
            else if (targetFrame.typingTutorials3.isVisible()) {
                targetFrame.typingTutorials3.setVisible(false);
                new Thread(new RunnableOfTyping(0, targetFrame, this), "TypingCountDown").start();
            }
            else {
                System.out.println("ENDING");
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {
        if (targetActionID.equals("ScoreBaordButton1")) {
            System.out.println("Clicked");
        }
        else if (targetActionID.equals("ScoreBaordButton2")) {
            System.out.println("Clicked");
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        if (targetActionID.equals("ScoreBaordButton1")) {
            System.out.println("ChangeTo Clicked Button");
        }
        else if (targetActionID.equals("ScoreBaordButton2")) {
            System.out.println("ChangeTo Clicked Button");
        }
    }


    @Override
    public void mouseReleased(MouseEvent e) {
        if (targetActionID.equals("ScoreBaordButton1")) {
            System.out.println("ChangeTo Default Button");
        }
        else if (targetActionID.equals("ScoreBaordButton2")) {
            System.out.println("ChangeTo Default Button");
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {}

//        targetFrame.layer.add( CatType.catCreate(new CatWalking()) {{
//            setBounds(0, 0, 1280, 720);
//        }},  Integer.valueOf(11));

//        targetFrame.layer.add(new CatWalking(){{
//            setBounds(0, 0, 1280, 720);
//        }},  Integer.valueOf(11));
//    public ActionHandlerOfTyping(int minigameTimmer) {
//        this.minigameTimmer = minigameTimmer;
//    }
//    @Override
//    public void run() {
//        if (Thread.currentThread().getName().equals("Thread1")) {
//            try {
//                while (minigameTimmer > 0) {
//                    System.out.println(minigameTimmer + " seconds remaining.");
//                    minigameTimmer--;
//                    Thread.sleep(1000); // wait for 1 second
//                }
//                System.out.println("Time's up!");
//            } catch (InterruptedException e) {
//                System.out.println("Thread interrupted.");
//            }
//        }
//    }

}
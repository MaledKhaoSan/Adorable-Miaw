import canvas_modify.FadeInAnimate;
import canvas_modify.FadeOutAnimate;
import canvas_modify.SceneModify;
import canvas_modify.introAnimate;

import javax.swing.*;
import java.awt.event.*;


public class ActionHandlerOfTyping implements ActionListener, KeyListener, MouseListener {
    private int wordsLength, correctWords, incorrectWords, waiter =1, prepareTime =3, gameTime = 60, tutorialsTime = 2;
    private MiniGameTyping targetFrame;
    private String targetActionID;
    private JLabel targetLabel;
    public ActionHandlerOfTyping(MiniGameTyping targetFrame) {
        this.targetFrame = targetFrame;
    }

    public void prepareTimer() {
        new Thread(new RunnableOfTyping(prepareTime , targetFrame, this), "prepareCountDown").start();

    }
    public void startGameTimer() {
        targetFrame.requestFocusInWindow();
        targetFrame.generateNewWord();
        targetFrame.setCurrentWordRunning(true);
        new Thread(new RunnableOfTyping(gameTime , targetFrame, this), targetFrame.difficulty).start();
    }
    public void endGameTimer(int wordsLength) {
        this.wordsLength = wordsLength;
        if (correctWords >= wordsLength/100 * 50){
            System.out.println("3 start, 15 point");
        } else if (correctWords >= wordsLength/100 * 40) {
            System.out.println("2 start, 10 point");
        } else {
            System.out.println("1 start, 5 point");
        }
        System.out.println(correctWords +" "+ incorrectWords);

        targetFrame.ScoreBoardBG.setVisible(true);
    }
    public void stageScene(){
        new MainStage();
        targetFrame.setVisible(false);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == targetFrame.intro) {
            targetFrame.intro.requestFocusInWindow();
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Pressed");
        if (targetFrame.isCurrentWordRunning()) {
            char typedChar = e.getKeyChar();
            if (typedChar == targetFrame.getCurrentWord().charAt(targetFrame.getCurrentWordStart())) {
                targetFrame.setCurrentWordStart(targetFrame.getCurrentWordStart() + 1);
                if (targetFrame.getCurrentWord().length() == targetFrame.getCurrentWordStart()) {
                    targetFrame.setCurrentWordRunning(false);
                    System.out.println("LAST WORD");
                }
                correctWords++;
                targetFrame.wordLabel.setText("<html><font style='font-family: Sabreen Regular Demo; font-size: 30px; color: gray'>" + targetFrame.getCurrentWord().substring(0, targetFrame.getCurrentWordStart()) + "<font style='font-family: Sabreen Regular Demo; font-size: 30px; color: black'>" + targetFrame.getCurrentWord().substring(targetFrame.getCurrentWordStart()) + "<html>");
            }
            else {
                targetFrame.wordLabel.setText("<html><font style='font-family: Sabreen Regular Demo; font-size: 30px; color: gray'>" + targetFrame.getCurrentWord().substring(0, targetFrame.getCurrentWordStart()) + "<font style='font-family: Sabreen Regular Demo; font-size: 30px; color: red'>" + targetFrame.getCurrentWord().substring(targetFrame.getCurrentWordStart(), targetFrame.getCurrentWordStart() + 1) + "<font style='font-family: Sabreen Regular Demo; font-size: 30px; color: black'>" + targetFrame.getCurrentWord().substring(targetFrame.getCurrentWordStart() + 1) + "<html>");
                incorrectWords++;
            }
        }

        //Tutorials <3
        else  if (e.getKeyCode() == KeyEvent.VK_SPACE & targetFrame.intro.isVisible()) {
            if (targetFrame.tutorial1.isVisible()) {
                targetFrame.tutorial1.setVisible(false);
            } else if (targetFrame.tutorial2.isVisible()) {
                targetFrame.tutorial2.setVisible(false);
            } else if (targetFrame.tutorial3.isVisible()) {
                new Thread(new RunnableOfTyping(tutorialsTime, targetFrame, this), "tutorialTransition").start();
            }
        }
    }@Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == targetFrame.ScoreBoardButton1) {
            System.out.println("Clicked");
        }
        else if (e.getSource() == targetFrame.ScoreBoardButton2) {
            targetFrame.layer.add(new SceneModify().addJLayerPaneAnimate(new FadeInAnimate()), Integer.valueOf(30));
            new Thread(new RunnableOfTyping(prepareTime, targetFrame, this), "stageTransition").start();
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}

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
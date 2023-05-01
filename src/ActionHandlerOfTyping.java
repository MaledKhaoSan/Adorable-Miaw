import canvas_modify.FadeInAnimate;
import canvas_modify.SceneModify;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class ActionHandlerOfTyping implements ActionListener, KeyListener {
    private int wordsLength, correctWords, incorrectWords, waiter =1, countdown =3, times = 5;
    private MiniGameTyping targetFrame;
    private String targetActionID;
    private JLabel targetLabel;
    public ActionHandlerOfTyping(MiniGameTyping targetFrame) {
        this.targetFrame = targetFrame;
    }

    public void startGameTimer() {
        targetFrame.generateNewWord();
        targetFrame.setCurrentWordRunning(true);
        new Thread(new RunnableOfTyping(times , targetFrame, this), targetFrame.difficulty).start();

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

        targetFrame.ScoreBaordBG.setVisible(true);
    }



    @Override
    public void keyTyped(KeyEvent e) {}
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
                correctWords++;
                targetFrame.wordLabel.setText("<html><font style='font-family: Sabreen Regular Demo; font-size: 30px; color: gray'>" + targetFrame.getCurrentWord().substring(0, targetFrame.getCurrentWordStart()) + "<font style='font-family: Sabreen Regular Demo; font-size: 30px; color: black'>" + targetFrame.getCurrentWord().substring(targetFrame.getCurrentWordStart()) + "<html>");
            }
            else {
                targetFrame.wordLabel.setText("<html><font style='font-family: Sabreen Regular Demo; font-size: 30px; color: gray'>" + targetFrame.getCurrentWord().substring(0, targetFrame.getCurrentWordStart()) + "<font style='font-family: Sabreen Regular Demo; font-size: 30px; color: red'>" + targetFrame.getCurrentWord().substring(targetFrame.getCurrentWordStart(), targetFrame.getCurrentWordStart() + 1) + "<font style='font-family: Sabreen Regular Demo; font-size: 30px; color: black'>" + targetFrame.getCurrentWord().substring(targetFrame.getCurrentWordStart() + 1) + "<html>");
                incorrectWords++;
            }
        }

        //Tutorials <3
        else {
            //เปลี่ยนไปใช้วิธี forLoop ArrayList
            if (targetFrame.typingTutorials1.isVisible()) {
                targetFrame.typingTutorials1.setVisible(false);}
            else if (targetFrame.typingTutorials2.isVisible()) {
                targetFrame.typingTutorials2.setVisible(false);}
            else if (targetFrame.typingTutorials3.isVisible()) {
                targetFrame.typingTutorials3.setVisible(false);
                new Thread(new RunnableOfTyping(countdown, targetFrame, this), "TypingCountDown").start();
            }
            else {
                System.out.println("ENDING");
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == targetFrame.ScoreBaordButton1) {
            System.out.println("Clicked");
        }
        else if (e.getSource() == targetFrame.ScoreBaordButton2) {

            targetFrame.layer.add(new SceneModify().addJLayerPaneAnimate(new FadeInAnimate()), Integer.valueOf(30));
            new Thread(new RunnableOfTyping(waiter, targetFrame, this), "waiter").start();
        }
    }

    public void stageScene(){
        new MainStage();
        targetFrame.setVisible(false);

    }

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
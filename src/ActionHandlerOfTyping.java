import canvas_modify.SceneFadeIn;
import canvas_modify.SceneModify;

import javax.swing.*;
import java.awt.event.*;


public class ActionHandlerOfTyping implements ActionListener, KeyListener, MouseListener, WindowListener {
    private static int correctWords;
    private static int incorrectWords;
    private int earnPoints;
    private int prepareTime =3;
    private int gameTime;
    private int gameBonus;
    private ImageIcon gameStarPath;
    private final MiniGameTyping targetFrame;
    public ActionHandlerOfTyping(MiniGameTyping targetFrame) {
        this.targetFrame = targetFrame;
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
                correctWords++;
                targetFrame.wordLabel.setText("<html><font style='font-family: Sabreen Regular Demo; font-size: 30px; color: gray'>"
                        + targetFrame.getCurrentWord().substring(0, targetFrame.getCurrentWordStart())
                        + "<font style='font-family: Sabreen Regular Demo; font-size: 30px; color: black'>"
                        + targetFrame.getCurrentWord().substring(targetFrame.getCurrentWordStart()) + "<html>");
            }
            else {
                targetFrame.wordLabel.setText("<html><font style='font-family: Sabreen Regular Demo; font-size: 30px; color: gray'>"
                        + targetFrame.getCurrentWord().substring(0, targetFrame.getCurrentWordStart())
                        + "<font style='font-family: Sabreen Regular Demo; font-size: 30px; color: red'>"
                        + targetFrame.getCurrentWord().substring(targetFrame.getCurrentWordStart(), targetFrame.getCurrentWordStart() + 1)
                        + "<font style='font-family: Sabreen Regular Demo; font-size: 30px; color: black'>"
                        + targetFrame.getCurrentWord().substring(targetFrame.getCurrentWordStart() + 1) + "<html>");
                incorrectWords++;
            }
        }

        //Tutorials <3
        else  if (e.getKeyCode() == KeyEvent.VK_SPACE & targetFrame.intro.isVisible()) {
            if (targetFrame.tutorial1.isVisible()) {
                targetFrame.tutorial1.setVisible(false);
            } else if (targetFrame.tutorial2.isVisible()) {
                targetFrame.intro.removeMouseListener(this);
                targetFrame.intro.removeKeyListener(this);
                int tutorialsTime = 2;
                new Thread(new RunnableOfTyping(tutorialsTime, targetFrame, this), "tutorialTransition").start();
            }
        }
    }
    public void prepareTimer() {
        new Thread(new RunnableOfTyping(prepareTime , targetFrame, this), "prepareCountDown").start();
    }
    public void startGameTimer() {
        targetFrame.requestFocusInWindow();
        targetFrame.generateNewWord();
        targetFrame.setCurrentWordRunning(true);
        if (targetFrame.difficulty.equals("starter") | targetFrame.difficulty.equals("normal")) {
            this.gameTime = 180;
            this.gameBonus = 5;
        } else if (targetFrame.difficulty.equals("hard")) {
            this.gameTime = 120;
            this.gameBonus = 8;
        }
        new Thread(new RunnableOfTyping(gameTime , targetFrame, this), targetFrame.difficulty).start();
    }
    public void endGameTimer(int wordsLength) {
        if (correctWords >= wordsLength/100 * 50){
            earnPoints = gameBonus * 3; gameStarPath = new ImageIcon("src/resource/ui_transition/gameStar3.png");
        } else if (correctWords >= wordsLength/100 * 40) {
            earnPoints = gameBonus * 2; gameStarPath = new ImageIcon("src/resource/ui_transition/gameStar2.png");
        } else {
            earnPoints = gameBonus; gameStarPath = new ImageIcon("src/resource/ui_transition/gameStar1.png");
        }
        targetFrame.ScoreBoardStar.setIcon(gameStarPath);
        targetFrame.ScoreBoard_CorrectWords.setText(targetFrame.ScoreBoard_CorrectWords.getText() + correctWords);
        targetFrame.ScoreBoard_IncorrectWords.setText(targetFrame.ScoreBoard_IncorrectWords.getText() + incorrectWords);
        targetFrame.ScoreBoard_EarnPoints.setText(targetFrame.ScoreBoard_EarnPoints.getText() + earnPoints);
        System.out.println("CorrectWords:  " + "" + correctWords + " InCorrectWords: " + incorrectWords + " EarnPoints: " + earnPoints);
        targetFrame.ScoreBoardBG.setVisible(true);
    }
    public void backToStage(){ new MainStage(); targetFrame.dispose(); }
    public void retryNewGame(){ new MiniGameTyping(targetFrame.difficulty); targetFrame.dispose(); }


    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == targetFrame.intro) {
            targetFrame.intro.requestFocusInWindow();
        }
    }
  @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == targetFrame.ScoreBoardButton1) {
            targetFrame.ScoreBoardButton1.removeActionListener(this);
            targetFrame.layer.add(new SceneModify().addJLayerPaneAnimate(new SceneFadeIn()), Integer.valueOf(30));
            new Thread(new RunnableOfTyping(prepareTime, targetFrame, this), "retryTransition").start();
        }
        else if (e.getSource() == targetFrame.ScoreBoardButton2) {
            targetFrame.ScoreBoardButton2.removeActionListener(this);
            targetFrame.layer.add(new SceneModify().addJLayerPaneAnimate(new SceneFadeIn()), Integer.valueOf(30));
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
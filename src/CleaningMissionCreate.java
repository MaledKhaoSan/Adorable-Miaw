import canvas_modify.SceneModify;

import javax.swing.*;
import java.awt.*;

public class CleaningMissionCreate extends JLayeredPane implements Runnable{
    private MiniGameCleaning targetFrame;
    private JLayeredPane targetLayer, puzzleLayerPane1, puzzleLayerPane2, puzzleLayerPane3;
    private CleaningObjects object1, object2, object3;
    public JLabel scoreBoard;
    private int puzzleScore;

    public CleaningMissionCreate(MiniGameCleaning targetFrame, JLayeredPane targetLayer) {
        this(targetLayer);
        this.targetFrame = targetFrame;
        this.targetLayer = targetLayer;
    }

    public CleaningMissionCreate(MiniGameCleaning targetFrame, JLayeredPane targetLayer, String targetLayerName) {
        if (targetLayerName.equals("")){
            targetFrame.Challenge1.setVisible(true);
            targetFrame.Challenge2.add(new CleaningMissionCreate(targetFrame, targetFrame.Challenge1));
        }
        else if (targetLayerName.equals("Challenge1")){
            targetFrame.Challenge2.setVisible(true);
            targetLayer.setVisible(false);
            targetFrame.Challenge2.add(new CleaningMissionCreate(targetFrame, targetFrame.Challenge2));
        }
        else if (targetLayerName.equals("Challenge2")){
            System.out.println("2");
        }
    }
    public CleaningMissionCreate(JLayeredPane targetLayer) {
        if (targetLayer.getName().equals("Challenge1")){
            targetLayer.add(object1 = new CleaningObjects("src/resource/cleaning_game/puzzle1_1.png", "src/resource/cleaning_game/puzzle1_4.png", 628, 626, 0) {{
                setBounds(-77, 65, 628, 626);
            }}, Integer.valueOf(2)); // add to layer 2

            targetLayer.add(object2 = new CleaningObjects("src/resource/cleaning_game/puzzle1_2.png", 488, 490, 235) {{
                setBounds(402, -15, 488, 490);
            }}, Integer.valueOf(1)); // add to layer 1

            targetLayer.add(object3 = new CleaningObjects("src/resource/cleaning_game/puzzle1_3.png", 628, 626, 25) {{
                setBounds(739, 65, 628, 626);
            }}, Integer.valueOf(2)); // add to layer 2
            CleaningMissionReset(3);


        } else if (targetLayer.getName().equals("Challenge2")) {
            targetLayer.add(object1 = new CleaningObjects("src/resource/cleaning_game/puzzle2_4.png", "src/resource/cleaning_game/puzzle2_1.png", 213, 361) {{
                setBounds(220, 263, 224, 361);
            }}, Integer.valueOf(2)); // add to layer 2

            targetLayer.add(object2 = new CleaningObjects("src/resource/cleaning_game/puzzle2_5.png", "src/resource/cleaning_game/puzzle2_2.png", 209, 512) {{
                setBounds(526, 114, 224, 512);
            }}, Integer.valueOf(1)); // add to layer 1

            targetLayer.add(object3 = new CleaningObjects("src/resource/cleaning_game/puzzle2_6.png", "src/resource/cleaning_game/puzzle2_3.png", 224, 456) {{
                setBounds(839, 173, 224, 456);
            }}, Integer.valueOf(2)); // add to layer 2
            CleaningMissionReset(3);
        }

    }
    public void CleaningMissionReset(int puzzleScore) {
        this.puzzleScore = puzzleScore;
        CleaningObjectsModify.setPuzzleScoreCheck(0);
        new Thread(this, "puzzleRunning").start();
    }
  //tewter <3 khao tanggy <3 punch khao <3 tanggy tewter <3 tanggy punch <3 tewter tewter <3 khao
    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("puzzleRunning")) {
            while (CleaningObjectsModify.getPuzzleScoreCheck() < 3){
                try {
                    System.out.println("Challenge 1 is Running");
                    Thread.sleep(1000);
                }
                catch (InterruptedException ignored){}
            }
            System.out.println("FINISHED");
            Thread.currentThread().interrupt();
            new Thread(this, "puzzleFadeOut").start();
        }
        else if (Thread.currentThread().getName().equals("puzzleFadeOut")) {
            while (true){
                try {
                    boolean allExited = true;
                    Component[] components = targetLayer.getComponents();
                    for (Component c : components) {
                        if (c instanceof JLabel) {
                            if (c.getY() >= -c.getHeight()) {
                                c.setBounds(c.getX(), c.getY() - 8, c.getWidth(), c.getHeight());
                                allExited = false;
                            }
                        }
                    }
                    if (allExited) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                    Thread.sleep(5);
                }
                catch (InterruptedException ignored){}
            }
            new CleaningMissionCreate(targetFrame, targetLayer, targetLayer.getName());
        }
    }
}

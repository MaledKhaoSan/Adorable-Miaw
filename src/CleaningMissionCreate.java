import canvas_modify.*;

import javax.swing.*;
import java.awt.*;

public class CleaningMissionCreate extends JLayeredPane implements Runnable{
    private MiniGameCleaning targetFrame;
    private JLayeredPane targetLayer;
    private CleaningObjects object0, object1, object2, object3, object4, object5, object6, object7, object8, object9;
    private int puzzleScore;

    public CleaningMissionCreate(MiniGameCleaning targetFrame, JLayeredPane targetLayer) {
        this(targetLayer);
        this.targetFrame = targetFrame;
        this.targetLayer = targetLayer;
    }

    public CleaningMissionCreate(MiniGameCleaning targetFrame, JLayeredPane targetLayer, String targetLayerName) {
        switch (targetLayerName) {
            case "" -> {
                targetFrame.Challenge1.setVisible(true);
                targetFrame.Challenge2.add(new CleaningMissionCreate(targetFrame, targetFrame.Challenge1));
            }
            case "Challenge1" -> {
                targetFrame.Challenge2.setVisible(true);
                targetLayer.setVisible(false);
                targetFrame.Challenge2.add(new CleaningMissionCreate(targetFrame, targetFrame.Challenge2));
            }
            case "Challenge2" -> {
                targetFrame.Challenge3.setVisible(true);
                targetLayer.setVisible(false);
                targetFrame.Challenge3.add(new CleaningMissionCreate(targetFrame, targetFrame.Challenge3));
            }
            case "Challenge3" -> {
                targetFrame.Challenge4.setVisible(true);
                targetLayer.setVisible(false);
                targetFrame.Challenge4.add(new CleaningMissionCreate(targetFrame, targetFrame.Challenge4));
            }
            case "Challenge4" -> {
                targetFrame.Challenge5.setVisible(true);
                targetLayer.setVisible(false);
                targetFrame.Challenge5.add(new CleaningMissionCreate(targetFrame, targetFrame.Challenge5));
            }
            case "Challenge5" -> targetFrame.ScoreBoardBG.setVisible(true);
        }
    }
    public CleaningMissionCreate(JLayeredPane targetLayer) {
        if (targetLayer.getName().equals("Challenge1")){
            targetLayer.add(object1 = new CleaningObjects("src/resource/cleaning_game/puzzle1_1.png", 628, 626, 163) {{
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

        else if (targetLayer.getName().equals("Challenge3")) {
            targetLayer.add(object0 = new CleaningObjects("src/resource/cleaning_game/Bowl.png", 516, 666, 0) {{
                setBounds(382, 27, 516, 666);
            }}, Integer.valueOf(1));
            targetLayer.add(object1 = new CleaningObjects("src/resource/cleaning_game/D1.png", "src/resource/cleaning_game/D0.png", 86, 97) {{
                setBounds(424, 63,86, 97);
            }}, Integer.valueOf(2));
            targetLayer.add(object2 = new CleaningObjects("src/resource/cleaning_game/D2.png", "src/resource/cleaning_game/D0.png", 159, 104) {{
                setBounds(683, 214, 159, 104);
            }}, Integer.valueOf(2));
            targetLayer.add(object3 = new CleaningObjects("src/resource/cleaning_game/D3.png", "src/resource/cleaning_game/D0.png", 79, 56) {{
                setBounds(437, 258, 79, 56);
            }}, Integer.valueOf(2));
            targetLayer.add(object4 = new CleaningObjects("src/resource/cleaning_game/D4.png", "src/resource/cleaning_game/D0.png", 205, 86) {{
                setBounds(548, 377, 205, 86);
            }}, Integer.valueOf(2));
            targetLayer.add(object5 = new CleaningObjects("src/resource/cleaning_game/D5.png", "src/resource/cleaning_game/D0.png", 193, 121) {{
                setBounds(466, 544, 193, 121);
            }}, Integer.valueOf(2));
            CleaningMissionReset(5);
        }

        else if (targetLayer.getName().equals("Challenge4")) {
            targetLayer.add(object0 = new CleaningObjects("src/resource/cleaning_game/puzzle4.png", 563, 563, 0) {{
                setBounds(356, 98, 563, 563);
            }}, Integer.valueOf(1));
            targetLayer.add(object1 = new CleaningObjects("src/resource/cleaning_game/D6.png", "src/resource/cleaning_game/D0.png", 159, 104) {{
                setBounds(683, 495, 159, 104);
            }}, Integer.valueOf(2));
            targetLayer.add(object2 = new CleaningObjects("src/resource/cleaning_game/D7.png", "src/resource/cleaning_game/D0.png", 104, 78) {{
                setBounds(447, 454, 104, 78);
            }}, Integer.valueOf(2));
            targetLayer.add(object3 = new CleaningObjects("src/resource/cleaning_game/D8.png", "src/resource/cleaning_game/D0.png", 83, 99) {{
                setBounds(476, 163, 83, 99);
            }}, Integer.valueOf(2));
            CleaningMissionReset(3);
        }

        else if (targetLayer.getName().equals("Challenge5")) {
            targetLayer.add(object1 = new CleaningObjects("src/resource/cleaning_game/Book1_1.png", "src/resource/cleaning_game/Book1.png", 137, 637) {{
                setBounds(262, 43, 137, 637);
            }}, Integer.valueOf(2));
            targetLayer.add(object2 = new CleaningObjects("src/resource/cleaning_game/Book2_1.png", "src/resource/cleaning_game/Book2.png", 111, 613) {{
                setBounds(398, 68, 111, 613);
            }}, Integer.valueOf(2));
            targetLayer.add(object3 = new CleaningObjects("src/resource/cleaning_game/Book3.png", 88, 593, 0) {{
                setBounds(509, 87, 88, 593);
            }}, Integer.valueOf(2));
            CleaningMissionReset(3);
            targetLayer.add(object4 = new CleaningObjects("src/resource/cleaning_game/Book4.png", 35, 575, 0) {{
                setBounds(597, 105, 35, 575);
            }}, Integer.valueOf(2));
            targetLayer.add(object5 = new CleaningObjects("src/resource/cleaning_game/Book5_1.png", "src/resource/cleaning_game/Book5.png", 42, 562) {{
                setBounds(629, 119, 42, 562);
            }}, Integer.valueOf(2));
            targetLayer.add(object6 = new CleaningObjects("src/resource/cleaning_game/Book6.png", 54, 536, 0) {{
                setBounds(671, 144, 54, 536);
            }}, Integer.valueOf(2));
            targetLayer.add(object7 = new CleaningObjects("src/resource/cleaning_game/Book7_1.png", "src/resource/cleaning_game/Book7.png", 153, 513) {{
                setBounds(725, 168, 153, 513);
            }}, Integer.valueOf(2));
            targetLayer.add(object8 = new CleaningObjects("src/resource/cleaning_game/Book8.png", 65, 463, 0) {{
                setBounds(878, 217, 65, 463);
            }}, Integer.valueOf(2));
            targetLayer.add(object9 = new CleaningObjects("src/resource/cleaning_game/Book9_1.png", "src/resource/cleaning_game/Book9.png", 75, 426) {{
                setBounds(943, 254, 75, 426);
            }}, Integer.valueOf(2));
            CleaningMissionReset(5);
        }
    }
    public void CleaningMissionReset(int puzzleScore) {
        this.puzzleScore = puzzleScore;
        CleaningObjectsModify.setPuzzleScoreCheck(0);
        new Thread(this, "puzzleRunning").start();
    }
    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("puzzleRunning")) {
            while (CleaningObjectsModify.getPuzzleScoreCheck() < puzzleScore){
                try {
                    System.out.println("Challenge is Running");
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

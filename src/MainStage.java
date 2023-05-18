import canvas_modify.SceneFadeOut;
import canvas_modify.SceneModify;
import canvas_modify.SceneSoundBackground;
import canvas_modify.SceneSoundPlayer;

import javax.swing.*;
import java.awt.*;


public class MainStage extends JFrame{
    public JLayeredPane layer;

    //Label Object in Scene
    private boolean minigameIsSelect;
    public JLabel minigameTypingEnter, minigameCleaningEnter, minigameCookingEnter;
    public JButton homeEnter;
    public JLabel minigameTypingUI;
    public JButton minigameTypingUIButton1, minigameTypingUIButton2, minigameTypingUIButton3, minigameTypingDifficulty1, minigameTypingDifficulty2, minigameTypingDifficulty3;
    public JLabel minigameCleaningUI, minigameCleaningCountDown;
    public JButton minigameCleaningUIButton1, minigameCleaningUIButton2, minigameCleaningUIButton3, minigameCleaningStart;
    public JLabel minigameCookingUI;
    public JButton minigameCookingUIButton1, minigameCookingUIButton2, minigameCookingUIButton3, minigameCookingDifficulty1, minigameCookingDifficulty2, minigameCookingDifficulty3;
    public SceneSoundPlayer soundPlayer = new SceneSoundBackground();

    public MainStage() {
        soundPlayer.getSoundPath(1);
        ActionHandlerOfStage handler = new ActionHandlerOfStage(this);
        this.setBackground(Color.BLACK);

        layer = new SceneModify().addJLayerPaneBackGround("src/resource/stage_canvas/background.png", "layer", true);
        layer.add(minigameTypingEnter = new SceneModify().createJLabelWithMouse(126, 419, 330, 250, handler, "src/resource/stage_canvas/minigameTypingEnter.png"), Integer.valueOf(0));
        layer.add(minigameCleaningEnter = new SceneModify().createJLabelWithMouse(475, 475, 330, 250, handler, "src/resource/stage_canvas/minigameCleaningEnter.png"), Integer.valueOf(0));
        layer.add(minigameCookingEnter = new SceneModify().createJLabelWithMouse(870, 474, 330, 250, handler, "src/resource/stage_canvas/minigameCookingEnter.png"), Integer.valueOf(0));
        layer.add(homeEnter = new SceneModify().createJButton(1172, 25, 55, 55, handler, "src/resource/building_canvas/uiButton2.png", true), Integer.valueOf(0));

        layer.add(minigameTypingUI = new SceneModify().createJLabelWithMouse((1280/2) - (580/2), 145, 580, 332, handler, "src/resource/stage_canvas/minigameTypingUI.png", false), Integer.valueOf(5));
        minigameTypingUI.add(minigameTypingUIButton1 = new SceneModify().createJButton(580/2 - 145/2 - 130, 332 - 50, 145, 45, handler, "src/resource/stage_canvas/UIBack.png", true), Integer.valueOf(2));
        minigameTypingUI.add(minigameTypingUIButton2 = new SceneModify().createJButton(580/2 - 145/2 + 130, 332 - 50, 145, 45, handler, "src/resource/stage_canvas/UINext.png", true), Integer.valueOf(2));
        minigameTypingUI.add(minigameTypingDifficulty1 = new SceneModify().createJButton(49, 123, 135, 85, handler, "src/resource/stage_canvas/difficulty1.png", false), Integer.valueOf(2));
        minigameTypingUI.add(minigameTypingDifficulty2 = new SceneModify().createJButton(222, 123, 135, 85, handler, "src/resource/stage_canvas/difficulty2.png", false), Integer.valueOf(2));
        minigameTypingUI.add(minigameTypingDifficulty3 = new SceneModify().createJButton(395, 123, 135, 85, handler, "src/resource/stage_canvas/difficulty3.png", false), Integer.valueOf(2));
        minigameTypingUI.add(minigameTypingUIButton3 = new SceneModify().createJButton(580/2 - 145/2 , 332 - 50, 145, 45, handler, "src/resource/stage_canvas/UIBack.png", false), Integer.valueOf(2));

        layer.add(minigameCleaningUI = new SceneModify().createJLabelWithMouse((1280/2) - (580/2), 145, 580, 332, handler, "src/resource/stage_canvas/minigameCleaningUI.png", false), Integer.valueOf(5));
        minigameCleaningUI.add(minigameCleaningUIButton1 = new SceneModify().createJButton(580/2 - 145/2 - 130, 332 - 50, 145, 45, handler, "src/resource/stage_canvas/UIBack.png", true), Integer.valueOf(2));
        minigameCleaningUI.add(minigameCleaningUIButton2 = new SceneModify().createJButton(580/2 - 145/2 + 130, 332 - 50, 145, 45, handler, "src/resource/stage_canvas/UINext.png", true), Integer.valueOf(2));
        minigameCleaningUI.add(minigameCleaningUIButton3 = new SceneModify().createJButton(580/2 - 145/2, 332 - 50, 145, 45, handler, "src/resource/stage_canvas/UIBack.png", false),  Integer.valueOf(2));
        minigameCleaningUI.add(minigameCleaningStart = new SceneModify().createJButton(222, 113, 135, 85, handler, "src/resource/stage_canvas/difficulty2.png", false), Integer.valueOf(2));
        minigameCleaningUI.add(minigameCleaningCountDown = new SceneModify().createJLabelWithFont(61, 185, 460, 112, 255, 20,"src/resource/fonts/RemboyRegular.ttf", "Arghh, the cats made a mess again. Let's clean it up." , false));

        layer.add(minigameCookingUI = new SceneModify().createJLabelWithMouse((1280/2) - (580/2), 145, 580, 332, handler, "src/resource/stage_canvas/minigameCookingUI.png", false), Integer.valueOf(5));
        minigameCookingUI.add(minigameCookingUIButton1 = new SceneModify().createJButton(580/2 - 145/2 - 130, 332 - 50, 145, 45, handler, "src/resource/stage_canvas/UIBack.png", true), Integer.valueOf(2));
        minigameCookingUI.add(minigameCookingUIButton2 = new SceneModify().createJButton(580/2 - 145/2 + 130, 332 - 50, 145, 45, handler, "src/resource/stage_canvas/UINext.png", true), Integer.valueOf(2));
        minigameCookingUI.add(minigameCookingUIButton3 = new SceneModify().createJButton(580/2 - 145/2 , 332 - 50, 145, 45, handler, "src/resource/stage_canvas/UIBack.png", false), Integer.valueOf(2));
        minigameCookingUI.add(minigameCookingDifficulty1 = new SceneModify().createJButton(49, 123, 135, 85, handler, "src/resource/stage_canvas/difficulty1.png", false), Integer.valueOf(2));
        minigameCookingUI.add(minigameCookingDifficulty2 = new SceneModify().createJButton(222, 123, 135, 85, handler, "src/resource/stage_canvas/difficulty2.png", false), Integer.valueOf(2));
        minigameCookingUI.add(minigameCookingDifficulty3 = new SceneModify().createJButton(395, 123, 135, 85, handler, "src/resource/stage_canvas/difficulty3.png", false), Integer.valueOf(2));

        this.add(layer);
        this.setSize(1280, 747);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.layer.add(new SceneModify().addJLayerPaneAnimate(new SceneFadeOut()),  Integer.valueOf(20));
        this.setVisible(true);
        new Thread(new RunnableOfMainStage(this), "MiniGameCleaningCountDown").start();
        this.addWindowListener(handler);
    }
    public boolean isMinigameIsSelect() {
        return minigameIsSelect;
    }

    public void setMinigameIsSelect(boolean minigameIsSelect) {
        this.minigameIsSelect = minigameIsSelect;
    }
}

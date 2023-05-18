import javax.swing.*;
import java.awt.*;
import canvas_modify.*;

public class MiniGameCleaning extends JFrame {
    public JLayeredPane layer, Challenge1, Challenge2, Challenge3, Challenge4, Challenge5, intro;
    public JLabel tutorial1, tutorial2;
    public JLabel ScoreBoardBG, ScoreBoardStar, ScoreBoard_CompleteText, ScoreBoard_EarnPoints;
    public JButton ScoreBoardButton1;
    public SceneSoundPlayer soundPlayer = new SceneSoundBackground();

    public MiniGameCleaning() {
        soundPlayer.getSoundPath(3);
        ActionHandlerOfCleaning handler = new ActionHandlerOfCleaning(this);
        this.setBackground(Color.BLACK);
        layer = new SceneModify().addJLayerPaneBackGround("src/resource/cleaning_game/background.png", "layer", true);
        layer.add(Challenge1 = new SceneModify().addJLayerPaneBackGround("src/resource/cleaning_game/background1.png", "Challenge1", false));
        layer.add(Challenge2 = new SceneModify().addJLayerPaneBackGround("src/resource/cleaning_game/background2.png", "Challenge2", false));
        layer.add(Challenge3 = new SceneModify().addJLayerPaneBackGround("src/resource/cleaning_game/background3.png", "Challenge3", false));
        layer.add(Challenge4 = new SceneModify().addJLayerPaneBackGround("src/resource/cleaning_game/background4.png", "Challenge4", false));
        layer.add(Challenge5 = new SceneModify().addJLayerPaneBackGround("src/resource/cleaning_game/background5.png", "Challenge5", false));



        //Intro
        layer.add(intro =  new SceneModify().addJLayerPaneBackGround("intro_layer", true), Integer.valueOf(10));
        intro.addMouseListener(handler); intro.addKeyListener(handler); intro.setFocusable(true);
        intro.add(tutorial1 = new SceneModify().createJLabelWithKey(431, 151, 417, 417, null, "src/resource/ui_transition/cleaning_htp.png"), Integer.valueOf(5));
        intro.add(tutorial2 = new SceneModify().createJLabelWithKey(431, 151, 417, 417, null, "src/resource/ui_transition/timeups_htp.png"), Integer.valueOf(4));

        //ScoreBoard
        layer.add(ScoreBoardBG = new SceneModify().createJLabel(399, 65, 480, 530, null, "src/resource/ui_transition/ScoreBoardBG.png",false),  Integer.valueOf(10));
        ScoreBoardBG.add(ScoreBoardStar = new SceneModify().createJLabel(91,50,300,100, null, "src/resource/ui_transition/gameStar3.png", true),  Integer.valueOf(1));
        ScoreBoardBG.add(ScoreBoard_CompleteText = new SceneModify().createJLabelWithFont(108,190,265,50, 255, 20, "src/resource/fonts/RemboyRegular.ttf", "Room's pristine!" , true),  Integer.valueOf(1));
        ScoreBoardBG.add(ScoreBoard_EarnPoints = new SceneModify().createJLabelWithFont(108,260,265,50, 255, 20, "src/resource/fonts/RemboyRegular.ttf", "Heart Collection: " , true),  Integer.valueOf(1));
        ScoreBoardBG.add(ScoreBoardButton1 = new SceneModify().createJButton((480/2) - (145/2), 530-70, 145, 45, handler, "src/resource/ui_transition/UINext.png", true),  Integer.valueOf(2));

        this.add(layer);
        this.setSize(1280, 747);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.layer.add(new SceneModify().addJLayerPaneAnimate(new SceneFadeOut()),  Integer.valueOf(20));
        this.setVisible(true);
        this.addWindowListener(handler);

    }
}
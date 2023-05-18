import canvas_modify.SceneFadeOut;
import canvas_modify.SceneModify;
import canvas_modify.SceneSoundBackground;
import canvas_modify.SceneSoundPlayer;

import javax.swing.*;
import java.awt.*;

public class MiniGameCooking extends JFrame {
    public JLayeredPane layer, intro;
    public JLabel tutorial1, tutorial2;
    public JLabel selectedFrame, selectedFrameName;
    public JButton selectedFrameButton, selectedFrameSlideLeft, selectedFrameSlideRight;
    public JButton BentoHitBox1, BentoHitBox2, BentoHitBox3;
    public JLabel BentoHint, BentoHintBox;
    public JLabel selectedFrameFood;
    public JLabel mainFood, sideFood, dessertFood, bentoBox, bentoBG, bentoArrow;
    public JLabel ScoreBoardBG, ScoreBoardStar, ScoreBoard_FinishedBento, ScoreBoard_EarnPoints;
    public JButton ScoreBoardButton1, ScoreBoardButton2;

    public Thread thread;
    private Account account;
    private AccountSaved accountSaved = new AccountSaved();
    public SceneSoundPlayer soundPlayer = new SceneSoundBackground();

    public MiniGameCooking() {
        soundPlayer.getSoundPath(4);
        account = accountSaved.load();
        this.setBackground(Color.BLACK);
        ActionHandlerOfCooking handler = new ActionHandlerOfCooking(this);
        layer = new SceneModify().addJLayerPaneBackGround("", "layer", true);
        //Intro
        layer.add(intro =  new SceneModify().addJLayerPaneBackGround("intro_layer", true), Integer.valueOf(10));
        intro.addMouseListener(new ActionHandlerOfCooking(MiniGameCooking.this)); intro.addKeyListener(new ActionHandlerOfCooking(MiniGameCooking.this)); intro.setFocusable(true);
        intro.add(tutorial1 = new SceneModify().createJLabelWithKey(431, 151, 417, 417, null, "src/resource/ui_transition/cooking_htp.png"), Integer.valueOf(5));
        intro.add(tutorial2 = new SceneModify().createJLabelWithKey(431, 151, 417, 417, null, "src/resource/ui_transition/timeups_htp.png"), Integer.valueOf(4));
        //Bento HitBox
        layer.add(BentoHint = new SceneModify().createJLabelWithFont(1280/2 - 450/2, 32, 460, 70, 176, 27, "src/resource/fonts/Aloja-Light.otf", "", true), Integer.valueOf(8));
        layer.add(BentoHintBox = new SceneModify().createJLabelWithKey(1280/2 - 450/2, 28, 460, 70, null, "src/resource/cooking_game/selectedHint.png"), Integer.valueOf(8));
        layer.add(BentoHitBox1 = new SceneModify().createJButton(123, 200, 224, 370, handler, null, true), Integer.valueOf(8));
        layer.add(BentoHitBox2 = new SceneModify().createJButton(364, 200, 251, 175, handler, null, true), Integer.valueOf(8));
        layer.add(BentoHitBox3 = new SceneModify().createJButton(364, 390, 283, 180, handler, null, true), Integer.valueOf(8));
        //Bento Food
        layer.add(mainFood = new SceneModify().createJLabelWithMouse(115, 222, 273, 350, null, null), Integer.valueOf(4));
        layer.add(sideFood = new SceneModify().createJLabelWithMouse(325, 209, 284, 189, null, null), Integer.valueOf(5));
        layer.add(dessertFood = new SceneModify().createJLabelWithMouse(364, 372, 265, 185, null, null), Integer.valueOf(6));
        layer.add(bentoBox = new SceneModify().createJLabelWithMouse(71, 188, 585, 453,null, "src/resource/cooking_game/bento3.png"), Integer.valueOf(3));
        layer.add(bentoBG = new SceneModify().createJLabelWithMouse(0, 0, 1280, 720, null, "src/resource/cooking_game/bentoBackground3.png"), Integer.valueOf(1));
        layer.add(bentoArrow = new SceneModify().createJLabelWithMouse(-500, -500, 50, 80, null, "src/resource/cooking_game/arrowDown.gif"), Integer.valueOf(7));
        bentoColorCheck();
        //Main Course
        layer.add(selectedFrame = new JLabel(new ImageIcon("src/resource/cooking_game/selectedFrame.png")) {{
            setBounds(788, 116, 371, 482);
            add(selectedFrameName = new SceneModify().createJLabelWithFont(7, 21, 351, 67, 111,30,"src/resource/fonts/gifted-personal.regular.otf","Japanese Pancake", true));
            add(selectedFrameSlideRight = new SceneModify().createJButton(320, 224, 32, 33, handler, "src/resource/cooking_game/selectedRight.png", true));
            add(selectedFrameSlideLeft = new SceneModify().createJButton(14, 224, 32, 33, handler, "src/resource/cooking_game/selectedLeft.png", true));
            add(selectedFrameFood = new SceneModify().createJLabelWithKey(8, 115, 350, 250, null, "src/resource/cooking_game/mainIcon1.png"));
            add(selectedFrameButton = new SceneModify().createJButton(111, 408, 148, 56, handler, "src/resource/cooking_game/selectedButton.png", true));
            setVisible(false);
        }},  Integer.valueOf(5));

        layer.add(ScoreBoardBG = new SceneModify().createJLabel(399, 65, 480, 530, null, "src/resource/ui_transition/ScoreBoardBG.png",false),  Integer.valueOf(10));
        ScoreBoardBG.add(ScoreBoardStar = new SceneModify().createJLabel(91,50,300,100, null, "", true),  Integer.valueOf(1));

        ScoreBoardBG.add(ScoreBoard_FinishedBento = new SceneModify().createJLabelWithFont(108,190,265,50, 255, 20, "src/resource/fonts/RemboyRegular.ttf", "Finished Bento : " , true),  Integer.valueOf(1));
        ScoreBoardBG.add(ScoreBoard_EarnPoints = new SceneModify().createJLabelWithFont(108,260,265,50, 255, 20, "src/resource/fonts/RemboyRegular.ttf", "Heart Collection: " , true),  Integer.valueOf(1));

        ScoreBoardBG.add(ScoreBoardButton1 = new SceneModify().createJButton((480/2) - (145/2) - 120, 530-70, 145, 45, handler, "src/resource/ui_transition/UIRetry.png", true),  Integer.valueOf(2));
        ScoreBoardBG.add(ScoreBoardButton2 = new SceneModify().createJButton((480/2)- (145/2) + 120, 530-70, 145, 45, handler, "src/resource/ui_transition/UINext.png", true),  Integer.valueOf(2));


        this.add(layer);
        this.setSize(1280, 747);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.layer.add(new SceneModify().addJLayerPaneAnimate(new SceneFadeOut()),  Integer.valueOf(20));
        this.setVisible(true);
        this.addWindowListener(handler);
    }

    public void bentoColorCheck(){
        if (account.getBentoset() == 0){
            bentoBox.setIcon(new ImageIcon("src/resource/cooking_game/bento3.png"));
            bentoBG.setIcon(new ImageIcon("src/resource/cooking_game/bentoBackground3.png"));
        }
        else if (account.getBentoset() == 1){

            bentoBox.setIcon(new ImageIcon("src/resource/cooking_game/bento2.png"));
            bentoBG.setIcon(new ImageIcon("src/resource/cooking_game/bentoBackground2.png"));
        } else if (account.getBentoset() == 2) {
            bentoBox.setIcon(new ImageIcon("src/resource/cooking_game/bento1.png"));
            bentoBG.setIcon(new ImageIcon("src/resource/cooking_game/bentoBackground1.png"));
        }
    }
}
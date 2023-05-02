import canvas_modify.SceneModify;

import javax.swing.*;
import java.awt.*;

public class MiniGameCooking extends JFrame {
    public JLayeredPane layer, intro;
    public JLabel tutorial1, tutorial2, tutorial3;
    public ActionHandlerOfCooking handler;
    public JLabel selectedFrame, selectedFrameName;
    public JButton selectedFrameButton, selectedFrameSlideLeft, selectedFrameSlideRight;
    public JButton BentoHitBox1, BentoHitBox2, BentoHitBox3;
    public JLabel BentoHint, BentoHintBox;
    public JLabel selectedFrameFood;
    public JLabel mainFood, sideFood, dessertFood, bentoBox, bentoBG, bentoArrow;
    public JLabel JLabelButton1, JLabelButton2;
    public Thread thread;

    public MiniGameCooking() {
        this.setBackground(Color.BLACK);
        handler = new ActionHandlerOfCooking(this);

        layer = new SceneModify().addJLayerPaneBackGround("", "layer", true);
        //Intro
        layer.add(intro =  new SceneModify().addJLayerPaneBackGround("intro_layer", true), Integer.valueOf(10));
        intro.addMouseListener(new ActionHandlerOfCooking(MiniGameCooking.this)); intro.addKeyListener(new ActionHandlerOfCooking(MiniGameCooking.this)); intro.setFocusable(true);
        intro.add(tutorial1 = new SceneModify().createJLabelWithKey(431, 151, 417, 417, null, "src/resource/cooking_game/tutorial1.png"), Integer.valueOf(5));
        intro.add(tutorial2 = new SceneModify().createJLabelWithKey(431, 151, 417, 417, null, "src/resource/cooking_game/tutorial2.png"), Integer.valueOf(4));
        intro.add(tutorial3 = new SceneModify().createJLabelWithKey(431, 151, 417, 417, null, "src/resource/cooking_game/tutorial3.png"), Integer.valueOf(3));
        //Bento HitBox
        layer.add(BentoHint = new SceneModify().createJLabelWithHint(1280/2 - 450/2, 28, 460, 70), Integer.valueOf(8));
        layer.add(BentoHintBox = new SceneModify().createJLabelWithKey(1280/2 - 450/2, 28, 460, 70, null, "src/resource/cooking_game/selectedHint.png"), Integer.valueOf(8));
        layer.add(BentoHitBox1 = new SceneModify().createJButton(123, 200, 224, 370, handler, null), Integer.valueOf(8));
        layer.add(BentoHitBox2 = new SceneModify().createJButton(364, 200, 251, 175, handler, null), Integer.valueOf(8));
        layer.add(BentoHitBox3 = new SceneModify().createJButton(364, 390, 283, 180, handler, null), Integer.valueOf(8));
        //Bento Food
        layer.add(mainFood = new SceneModify().createJLabelWithMouse(115, 222, 273, 350, null, null), Integer.valueOf(4));
        layer.add(sideFood = new SceneModify().createJLabelWithMouse(325, 209, 284, 189, null, null), Integer.valueOf(5));
        layer.add(dessertFood = new SceneModify().createJLabelWithMouse(364, 372, 265, 185, null, null), Integer.valueOf(6));
        layer.add(bentoBox = new SceneModify().createJLabelWithMouse(71, 188, 585, 453,null, "src/resource/cooking_game/bento3.png"), Integer.valueOf(3));
        layer.add(bentoBG = new SceneModify().createJLabelWithMouse(0, 0, 1280, 720, null, "src/resource/cooking_game/bentoBackground3.png"), Integer.valueOf(1));
        layer.add(bentoArrow = new SceneModify().createJLabelWithMouse(-500, -500, 50, 80, null, "src/resource/cooking_game/arrowDown.gif"), Integer.valueOf(7));
        //Main Course
        layer.add(selectedFrame = new JLabel(new ImageIcon("src/resource/cooking_game/selectedFrame.png")) {{
            setBounds(788, 116, 371, 482);
            add(selectedFrameName = new SceneModify().createJLabelWithFont(7, 21, 351, 67, "Japanese Pancake"));
            add(selectedFrameSlideRight = new SceneModify().createJButton(320, 224, 32, 33, handler, "src/resource/cooking_game/selectedRight.png"));
            add(selectedFrameSlideLeft = new SceneModify().createJButton(14, 224, 32, 33, handler, "src/resource/cooking_game/selectedLeft.png"));
            add(selectedFrameFood = new SceneModify().createJLabelWithKey(8, 115, 350, 250, null, "src/resource/cooking_game/mainIcon1.png"));
            add(selectedFrameButton = new SceneModify().createJButton(111, 408, 148, 56, handler, "src/resource/cooking_game/selectedButton.png"));
            setVisible(false);
        }},  Integer.valueOf(5));
        this.add(layer);//adding (panel)background-img in JFrame
        this.setSize(1280, 747);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
import canvas_modify.*;
import javax.swing.*;
import java.awt.*;

import java.awt.Font;
import java.io.File;
import java.io.IOException;

public class MiniGameCooking extends JFrame {
    public JLayeredPane layer;
    public ActionHandlerOfCooking handler;
    public JLabel selectedFrameBG, selectedFrameName;
    public JButton selectedFrameButton, selectedFrameSlideLeft, selectedFrameSlideRight;
    public JButton BentoHitBox1, BentoHitBox2, BentoHitBox3, BentoHitBox4;
    public JLabel selectedFrameFood;
    public JLabel mainFood, sideFood, dessertFood, BentoBox;
    public JLabel JLabelButton1, JLabelButton2;
    public Thread thread;

    public MiniGameCooking() {
        this.setBackground(Color.BLACK);
        handler = new ActionHandlerOfCooking(this);
        layer = new SceneModify().addJLayerPaneBackGround("src/resource/cooking_game/bentoBackground1.png", "layer", true);

//        layer.add(minigameCookingBento1 = new JLabel(new ImageIcon("src/resource/cooking_game/bento1.png")) {{
//            setBounds(71, 188, 585, 455);
//            //addMouseListener(new ActionHandlerOfCooking(MiniGameCooking.this, minigameCookingBento1));
//        }});

        //Bento HitBox
        layer.add(BentoHitBox1 = new SceneModify().newJButton(123, 200, 224, 350, handler, null), Integer.valueOf(7));
        layer.add(BentoHitBox2 = new SceneModify().newJButton(364, 200, 251, 175, handler, null), Integer.valueOf(7));
        layer.add(BentoHitBox3 = new SceneModify().newJButton(364, 390, 283, 160, handler, null), Integer.valueOf(7));
        layer.add(BentoHitBox4 = new SceneModify().newJButton(59, 177, 615, 485, handler, null), Integer.valueOf(6));

        //Bento Food
        layer.add(mainFood = new SceneModify().newJLabel(115, 224, 273, 350, null, "src/resource/cooking_game/main3.png"), Integer.valueOf(4));
        layer.add(sideFood = new SceneModify().newJLabel(325, 209, 284, 189, null, "src/resource/cooking_game/side1.png"), Integer.valueOf(5));
        layer.add(dessertFood = new SceneModify().newJLabel(364, 372, 265, 185, null, "src/resource/cooking_game/dessert2.png"), Integer.valueOf(6));
        layer.add(BentoBox = new SceneModify().newJLabel(71, 188, 585, 453, null, "src/resource/cooking_game/bento2.png"), Integer.valueOf(3));




        //Main Course
        layer.add(selectedFrameBG = new JLabel(new ImageIcon("src/resource/cooking_game/selectedFrame.png")) {{
            setBounds(788, 116, 371, 482);
            add(selectedFrameName = new SceneModify().newJLabel(7, 21, 351, 67, "Japanese Pancake"));
            add(selectedFrameSlideRight = new SceneModify().newJButton(320, 224, 32, 33, handler, "src/resource/cooking_game/selectedRight.png"));
            add(selectedFrameSlideLeft = new SceneModify().newJButton(14, 224, 32, 33, handler, "src/resource/cooking_game/selectedLeft.png"));
            add(selectedFrameFood = new SceneModify().newJLabel(8, 115, 350, 250, null, "src/resource/cooking_game/mainIcon1.png"));
            add(selectedFrameButton = new SceneModify().newJButton(111, 408, 148, 56, handler, "src/resource/cooking_game/selectedButton.png"));
        }},  Integer.valueOf(5));

        this.add(layer);//adding (panel)background-img in JFrame
        this.setSize(1280, 747);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}


import canvas_modify.SceneModify;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.lang.reflect.Array;

public class MiniGameCooking extends JFrame {
    public JLayeredPane layer;
    public JButton menuButton2, difficultyButton1, difficultyButton2;
    public JLabel minigameCookingButton1;
    public JLabel minigameCookingBento1;

    public JLabel selectedFrameBG;
    public JButton selectedFrameButton, selectedFrameSlideLeft, selectedFrameSlideRight;

    public JLabel selectedFrameFood;
    public JLabel JLabelButton1, JLabelButton2;
    public int[] array = {1, 2, 3};
    public int currentIndex = -1;
    public Thread thread;

    public MiniGameCooking() {
        this.setBackground(Color.BLACK);
        layer = new SceneModify().addJLayerPaneBackGround("src/resource/cooking_game/bentoBackground1.png", "layer", true);

        layer.add(minigameCookingBento1 = new JLabel(new ImageIcon("src/resource/cooking_game/bento1.png")) {{
            setBounds(71, 188, 585, 455);
//            addMouseListener(new ActionHandlerOfCooking(MiniGameCooking.this, minigameCookingBento1));
        }});


        //Main Course
        layer.add(selectedFrameBG = new JLabel(new ImageIcon("src/resource/cooking_game/selectedFrame.png")) {{
            setBounds(788, 116, 371, 482);
            add(selectedFrameSlideRight = new JButton(new ImageIcon("src/resource/cooking_game/selectedRight.png")) {{
                setBounds(320, 224, 32, 33);
                setBorder(null);
                addActionListener(new ActionHandlerOfCooking(MiniGameCooking.this));
            }},  Integer.valueOf(2));
            add(selectedFrameSlideLeft = new JButton(new ImageIcon("src/resource/cooking_game/selectedLeft.png")) {{
                setBounds(14, 224, 32, 32);
                setBorder(null);
                addActionListener(new ActionHandlerOfCooking(MiniGameCooking.this));
            }},  Integer.valueOf(2));
            add(selectedFrameButton = new JButton(new ImageIcon("src/resource/cooking_game/selectedButton.png")) {{
                setBounds(111, 408, 148, 56);
                setBorder(null);
                addActionListener(new ActionHandlerOfCooking(MiniGameCooking.this));
            }},  Integer.valueOf(2));
            add(selectedFrameFood = new JLabel(new ImageIcon("src/resource/cooking_game/icon1.png")) {{
                setBounds(10, 115, 350, 250);
            }},  Integer.valueOf(1));
        }},  Integer.valueOf(5));









//        panel.add(JLabelButton1 = new JLabel(){{
//            setBounds(150,100, 50,50);
//            setBackground(Color.yellow);
//            setOpaque(true);
//            addMouseListener(new ActionHandlerOfCooking(MiniGameCooking.this));
//        }});
//
//        panel.add(JLabelButton2 = new JLabel(){{
//            setBounds(400,100, 50,50);
//            setBackground(Color.RED);
//            setOpaque(true);
//            addMouseListener(new ActionHandlerOfCooking(MiniGameCooking.this));
//        }});


//        panel.add(minigameCookingButton1 = new JLabel(new ImageIcon("src/resource/cooking_game/button1.png")) {{
//            setBounds((1280/2 - 240), (720/2 - 240), 85, 85);
//            addMouseListener(new ActionHandlerOfCooking("minigameCookingButton1",  MiniGameCooking.this, minigameCookingButton1));
//            setOpaque(true);
//            setBackground(Color.YELLOW);
//        }});


        this.add(layer);//adding (panel)background-img in JFrame
        this.setSize(1280, 747);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setVisible(true);


    }
}
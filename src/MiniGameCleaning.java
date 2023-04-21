import javax.swing.*;
import java.awt.*;
import canvas_modify.*;

public class MiniGameCleaning extends JFrame {
    public JLayeredPane layer, Challenge1, Challenge2, Challenge3, FadeIn;
    public  JLabel Button1, Button2;
    public JLabel scoreBoard;
    private ImageIcon image1 = new ImageIcon("src/menu_canvas/background.png");
    private ImageIcon image2 = new ImageIcon("src/typing_game/background.png");
    private ImageIcon image3 = new ImageIcon("src/menu_canvas/difficulty.png");

    public MiniGameCleaning() {
        layer = new JLayeredPane() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                image1 = new ImageIcon("src/cleaning_game/background.png");
                g.drawImage(image1.getImage(), 0, 0, null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        };
        layer.add(Challenge1 = new SceneModify().addJLayerPaneBackGround("src/cleaning_game/background1.png", "Challenge1"));
        layer.add(Challenge2 = new SceneModify().addJLayerPaneBackGround("src/cleaning_game/background2.png", "Challenge2"));
//        layer.add(FadeIn = new SceneModify().addJLayerPaneBackGround());

//        layer.add(Challenge1 = new addJLayerPaneBackGround("src/cleaning_game/background1.png", "Challenge1"));
//        layer.add(Challenge2 = new addJLayerPaneBackGround("src/cleaning_game/background2.png", "Challenge2"));



        layer.add(Button1 = new JLabel(new ImageIcon("src/cooking_game/button1.png")) {{
            setBounds(50, 30, 85, 85);
            addMouseListener(new ActionHandlerOfCleaning(MiniGameCleaning.this, Button1));
        }});

        layer.add(Button2 = new JLabel(new ImageIcon("src/cooking_game/button1.png")) {{
            setBounds(50, 300, 85, 85);
            addMouseListener(new ActionHandlerOfCleaning(MiniGameCleaning.this, Button2));
        }});

//        layer.add(scoreBoard = new JLabel(){{
//            setBounds(1280/2 - 150, 720/2- 300, 300, 600);
//            setBackground(Color.YELLOW);
//            setOpaque(true);
//            addMouseListener(new ActionHandlerOfCleaning(MiniGameCleaning.this, scoreBoard));
//            setVisible(false);
//        }}, Integer.valueOf(10));



        this.add(layer);//adding (panel)background-img in JFrame
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
//    public JLayeredPane addJLayerPaneBackGround(String imagePath, String layerName){
//        JLayeredPane jLayeredPane = new JLayeredPane() {
//            @Override
//            public void paintComponent(Graphics g) {
//                super.paintComponent(g);
//                try {
//                    image1 = new ImageIcon(imagePath);
//                    g.drawImage(image1.getImage(), 0, 0, null);
//                } catch (Exception e) {e.printStackTrace();}
//            }
//            {
//                setName(layerName);
//                setBounds(0,0, 1280,720);
//                setVisible(false);
//            }};
//        return jLayeredPane;
//    }
}


//        new ActionHandlerOfCleaning().Cleaning_MiniGame1(this, layer);

//        // Add the cat animation to the panel
//        EntityAnimation catAnimation = new EntityAnimation();
//        catAnimation.setBounds(0, 0, 1280, 720);
//        panel.add(catAnimation, new Integer(20));


//        CleaningMission1 myTEstt = new CleaningMission1("src/cleaning_game/puzzle1_1.png", 377, 482, 48, 123);
//        myTEstt.setBounds(0, 0, getWidth(), getHeight());


//        CleaningMission1 puzzle2 = new CleaningMission1("src/cleaning_game/puzzle1_2.png", 0, 0, 488, 490, 235);
//        puzzle2.setBounds(401, -15, 1280, 720);
//        panel.add(puzzle2);


//        panel.add(new CleaningMission1("src/cleaning_game/puzzle1_1.png", 377, 482, 48, 123),  Integer.valueOf(11));


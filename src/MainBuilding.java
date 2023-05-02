import canvas_modify.*;
import javax.swing.*;
import java.awt.*;

public class MainBuilding extends JFrame{
    public JLayeredPane layer;
    public JLabel uiButton1;
    public JButton homeExit;

    public MainBuilding() {
        ActionHandlerOfBuilding handler = new ActionHandlerOfBuilding(this);
        this.setBackground(Color.BLACK);


        layer = new SceneModify().addJLayerPaneBackGround("src/resource/building_canvas/background.png", "layer", true);
        add(layer);

//        layer.add(uiButton1 = new JLabel() {{
//            ImageIcon minigameTypingEnter_Icon = new ImageIcon("src/resource/building_canvas/uiButton1.png");
//            setIcon(minigameTypingEnter_Icon);
//            //addMouseListener(new ActionHandlerOfStage(MainStage.this, minigameTypingEnter));
//            setBounds(1103, 28, 150, 55);
//        }}, Integer.valueOf(9));

        layer.add(uiButton1 = new SceneModify().createJLabelWithMouse(1103, 28, 150, 55, null, "src/resource/building_canvas/uiButton1.png"), Integer.valueOf(9));
        layer.add(homeExit = new SceneModify().createJButton(108, 25, 55, 55, handler, "src/resource/stage_canvas/homeEnter.png"), Integer.valueOf(0));

        //layer.add(furniture_ชื่อเฟอร์ตัวเล็ก = new SceneModify().createJButton(x, y, w, h, handler, "src/resource/stage_canvas/ชื่อเฟอร์ตัวเล็ก.png"), Integer.valueOf(0));


        this.setSize(1280, 747);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.layer.add(new SceneModify().addJLayerPaneAnimate(new FadeOutAnimate()),  Integer.valueOf(10));
        this.setVisible(true);
    }
}

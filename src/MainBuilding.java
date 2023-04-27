import canvas_modify.*;
import javax.swing.*;
import java.awt.*;

public class MainBuilding extends JFrame{
    public JLayeredPane layer;
    public JLabel uiButton1;

    public MainBuilding() {
        this.setBackground(Color.BLACK);

        layer = new SceneModify().addJLayerPaneBackGround("src/resource/building_canvas/background.png", "layer", true);
        add(layer);

        layer.add(uiButton1 = new JLabel() {{
            ImageIcon minigameTypingEnter_Icon = new ImageIcon("src/resource/building_canvas/uiButton1.png");
            setIcon(minigameTypingEnter_Icon);
            //addMouseListener(new ActionHandlerOfStage(MainStage.this, minigameTypingEnter));
            setBounds(1103, 28, 150, 55);
        }}, Integer.valueOf(9));


        this.setSize(1280, 747);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.layer.add(new SceneModify().addJLayerPaneAnimate(new FadeOutAnimate()),  Integer.valueOf(10));
        this.setVisible(true);
    }
}

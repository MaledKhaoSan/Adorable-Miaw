import canvas_modify.SceneFadeOut;
import canvas_modify.SceneModify;
import canvas_modify.SceneSoundBackground;
import canvas_modify.SceneSoundPlayer;

import javax.swing.*;
import java.awt.*;




public class MainMenu extends JFrame{
    public JLayeredPane layer;
    public JButton menuButton1;
    public SceneSoundPlayer soundPlayer = new SceneSoundBackground();

    public MainMenu() {
        soundPlayer.getSoundPath(0);
        ActionHandlerOfMenu handler = new ActionHandlerOfMenu(this);
        this.setBackground(Color.black);
        layer = new SceneModify().addJLayerPaneBackGround("src/resource/menu_canvas/background.png", "layer", true);

        this.add(menuButton1 = new SceneModify().createJButton((1280/2) - (150/2), 589, 150, 35, handler, "src/resource/menu_canvas/Button1.png", true));
        menuButton1.setPressedIcon(new ImageIcon("src/resource/menu_canvas/Button1_1.png")); /* Remove border-graphics.*/


        this.add(layer);
        this.setSize(1280, 747);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.addWindowListener(handler);
        this.layer.add(new SceneModify().addJLayerPaneAnimate(new SceneFadeOut()),  Integer.valueOf(20));
        this.setVisible(true);


    }

}






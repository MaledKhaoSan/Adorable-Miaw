import canvas_modify.*;
import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame{
    private JFrame canvas = new JFrame();
    public JLayeredPane layer;
    public JButton menuButton1;

    public MainMenu() {
        this.setBackground(Color.black);
        layer = new SceneModify().addJLayerPaneBackGround("src/resource/menu_canvas/background.png", "layer", true);
        this.add(menuButton1 = new JButton(new ImageIcon("src/resource/menu_canvas/Button1.png")) {{
            setBorder(null); setPressedIcon(new ImageIcon("src/resource/menu_canvas/Button1_1.png")); /* Remove border-graphics.*/
            setBounds((1280/2) - (150/2), 589, 150, 35);
            addActionListener(new ActionHandlerOfMenu(MainMenu.this));
        }});

        this.add(layer);//adding (panel)background-img in JFrame
        this.setSize(1280, 747);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

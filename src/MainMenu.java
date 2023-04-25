import canvas_modify.*;
import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame{
    private JFrame canvas = new JFrame();
    public JLayeredPane layer;
    public JButton menuButton1, menuButton2, difficultyButton1, difficultyButton2;
    public JLabel label1;
    public boolean menuIsSelected;

    private int mouseX, mouseY;
    public boolean running;
    public Thread thread;

    public MainMenu() {

        layer = new SceneModify().addJLayerPaneBackGround("src/menu_canvas/background.png", "layer", true);
        this.add(menuButton1 = new JButton(new ImageIcon("src/menu_canvas/Button1.png")) {{
            setBounds((1280/2) - (150/2), 589, 150, 35);
            setBorder(null); setPressedIcon(new ImageIcon("src/menu_canvas/Button1_1.png")); /* Remove border-graphics.*/
            addActionListener(new ActionHandlerOfMenu(MainMenu.this, menuButton2));
        }});

        this.add(layer);//adding (panel)background-img in JFrame
        this.setSize(1280, 747);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

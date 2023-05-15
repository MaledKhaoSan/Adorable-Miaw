import canvas_modify.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;




public class MainMenu extends JFrame{
    public JLayeredPane layer;
    public JButton menuButton1;

    public MainMenu() {
        ActionHandlerOfMenu handler = new ActionHandlerOfMenu(this);
        this.setBackground(Color.black);
        layer = new SceneModify().addJLayerPaneBackGround("src/resource/menu_canvas/background.png", "layer", true);
        this.add(menuButton1 = new JButton(new ImageIcon("src/resource/menu_canvas/Button1.png")) {{
            setBorder(null); setPressedIcon(new ImageIcon("src/resource/menu_canvas/Button1_1.png")); /* Remove border-graphics.*/
            setBounds((1280/2) - (150/2), 589, 150, 35);
            addActionListener(handler);
        }});

        this.add(layer);
        this.setSize(1280, 747);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.addWindowListener(handler);
        this.layer.add(new SceneModify().addJLayerPaneAnimate(new SceneFadeOut()),  Integer.valueOf(20));
        this.setVisible(true);

        playBackgroundMusic("src/resource/audio/Attention.wav");
    }

    public void playBackgroundMusic(String filePath) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            System.out.println("Error playing background music: " + e.getMessage());
        }
    }
}






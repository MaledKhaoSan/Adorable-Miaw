package canvas_modify;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class SceneModify extends JLayeredPane implements Runnable{
    private int currentFrame = 1;
    private BufferedImage[] frames;
    private JLabel label;


    public JLayeredPane addJLayerPaneBackGround(String imagePath, String layerName, boolean visible){
        return new JLayeredPane() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    ImageIcon image1 = new ImageIcon(imagePath);
                    g.drawImage(image1.getImage(), 0, 0, null);
                } catch (Exception e) {e.printStackTrace();}
            }
            {
                setName(layerName);
                setBounds(0,0, 1280,720);
                setVisible(visible);
            }};
    }

    public JLayeredPane addJLayerPaneBackGround(String layerName, boolean visible){
        return new JLayeredPane() {
            {
                setName(layerName);
                setBounds(0,0, 1280,720);
                setBackground(Color.white);
                setOpaque(true);
                setVisible(visible);
            }};
    }

    public JLabel addJLayerPaneAnimate(SpriteSheetSlice spriteSheetSlice) {
        //interface เรียกใช้method getSlice();
        BufferedImage[] frames = spriteSheetSlice.getSlice();
        JLabel label = new JLabel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(frames[currentFrame], 0, 0, 1280, 720, null);
            }
            {
                setBounds(0,0,1280,720);
                setVisible(true);
            }
        };
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < frames.length; i++) {
                    currentFrame = i;
                    label.repaint();
                    try { Thread.sleep(100); }
                    catch (InterruptedException ex) { ex.printStackTrace();}
                }
            }
        });
        thread.start();
        return label;
    }

    public void run() {
        if (Thread.currentThread().getName().equals("typingIntro")) {
            for (int i = 0; i < frames.length; i++) {
                currentFrame = i;
                label.repaint();
                try { Thread.sleep(100); }
                catch (InterruptedException ex) { ex.printStackTrace();}
            }
        }
    }


    public JButton createJButton(int x, int y, int width, int height, ActionListener handler, String path, boolean visible) {
        JButton jButton = new JButton(new ImageIcon(path));
        jButton.setBounds(x, y, width, height);
        jButton.setBorder(null);
        jButton.addActionListener(handler); // use the actionHandler parameter directly
        jButton.setVisible(visible);
        return jButton;
    }

    public JLabel createJLabel(int x, int y, int width, int height, MouseListener handler, String path, boolean visible) {
        JLabel jLabel = new JLabel(new ImageIcon(path));
        jLabel.setBounds(x, y, width, height);
        jLabel.addMouseListener(handler);
        jLabel.setVisible(visible);
        return jLabel;
    }

    public JLabel createJLabelWithMouse(int x, int y, int width, int height, MouseListener handler, String path, boolean visible) {
        JLabel jLabel = new JLabel(new ImageIcon(path));
        jLabel.setBounds(x, y, width, height);
        jLabel.addMouseListener(handler);
        jLabel.setVisible(visible);
        return jLabel;
    }
    public JLabel createJLabelWithMouse(int x, int y, int width, int height, MouseListener handler, String path) {
        return createJLabelWithMouse(x,y,width,height,handler,path, true);
    }

    public JLabel createJLabelWithKey(int x, int y, int width, int height, KeyListener handler, String path) {
        JLabel jLabel = new JLabel(new ImageIcon(path));
        jLabel.setBounds(x, y, width, height);
        jLabel.addKeyListener(handler);
        return jLabel;
    }

    public JLabel createJLabelWithFont(int x, int y, int width, int height, int fontOpacity, int fontSize, String fontPath, String words, boolean visible) {
        JLabel jLabel = this.createJLabel(x,y,width,height, null, "", visible);
        try {
            //---- Load the font from a file
            //File fontPath = new File("src/resource/fonts/Sabreen Regular Demo 400.ttf");
            //Font font = Font.createFont(Font.TRUETYPE_FONT, fontPath);
            //Font fontsize = font.deriveFont(30f);
            //---- Set size & style
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)).deriveFont(Font.PLAIN,fontSize);
            jLabel.setText(words);
            jLabel.setFont(font);
            jLabel.setForeground(new Color(0, 0, 0, fontOpacity));
            jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        return jLabel;
    }

    protected void playAudio(String filePath) {



        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            System.out.println("Error playing audio: " + e.getMessage());
        }
    }
}

package canvas_modify;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SceneModify extends JLayeredPane{
    private int currentFrame = 0;
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

    public JLabel addJLayerPaneAnimate(SpriteSheetSlice spriteSheetSlice) {
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


    public JButton newJButton(int x, int y, int width, int height, ActionListener handler, String path) {
        JButton jButton = new JButton(new ImageIcon(path));
        jButton.setBounds(x, y, width, height);
        jButton.setBorder(null);
        jButton.addActionListener(handler); // use the actionHandler parameter directly
        return jButton;
    }
    public JLabel newJLabel(int x, int y, int width, int height, MouseListener handler, String path) {
        JLabel jLabel = new JLabel(new ImageIcon(path));
        jLabel.setBounds(x, y, width, height);
        jLabel.addMouseListener(handler);
        return jLabel;
    }

    public JLabel newJLabel(int x, int y, int width, int height,int r,int g,int b,int a,boolean opaque, MouseListener handler) {
        JLabel jLabel = new JLabel();
        jLabel.setBounds(x, y, width, height);
        jLabel.setBackground(new Color(r, g, b, a));
        jLabel.setOpaque(opaque);
        jLabel.addMouseListener(handler);
        return jLabel;
    }
}

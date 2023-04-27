package canvas_modify;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
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


//    public JLabel addJLayerPaneFadeOutAnimate() {
//        try {
//            spriteSheet = ImageIO.read(new File("src/resource/canvas_modify/FadeOut.png"));
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        this.frameCount = 10;
//        this.frameWidth = spriteSheet.getWidth() / frameCount;
//        this.frameHeight = spriteSheet.getHeight();
//
//        BufferedImage[] frames = new BufferedImage[frameCount];
//
//        for (int i = 0; i < frameCount; i++) {
//            int x = i * frameWidth;
//            int y = 0;
//            frames[i] = spriteSheet.getSubimage(x, y, frameWidth, frameHeight);
//        }
//
//        JLabel label = new JLabel() {
//            @Override
//            public void paintComponent(Graphics g) {
//                super.paintComponent(g);
//                g.drawImage(frames[currentFrame], 0, 0, 1280, 720, null);
//            }
//            {
//                setBounds(0,0,1280,720);
//                setVisible(true);
//            }
//        };
//
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < frames.length; i++) {
//                    currentFrame = i; label.repaint();
//
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException ex) {
//                        ex.printStackTrace();
//                    }
//                }
//
//            }
//        });
//        thread.start();
//        return label;
//    }



}

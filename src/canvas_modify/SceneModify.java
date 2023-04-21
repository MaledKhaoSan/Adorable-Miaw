package canvas_modify;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SceneModify extends JLayeredPane{
    private int currentFrame = 0;
    public JLayeredPane addJLayerPaneBackGround(String imagePath, String layerName){
        JLayeredPane jLayeredPane = new JLayeredPane() {
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
                setVisible(false);
            }};
        return jLayeredPane;
    }

    public JLabel createAnimatedLabel() {
        String spriteSheetPath = "src/canvas_modify/FadeIn.png";
        int frameWidth = 1280; int frameHeight = 720; int rows = 1; int cols = 7; int frameDelay = 1000;
        // Load the sprite sheet image
        BufferedImage spriteSheet = null;
        try {
            spriteSheet = ImageIO.read(new File(spriteSheetPath));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Slice the sprite sheet into individual frames
        BufferedImage[] frames = new BufferedImage[rows * cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                frames[(i * cols) + j] = spriteSheet.getSubimage(j * frameWidth, i * frameHeight, frameWidth, frameHeight);
            }
        }

        // Define the animation sequence
        int frameCount = frames.length;

        // Set the initial position of the entity
        int x = 0;
        int y = 0;
        int width = frameWidth * 1; // Width of entity in pixels
        int height = frameHeight * 1; // Height of entity in pixels

        // Create a new JLabel to hold the animated image
        JLabel label = new JLabel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(frames[currentFrame], x, y, 1280, 720, null);
            }
            {
                setBounds(0,0,1280,720);
                setVisible(true);
            }
        };

        // Create a new thread to update the animation
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (currentFrame < frames.length- 1) {
                    // Update the current frame of the animation // Repaint the label to show the updated animation and position
                    currentFrame = (currentFrame + 1);
                    label.repaint();

                    // Wait for the specified delay between frames
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }

            }
        });
        thread.start();
        return label;
    }



}

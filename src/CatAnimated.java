import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public abstract class CatAnimated extends JLayeredPane implements Runnable, CatBehavior {

    protected BufferedImage spriteSheet;
    protected BufferedImage[] frames;
    protected int currentFrame;
    protected int frameCount;
    protected int frameDelay;
    protected int x, y;
    protected boolean running;
    protected int width, height;
    public CatAnimated(String spriteSheetPath, int frameWidth, int frameHeight, int rows, int cols, int frameDelay) {
        // Load the sprite sheet image
        try {
            spriteSheet = ImageIO.read(new File(spriteSheetPath));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Slice the sprite sheet into individual frames
        frames = new BufferedImage[rows * cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                frames[(i * cols) + j] = spriteSheet.getSubimage(j * frameWidth, i * frameHeight, frameWidth, frameHeight);
            }
        }

        // Define the animation sequence
        currentFrame = 0;
        frameCount = frames.length;
        this.frameDelay = frameDelay;


        // Set the initial position of the entity
        x = -800;
        y = -30;
        width = frameWidth * 1; // Width of entity in pixels
        height = frameHeight * 1; // Height of entity in pixels

        // Set the running flag to true
        running = true;

        // Create a new thread to update the animation
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void paint(Graphics g) {}
    @Override
    public void run() {
        while (running) {
            // Update the current frame of the animation
            currentFrame = (currentFrame + 1) % frameCount;

            // Update the position of the entity
            move();
            jump();
            repaint();
            try {
                Thread.sleep(frameDelay);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}


//    public void paint(Graphics g) {
//        super.paint(g);
//        g.drawImage(frames[currentFrame], x, y, width, height, null);
//    }

//class CatEating extends EntityAnimation {
//
//    public CatEating(String spriteSheetPath) {
//        super(spriteSheetPath, 1280, 720, 1, 6, 500);
//    }
//
//    @Override
//    protected void move() {
//        // Eating animation doesn't move
//    }
//}
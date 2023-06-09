import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public abstract class CatAnimated extends JLayeredPane implements Runnable, CatBehavior {
    protected BufferedImage spriteSheet;
    protected BufferedImage[] frames;
    protected int currentFrame;
    protected int frameCount;
    protected boolean running;
    protected int width, height;

    private String spriteSheetPath;
    private int frameWidth;
    private int frameHeight;
    private int rows;
    private int cols;
    protected int x;
    protected int y;
    protected int frameDelay;
    public void CreateBufferedAnimated(String spriteSheetPath, int frameWidth, int frameHeight, int rows, int cols, int x, int y, int frameDelay){
        this.spriteSheetPath = spriteSheetPath;
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        this.rows = rows;
        this.cols = cols;
        this.x = x;
        this.y = y;
        this.frameDelay = frameDelay;
        try (InputStream input = new FileInputStream(spriteSheetPath)) {
            spriteSheet = ImageIO.read(input);
        } catch (IOException ex) {ex.printStackTrace();}
        CreateBufferedSlice();
        running = true; new Thread(this, "").start();
    }


    public void CreateBufferedSlice() {

        frames = new BufferedImage[rows * cols];
        for (int i = 0; i < rows; i++) {
          for (int j = 0; j < cols; j++) {
            int X = j * frameWidth; int Y = i * frameHeight;
            int W = frameWidth;     int H = frameHeight;
            frames[(i * cols) + j] = spriteSheet.getSubimage(X, Y, W, H);
          }
        }



        // Slice the sprite sheet into individual frames
        // Define the animation sequence
        currentFrame = 0;
        frameCount = frames.length;
        //this.frameDelay = frameDelay;
        // Set the initial position of the entity
        //this.x = x;//-800;
        //this.y = y;//-30;
        width = (frameWidth); // Width of entity in pixels
        height = (frameHeight); // Height of entity in pixels
    }

    // Update the current frame of the animation // Update the position of the entity
    @Override
    public void run() {
        while (running) {
            update();
            move();
            playing();
            repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
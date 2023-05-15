package canvas_modify;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SceneFadeInOut implements SpriteSheetSlice, Runnable{
    private BufferedImage fadeInSpriteSheet = null;
    private BufferedImage fadeOutSpriteSheet = null;
    private int frameCount;
    private int frameWidth;
    private int frameHeight;




    @Override
    public BufferedImage[] getSlice() {
        BufferedImage[] firstFrames = getFrames("src/resource/ui_transition/CookingFadeIn.png");
        BufferedImage[] secFrames = getFrames("src/resource/ui_transition/CookingFadeOut.png");

        BufferedImage[] frames = new BufferedImage[firstFrames.length + secFrames.length];
        System.arraycopy(firstFrames, 0, frames, 0, firstFrames.length);
        System.arraycopy(secFrames, 0, frames, 10, secFrames.length);
        new Thread(new SceneFadeInOut()).start();
        return frames;
    }

    private BufferedImage[] getFrames(String filename) {
        try {
            BufferedImage spriteSheet = ImageIO.read(new File(filename));
            this.frameCount = 10;
            this.frameWidth = spriteSheet.getWidth() / frameCount;
            this.frameHeight = spriteSheet.getHeight();
            BufferedImage[] frames = new BufferedImage[frameCount];
            for (int i = 0; i < frameCount; i++) {
                int x = i * frameWidth;
                int y = 0;
                frames[i] = spriteSheet.getSubimage(x, y, frameWidth, frameHeight);
            }
            return frames;
        }
        catch (IOException ex) {ex.printStackTrace(); return null; }
    }

    @Override
    public void run() {
        try {
            System.out.println("Test");
            Thread.sleep(100);
        } catch (InterruptedException e) {}

    }
}
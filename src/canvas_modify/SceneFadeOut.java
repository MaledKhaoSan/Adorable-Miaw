package canvas_modify;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SceneFadeOut implements SpriteSheetSlice{
    private BufferedImage spriteSheet = null;
    private int frameCount;
    private int frameWidth;
    private int frameHeight;

    @Override
    public BufferedImage[] getSlice() {
        try {
            spriteSheet = ImageIO.read(new File("src/resource/ui_transition/FadeOut.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
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
}
import javax.swing.*;
import java.awt.image.BufferedImage;

public class CatJumping extends CatAnimated {

    public CatJumping(String spriteSheetPath) {
        super(spriteSheetPath, 1280, 720, 1, 6, 100);
    }

    @Override
    public void move() {
        x += 45;
    }

    @Override
    public void jump() {}

    @Override
    public BufferedImage getBufferedImage() {
        return null;
    }
}

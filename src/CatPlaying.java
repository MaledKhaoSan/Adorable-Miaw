import java.awt.*;
import java.awt.image.BufferedImage;

public class CatPlaying extends CatAnimated {
    public CatPlaying(String spriteSheetPath){
        this.CreateBufferedAnimated(spriteSheetPath, 1280, 720, 1, 6, 0,0, 150);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(frames[currentFrame], x, y, width, height, null);
    }
    @Override
    public void move() {}
    @Override
    public void playing() {}

    @Override
    public void update() {
        if ((currentFrame + 1) % frameCount == 0 & frameCount == 6){
            CreateBufferedAnimated("src/resource/typing_game/CatSpriteSheet4.png", 1280, 720, 1, 9, 0,0, 150);
        }
        else if ((currentFrame + 1) % frameCount == 0){
            for (int i = 0; i < frames.length / 2; i++) {
                BufferedImage temp = frames[i];
                frames[i] = frames[frames.length - 1 - i];
                frames[frames.length - 1 - i] = temp;
            }
        }
        currentFrame = (currentFrame + 1) % frameCount;
    }
}

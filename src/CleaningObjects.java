import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class CleaningObjects extends CleaningObjectsModify implements  MouseListener{
    public CleaningObjects(String mainSpriteSheetPath, String subSpriteSheetPath, int objectWidth, int objectHeight, int rotationStart) {
        super(mainSpriteSheetPath, subSpriteSheetPath, objectWidth, objectHeight, rotationStart);
        addMouseListener(this);
    }
    public CleaningObjects(String mainSpriteSheetPath, int objectWidth, int objectHeight, int rotationStart) {
        this(mainSpriteSheetPath, "", objectWidth, objectHeight, rotationStart);
    }
    public CleaningObjects(String mainSpriteSheetPath, String subSpriteSheetPath, int objectWidth, int objectHeight) {
        this(mainSpriteSheetPath, subSpriteSheetPath, objectWidth, objectHeight, 0);
    }
    public void rotatable(){
        if (running){
            if (rotationSwitch & rotatable){
                rotationStart += 2.4;
            }
        }
    }
    @Override
    public void switchable() {
        if (running){
            if (hasSubSpriteSheet){
                try {
                    // Toggle the boolean variable
                    if (switchSpriteSheet) {spriteSheet = ImageIO.read(new File(mainSpriteSheetPath));}
                    else {spriteSheet = ImageIO.read(new File(subSpriteSheetPath));}
                    switchSpriteSheet = !switchSpriteSheet;
                } catch (IOException ex) { ex.printStackTrace(); }
            }
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1 & hasSubSpriteSheet){
            switchable();
        }
    }

    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3){
            if (rotatable) {
                rotationSwitch = !rotationSwitch;
            }
        }
    }
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3){
            rotationSwitch = !rotationSwitch;
        }
    }

    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}

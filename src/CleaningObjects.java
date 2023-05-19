import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class CleaningObjects extends CleaningObjectsModify implements  MouseListener, MouseMotionListener{
    private int mouseX, mouseY;
    public CleaningObjects(String mainSpriteSheetPath, String subSpriteSheetPath, int objectWidth, int objectHeight, int rotationStart) {
        super(mainSpriteSheetPath, subSpriteSheetPath, objectWidth, objectHeight, rotationStart);
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    public CleaningObjects(String mainSpriteSheetPath, int objectWidth, int objectHeight, int rotationStart) {
        this(mainSpriteSheetPath, "", objectWidth, objectHeight, rotationStart);
    }
    public CleaningObjects(String mainSpriteSheetPath, String subSpriteSheetPath, int objectWidth, int objectHeight) {
        this(mainSpriteSheetPath, subSpriteSheetPath, objectWidth, objectHeight, 0);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D obj = (Graphics2D) g;
        int centerX = objectWidth / 2;  // Calculate center point of image X    |  int centerX = 48 + (377 - 48) / 2; // Calculate center point of image X
        int centerY = objectHeight / 2; // Calculate center point of image Y    |  int centerY = 123 + (482 - 123) / 2; // Calculate center point of image Y
        // Translate to the center of the image
        obj.translate(centerX, centerY);
        // Rotate by the desired angle
        obj.rotate(Math.toRadians(rotationStart));
        // Draw the image
        obj.drawImage(spriteSheet, -objectWidth/2, -objectHeight/2, objectWidth, objectHeight, null);
        // Reset transformations
        obj.rotate(-Math.toRadians(rotationStart));
        obj.translate(-centerX, -centerY);
    }
    @Override
    public void mouseDragged(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
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
                if (mouseX >= 0 && mouseX < objectWidth && mouseY >= 0 && mouseY < objectHeight) {
                    rotationSwitch = !rotationSwitch;
                }
            }
        }
    }
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3){
            rotationSwitch = !rotationSwitch;
        }

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

    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public abstract class CleaningObjectsModify extends JLabel implements Runnable, CleaningObjectsController{
    protected BufferedImage spriteSheet;
    protected String mainSpriteSheetPath, subSpriteSheetPath;
    protected int objectWidth, objectHeight, rotationStart;
    protected boolean running, rotationSwitch, switchSpriteSheet, hasSubSpriteSheet;
    protected boolean rotatable, switchable;
    private static int puzzleScoreCheck = 0;
    public CleaningObjectsModify(String mainSpriteSheetPath, String subSpriteSheetPath, int objectWidth, int objectHeight, int rotationStart) {
        // Load the sprite sheet image
        try {
            spriteSheet = ImageIO.read(new File(mainSpriteSheetPath));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
            if (!subSpriteSheetPath.equals("")){
                hasSubSpriteSheet = true; switchable = true;
                this.subSpriteSheetPath = subSpriteSheetPath;
            }
            if (rotationStart > 0){
                rotatable = true;
                this.rotationStart = rotationStart;
            }
        this.mainSpriteSheetPath = mainSpriteSheetPath; this.objectWidth = objectWidth; this.objectHeight = objectHeight;
        running = true; // Set the running flag to true
        new Thread(this, "objRunning").start(); // Create a new thread to update the animation
    }
    public void run() {
        if (Thread.currentThread().getName().equals("objRunning")) {
            while (running) {
                try {
                    //เช็ค Objects ที่ Rotate กับ Switch ได้
                    if (rotatable & switchable){
                        if (rotationStart >= 360) {rotationStart = 0;
                            if (switchSpriteSheet){stopObjRunning();}
                        }
                    }
                    //เช็ค Objects ที่ Rotate ได้
                    else if (rotatable & !switchable) {
                        if (rotationStart >= 360) {stopObjRunning();}
                    }
                    //เช็ค Objects ที่ Switch ได้
                    else if (switchable) {
                        if (switchSpriteSheet){stopObjRunning();}
                    }
                    rotatable();
                    repaint();
                    Thread.sleep(10);
                }
                catch (InterruptedException ignored){}
            }
        }
    }
    public void stopObjRunning(){
        rotationStart = 0;
        running = false;
        setPuzzleScoreCheck(getPuzzleScoreCheck() + 1);
        Thread.currentThread().interrupt();
    }

    @Override
    public void paint(Graphics g) {}

    public static int getPuzzleScoreCheck() {return puzzleScoreCheck;}

    public static void setPuzzleScoreCheck(int puzzleScoreCheck) {CleaningObjectsModify.puzzleScoreCheck = puzzleScoreCheck;}
}
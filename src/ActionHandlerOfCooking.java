import java.awt.event.*;


public class ActionHandlerOfCooking implements ActionListener, MouseListener {

    private MiniGameCooking targetFrame;

    private static int currentIndex = -1;
    private static String[][] defaultSlideMenu;
    public String[][] mainSlideMenu = {
            {"String1", "String2", "String3"},
            {"String4", "String5", "String6"},
            {"String7", "String8", "String9"}
    };

    public String[][] boxSlideMenu = {
            {"BoxSlide1", "BoxSlide2", "BoxSlide3"},
            {"BoxSlide4", "BoxSlide5", "BoxSlide6"},
            {"BoxSlide7", "BoxSlide8", "BoxSlide9"}
    };

    public String[][] sideSlideMenu = {
            {"BoxSlide1", "BoxSlide2", "BoxSlide3"},
            {"BoxSlide4", "BoxSlide5", "BoxSlide6"},
            {"BoxSlide7", "BoxSlide8", "BoxSlide9"}
    };

    public String[][] dessertSlideMenu = {
            {"BoxSlide1", "BoxSlide2", "BoxSlide3"},
            {"BoxSlide4", "BoxSlide5", "BoxSlide6"},
            {"BoxSlide7", "BoxSlide8", "BoxSlide9"}
    };
//    public int[] boxSlideMenu = {7, 8, 9};

    public ActionHandlerOfCooking(MiniGameCooking targetFrame) {
        this.targetFrame = targetFrame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == targetFrame.selectedFrameButton){
            System.out.println("Select Food");
            System.out.println(defaultSlideMenu[currentIndex][2]);

        }

        else if (e.getSource() == targetFrame.selectedFrameSlideRight | e.getSource() == targetFrame.selectedFrameSlideLeft){
            currentIndex = (currentIndex + 1) % defaultSlideMenu.length;
            System.out.println(defaultSlideMenu[currentIndex][0]);
            System.out.println(defaultSlideMenu[currentIndex][1]);
            System.out.println(defaultSlideMenu[currentIndex][2]);
            System.out.println(" ");
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == targetFrame.BentoHitBox1){
            int numRows = mainSlideMenu.length;
            int numCols = mainSlideMenu[0].length;
            defaultSlideMenu = new String[numRows][numCols];
            for (int i = 0; i < numRows; i++) {
                System.arraycopy(mainSlideMenu[i], 0, defaultSlideMenu[i], 0, numCols);
            }
            System.out.println("HitBox1");
        }
        else if (e.getSource() == targetFrame.BentoHitBox4){
//            System.arraycopy(boxSlideMenu, 0, defaultSlideMenu, 0, boxSlideMenu.length);
            int numRows = boxSlideMenu.length;
            int numCols = boxSlideMenu[0].length;
            defaultSlideMenu = new String[numRows][numCols];
            for (int i = 0; i < numRows; i++) {
                System.arraycopy(boxSlideMenu[i], 0, defaultSlideMenu[i], 0, numCols);
            }

            System.out.println("HitBox4");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
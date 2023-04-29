import java.awt.event.*;


public class ActionHandlerOfCooking implements ActionListener, MouseListener {

    private MiniGameCooking targetFrame;

    private static int currentIndex = -1;
    private static int[] defaultSlideMenu = {0, 0, 0};
    public int[] mainSlideMenu = {1, 2, 3};
    public int[] sideSlideMenu = {4, 5, 6};
    public int[] dessertSlideMenu = {4, 5, 6};
    public int[] boxSlideMenu = {7, 8, 9};

    public ActionHandlerOfCooking(MiniGameCooking targetFrame) {
        this.targetFrame = targetFrame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == targetFrame.JLabelButton1){
//            main.setVisible(true);
//            desert.setVisible(true);
//            side.setVisible(true);
//            box.setVisible(true);
        }

        else if (e.getSource() == targetFrame.selectedFrameSlideRight | e.getSource() == targetFrame.selectedFrameSlideLeft){
            currentIndex = (currentIndex + 1) % defaultSlideMenu.length;
            System.out.println(defaultSlideMenu[currentIndex]);
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == targetFrame.BentoHitBox1){
            System.arraycopy(mainSlideMenu, 0, defaultSlideMenu, 0, mainSlideMenu.length);
            System.out.println("HitBox1");
        }
        else if (e.getSource() == targetFrame.BentoHitBox4){
            System.arraycopy(boxSlideMenu, 0, defaultSlideMenu, 0, boxSlideMenu.length);
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
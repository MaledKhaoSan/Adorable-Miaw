import java.awt.event.*;


public class ActionHandlerOfCooking implements ActionListener, MouseListener {

    private MiniGameCooking targetFrame;
//    private int[] NewArray = new int[3];
//    private int[] NewArray = new int[3];

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
            targetFrame.currentIndex = (targetFrame.currentIndex + 1) % targetFrame.NewArray.length;
            System.out.println(targetFrame.NewArray[targetFrame.currentIndex]);
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == targetFrame.BentoHitBox1){
            System.arraycopy(targetFrame.arrayB, 0, targetFrame.NewArray, 0, targetFrame.arrayB.length);
            System.out.println("HitBox1");
        }
        else if (e.getSource() == targetFrame.BentoHitBox4){
            System.arraycopy(targetFrame.arrayA, 0, targetFrame.NewArray, 0, targetFrame.arrayA.length);
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
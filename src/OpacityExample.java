//import javax.swing.*;
//import java.awt.*;
//
//public class OpacityExample extends JFrame {
//    private JLayeredPane layeredPane;
//    private int opacity = 0;
//
//    public OpacityExample() {
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(300, 300);
//
//        // Create the JLayeredPane and set its background color to black
//        layeredPane = new JLayeredPane();
//        layeredPane.setBackground(Color.BLACK);
//        add(layeredPane);
//
//        // Create a Runnable to gradually increase the opacity
//        Runnable opacityRunnable = new Runnable() {
//            @Override
//            public void run() {
//                // Increase the opacity by 10% every 50 milliseconds
//                while (opacity <= 100) {
//                    try {
////                        layeredPane.setVisible(false);
////                        opacity += 1;
//                        layeredPane.setOpaque(true);
//                        layeredPane.setBackground(new Color(0, 0, 0, 60 * 255 / 100));
////                        layeredPane.setVisible(true);
////                        layeredPane.setVisible(true);
//                        Thread.sleep(1000);
//                    } catch (InterruptedException ex) {
//                        ex.printStackTrace();
//                    }
//                }
//            }
//        };
//
//        // Start a new thread to run the Runnable
//        Thread thread = new Thread(opacityRunnable);
//        thread.start();
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                new OpacityExample().setVisible(true);
//            }
//        });
//    }
//}

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MainMenu extends JFrame implements MouseMotionListener, Runnable{
    private JFrame canvas = new JFrame();
    public JPanel panel;

    private ImageIcon image1 = new ImageIcon("src/menu_canvas/background.png");
    private ImageIcon image2 = new ImageIcon("src/menu_canvas/difficulty.png");
    private ImageIcon image3 = new ImageIcon("src/menu_canvas/difficulty.png");

    private ImageIcon imageIcon = new ImageIcon("src/level_canvas/label01.png");
    public JButton menuButton1, menuButton2, difficultyButton1, difficultyButton2;
    public JLabel label1;
    public boolean menuIsSelected;

    private int mouseX, mouseY;
    public boolean running;
    public Thread thread;

    public MainMenu() {
        panel = new JPanel(null)
        {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    image1 = new ImageIcon("src/menu_canvas/background.png");
                    g.drawImage(image1.getImage(), 0, 0, null);
                    if (menuIsSelected) {
                        int imageIconX = ((1280/2) - (image2.getIconWidth()/2));
                        int imageIconY = ((720/2) - (image2.getIconHeight()/2));
                        g.drawImage(image2.getImage(), imageIconX, imageIconY, null);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        panel.addMouseMotionListener(this);
        this.add(menuButton1 = new JButton("Play") {{
            setBounds((1280/2) - (100/2), 580, 100, 40);
            addActionListener(new ActionHandlerOfMenu(MainMenu.this, menuButton2));
        }});
        this.add(difficultyButton1 = new JButton("back") {{
            setBounds(((1280/2) - 50) - 70,480,100, 40);
            setVisible(false);
            addActionListener(new ActionHandlerOfMenu(MainMenu.this, difficultyButton1));
        }});
        this.add(difficultyButton2 = new JButton("start") {{
            setBounds(((1280/2) - 50) + 70,480,100, 40);//x-axis, y-axis, width, height
            setVisible(false);
            addActionListener(new ActionHandlerOfMenu(MainMenu.this, difficultyButton2));
        }});
//        panel.add(label1 = new JLabel(imageIcon) {{
//            setBounds(50, 50, 100, 100);
//            setOpaque(true);
//            setBackground(Color.YELLOW);
//        }});


//        ImageIcon imageIcon = new ImageIcon("src/level_canvas/label01.png");
//        label1 = new JLabel(imageIcon);
//        label1.addMouseListener(new ActionHandlerOfStage("Label1", this, label1));
//        label1.setBounds(50, 50, 100, 100);
//        label1.setOpaque(true);
//        panel.add(label1 = new JLabel(imageIcon));


        this.add(panel);//adding (panel)background-img in JFrame
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setVisible(true);
        Thread thread = new Thread(this);
        thread.start();


    }

    public void run(){
        running = true;

        while (running) {
            Point mouseLoc = MouseInfo.getPointerInfo().getLocation();
//            System.out.println(mouseX +" "+ mouseY);
//            System.out.println(label1.getX() +" "+ label1.getY());

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
            mouseX = e.getX();
            mouseY = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
            mouseX = e.getX();
            mouseY = e.getY();
    }
}

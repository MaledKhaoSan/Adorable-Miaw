

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.lang.reflect.Array;

public class MiniGameCooking extends JFrame implements MouseMotionListener, Runnable{
    private JFrame canvas = new JFrame();
    public JPanel panel;

    private ImageIcon image1 = new ImageIcon("src/resource/menu_canvas/background.png");
    private ImageIcon image2 = new ImageIcon("src/resource/menu_canvas/difficulty.png");
    private ImageIcon image3 = new ImageIcon("src/resource/menu_canvas/difficulty.png");
    public JButton  menuButton2, difficultyButton1, difficultyButton2;
    public JLabel minigameCookingButton1;
    public JLabel minigameCookingBento1;
    public JLabel JLabelButton1, JLabelButton2;
    public boolean menuIsSelected;

    private int mouseX, mouseY;
    public boolean running;
    public int[] array = {1, 2, 3};
    public int currentIndex = -1;
    public Thread thread;

    public MiniGameCooking() {
        panel = new JPanel(null)
        {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    //path ไปหาไฟล์รูปภาพ
                    image1 = new ImageIcon("src/resource/cooking_game/background.png");
                    g.drawImage(image1.getImage(), 0, 0, null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        // Initialize the current index to the first element
        // Slide the index to the next element and wrap around to the beginning if necessary


        panel.add(minigameCookingBento1 = new JLabel(new ImageIcon("src/resource/cooking_game/bento1.png")) {{
            setBounds(71, 188, 585, 455);
//            addMouseListener(new ActionHandlerOfCooking(MiniGameCooking.this, minigameCookingBento1));
        }});

        panel.add(JLabelButton1 = new JLabel(){{
            setBounds(150,100, 50,50);
            setBackground(Color.yellow);
            setOpaque(true);
            addMouseListener(new ActionHandlerOfCooking(MiniGameCooking.this, JLabelButton1));
        }});

        panel.add(JLabelButton2 = new JLabel(){{
            setBounds(400,100, 50,50);
            setBackground(Color.RED);
            setOpaque(true);
            addMouseListener(new ActionHandlerOfCooking(MiniGameCooking.this, JLabelButton2));
        }});


//        panel.add(minigameCookingButton1 = new JLabel(new ImageIcon("src/resource/cooking_game/button1.png")) {{
//            setBounds((1280/2 - 240), (720/2 - 240), 85, 85);
//            addMouseListener(new ActionHandlerOfCooking("minigameCookingButton1",  MiniGameCooking.this, minigameCookingButton1));
//            setOpaque(true);
//            setBackground(Color.YELLOW);
//        }});


        this.add(panel);//adding (panel)background-img in JFrame
        this.setSize(1280, 747);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setVisible(true);


    }

    public void run(){}

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
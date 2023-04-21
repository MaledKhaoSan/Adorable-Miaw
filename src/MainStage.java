import javax.swing.*;
import javax.swing.text.StyleConstants;
import java.awt.*;


public class MainStage extends JFrame{
    private JLayeredPane layer;

    private ImageIcon image1 = new ImageIcon("src/stage_canvas/background.png");

    //Label Object in Scene
    private ImageIcon minigameTyping = new ImageIcon("src/stage_canvas/label01.png");
    private boolean minigameIsSelect, running;
    public JLabel minigameTypingEnter, minigameCleaningEnter, minigameCookingEnter, homeEnter;
    public JLabel minigameTypingUI, minigameTypingUIButton1, minigameTypingUIButton2;
    public JLabel minigameCleaningUI, minigameCleaningUIButton1, minigameCleaningUIButton2;
    public JLabel minigameCookingUI, minigameCookingUIButton1, minigameCookingUIButton2;
    public MainStage() {
        layer = new JLayeredPane() {

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    image1 = new ImageIcon("src/stage_canvas/background.png");
                    g.drawImage(image1.getImage(), 0, 0, null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        layer.add(minigameTypingEnter = new JLabel() {{
            ImageIcon minigameTypingEnter_Icon = new ImageIcon("src/stage_canvas/minigameTypingEnter.png");
            setIcon(minigameTypingEnter_Icon);
            addMouseListener(new ActionHandlerOfStage(MainStage.this, minigameTypingEnter));
            setBounds(126, 419, 330, 250);
        }}, Integer.valueOf(0));
        layer.add(minigameCleaningEnter = new JLabel() {{
            ImageIcon minigameCleaningEnter_Icon = new ImageIcon("src/stage_canvas/minigameCleaningEnter.png");
            setIcon(minigameCleaningEnter_Icon);
            addMouseListener(new ActionHandlerOfStage(MainStage.this, minigameCleaningEnter));
            setBounds(475, 475, 330, 250);
        }}, Integer.valueOf(0));
        layer.add(minigameCookingEnter = new JLabel() {{
            ImageIcon minigameCookingEnter_Icon = new ImageIcon("src/stage_canvas/minigameCookingEnter.png");
            setIcon(minigameCookingEnter_Icon);
            addMouseListener(new ActionHandlerOfStage(MainStage.this, minigameCookingEnter));
            setBounds(870, 474, 330, 250);
        }}, Integer.valueOf(0));

        layer.add(homeEnter = new JLabel(new ImageIcon("src/stage_canvas/homeEnter.png")) {{
            addMouseListener(new ActionHandlerOfStage(MainStage.this, homeEnter));
            setBounds(1172, 25, 80, 80);
        }}, Integer.valueOf(0));

        layer.add(minigameTypingUI = new JLabel() {{
            ImageIcon minigameTypingUI_Icon = new ImageIcon("src/stage_canvas/minigameUI.png");
            setIcon(minigameTypingUI_Icon);
            addMouseListener(new ActionHandlerOfStage(MainStage.this, minigameTypingUI));
            setBounds((1280/2) - (580/2), 145, 580, 332);
            setVisible(false);
            add(minigameTypingUIButton1 = new JLabel() {{
                ImageIcon minigameUIButton1_Icon = new ImageIcon("src/stage_canvas/minigameUIButton1.png");
                setIcon(minigameUIButton1_Icon);
                setBounds(580/2 - 145/2 - 130, 332 - 50, 145, 45);
                addMouseListener(new ActionHandlerOfStage(MainStage.this, minigameTypingUIButton1));
            }},  Integer.valueOf(2));
            add(minigameTypingUIButton2 = new JLabel() {{
                ImageIcon minigameTypingUIButton2_Icon = new ImageIcon("src/stage_canvas/minigameUIButton1.png");
                setIcon(minigameTypingUIButton2_Icon);
                setBounds(580/2 - 145/2 + 130, 332 - 50, 145, 45);
                addMouseListener(new ActionHandlerOfStage(MainStage.this, minigameTypingUIButton2));
            }},  Integer.valueOf(2));
        }},  Integer.valueOf(5));

        layer.add(minigameCleaningUI = new JLabel() {{
            ImageIcon minigameCleaningUI_Icon = new ImageIcon("src/stage_canvas/minigameUI.png");
            setIcon(minigameCleaningUI_Icon);
            addMouseListener(new ActionHandlerOfStage(MainStage.this, minigameCleaningUI));
            setBounds((1280/2) - (580/2), 145, 580, 332);
            setVisible(false);

            add(minigameCleaningUIButton1 = new JLabel() {{
                ImageIcon minigameCleaningUIButton1_Icon = new ImageIcon("src/stage_canvas/minigameUIButton1.png");
                setIcon(minigameCleaningUIButton1_Icon);
                setBounds(580/2 - 145/2 - 130, 332 - 50, 145, 45);
                addMouseListener(new ActionHandlerOfStage(MainStage.this, minigameCleaningUIButton1));
            }},  Integer.valueOf(2));
            add(minigameCleaningUIButton2 = new JLabel() {{
                ImageIcon minigameCleaningUIButton2_Icon = new ImageIcon("src/stage_canvas/minigameUIButton1.png");
                setIcon(minigameCleaningUIButton2_Icon);
                setBounds(580/2 - 145/2 + 130, 332 - 50, 145, 45);
                addMouseListener(new ActionHandlerOfStage(MainStage.this, minigameCleaningUIButton2));
            }},  Integer.valueOf(2));
        }},  Integer.valueOf(5));

        layer.add(minigameCookingUI = new JLabel() {{
            ImageIcon minigameCookingUI_Icon = new ImageIcon("src/stage_canvas/minigameUI.png");
            setIcon(minigameCookingUI_Icon);
            addMouseListener(new ActionHandlerOfStage(MainStage.this, minigameCookingUI));
            setBounds((1280/2) - (580/2), 145, 580, 332);
            setVisible(false);
            add(minigameCookingUIButton1 = new JLabel() {{
                ImageIcon minigameCookingUIButton1_Icon = new ImageIcon("src/stage_canvas/minigameUIButton1.png");
                setIcon(minigameCookingUIButton1_Icon);
                setBounds(580/2 - 145/2 - 130, 332 - 50, 145, 45);
                addMouseListener(new ActionHandlerOfStage(MainStage.this, minigameCookingUIButton1));
            }},  Integer.valueOf(2));
            add(minigameCookingUIButton2 = new JLabel() {{
                ImageIcon minigameCookingUIButton2_Icon = new ImageIcon("src/stage_canvas/minigameUIButton1.png");
                setIcon(minigameCookingUIButton2_Icon);
                setBounds(580/2 - 145/2 + 130, 332 - 50, 145, 45);
                addMouseListener(new ActionHandlerOfStage(MainStage.this, minigameCookingUIButton2));
            }},  Integer.valueOf(2));
        }},  Integer.valueOf(5));














        this.add(layer);//adding (panel)background-img in JFrame
        this.setSize(layer.getPreferredSize());
        this.setSize(1280, 747);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public boolean isMinigameIsSelect() {
        return minigameIsSelect;
    }

    public void setMinigameIsSelect(boolean minigameIsSelect) {
        this.minigameIsSelect = minigameIsSelect;
    }
}

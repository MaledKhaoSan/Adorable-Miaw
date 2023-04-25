import canvas_modify.SceneModify;

import javax.swing.*;
import javax.swing.text.StyleConstants;
import java.awt.*;


public class MainStage extends JFrame{
    private JLayeredPane layer;

    //Label Object in Scene
    private boolean minigameIsSelect, running;
    public JLabel minigameTypingEnter, minigameCleaningEnter, minigameCookingEnter, homeEnter;
    public JLabel minigameTypingUI, minigameTypingUIButton1, minigameTypingUIButton2;
    public JLabel minigameCleaningUI, minigameCleaningUIButton1, minigameCleaningUIButton2;
    public JLabel minigameCookingUI, minigameCookingUIButton1, minigameCookingUIButton2;

    public JLabel minigameTypingDifficultyUI, minigameTypingDifficultyButton1;
    public JButton minigameTypingDifficulty1, minigameTypingDifficulty2, minigameTypingDifficulty3;
    public MainStage() {
        layer = new JLayeredPane() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    g.drawImage(new ImageIcon("src/stage_canvas/background.png").getImage(), 0, 0, null);
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

        layer.add(minigameTypingUI = new JLabel(new ImageIcon("src/stage_canvas/minigameUI.png")) {{
            addMouseListener(new ActionHandlerOfStage(MainStage.this, minigameTypingUI));
            setBounds((1280/2) - (580/2), 145, 580, 332);
            setVisible(false);
            add(minigameTypingUIButton1 = new JLabel(new ImageIcon("src/stage_canvas/minigameUIButton1.png")) {{
                setBounds(580/2 - 145/2 - 130, 332 - 50, 145, 45);
                addMouseListener(new ActionHandlerOfStage(MainStage.this, minigameTypingUIButton1));
            }},  Integer.valueOf(2));
            add(minigameTypingUIButton2 = new JLabel(new ImageIcon("src/stage_canvas/minigameUIButton1.png")) {{
                setBounds(580/2 - 145/2 + 130, 332 - 50, 145, 45);
                addMouseListener(new ActionHandlerOfStage(MainStage.this, minigameTypingUIButton2));
            }},  Integer.valueOf(2));
        }},  Integer.valueOf(5));

        layer.add(minigameTypingDifficultyUI = new JLabel(new ImageIcon("src/stage_canvas/minigameTypingDifficultyUI.png")) {{
            addMouseListener(new ActionHandlerOfStage(MainStage.this, minigameTypingDifficultyUI));
            setBounds((1280/2) - (580/2), 145, 580, 332);
            setVisible(false);
            add(minigameTypingDifficulty1 = new JButton(new ImageIcon("src/stage_canvas/minigameTypingDifficulty1.png")) {{
                setBounds(49, 123, 135, 85); setBorder(null); setPressedIcon(new ImageIcon("src/stage_canvas/minigameTypingDifficulty4.png")); /* Remove border-graphics.*/
                addMouseListener(new ActionHandlerOfStage(MainStage.this, minigameTypingDifficulty1));
            }},  Integer.valueOf(2));
            add(minigameTypingDifficulty2 = new JButton(new ImageIcon("src/stage_canvas/minigameTypingDifficulty1.png")) {{
                setBounds(222, 123, 135, 85); setBorder(null); setPressedIcon(new ImageIcon("src/stage_canvas/minigameTypingDifficulty4.png")); /* Remove border-graphics.*/
                addMouseListener(new ActionHandlerOfStage(MainStage.this, minigameTypingDifficulty2));
            }},  Integer.valueOf(2));
            add(minigameTypingDifficulty3 = new JButton(new ImageIcon("src/stage_canvas/minigameTypingDifficulty1.png")) {{
                setBounds(395, 123, 135, 85); setBorder(null); setPressedIcon(new ImageIcon("src/stage_canvas/minigameTypingDifficulty4.png")); /* Remove border-graphics.*/
                addMouseListener(new ActionHandlerOfStage(MainStage.this, minigameTypingDifficulty3));
            }},  Integer.valueOf(2));
//
            add(minigameTypingDifficultyButton1 = new JLabel(new ImageIcon("src/stage_canvas/minigameUIButton1.png")) {{
                setBounds(580/2 - 145/2 , 332 - 50, 145, 45);
                addMouseListener(new ActionHandlerOfStage(MainStage.this, minigameTypingDifficultyButton1));
            }},  Integer.valueOf(2));

        }},  Integer.valueOf(6));

        layer.add(minigameCleaningUI = new JLabel(new ImageIcon("src/stage_canvas/minigameUI.png")) {{
            addMouseListener(new ActionHandlerOfStage(MainStage.this, minigameCleaningUI));
            setBounds((1280/2) - (580/2), 145, 580, 332);
            setVisible(false);

            add(minigameCleaningUIButton1 = new JLabel() {{
                setIcon(new ImageIcon("src/stage_canvas/minigameUIButton1.png"));
                setBounds(580/2 - 145/2 - 130, 332 - 50, 145, 45);
                addMouseListener(new ActionHandlerOfStage(MainStage.this, minigameCleaningUIButton1));
            }},  Integer.valueOf(2));
            add(minigameCleaningUIButton2 = new JLabel() {{
                setIcon(new ImageIcon("src/stage_canvas/minigameUIButton1.png"));
                setBounds(580/2 - 145/2 + 130, 332 - 50, 145, 45);
                addMouseListener(new ActionHandlerOfStage(MainStage.this, minigameCleaningUIButton2));
            }},  Integer.valueOf(2));
        }},  Integer.valueOf(5));

        layer.add(minigameCookingUI = new JLabel() {{
            setIcon(new ImageIcon("src/stage_canvas/minigameUI.png"));
            addMouseListener(new ActionHandlerOfStage(MainStage.this, minigameCookingUI));
            setBounds((1280/2) - (580/2), 145, 580, 332);
            setVisible(false);
            add(minigameCookingUIButton1 = new JLabel() {{
                setIcon(new ImageIcon("src/stage_canvas/minigameUIButton1.png"));
                setBounds(580/2 - 145/2 - 130, 332 - 50, 145, 45);
                addMouseListener(new ActionHandlerOfStage(MainStage.this, minigameCookingUIButton1));
            }},  Integer.valueOf(2));
            add(minigameCookingUIButton2 = new JLabel() {{
                setIcon(new ImageIcon("src/stage_canvas/minigameUIButton1.png"));
                setBounds(580/2 - 145/2 + 130, 332 - 50, 145, 45);
                addMouseListener(new ActionHandlerOfStage(MainStage.this, minigameCookingUIButton2));
            }},  Integer.valueOf(2));
        }},  Integer.valueOf(5));














        this.add(layer);//adding (panel)background-img in JFrame
        this.setSize(layer.getPreferredSize());
        this.setSize(1280, 747);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.layer.add(new SceneModify().addJLayerPaneFadeOutAnimate(),  Integer.valueOf(10));
        this.setVisible(true);
    }
    public boolean isMinigameIsSelect() {
        return minigameIsSelect;
    }

    public void setMinigameIsSelect(boolean minigameIsSelect) {
        this.minigameIsSelect = minigameIsSelect;
    }
}

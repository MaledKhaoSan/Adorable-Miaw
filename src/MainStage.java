import canvas_modify.FadeOutAnimate;
import canvas_modify.SceneModify;
import javax.swing.*;
import java.awt.*;


public class MainStage extends JFrame{
    public JLayeredPane layer;

    //Label Object in Scene
    private boolean minigameIsSelect, running;
    public JLabel minigameTypingEnter, minigameCleaningEnter, minigameCookingEnter;
    public JButton homeEnter;
    public JLabel minigameTypingUI;
    public JButton minigameTypingUIButton1, minigameTypingUIButton2, minigameTypingUIButton3, minigameTypingDifficulty1, minigameTypingDifficulty2, minigameTypingDifficulty3;
    public JLabel minigameCleaningUI;
    public JButton minigameCleaningUIButton1, minigameCleaningUIButton2, minigameCleaningUIButton3;
    public JLabel minigameCookingUI;
    public JButton minigameCookingUIButton1, minigameCookingUIButton2, minigameCookingUIButton3, minigameCookingDifficulty1, minigameCookingDifficulty2, minigameCookingDifficulty3;


    public JLabel minigameTypingDifficultyUI;
    public MainStage() {
        this.setBackground(Color.BLACK);
        layer = new SceneModify().addJLayerPaneBackGround("src/resource/stage_canvas/background.png", "layer", true);
        layer.add(minigameTypingEnter = new JLabel() {{
            ImageIcon minigameTypingEnter_Icon = new ImageIcon("src/resource/stage_canvas/minigameTypingEnter.png");
            setIcon(minigameTypingEnter_Icon);
            addMouseListener(new ActionHandlerOfStage(MainStage.this, minigameTypingEnter));
            setBounds(126, 419, 330, 250);
        }}, Integer.valueOf(0));
        layer.add(minigameCleaningEnter = new JLabel() {{
            ImageIcon minigameCleaningEnter_Icon = new ImageIcon("src/resource/stage_canvas/minigameCleaningEnter.png");
            setIcon(minigameCleaningEnter_Icon);
            addMouseListener(new ActionHandlerOfStage(MainStage.this, minigameCleaningEnter));
            setBounds(475, 475, 330, 250);
        }}, Integer.valueOf(0));
        layer.add(minigameCookingEnter = new JLabel() {{
            ImageIcon minigameCookingEnter_Icon = new ImageIcon("src/resource/stage_canvas/minigameCookingEnter.png");
            setIcon(minigameCookingEnter_Icon);
            addMouseListener(new ActionHandlerOfStage(MainStage.this, minigameCookingEnter));
            setBounds(870, 474, 330, 250);
        }}, Integer.valueOf(0));

        layer.add(homeEnter = new JButton(new ImageIcon("src/resource/stage_canvas/homeEnter.png")) {{
            addActionListener(new ActionHandlerOfStage(MainStage.this));
            setBounds(1172, 25, 55, 55);
        }}, Integer.valueOf(0));

        layer.add(minigameTypingUI = new JLabel(new ImageIcon("src/resource/stage_canvas/minigameUI.png")) {{
            addMouseListener(new ActionHandlerOfStage(MainStage.this, minigameTypingUI));
            setBounds((1280/2) - (580/2), 145, 580, 332);
            setVisible(false);
            add(minigameTypingUIButton1 = new JButton(new ImageIcon("src/resource/stage_canvas/minigameUIButton1.png")) {{
                setBounds(580/2 - 145/2 - 130, 332 - 50, 145, 45);
                addActionListener(new ActionHandlerOfStage(MainStage.this, minigameTypingUIButton1));
            }},  Integer.valueOf(2));
            add(minigameTypingUIButton2 = new JButton(new ImageIcon("src/resource/stage_canvas/minigameUIButton1.png")) {{
                setBounds(580/2 - 145/2 + 130, 332 - 50, 145, 45);
                addActionListener(new ActionHandlerOfStage(MainStage.this, minigameTypingUIButton2));
            }},  Integer.valueOf(2));
            add(minigameTypingDifficulty1 = new JButton(new ImageIcon("src/resource/stage_canvas/minigameTypingDifficulty1.png")) {{
                setBounds(49, 123, 135, 85); setBorder(null); setPressedIcon(new ImageIcon("src/resource/stage_canvas/minigameTypingDifficulty4.png")); /* Remove border-graphics.*/
                addActionListener(new ActionHandlerOfStage(MainStage.this, minigameTypingDifficulty1)); setVisible(false);
            }},  Integer.valueOf(2));
            add(minigameTypingDifficulty2 = new JButton(new ImageIcon("src/resource/stage_canvas/minigameTypingDifficulty1.png")) {{
                setBounds(222, 123, 135, 85); setBorder(null); setPressedIcon(new ImageIcon("src/resource/stage_canvas/minigameTypingDifficulty4.png")); /* Remove border-graphics.*/
                addActionListener(new ActionHandlerOfStage(MainStage.this, minigameTypingDifficulty2)); setVisible(false);
            }},  Integer.valueOf(2));
            add(minigameTypingDifficulty3 = new JButton(new ImageIcon("src/resource/stage_canvas/minigameTypingDifficulty1.png")) {{
                setBounds(395, 123, 135, 85); setBorder(null); setPressedIcon(new ImageIcon("src/resource/stage_canvas/minigameTypingDifficulty4.png")); /* Remove border-graphics.*/
                addActionListener(new ActionHandlerOfStage(MainStage.this, minigameTypingDifficulty3)); setVisible(false);
            }},  Integer.valueOf(2));
            add(minigameTypingUIButton3 = new JButton(new ImageIcon("src/resource/stage_canvas/minigameUIButton1.png")) {{
                setBounds(580/2 - 145/2 , 332 - 50, 145, 45);
                addActionListener(new ActionHandlerOfStage(MainStage.this, minigameTypingUIButton3)); setVisible(false);
            }},  Integer.valueOf(2));
        }},  Integer.valueOf(5));

        layer.add(minigameCleaningUI = new JLabel(new ImageIcon("src/resource/stage_canvas/minigameCleaningTutorial.png")) {{
            addMouseListener(new ActionHandlerOfStage(MainStage.this, minigameCleaningUI));
            setBounds((1280/2) - (580/2), 145, 580, 332);
            setVisible(false);

            add(minigameCleaningUIButton1 = new JButton() {{
                setIcon(new ImageIcon("src/resource/stage_canvas/minigameUIButton1.png"));
                setBounds(580/2 - 145/2 - 130, 332 - 50, 145, 45);
                addActionListener(new ActionHandlerOfStage(MainStage.this));
            }},  Integer.valueOf(2));
            add(minigameCleaningUIButton2 = new JButton() {{
                setIcon(new ImageIcon("src/resource/stage_canvas/minigameUIButton1.png"));
                setBounds(580/2 - 145/2 + 130, 332 - 50, 145, 45);
                addActionListener(new ActionHandlerOfStage(MainStage.this));
            }},  Integer.valueOf(2));

            add(minigameCleaningUIButton3 = new JButton(new ImageIcon("src/resource/stage_canvas/minigameUIButton1.png")) {{
                setBounds(580/2 - 145/2 , 332 - 50, 145, 45);
                addActionListener(new ActionHandlerOfStage(MainStage.this)); setVisible(false);
            }},  Integer.valueOf(2));
        }},  Integer.valueOf(5));

        layer.add(minigameCookingUI = new JLabel() {{
            setIcon(new ImageIcon("src/resource/stage_canvas/minigameUI.png"));
            addMouseListener(new ActionHandlerOfStage(MainStage.this, minigameCookingUI));
            setBounds((1280/2) - (580/2), 145, 580, 332);
            setVisible(false);
            add(minigameCookingUIButton1 = new JButton() {{
                setIcon(new ImageIcon("src/resource/stage_canvas/minigameUIButton1.png"));
                setBounds(580/2 - 145/2 - 130, 332 - 50, 145, 45);
                addActionListener(new ActionHandlerOfStage(MainStage.this, minigameCookingUIButton1));
            }},  Integer.valueOf(2));
            add(minigameCookingUIButton2 = new JButton() {{
                setIcon(new ImageIcon("src/resource/stage_canvas/minigameUIButton1.png"));
                setBounds(580/2 - 145/2 + 130, 332 - 50, 145, 45);
                addActionListener(new ActionHandlerOfStage(MainStage.this, minigameCookingUIButton2));
            }},  Integer.valueOf(2));
            add(minigameCookingUIButton3 = new JButton( new ImageIcon("src/resource/stage_canvas/minigameUIButton1.png")) {{
                setBounds(580/2 - 145/2 , 332 - 50, 145, 45);
                addActionListener(new ActionHandlerOfStage(MainStage.this)); setVisible(false);
            }},  Integer.valueOf(2));

            add(minigameCookingDifficulty1 = new JButton(new ImageIcon("src/resource/stage_canvas/minigameTypingDifficulty1.png")) {{
                setBounds(49, 123, 135, 85); setBorder(null); setPressedIcon(new ImageIcon("src/resource/stage_canvas/minigameTypingDifficulty4.png")); /* Remove border-graphics.*/
                addActionListener(new ActionHandlerOfStage(MainStage.this)); setVisible(false);
            }},  Integer.valueOf(2));
            add(minigameCookingDifficulty2 = new JButton(new ImageIcon("src/resource/stage_canvas/minigameTypingDifficulty1.png")) {{
                setBounds(222, 123, 135, 85); setBorder(null); setPressedIcon(new ImageIcon("src/resource/stage_canvas/minigameTypingDifficulty4.png")); /* Remove border-graphics.*/
                addActionListener(new ActionHandlerOfStage(MainStage.this)); setVisible(false);
            }},  Integer.valueOf(2));
            add(minigameCookingDifficulty3 = new JButton(new ImageIcon("src/resource/stage_canvas/minigameTypingDifficulty1.png")) {{
                setBounds(395, 123, 135, 85); setBorder(null); setPressedIcon(new ImageIcon("src/resource/stage_canvas/minigameTypingDifficulty4.png")); /* Remove border-graphics.*/
                addActionListener(new ActionHandlerOfStage(MainStage.this)); setVisible(false);
            }},  Integer.valueOf(2));

        }},  Integer.valueOf(5));














        this.add(layer);//adding (panel)background-img in JFrame
        this.setSize(layer.getPreferredSize());
        this.setSize(1280, 747);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.layer.add(new SceneModify().addJLayerPaneAnimate(new FadeOutAnimate()),  Integer.valueOf(10));
        this.setVisible(true);
    }
    public boolean isMinigameIsSelect() {
        return minigameIsSelect;
    }

    public void setMinigameIsSelect(boolean minigameIsSelect) {
        this.minigameIsSelect = minigameIsSelect;
    }
}

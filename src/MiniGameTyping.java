import canvas_modify.FadeOutAnimate;
import canvas_modify.SceneModify;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Random;

public class MiniGameTyping extends JFrame{
    public String difficulty;
    public JLabel wordLabel;
//    private String[] words = {"apple", "banana", "cherry", "durian", "elderberry", "fig", "grape"};
    private String[] words = {"alice was a fast typist she could type at lightning speed without even looking at the keyboard her fingers danced across the keys tapping out words as fast as her mind could think them one day alice decided to enter a typing competition she knew she had what it took to win and she was determined to come out on top"};



    private boolean currentWordRunning;
    private int currentWordIndex = 0;
    private String currentWord;
    private int currentWordStart = 0;
    private int score = 0;



    public JLayeredPane layer;
    public JLabel typingTutorials1, typingTutorials2, typingTutorials3;
    public JLabel typingCountdown;
    public JLabel ScoreBaordBG;
    public JButton ScoreBaordButton1, ScoreBaordButton2;

    Font font;

    public MiniGameTyping(String difficulty) {
        this.setBackground(Color.BLACK);
        this.difficulty = difficulty;
        layer = new JLayeredPane() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    g.drawImage(new ImageIcon("src/resource/typing_game/background.png").getImage(), 0, 0, null);

                    File fontPath = new File("src/resource/fonts/Sabreen Regular Demo 400.ttf");
                    Font font = Font.createFont(Font.TRUETYPE_FONT, fontPath).deriveFont(Font.PLAIN, 30); //set size & style

                    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                    ge.registerFont(font);


                } catch (Exception e) { e.printStackTrace(); }
            }
        };


        wordLabel = new JLabel();
        wordLabel.setBounds((1280/2) - 400, (720/2) - 250, 800, 500);
        wordLabel.setHorizontalAlignment(JLabel.CENTER);
        wordLabel.setVerticalAlignment(JLabel.CENTER);
        layer.add(wordLabel);

        layer.add(typingCountdown = new JLabel(""){{
            setBounds(1280/2 - 100,70, 200, 105);
            setText("<html><font style='font-family: Sabreen Regular Demo; font-size: 30px; color: gray'>" + getText() + "<html>");
            setHorizontalAlignment(SwingConstants.CENTER);
        }});

        layer.add(typingTutorials1 = new JLabel() {{
            ImageIcon typingTutorials1_Icon = new ImageIcon("src/resource/typing_game/minigameTypingTutorials1.png");
            setIcon(typingTutorials1_Icon);
            setBounds((1280/2) - (580/2), 145, 580, 332);
            setVisible(true);
        }},  Integer.valueOf(5));
        layer.add(typingTutorials2 = new JLabel() {{
            ImageIcon typingTutorials2_Icon = new ImageIcon("src/resource/typing_game/minigameTypingTutorials2.png");
            setIcon(typingTutorials2_Icon);
            setBounds((1280/2) - (580/2), 145, 580, 332);
            setVisible(true);
        }},  Integer.valueOf(4));
        layer.add(typingTutorials3 = new JLabel() {{
            ImageIcon typingTutorials3_Icon = new ImageIcon("src/resource/typing_game/minigameTypingTutorials3.png");
            setIcon(typingTutorials3_Icon);
            setBounds((1280/2) - (580/2), 145, 580, 332);
            setVisible(true);
        }},  Integer.valueOf(3));


        layer.add(ScoreBaordBG = new JLabel(new ImageIcon("src/resource/typing_game/ScoreBaordBG.png")) {{
//            addMouseListener(new ActionHandlerOfTyping("ScoreBaordBG",  MiniGameTyping.this, ScoreBaordBG));
            setBounds(399, 35, 480, 640);
            setVisible(false);
            add(ScoreBaordButton1 = new JButton(new ImageIcon("src/resource/typing_game/ScoreBaordButton1.png")) {{
                setBounds((480/2) - (145/2) - 120, 640-50, 145, 45);
                addActionListener(new ActionHandlerOfTyping(MiniGameTyping.this));
            }},  Integer.valueOf(2));
            add(ScoreBaordButton2 = new JButton(new ImageIcon("src/resource/typing_game/ScoreBaordButton1.png")) {{
                setBounds((480/2)- (145/2) + 120, 640-50, 145, 45);
                addActionListener(new ActionHandlerOfTyping(MiniGameTyping.this));
            }},  Integer.valueOf(2));
        }},  Integer.valueOf(10));


        add(layer);
        this.setSize(1280, 747);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.layer.add(new SceneModify().addJLayerPaneAnimate(new FadeOutAnimate()),  Integer.valueOf(10));
        this.setVisible(true);
        this.addKeyListener(new ActionHandlerOfTyping(this));
//        EntityAnimation animation = new EntityAnimation();
//        this.add(animation);



//        generateNewWord(); // start the game with the first word
//        currentWordRunning = true;


//        Thread newThread = new Thread(() -> {
//            System.out.println("New thread started!");
//        });
//        newThread.start();


//        Thread scoreThread = new Thread(() -> {
//            while (true) {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("Score: " + score);
//            }
//        });
//        scoreThread.start();

        // Create a new Thread to handle the fade in animation
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                float alpha = 0.0f;
//                while (alpha < 1.0f) {
//                    // Increase alpha by a small amount
//                    alpha += 0.01f;
//
//                    // Set alpha of ScoreBaordBG and its child components
//                    ScoreBaordBG.setOpaque(false);
//                    ScoreBaordBG.setBackground(new Color(0, 0, 0, alpha));
//                    ScoreBaordBG.repaint();
//                    ScoreBaordButton1.setOpaque(false);
//                    ScoreBaordButton1.setBackground(new Color(0, 0, 0, alpha));
//                    ScoreBaordButton1.repaint();
//                    ScoreBaordButton2.setOpaque(false);
//                    ScoreBaordButton2.setBackground(new Color(0, 0, 0, alpha));
//                    ScoreBaordButton2.repaint();
//
//                    try {
//                        // Sleep for a short amount of time to slow down the animation
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
    }
    public void generateNewWord() {
        currentWord = words[currentWordIndex];
        currentWordIndex = (currentWordIndex + 1) % words.length;
        wordLabel.setText("<html><font style='font-family: Sabreen Regular Demo; font-size: 30px; color: gray'>" + currentWord + "<html>");
    }
    public boolean isCurrentWordRunning() {
        return currentWordRunning;
    }

    public void setCurrentWordRunning(boolean currentWordRunning) {
        this.currentWordRunning = currentWordRunning;
    }

    public int getCurrentWordIndex() {
        return currentWordIndex;
    }

    public void setCurrentWordIndex(int currentWordIndex) {
        this.currentWordIndex = currentWordIndex;
    }

    public String getCurrentWord() {
        return currentWord;
    }

    public void setCurrentWord(String currentWord) {
        this.currentWord = currentWord;
    }

    public int getCurrentWordStart() {
        return currentWordStart;
    }

    public void setCurrentWordStart(int currentWordStart) {
        this.currentWordStart = currentWordStart;
    }
}

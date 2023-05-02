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



    public JLayeredPane layer, intro;
    public JLabel tutorial1, tutorial2, tutorial3;
    public JLabel typingCountdown;
    public JLabel ScoreBoardBG;
    public JButton ScoreBoardButton1, ScoreBoardButton2;

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

        layer.add(intro =  new SceneModify().addJLayerPaneBackGround("intro_layer", true), Integer.valueOf(10));
        intro.addMouseListener(new ActionHandlerOfTyping(MiniGameTyping.this));
        intro.addKeyListener(new ActionHandlerOfTyping(MiniGameTyping.this)); intro.setFocusable(true);
        intro.add(tutorial1 = new SceneModify().createJLabelWithKey(431, 151, 417, 417, null, "src/resource/typing_game/tutorial1.png"), Integer.valueOf(5));
        intro.add(tutorial2 = new SceneModify().createJLabelWithKey(431, 151, 417, 417, null, "src/resource/typing_game/tutorial2.png"), Integer.valueOf(4));
        intro.add(tutorial3 = new SceneModify().createJLabelWithKey(431, 151, 417, 417, null, "src/resource/typing_game/tutorial3.png"), Integer.valueOf(3));


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



        layer.add(ScoreBoardBG = new JLabel(new ImageIcon("src/resource/typing_game/ScoreBoardBG.png")) {{
            //addMouseListener(new ActionHandlerOfTyping("ScoreBoardBG",  MiniGameTyping.this, ScoreBoardBG));
            setBounds(399, 65, 480, 530);
            setVisible(false);
            add(ScoreBoardButton1 = new JButton(new ImageIcon("src/resource/typing_game/ScoreBoardButton1.png")) {{
                setBounds((480/2) - (145/2) - 120, 530-70, 145, 45);
                addActionListener(new ActionHandlerOfTyping(MiniGameTyping.this));
            }},  Integer.valueOf(2));
            add(ScoreBoardButton2 = new JButton(new ImageIcon("src/resource/typing_game/ScoreBoardButton1.png")) {{
                setBounds((480/2)- (145/2) + 120, 530-70, 145, 45);
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
//                    // Set alpha of ScoreBoardBG and its child components
//                    ScoreBoardBG.setOpaque(false);
//                    ScoreBoardBG.setBackground(new Color(0, 0, 0, alpha));
//                    ScoreBoardBG.repaint();
//                    ScoreBoardButton1.setOpaque(false);
//                    ScoreBoardButton1.setBackground(new Color(0, 0, 0, alpha));
//                    ScoreBoardButton1.repaint();
//                    ScoreBoardButton2.setOpaque(false);
//                    ScoreBoardButton2.setBackground(new Color(0, 0, 0, alpha));
//                    ScoreBoardButton2.repaint();
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

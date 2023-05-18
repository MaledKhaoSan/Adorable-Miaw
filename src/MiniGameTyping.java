import canvas_modify.SceneFadeOut;
import canvas_modify.SceneModify;
import canvas_modify.SceneSoundBackground;
import canvas_modify.SceneSoundPlayer;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class MiniGameTyping extends JFrame{
    public String difficulty;
    public JLabel wordLabel;
    private String[] words = {
        "alice was a fast typist she could type at lightning speed without even looking at the keyboard her fingers danced across the keys tapping out words as fast as her mind could think them one day alice decided to enter a typing competition she knew she had what it took to win and she was determined to come out on top",
        "sally loves to play the piano and sing along the sound of the keys resonates through the room filling it with melodic beauty her fingers gracefully dance across the ivory effortlessly bringing life to each note as she plays her passion shines through captivating anyone who listens the music take her",
        "the sun shines brightly spreading warmth across the calm meadow the gentle wind carries the sweet scent of flowers enhancing the peaceful atmosphere birds sing joyfully as butterflies flutter among the swaying grass nature beauty and harmony create a tranquil haven inspiring a sense of calm and wonder in those who witness it"
    };
    private boolean currentWordRunning;
    private int currentWordIndex = 0;
    private String currentWord;
    private int currentWordStart = 0;



    public JLayeredPane layer, intro;
    public JLabel tutorial1, tutorial2;
    public JLabel typingCountdown;
    public JLabel ScoreBoardBG, ScoreBoardStar, ScoreBoard_CorrectWords,ScoreBoard_IncorrectWords, ScoreBoard_EarnPoints;
    public JButton ScoreBoardButton1, ScoreBoardButton2;
    public SceneSoundPlayer soundPlayer = new SceneSoundBackground();

    public MiniGameTyping(String difficulty) {
        soundPlayer.getSoundPath(5);
        ActionHandlerOfTyping handler = new ActionHandlerOfTyping(this);
        this.setBackground(Color.BLACK);
        this.addKeyListener(new ActionHandlerOfTyping(this));
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
        intro.add(tutorial1 = new SceneModify().createJLabelWithKey(431, 151, 417, 417, null, "src/resource/ui_transition/typing_htp.png"), Integer.valueOf(5));
        intro.add(tutorial2 = new SceneModify().createJLabelWithKey(431, 151, 417, 417, null, "src/resource/ui_transition/timeups_htp.png"), Integer.valueOf(4));

        wordLabel = new JLabel();
        wordLabel.setBounds((1280/2) - 400, (720/2) - 250, 800, 500);
        wordLabel.setHorizontalAlignment(JLabel.CENTER);
        wordLabel.setVerticalAlignment(JLabel.CENTER);
        layer.add(wordLabel); layer.add(typingCountdown = new SceneModify().createJLabelWithFont(525, 70, 200 ,105, 255, 40,"src/resource/fonts/RemboyRegular.ttf", "" , true)); layer.add(ScoreBoardBG = new SceneModify().createJLabel(399, 65, 480, 530, null, "src/resource/ui_transition/ScoreBoardBG.png",false),  Integer.valueOf(10));
        ScoreBoardBG.add(ScoreBoardStar = new SceneModify().createJLabel(91,50,300,100, null, "", true),  Integer.valueOf(1));
        ScoreBoardBG.add(ScoreBoard_CorrectWords = new SceneModify().createJLabelWithFont(108,190,265,50, 255, 20, "src/resource/fonts/RemboyRegular.ttf", "Correct Words : " , true),  Integer.valueOf(1));
        ScoreBoardBG.add(ScoreBoard_IncorrectWords = new SceneModify().createJLabelWithFont(108,260,265,50, 255, 20, "src/resource/fonts/RemboyRegular.ttf", "Incorrect Words: " , true),  Integer.valueOf(1));
        ScoreBoardBG.add(ScoreBoard_EarnPoints = new SceneModify().createJLabelWithFont(108,330,265,50, 255, 20, "src/resource/fonts/RemboyRegular.ttf", "Heart Collection: " , true),  Integer.valueOf(1));
        ScoreBoardBG.add(ScoreBoardButton1 = new SceneModify().createJButton((480/2) - (145/2) - 120, 530-70, 145, 45, handler, "src/resource/ui_transition/UIRetry.png", true),  Integer.valueOf(2));
        ScoreBoardBG.add(ScoreBoardButton2 = new SceneModify().createJButton((480/2)- (145/2) + 120, 530-70, 145, 45, handler, "src/resource/ui_transition/UINext.png", true),  Integer.valueOf(2));

        add(layer);
        this.setSize(1280, 747);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.layer.add(new SceneModify().addJLayerPaneAnimate(new SceneFadeOut()),  Integer.valueOf(20));
        this.setVisible(true);
        this.addWindowListener(handler);
    }
    public void generateNewWord() {
        if (difficulty.equals("starter")) {
            currentWordIndex = 0;
        }
        else if (difficulty.equals("normal")){
            currentWordIndex = 1;
        }
        else if (difficulty.equals("hard")){
            currentWordIndex = 2;
        }
        currentWord = words[currentWordIndex];
        wordLabel.setText("<html><font style='font-family: Sabreen Regular Demo; font-size: 30px; color: gray'>" + currentWord + "<html>");
    }
    public boolean isCurrentWordRunning() {
        return currentWordRunning;
    }

    public void setCurrentWordRunning(boolean currentWordRunning) {
        this.currentWordRunning = currentWordRunning;
    }
    public String getCurrentWord() {
        return currentWord;
    }


    public int getCurrentWordStart() {
        return currentWordStart;
    }

    public void setCurrentWordStart(int currentWordStart) {
        this.currentWordStart = currentWordStart;
    }
}

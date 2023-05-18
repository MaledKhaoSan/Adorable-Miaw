import canvas_modify.*;
import javax.swing.*;
import java.awt.*;

public class MainBuilding extends JFrame{
    public JLayeredPane layer, bentoFurPanel;
    public JLabel uiAccount, uiAccountText;
    public JButton homeExit;

    public JButton furniture_aqua, furniture_bear, furniture_coffee, furniture_sofa, furniture_bento, furniture_television;
    public JLabel furniture_vase;
    public JButton ButtonA, ButtonB, ButtonC, ButtonD;
    public JLabel selectedFrame, selectedFrameName, selectedFrameBento, bentoBox, bentoBG;
    public JButton selectedFrameSlideRight, selectedFrameSlideLeft, selectedFrameButton, bentoExit;

    private Account account;
    private AccountSaved accountSaved = new AccountSaved();
    public SceneSoundPlayer soundPlayer = new SceneSoundBackground();

    public MainBuilding() {
        soundPlayer.getSoundPath(2);
        ActionHandlerOfBuilding handler = new ActionHandlerOfBuilding(this);
        account = accountSaved.load();
        this.setBackground(Color.BLACK);


        layer = new SceneModify().addJLayerPaneBackGround("src/resource/building_canvas/background.png", "layer", true);
        layer.add(bentoFurPanel = new SceneModify().addJLayerPaneBackGround("", "bentoFur_layer", false), Integer.valueOf(6));

        bentoFurPanel.add(bentoBox = new SceneModify().createJLabelWithMouse(71, 188, 585, 453,null, "src/resource/cooking_game/bento3.png"), Integer.valueOf(3));
        bentoFurPanel.add(bentoBG = new SceneModify().createJLabelWithMouse(0, 0, 1280, 720, null, "src/resource/cooking_game/bentoBackground3.png"), Integer.valueOf(1));
        bentoFurPanel.add(bentoExit = new SceneModify().createJButton(108, 25, 59, 59, handler, "src/resource/building_canvas/uiButton2.png", true), Integer.valueOf(2));
        bentoFurPanel.add(selectedFrame = new JLabel(new ImageIcon("src/resource/cooking_game/selectedFrame.png")) {{
            setBounds(788, 116, 371, 482);
            add(selectedFrameName = new SceneModify().createJLabelWithFont(7, 21, 351, 67, 111,30,"src/resource/fonts/gifted-personal.regular.otf","Orange Bento Box", true));
            add(selectedFrameSlideRight = new SceneModify().createJButton(320, 224, 32, 33, handler, "src/resource/cooking_game/selectedRight.png", true));
            add(selectedFrameSlideLeft = new SceneModify().createJButton(14, 224, 32, 33, handler, "src/resource/cooking_game/selectedLeft.png", true));
            add(selectedFrameBento = new SceneModify().createJLabelWithKey(8, 115, 350, 250, null, "src/resource/cooking_game/bentoIcon3.png"));
            add(selectedFrameButton = new SceneModify().createJButton(111, 408, 148, 56, handler, "src/resource/cooking_game/selectedButton.png", true));
            setVisible(true);
        }},  Integer.valueOf(5));
        add(layer);

        layer.add(uiAccount = new SceneModify().createJLabelWithMouse(950, 28, 205, 59, null, "src/resource/building_canvas/uiButton1.png"), Integer.valueOf(0));
        layer.add(uiAccountText = new SceneModify().createJLabelWithFont(1030, 34, 205, 59, 200, 30, "src/resource/fonts/Aloja-Light.otf", String.valueOf(account.getBalance()) , true), Integer.valueOf(1));
        uiAccountText.setHorizontalAlignment(SwingConstants.LEFT);
        layer.add(homeExit = new SceneModify().createJButton(108, 25, 59, 59, handler, "src/resource/building_canvas/uiButton2.png", true), Integer.valueOf(0));

        layer.add(furniture_aqua = new SceneModify().createJButton(729, 127, 230, 222, handler, "src/resource/building_canvas/aquarium_bw.png", true), Integer.valueOf(2));
        layer.add(furniture_bear = new SceneModify().createJButton(69, 490, 267, 221, handler, "src/resource/building_canvas/bear_bw.png", true), Integer.valueOf(2));
        layer.add(furniture_coffee = new SceneModify().createJButton(360, 397, 433, 176, handler, "src/resource/building_canvas/coffee_bw.png", true), Integer.valueOf(2));
        layer.add(furniture_sofa = new SceneModify().createJButton(270 , 593, 507, 127, handler, "src/resource/building_canvas/sofa_bw.png", true), Integer.valueOf(3));
        layer.add(furniture_bento = new SceneModify().createJButton(927, 483, 321, 237, handler, "src/resource/building_canvas/bento_bw.png", true), Integer.valueOf(3));
        layer.add(furniture_television = new SceneModify().createJButton(480, 108, 248, 217, handler, "src/resource/building_canvas/television_bw.png", true), Integer.valueOf(3));
        layer.add(furniture_vase = new SceneModify().createJLabelWithMouse(751, 562,137,158, null, "src/resource/building_canvas/vase.png"), Integer.valueOf(4));


//        layer.add(ButtonA = new SceneModify().createJButton(100, 100, 50, 50, handler, null, true), Integer.valueOf(4));
//        ButtonA.setOpaque(true);
//        ButtonA.setBackground(Color.black);
//
//        layer.add(ButtonB = new SceneModify().createJButton(200, 100, 50, 50, handler, null, true), Integer.valueOf(4));
//        ButtonB.setOpaque(true);
//        ButtonB.setBackground(Color.RED);
//
//        layer.add(ButtonC = new SceneModify().createJButton(300, 100, 50, 50, handler, null, true), Integer.valueOf(4));
//        ButtonC.setOpaque(true);
//        ButtonC.setBackground(Color.CYAN);
//
//        layer.add(ButtonD = new SceneModify().createJButton(400, 100, 50, 50, handler, null, true), Integer.valueOf(4));
//        ButtonD.setOpaque(true);
//        ButtonD.setBackground(Color.ORANGE);




        this.setSize(1280, 747);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.addWindowListener(handler);
        this.layer.add(new SceneModify().addJLayerPaneAnimate(new SceneFadeOut()),  Integer.valueOf(20));
        this.setVisible(true);

    }
}

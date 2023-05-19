import javax.swing.*;
import java.awt.event.*;

public class ActionHandlerOfBuilding implements ActionListener, WindowListener{
    private MainBuilding targetFrame;
    private Account account;
    private AccountSaved accountSaved = new AccountSaved();
    private int waiter = 2;

    private static int currentIndex = 0;
    public static String[][] defaultSlideMenu = {
            //boxIcon1
            {"Purple Bento Box", "src/resource/cooking_game/bentoIcon3.png", "src/resource/cooking_game/bento3.png", "src/resource/cooking_game/bentoBackground3.png"},
            //boxIcon2
            {"Yellow Bento Box", "src/resource/cooking_game/bentoIcon2.png", "src/resource/cooking_game/bento2.png", "src/resource/cooking_game/bentoBackground2.png"},
            //boxIcon3
            {"Orange Bento Box", "src/resource/cooking_game/bentoIcon1.png", "src/resource/cooking_game/bento1.png", "src/resource/cooking_game/bentoBackground1.png"}
    };




    public ActionHandlerOfBuilding(MainBuilding targetFrame) {
        this.targetFrame = targetFrame;
        account = accountSaved.load();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Selected Button
        if (e.getSource() == targetFrame.selectedFrameButton){
            account.setBentoset(currentIndex);
            accountSaved.save();
            targetFrame.selectedFrameName.setText("Already Select!");
        }
        else if (e.getSource() == targetFrame.selectedFrameSlideRight){
            currentIndex = (currentIndex + 1) % defaultSlideMenu.length;
            targetFrame.selectedFrameName.setText(defaultSlideMenu[currentIndex][0]);
            targetFrame.selectedFrameBento.setIcon(new ImageIcon(defaultSlideMenu[currentIndex][1]));
            targetFrame.bentoBox.setIcon(new ImageIcon(defaultSlideMenu[currentIndex][2]));
            targetFrame.bentoBG.setIcon(new ImageIcon(defaultSlideMenu[currentIndex][3]));
        }
        else if (e.getSource() == targetFrame.selectedFrameSlideLeft){
            currentIndex = (currentIndex - 1 + defaultSlideMenu.length) % defaultSlideMenu.length;
            targetFrame.selectedFrameName.setText(defaultSlideMenu[currentIndex][0]);
            targetFrame.selectedFrameBento.setIcon(new ImageIcon(defaultSlideMenu[currentIndex][1]));
            targetFrame.bentoBox.setIcon(new ImageIcon(defaultSlideMenu[currentIndex][2]));
            targetFrame.bentoBG.setIcon(new ImageIcon(defaultSlideMenu[currentIndex][3]));
        }
        if (e.getSource() == targetFrame.homeExit) {
            targetFrame.homeExit.removeActionListener(this);
            new Thread(new RunnableOfBuilding(1, targetFrame, this), "HomeExit").start();
        }
        if (e.getSource() == targetFrame.bentoExit) {
            new Thread(new RunnableOfBuilding(waiter, targetFrame, targetFrame.bentoExit, this), "bentoFurTransition").start();
        }
        else if (e.getSource() == targetFrame.furniture_aqua) {
            furnitureInteract( new Furniture("aquarium", account.isFur_aqua(), 100) );
        }
        else if (e.getSource() == targetFrame.furniture_television) {
            furnitureInteract( new Furniture("television", account.isFur_television(), 100) );
        }
        else if (e.getSource() == targetFrame.furniture_coffee) {
            furnitureInteract( new Furniture("coffee", account.isFur_coffee(), 200) );
        }
        else if (e.getSource() == targetFrame.furniture_bear) {
            furnitureInteract( new Furniture("bear", account.isFur_bear(), 100) );
        }
        else if (e.getSource() == targetFrame.furniture_sofa) {
            furnitureInteract( new Furniture("sofa", account.isFur_sofa(), 100) );
        }
        else if (e.getSource() == targetFrame.furniture_bento) {
            furnitureInteract( new Furniture("bento", account.isFur_bento(), 200) );
        }
        //else if (e.getSource() == targetFrame.furniture_vase) {account.setBalance(account.getBalance() + 100); System.out.println("addMoney 100: " + account.getBalance());}
    }
    @Override
    public void windowOpened(WindowEvent e) {
        checkAccAttr();
    }


    public void furnitureInteract(Furniture furniture) {
        if (furniture.isActive()) {
            if (furniture.getName().equals("bento")) {
                targetFrame.furniture_bento.removeActionListener(this);
                new Thread(new RunnableOfBuilding(waiter, targetFrame, targetFrame.furniture_bento, this), "bentoFurTransition").start();
            }
            System.out.println("Already Buy it");
        }
        else {
            if ((account.getBalance() - furniture.getPrice()) >= 0) {
                account.setBalance(account.getBalance() - furniture.getPrice());
                updateAccAttr(account, furniture);
                System.out.println("You have bought a " + furniture.getName() + " for " + furniture.getPrice() + " dollars.");
            } else {
                System.out.println("You do not have enough balance to buy a " + furniture.getName() + ".");
            }
        }
        targetFrame.uiAccountText.setText( String.valueOf(account.getBalance()));
    }

    public void checkAccAttr() {
        if (account.isFur_television()){
            targetFrame.furniture_television.setIcon(new ImageIcon("src/resource/building_canvas/television.png"));
            targetFrame.furniture_television.setBorder(null);
        }
        if (account.isFur_aqua()){
            targetFrame.furniture_aqua.setIcon(new ImageIcon("src/resource/building_canvas/aquarium.png"));
            targetFrame.furniture_aqua.setBorder(null);
        }
        if (account.isFur_coffee()){
            targetFrame.furniture_coffee.setIcon(new ImageIcon("src/resource/building_canvas/coffee.png"));
            targetFrame.furniture_coffee.setBorder(null);
        }
        if (account.isFur_bear()){
            targetFrame.furniture_bear.setIcon(new ImageIcon("src/resource/building_canvas/bear.png"));
            targetFrame.furniture_bear.setBorder(null);
        }
        if (account.isFur_sofa()){
            targetFrame.furniture_sofa.setIcon(new ImageIcon("src/resource/building_canvas/sofa.png"));
            targetFrame.furniture_sofa.setBorder(null);
        }
        if (account.isFur_bento()){
            targetFrame.furniture_bento.setIcon(new ImageIcon("src/resource/building_canvas/bento.png"));
            targetFrame.furniture_bento.setBorder(null);
        }
    }

    private void updateAccAttr(Account account, Furniture furniture) {
        switch (furniture.getName()) {
            case "television":
                account.setFur_television(true);
                break;
            case "aquarium":
                account.setFur_aqua(true);
                break;
            case "coffee":
                account.setFur_coffee(true);
                break;
            case "bear":
                account.setFur_bear(true);
                break;
            case "sofa":
                account.setFur_sofa(true);
                break;
            case "bento":
                account.setFur_bento(true);
                break;
            default:
                break;
        }
        checkAccAttr();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Window is closing save");}

    @Override
    public void windowClosed(WindowEvent e) {
        targetFrame.soundPlayer.stopAudio();
        System.out.println("Window is closed");
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
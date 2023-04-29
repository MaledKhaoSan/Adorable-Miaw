import java.awt.event.*;


public class ActionHandlerOfCooking implements ActionListener {

    private MiniGameCooking targetFrame;

    private int numRows = 3;
    private int numCols = 3;
    private static int currentIndex = -1;
    private static String[][] defaultSlideMenu = { {"","",""}, {"","",""}, {"","",""} };
    public String[][] mainSlideMenu = {
            //mainIcon1
            {"Spam Musubi", "src/resource/cooking_game/mainIcon1.png", "src/resource/cooking_game/main1.png"},
            //mainIcon2
            {"Yakisoba", "src/resource/cooking_game/mainIcon2.png", "src/resource/cooking_game/main2.png"},
            //mainIcon3
            {"Onigiri", "src/resource/cooking_game/mainIcon3.png", "src/resource/cooking_game/main3.png"}
    };

    public String[][] sideSlideMenu = {
            //sideIcon1
            {"Karaage", "src/resource/cooking_game/sideIcon1.png", "src/resource/cooking_game/side1.png"},
            //sideIcon2
            {"Saba Shioyaki", "src/resource/cooking_game/sideIcon2.png", "src/resource/cooking_game/side2.png"},
            //sideIcon3
            {"Steak", "src/resource/cooking_game/sideIcon3.png", "src/resource/cooking_game/side3.png"}
    };

    public String[][] dessertSlideMenu = {
            //dessertIcon1
            {"Japanese Pancake", "src/resource/cooking_game/dessertIcon1.png", "src/resource/cooking_game/dessert1.png"},
            //dessertIcon2
            {"Matcha Roll", "src/resource/cooking_game/dessertIcon2.png", "src/resource/cooking_game/dessert2.png"},
            //dessertIcon3
            {"Strawberry Millefeuilie", "src/resource/cooking_game/dessertIcon3.png", "src/resource/cooking_game/dessert3.png"}
    };

    public String[][] boxSlideMenu = {
            //boxIcon1
            {"Purple Bento Box", "src/resource/cooking_game/boxIcon1.png", "src/resource/cooking_game/bento1.png"},
            //boxIcon2
            {"Yellow Bento Box", "src/resource/cooking_game/boxIcon2.png", "src/resource/cooking_game/bento2.png"},
            //boxIcon3
            {"Orange Bento Box", "src/resource/cooking_game/boxIcon3.png", "src/resource/cooking_game/bento3.png"}
    };

//    public int[] boxSlideMenu = {7, 8, 9};

    public ActionHandlerOfCooking(MiniGameCooking targetFrame) {
        this.targetFrame = targetFrame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == targetFrame.selectedFrameButton){
            System.out.println("Select Food");
            System.out.println(defaultSlideMenu[currentIndex][2]);

        }

        else if (e.getSource() == targetFrame.selectedFrameSlideRight | e.getSource() == targetFrame.selectedFrameSlideLeft){
            currentIndex = (currentIndex + 1) % defaultSlideMenu.length;
            System.out.println(defaultSlideMenu[currentIndex][0]);
            System.out.println(defaultSlideMenu[currentIndex][1]);
            System.out.println(defaultSlideMenu[currentIndex][2]);
            System.out.println(" ");
        }

        else if (e.getSource() == targetFrame.BentoHitBox1){
            defaultSlideMenu = new String[numRows][numCols];
            for (int i = 0; i < numRows; i++) {
                System.arraycopy(mainSlideMenu[i], 0, defaultSlideMenu[i], 0, numCols);
            }
            System.out.println("HitBox1");
        }
        else if (e.getSource() == targetFrame.BentoHitBox4){
            defaultSlideMenu = new String[numRows][numCols];
            for (int i = 0; i < numRows; i++) {
                System.arraycopy(boxSlideMenu[i], 0, defaultSlideMenu[i], 0, numCols);
            }
            System.out.println("HitBox4");
        }
    }
}
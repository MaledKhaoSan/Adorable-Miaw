public class Main {
    public static void main(String[] args) {
      new MainMenu();
    Thread thread = new Thread(new CooldownAftergame());
    thread.start();

    }
}
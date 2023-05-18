public class CooldownAftergame implements Runnable{
    private int totalSeconds;
    private Account account;
    private AccountSaved accountSaved = new AccountSaved();
    public CooldownAftergame(){
        account = accountSaved.load(); totalSeconds = account.getCooldown();
    }
    @Override
    public void run() {
            try {
                while (totalSeconds > 0){
                    --totalSeconds;
                    account = accountSaved.load();
                    account.setCooldown(totalSeconds);
                    accountSaved.save();
                    Thread.sleep(1000);
                }
                System.out.println("NO COOLDOWN");
            }
            catch (InterruptedException e) {}
    }
}


//                    int hours = totalSeconds / 3600;
//                    int minutes = (totalSeconds % 3600) / 60;
//                    int seconds = totalSeconds % 60;
//                    String formattedTime = String.format("%02d:%02d:%02d", hours, minutes, seconds);
//                    System.out.println(formattedTime);
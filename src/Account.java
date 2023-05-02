

public abstract class Account{
    private static int balance = 0;


    //
    public static void setBalance(int balance) {
        Account.balance = balance;
    }
    //
    public static int getBalance(){
        return balance;
    }
}




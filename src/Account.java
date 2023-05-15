
import java.io.Serializable;
public class Account implements Serializable{
    private int balance, cooldown, bentoset;
    private boolean fur_television;
    private boolean fur_aqua;
    private boolean fur_coffee;
    private boolean fur_bear;
    private boolean fur_sofa;
    private boolean fur_bento;

    public Account(){
        this(0, 0, 0, false, false, false, false, false, false);
    }
    public Account(int balance, int cooldown,  int bentoset,boolean fur_television, boolean fur_aqua, boolean fur_coffee, boolean fur_bear, boolean fur_sofa, boolean fur_bento) {
        this.balance = balance;
        this.cooldown = cooldown;
        this.bentoset = bentoset;
        this.fur_television = fur_television;
        this.fur_aqua = fur_aqua;
        this.fur_coffee = fur_coffee;
        this.fur_bear = fur_bear;
        this.fur_sofa = fur_sofa;
        this.fur_bento = fur_bento;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public int getBentoset() {
        return bentoset;
    }

    public void setBentoset(int bentoset) {
        this.bentoset = bentoset;
    }

    public boolean isFur_television() {
        return fur_television;
    }

    public void setFur_television(boolean fur_television) {
        this.fur_television = fur_television;
    }

    public boolean isFur_aqua() {
        return fur_aqua;
    }

    public void setFur_aqua(boolean fur_aqua) {
        this.fur_aqua = fur_aqua;
    }

    public boolean isFur_coffee() {
        return fur_coffee;
    }

    public void setFur_coffee(boolean fur_coffee) {
        this.fur_coffee = fur_coffee;
    }

    public boolean isFur_bear() {
        return fur_bear;
    }

    public void setFur_bear(boolean fur_bear) {
        this.fur_bear = fur_bear;
    }

    public boolean isFur_sofa() {
        return fur_sofa;
    }

    public void setFur_sofa(boolean fur_sofa) {
        this.fur_sofa = fur_sofa;
    }

    public boolean isFur_bento() {
        return fur_bento;
    }

    public void setFur_bento(boolean fur_bento) {
        this.fur_bento = fur_bento;
    }
}








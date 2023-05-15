public class Furniture {
    private int price;
    private String name;
    private boolean active;


    public Furniture(String name, boolean active, int price) {
        this.name = name;
        this.active = active;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() { return active; }
}
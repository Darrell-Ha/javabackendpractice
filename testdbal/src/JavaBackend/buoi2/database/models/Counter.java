package JavaBackend.buoi2.database.models;

public class Counter {
    private String maker;
    private int quantity;
    private long money;

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public Counter(){

    }
    public Counter(String maker,int quantity,long money){
        this.maker=maker;
        this.quantity=quantity;
        this.money=money;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "maker='" + maker + '\'' +
                ", quantity=" + quantity +
                ", money=" + money +
                '}';
    }
}

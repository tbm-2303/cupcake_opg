package business.entities;

public class Cupcake {
    String top;
    String bot;
    int amount;
    String discription;
    int price;


    public Cupcake(String top, String bottom, int amount) {
        this.top = top;
        this.bot = bot;
        this.amount = amount;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public String getBottom() {
        return bot;
    }

    public void setBottom(String bottom) {
        this.bot = bottom;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

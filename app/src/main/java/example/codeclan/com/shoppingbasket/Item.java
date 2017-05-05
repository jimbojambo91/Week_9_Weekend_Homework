package example.codeclan.com.shoppingbasket;

/**
 * Created by user on 05/05/2017.
 */

public class Item {
    private String name;
    private double price;

    public Item (String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double newPrice) {
        price = newPrice;
    }
}

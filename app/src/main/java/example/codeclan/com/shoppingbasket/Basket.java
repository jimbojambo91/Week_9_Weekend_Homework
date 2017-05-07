package example.codeclan.com.shoppingbasket;

import java.util.ArrayList;

/**
 * Created by user on 05/05/2017.
 */

public class Basket {
    private ArrayList<Item> items;
    private boolean loyaltyCard;

    public Basket(boolean loyaltyCard){
        this.items = new ArrayList<Item>();
        this.loyaltyCard = loyaltyCard;
    }

    public int getItemsCount() {
        return items.size();
    }

    public void add(Item item) {
        items.add(item);
    }

    public void remove(Item item) {
        items.remove(item);
    }

    public void empty() {
        items.clear();
    }

    public double getTotalItemsPrice() {
        double totalPrice = 0;
        for(Item item : items){
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public boolean getLoyaltyCard() {
        return loyaltyCard;
    }
}

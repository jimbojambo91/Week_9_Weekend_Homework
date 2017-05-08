package example.codeclan.com.shoppingbasket;

import java.util.ArrayList;

/**
 * Created by user on 08/05/2017.
 */

public class Checkout {
    private ArrayList<String> currentBogof;

    public Checkout(){
        this.currentBogof = new ArrayList<String>();
    }

    public ArrayList<String> getCurrentBogof() {
        return currentBogof;
    }

    public int getCurrentBogofSize() {
        return currentBogof.size();
    }

    public void addToCurrentBogof(String item) {
        currentBogof.add(item);
    }

    public void removeFromCurrentBogof(String item){
        currentBogof.remove(item);
    }

    public double processBasketPrice(Basket basket){
        double saving = checkBogofSaving(basket);
        double basketPrice = basket.getTotalItemsPrice() - saving;
        if((basketPrice) > 20.00 ){
            basketPrice = basketPrice * 0.90;
        }
        if(basket.getLoyaltyCard()){
            basketPrice = basketPrice * 0.98;
        }

        return Math.round(basketPrice * 100d) / 100d ;
    }

    public double checkBogofSaving(Basket basket) {
        double saving = 0;
        for(String StoreBogof: currentBogof){
            int counter = 0;
            for(Item item: basket.getItems()){
                if(item.getName().equals(StoreBogof)){
                    counter ++;
                    if(counter == 2){
                        saving += item.getPrice();
                        counter = 0;
                    }
                }

            }
        }
        return saving;
    }
}

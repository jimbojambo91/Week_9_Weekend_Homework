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
}

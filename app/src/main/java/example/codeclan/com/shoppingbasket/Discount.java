package example.codeclan.com.shoppingbasket;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by user on 05/05/2017.
 */

public class Discount {

    public double percentOff(double totalprice, double amount){
        double discount = totalprice * amount;
        return discount;
    }

    public double bogof(Basket basket){
        HashMap<String, Integer> itemMap = new HashMap<String, Integer>();
        Set<String> keys = itemMap.keySet();
        for(Item item: basket.getItems()){
            for(String key : keys)   {
                if(key.equals(item.getName())){
                    itemMap.put(key, itemMap.get(key) + 1);
                }
            }
        }
    }
}

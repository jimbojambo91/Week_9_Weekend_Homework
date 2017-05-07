package example.codeclan.com.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 08/05/2017.
 */

public class CheckoutTest {

    Checkout checkout;
    Item item;
    Item item2;
    Basket basket;


    @Before
    public void before(){
        checkout = new Checkout();
        item = new Item ("Banana", 2.50);
        item2 = new Item ("Grapes", 1.00);
        basket = new Basket();
    }

    @Test
    public void CheckoutCanAddBogofItems(){
        checkout.addToCurrentBogof("Banana");
        int result = checkout.getCurrentBogofSize();
        assertEquals(1, result);
    }

    @Test
    public void CheckoutCanRemoveBogofItems(){
        checkout.addToCurrentBogof("Banana");
        checkout.removeFromCurrentBogof("Banana");
        int result = checkout.getCurrentBogofSize();
        assertEquals(0, result);
    }
}

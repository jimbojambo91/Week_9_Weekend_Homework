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
    Basket basket2;


    @Before
    public void before(){
        checkout = new Checkout();
        item = new Item ("Banana", 2.50);
        item2 = new Item ("Grapes", 1.00);
        basket = new Basket(false);
        basket2 = new Basket(true);
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

    @Test
    public void checkCurrentBogofVersusBasket(){
        checkout.addToCurrentBogof("Banana");
        basket.add(item);
        basket.add(item);
        basket.add(item2);
        double result = checkout.checkBogofSaving(basket);
        assertEquals(2.50, result);

    }

    @Test
    public void checkOver20Gets10PercentOff(){
        Item expensiveItem = new Item("Xbox", 200.00);
        basket.add(expensiveItem);
        double result = checkout.processBasketPrice(basket);
        assertEquals(180.00, result);
    }

    @Test
    public void checkLoyaltyCardGets2PercentOff(){
        basket2.add(item);
        double result = checkout.processBasketPrice(basket2);
        assertEquals(2.45,result);
    }

    @Test
    public void checkAllDiscountsCanBeAppliedAtOnce(){
        Item expensiveItem = new Item("Xbox", 200.00);
        checkout.addToCurrentBogof("Banana");
        basket2.add(expensiveItem);
        basket2.add(item);
        basket2.add(item);
        basket2.add(item2);
        double result = checkout.processBasketPrice(basket2);
        assertEquals(179.49,result);
    }

    @Test
    public void ensuringMultipleBogofDealsWork(){
        checkout.addToCurrentBogof("Banana");
        checkout.addToCurrentBogof("Grapes");
        basket.add(item);
        basket.add(item);
        basket.add(item2);
        basket.add(item2);
        double result = checkout.processBasketPrice(basket);
        assertEquals(3.50,result);
    }

    @Test
    public void ensuringMultipleBogofDealsWorkOnSameItem(){
        checkout.addToCurrentBogof("Banana");
        basket.add(item);
        basket.add(item);
        basket.add(item);
        basket.add(item);
        double result = checkout.processBasketPrice(basket);
        assertEquals(5.00,result);
    }
}

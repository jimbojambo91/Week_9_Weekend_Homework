package example.codeclan.com.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 05/05/2017.
 */

public class BasketTest {
    Item item;
    Item item2;
    Basket basket;

    @Before
    public void before(){
        item = new Item ("Banana", 2.50);
        basket = new Basket();
        item2 = new Item ("Grapes", 1.00);
    }

    @Test
    public void basketStartsEmpty(){
        int result = basket.getItemsCount();
        assertEquals(0, result);
    }

    @Test
    public void canAddItemToBasket(){
        basket.add(item);
        int result = basket.getItemsCount();
        assertEquals(1, result);
    }

    @Test
    public void canRemoveItemFromBasket(){
        basket.add(item);
        basket.remove(item);
        int result = basket.getItemsCount();
        assertEquals(0, result);
    }

    @Test
    public void canEmptyBasket(){
        basket.add(item);
        basket.empty();
        int result = basket.getItemsCount();
        assertEquals(0, result);
    }

    @Test
    public void canTotalBasketPrice(){
        double result = basket.getTotalItemsPrice();
    }

}

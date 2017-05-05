package example.codeclan.com.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 05/05/2017.
 */

public class ItemTest {
    Item item;

    @Before
    public void before(){
        item = new Item ("Banana", 2.50);
    }

    @Test
    public void itemHasName(){
        String result = item.getName();
        assertEquals("Banana", result);
    }

    @Test
    public void itemHasPrice(){
        double result = item.getPrice();
        assertEquals(2.50, result);
    }

    @Test
    public void changeItemPriceTest(){
        item.setPrice(5.00);
        double result = item.getPrice();
        assertEquals(5.00, result);
    }
}

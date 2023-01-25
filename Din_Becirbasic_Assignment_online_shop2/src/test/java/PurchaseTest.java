import ba.edu.ssst.Item;
import ba.edu.ssst.Purchase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PurchaseTest {

    @Test
    public void testGetterSetter(){
        Item item = new Item("Milk", 2.0, 10, "Food");
        Integer quantity = 10;
        Purchase purchase = new Purchase(item, quantity);
        assertEquals(item, purchase.getItem());
        assertEquals(quantity, purchase.getQuantity());
    }

    @Test
    public void testToString(){
        Item item = new Item("Milk", 2.0, 10, "Food");
        Integer quantity = 10;
        Purchase purchase = new Purchase(item, quantity);
        assertEquals("Milk 2.0 10 Food 10", purchase.toString());
    }
}

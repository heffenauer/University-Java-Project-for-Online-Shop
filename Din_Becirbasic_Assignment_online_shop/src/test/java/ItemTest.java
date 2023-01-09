import ba.edu.ssst.Item;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTest {

    @Test
    public void testItem() {
        String name = "Milk";
        Double price = 2.0;
        Integer quantity = 10;
        String category = "Food";
        Item item = new Item(name, price, quantity, category);
        assertEquals(name, item.getName());
        assertEquals(price, item.getPrice());
        assertEquals(quantity, item.getStock());
        assertEquals(category, item.getCategory());
    }

    @Test
    public void testToStock() {
        Item item = new Item("Milk", 2.0, 10, "Food");
        item.setStock(5);
        assertEquals(5, item.getStock().intValue());
    }

    @Test
    public void testToString() {
        Item item = new Item("Milk", 2.0, 10, "Food");
        assertEquals("Milk 2.0 10 Food", item.toString());
    }

}

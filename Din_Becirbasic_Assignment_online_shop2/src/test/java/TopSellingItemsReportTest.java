import ba.edu.ssst.Item;
import ba.edu.ssst.TopSellingItemsReport;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TopSellingItemsReportTest {
    @Test
    public void testGenerate() throws IOException {
        Map<Item, Integer> map = new HashMap<>();
        map.put(new Item("Milk", 2.0, 10, "Food"), 100);
        map.put(new Item("Bread", 1.0, 10, "Food"), 50);
        map.put(new Item("Eggs", 3.0, 10, "Food"), 200);
        map.put(new Item("Coke", 1.5, 10, "Food"), 150);
        map.put(new Item("Beer", 2.5, 10, "Food"), 300);
        map.put(new Item("Wine", 5.0, 10, "Food"), 250);

        TopSellingItemsReport.generate(map);

        BufferedReader reader = new BufferedReader(new FileReader("TopSellingItemsReport.csv"));
        assertEquals("Item Name, Quantity Sold ", reader.readLine());
        assertEquals("Beer, 300", reader.readLine());
        assertEquals("Wine, 250", reader.readLine());
        assertEquals("Eggs, 200", reader.readLine());
        assertEquals("Coke, 150", reader.readLine());
        assertEquals("Milk, 100", reader.readLine());
        assertEquals("Bread, 50", reader.readLine());
        reader.close();

    }
}

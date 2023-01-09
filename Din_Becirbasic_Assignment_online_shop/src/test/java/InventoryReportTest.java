import ba.edu.ssst.InventoryReport;
import ba.edu.ssst.Item;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class InventoryReportTest {

    @Test
    public void generateTest() throws IOException {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("Bread", 1.0, 1, "Bread"));
        items.add(new Item("Milk", 2.0, 1, "Milk"));
        items.add(new Item("Lepina", 200.0, 4, "Bread"));
        InventoryReport.generate(items);

        BufferedReader reader = new BufferedReader(new FileReader("InventoryReport.csv"));
        assertEquals("Name, Quantity " , reader.readLine());
        assertEquals("Lepina, 4", reader.readLine());
        assertEquals("Bread, 1", reader.readLine());
        assertEquals("Milk, 1", reader.readLine());
    }
}

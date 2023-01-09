import ba.edu.ssst.CategorySalesReport;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CategorySalesReportTest {
    @Test
    public void generateTest() throws IOException {
        Map<String, Integer> itemCategory = new HashMap<>();
        itemCategory.put("Bread", 10);
        itemCategory.put("Milk", 20);
        itemCategory.put("Eggs", 30);
        itemCategory.put("Cheese", 40);
        itemCategory.put("Butter", 50);
        itemCategory.put("Yogurt", 60);
        itemCategory.put("Cereal", 70);

        CategorySalesReport.generate(itemCategory);

        BufferedReader reader = new BufferedReader(new FileReader("CategorySalesReport.csv"));
        assertEquals("Category, Total Sales ", reader.readLine());
        assertEquals("Cereal, 70", reader.readLine());
        assertEquals("Yogurt, 60", reader.readLine());
        assertEquals("Butter, 50", reader.readLine());
        assertEquals("Cheese, 40", reader.readLine());
        assertEquals("Eggs, 30", reader.readLine());
        assertEquals("Milk, 20", reader.readLine());
        assertEquals("Bread, 10", reader.readLine());
        reader.close();






    }

}

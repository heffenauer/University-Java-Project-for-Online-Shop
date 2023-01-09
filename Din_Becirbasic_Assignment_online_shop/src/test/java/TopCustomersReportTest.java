import ba.edu.ssst.Customer;
import ba.edu.ssst.TopCustomersReport;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TopCustomersReportTest {

        @Test
        public void testTopCustomersReport() throws IOException {
            Map<Customer, Double> map = new HashMap<>();
            map.put(new Customer("John", "john@mail.com"), 100.0);
            map.put(new Customer("Jane", "jane@mail.com"), 200.0);
            map.put(new Customer("Jack", "jack@mail.com"), 300.0);
            map.put(new Customer("Jill", "jill@mail.com"), 400.0);
            map.put(new Customer("Jenny", "jenny@mail.com"), 500.0);
            map.put(new Customer("Jen", "Jen@mail.com"), 600.0);

            TopCustomersReport.generate(map);

            BufferedReader reader = new BufferedReader(new FileReader("TopCustomersReport.csv"));
            assertEquals("Customer Name, Total Bill ", reader.readLine());
            assertEquals("Jen, 600.0", reader.readLine());
            assertEquals("Jenny, 500.0", reader.readLine());
            assertEquals("Jill, 400.0", reader.readLine());
            assertEquals("Jack, 300.0", reader.readLine());
            assertEquals("Jane, 200.0", reader.readLine());
            assertEquals("John, 100.0", reader.readLine());
            reader.close();

        }

}

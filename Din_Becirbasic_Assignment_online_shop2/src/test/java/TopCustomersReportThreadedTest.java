import ba.edu.ssst.Customer;
import ba.edu.ssst.TopCustomersReport;
import ba.edu.ssst.TopCustomersReportThreaded;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TopCustomersReportThreadedTest {


    @Test
    public void testTopCustomersReport() throws IOException, InterruptedException {
        Map<Customer, Double> map = new HashMap<>();
        map.put(new Customer("John", "john@mail.com", 10 , "furniture"), 100.0);
        map.put(new Customer("Jane", "jane@mail.com",10 , "furniture"), 200.0);
        map.put(new Customer("Jack", "jack@mail.com",10 , "furniture"), 300.0);
        map.put(new Customer("Jill", "jill@mail.com",10 , "furniture"), 400.0);
        map.put(new Customer("Jenny", "jenny@mail.com",10 , "furniture"), 500.0);
        map.put(new Customer("Jen", "Jen@mail.com",10 , "furniture"), 600.0);

        TopCustomersReportThreaded.generate(map);

        BufferedReader reader = new BufferedReader(new FileReader("TopCustomersReportThreaded.csv"));
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

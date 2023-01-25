import ba.edu.ssst.Customer;
import ba.edu.ssst.TopTenCustomersByCredit;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TopTenCustomersByCreditTest {

    @Test
    public void TopTenCustomersByCreditTest() throws IOException {

        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer("John", "john@example.com", 10, "furniture"));
        customers.add(new Customer("Jane", "jane@example.com", 20, "furniture"));
        customers.add(new Customer("Jack", "jack@example.com", 30, "furniture"));
        customers.add(new Customer("Jill", "jill@example.com", 40, "furniture"));

        TopTenCustomersByCredit topTenCustomersByCredit = new TopTenCustomersByCredit(customers, 0, 3);
        topTenCustomersByCredit.start();

        BufferedReader reader = new BufferedReader(new FileReader("TopTenCustomersByCredit.csv"));

        assertEquals("Customer Name, Credit", reader.readLine());
        assertEquals("Jill, 40", reader.readLine());
        assertEquals("Jack, 30", reader.readLine());
        assertEquals("Jane, 20", reader.readLine());
        assertEquals("John, 10", reader.readLine());
        reader.close();


    }
}

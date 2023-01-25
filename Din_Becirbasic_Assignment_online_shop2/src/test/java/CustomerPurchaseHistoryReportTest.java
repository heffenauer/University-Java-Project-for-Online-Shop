import ba.edu.ssst.Customer;
import ba.edu.ssst.Item;
import ba.edu.ssst.CustomerPurchaseHistoryReport;
import ba.edu.ssst.Purchase;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class CustomerPurchaseHistoryReportTest {
    @Test
    public void generateTest() throws IOException {

        ArrayList<Customer> customers = new ArrayList<>();

        Customer customer1 = new Customer("John Doe", "jd123@mail.com", 15, "toys");
        customer1.addPurchase(new Purchase(new Item("Bread", 1.0, 1, "Bread"), 1));
        customer1.addPurchase(new Purchase(new Item("Milk", 2.0, 1, "Milk"), 3));
        customers.add(customer1);

        Customer customer2 = new Customer("Jane Doe", "jd234@mail.com", 20, "cosmetics");
        customer2.addPurchase(new Purchase(new Item("Lepina", 200.0, 4, "Bread"),4));
        customer2.addPurchase(new Purchase(new Item("Milk", 2.0, 1, "Milk"), 1));
        customers.add(customer2);

        CustomerPurchaseHistoryReport.generate(customers);

        BufferedReader reader = new BufferedReader(new FileReader("CustomerPurchaseHistoryReport.csv"));
        assertEquals("John Doe: Bread - 1.0 Milk - 6.0 ", reader.readLine());
        assertEquals("Jane Doe: Lepina - 800.0 Milk - 2.0 ", reader.readLine());
        reader.close();



    }
}

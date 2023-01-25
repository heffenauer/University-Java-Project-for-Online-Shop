import ba.edu.ssst.Customer;
import ba.edu.ssst.Item;
import ba.edu.ssst.RecommendedPurchase;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RecommendedPurchaseTest {


        @Test
        public void generate() throws IOException {
            ArrayList<Customer> customers = new ArrayList<>();
            customers.add(new Customer("Bob", "bob@example.com", 50,"sports equipment"));
            customers.add(new Customer("Alice", "alice@example.com", 100,"furniture"));
            customers.add(new Customer("John", "john@example.com", 150,"electronics"));
            customers.add(new Customer("Jack", "jack@example.com", 200,"food"));
            customers.add(new Customer("Jane", "jane@example.com", 250,"book"));


            ArrayList<Item> Item = new ArrayList<>();
            Item.add(new Item("Ball", 150.0, 15, "sports equipment"));
            Item.add(new Item("Cake", 5.0, 14, "food"));
            Item.add(new Item("Sofa", 138.0, 158, "furniture"));
            Item.add(new Item("Book", 14.0, 15, "book"));
            Item.add(new Item("Laptop", 36.0, 14, "electronics"));


            RecommendedPurchase.generate(customers, Item);

            BufferedReader r = new BufferedReader(new FileReader("RecommendedPurchase.csv"));

            assertEquals("Customer, Recommended Purchase, Price of Item", r.readLine());
            assertEquals("Bob, Laptop, 36.0", r.readLine());
            assertEquals("Alice, Laptop, 36.0", r.readLine());
            assertEquals("John, Ball, 150.0", r.readLine());
            assertEquals("Jack, Ball, 150.0", r.readLine());
            assertEquals("Jane, Ball, 150.0", r.readLine());

        }
    }


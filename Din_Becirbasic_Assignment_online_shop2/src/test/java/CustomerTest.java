import ba.edu.ssst.Customer;
import ba.edu.ssst.Item;
import ba.edu.ssst.Purchase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    @Test

    public void testConstructorAndGetter(){
        String name = "John Doe";
        String email = "jd123@mail.com";
        Integer credit = 10;
        String favoriteCategory = "electronics";
        Customer customer = new Customer(name, email, credit, favoriteCategory);
        assertEquals(name, customer.getName());
        assertEquals(email, customer.getEmail());
    }


    @Test
    public void testAddPurchase() {
        Customer customer = new Customer("John Doe", "jd123@mail.com", 10, "electronics");
        Item item = new Item("Bread", 1.0, 1, "Bread");
        Purchase purchase = new Purchase(item, 1);
        customer.addPurchase(purchase);
        assertEquals(1, customer.getPurchases().size());
        assertEquals(purchase, customer.getPurchases().get(0));
    }

    @Test
    public void testToString() {
        Customer customer = new Customer("John Doe", "jd123@mail.com", 20, "cosmetics");
        assertEquals("John Doe jd123@mail.com", customer.toString());
    }






}

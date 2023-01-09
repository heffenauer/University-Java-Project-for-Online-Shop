package ba.edu.ssst;

import java.util.ArrayList;

public class Customer {

    String name;



    String email;

    ArrayList<Purchase> purchases = new ArrayList<>();

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;

    }

    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }

    public ArrayList<Purchase> getPurchases() {
        return purchases;
    }
    public void addPurchase(Purchase purchase) {
        purchases.add(purchase);
    }

    @Override
    public String toString() {
        return getName() + " " + getEmail();
    }
}




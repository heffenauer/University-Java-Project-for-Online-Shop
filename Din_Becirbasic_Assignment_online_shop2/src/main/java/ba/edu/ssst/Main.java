package ba.edu.ssst;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        ArrayList<Item> items = new ArrayList<>();
        ArrayList<Customer> customers = new ArrayList<>();
        Map<Item,Integer> sellItems = new HashMap<>();
        Map<Customer,Double> customerBill = new HashMap<>();
        Map<String, Integer> itemCategory = new HashMap<>();


        //read items file
        File itemFile = new File("items.csv");
        Scanner itemScanner = new Scanner(itemFile);
        itemScanner.nextLine();

        while (itemScanner.hasNextLine()) {
            String line = itemScanner.nextLine();
            String[] data = line.split(",");
            String name = data[0];
            Double price = Double.valueOf(data[1]);
            Integer quantity = Integer.valueOf(data[2]);
            String category = data[3];

            Item item = new Item(name, price, quantity, category);
            items.add(item);

        } //end of while loop for items

        //read customers file
        File customerFile = new File("customers.csv");
        Scanner customerScanner = new Scanner(customerFile);
        customerScanner.nextLine();

        while (customerScanner.hasNextLine()) {
            String line = customerScanner.nextLine();
            String[] data = line.split(",");
            String name = data[0];
            String email = data[1];
            Integer credit = Integer.valueOf(data[2]);
            String favoriteCategory = data[3];

            Customer customer = new Customer(name,email,credit,favoriteCategory);
            customers.add(customer);

        } //end of while loop for customers

        //read purchases file
        File purchaseFile = new File("purchases.csv");
        Scanner purchaseScanner = new Scanner(purchaseFile);
        purchaseScanner.nextLine();

        while (purchaseScanner.hasNextLine()) {
            String line = purchaseScanner.nextLine();
            String[] data = line.split(",");
            String customerName = data[0];
            String itemName = data[1];
            Integer quantity = Integer.valueOf(data[2]);

            Item item = null;
            for (Item i : items) {
                if (i.getName().equals(itemName)) {
                    item = i;
                    break;
                }
            }
            //above code is to find the item object from the items list
            //below code is to find the customer object from the customers list
            Customer customer = null;
            for (Customer c : customers) {
                if (c.getName().equals(customerName)) {
                    customer = c;
                    break;
                }
            }
            //check customer and item and add to customer purchases and stock
            if (customer != null && item != null) {
                Purchase purchase = new Purchase(item, quantity);
                customer.addPurchase(purchase);
                item.setStock(quantity);
            }

            //add items to sellItems map
            if (sellItems.containsKey(item)) {
                sellItems.put(item, sellItems.get(item) + quantity);
            } else {
                sellItems.put(item, quantity);
            }

            //add items to customerBill map
            if (customerBill.containsKey(customer)) {
                customerBill.put(customer, customerBill.get(customer) + quantity*item.getPrice());
            } else {
                customerBill.put(customer, quantity*item.getPrice());
            }

            //add items to itemCategory map
            if (itemCategory.containsKey(item.getCategory())) {
                itemCategory.put(item.getCategory(), itemCategory.get(item.getCategory()) + quantity);
            } else {
                itemCategory.put(item.getCategory(), quantity);
            }






        } //end of while loop for purchases


        // tasks


        TopSellingItemsReport.generate(sellItems); //tested
        TopCustomersReport.generate(customerBill); //tested
        CategorySalesReport.generate(itemCategory); //tested
        CustomerPurchaseHistoryReport.generate(customers); //tested
        InventoryReport.generate(items); //tested

        RecommendedPurchase.generate(customers,items);  //tested
        TopCustomersReportThreaded.generate(customerBill); //tested
        TopTenCustomersByCredit.generate(customers); //tested





    } //end of main
} //end of class Main

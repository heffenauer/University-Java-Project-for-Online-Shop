package ba.edu.ssst;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CustomerPurchaseHistoryReport {

        public static void generate(ArrayList<Customer> customers) throws IOException {
            FileWriter fileWriter = new FileWriter("CustomerPurchaseHistoryReport.csv");


            //print file with customer name, item name and total price of item
            for (Customer customer : customers) {
                fileWriter.write(customer.getName() + ": ");
                for (Purchase p: customer.getPurchases()) fileWriter.write(p.getItem().getName() + " - " + p.getQuantity()*p.getItem().getPrice() + " ");
                fileWriter.write("\n");

            }

            fileWriter.close();
            }



        }


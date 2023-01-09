package ba.edu.ssst;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class InventoryReport {
    public static void generate(ArrayList<Item> items) throws IOException {
            FileWriter fileWriter = new FileWriter("InventoryReport.csv");
            fileWriter.write("Name, Quantity \n");

           //sort items by amount in stock in descending order and write to file
            items.sort((o1, o2) -> o2.getStock().compareTo(o1.getStock()));
            for (Item item : items) {
                fileWriter.write(item.getName() + ", " + item.getStock() + "\n");
            }


            fileWriter.close();
        }


        }


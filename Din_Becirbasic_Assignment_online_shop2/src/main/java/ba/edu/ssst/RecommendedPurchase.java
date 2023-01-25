package ba.edu.ssst;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RecommendedPurchase {

    public static void generate(ArrayList<Customer> customers, ArrayList<Item> items) throws IOException {

        File file = new File("RecommendedPurchase.csv");
        FileWriter fw = new FileWriter(file);
        fw.write("Customer, Recommended Purchase, Price of Item" + "\n");

        Item max = null;
        ArrayList<Item> allmax = new ArrayList<>();

        for(Customer c : customers){
            for(Item i : items){
              /*  if(c.getFavoriteCategory().equals(i.getCategory()) && c.getCredit() - i.getPrice() >= 0){
                    fw.write(c.getName() + ", " + "should purchase " + i.getName() + " for " + i.getPrice() + " credits");
*/

                if(c.getCredit() - i.getPrice() >= 0.0) {
                    max = i;
                    allmax.add(max);

                }

                Collections.sort(allmax, new Comparator<Item>() {
                    @Override
                    public int compare(Item o1, Item o2) {
                        return o1.getPrice().compareTo(o2.getPrice());
                    }
                }
                );
                Collections.reverse(allmax);

            } //item for

            Comparator cee = new Comparator<Item>() {
                @Override
                public int compare(Item o1, Item o2) {
                    return 0;
                }
            };



            if(!allmax.isEmpty()) {
                fw.write(c.getName() + ", " + allmax.get(0).getName() + ", "+ allmax.get(0).getPrice() + "\n");
            }

            } //customer for
        fw.close();
        }



        Runnable task = () -> {};



    }



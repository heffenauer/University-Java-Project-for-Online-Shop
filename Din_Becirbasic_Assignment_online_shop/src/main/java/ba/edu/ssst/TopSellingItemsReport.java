package ba.edu.ssst;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TopSellingItemsReport {

    public static void generate(Map<Item,Integer> items) throws IOException {
        FileWriter fileWriter = new FileWriter("TopSellingItemsReport.csv");
        List<Map.Entry<Item,Integer>> list = MyUtils.getLargest(items, items.size());

        fileWriter.write("Item Name, Quantity Sold \n");
        //sort items by quantity sold and write to file in descending order

        if (list.size()<10)
        {
          for(Map.Entry<Item,Integer> entry : list)
          {
            fileWriter.write(entry.getKey().getName()+", "+entry.getValue()+"\n");
          }
        }
        else
        {
          for(int i=0;i<10;i++)
          {
            fileWriter.write(list.get(i).getKey().getName()+", "+list.get(i).getValue()+"\n");
          }
        }



        fileWriter.close();




    }
}

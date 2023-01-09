package ba.edu.ssst;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CategorySalesReport {

        public static void generate(Map<String, Integer> itemCategory) throws IOException {

            FileWriter fileWriter = new FileWriter("CategorySalesReport.csv");

            //write total sales for each category
            fileWriter.write("Category, Total Sales \n");

            //sort the map by value and write to file in descending order of total sales for each category
            itemCategory.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).forEach(entry -> {
                        try {
                            fileWriter.write(entry.getKey() + ", " + entry.getValue() + "\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
            fileWriter.close();

        }
}

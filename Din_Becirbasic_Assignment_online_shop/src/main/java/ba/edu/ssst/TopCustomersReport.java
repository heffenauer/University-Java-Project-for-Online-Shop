package ba.edu.ssst;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TopCustomersReport {


    public static void generate(Map<Customer, Double> customerBill) throws IOException {

        FileWriter fileWriter = new FileWriter("TopCustomersReport.csv");
        List<Map.Entry<Customer,Double>> list = MyUtils.getLargest(customerBill, customerBill.size());
        //sort the list by value in descending order
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));


        fileWriter.write("Customer Name, Total Bill \n");
        //display customers by total bill in descending order and write to file

        if(list.size() < 10) {
        for (int i = 0; i < list.size(); i++) {
                fileWriter.write(list.get(i).getKey().getName() + ", " + list.get(i).getValue() + "\n");
            }
        } else {
            for (int i = 0; i < 10; i++) {
                fileWriter.write(list.get(i).getKey().getName() + ", " + list.get(i).getValue() + "\n");
            }

        }

        fileWriter.close();



    }
}

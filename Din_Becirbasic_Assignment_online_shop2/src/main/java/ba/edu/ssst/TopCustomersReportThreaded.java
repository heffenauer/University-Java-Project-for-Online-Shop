package ba.edu.ssst;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TopCustomersReportThreaded {

    public static void generate(Map<Customer, Double> customerBill) throws IOException, InterruptedException {

        FileWriter fw = new FileWriter("TopCustomersReportThreaded.csv");

        Runnable task = () -> {
            List<Map.Entry<Customer,Double>> list = MyUtils.getLargest(customerBill, customerBill.size());
            //sort the list by value in descending order
            list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

            try {
                fw.write("Customer Name, Total Bill \n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            //display customers by total bill in descending order and write to file
            if(list.size() < 10) {
                for (Map.Entry<Customer, Double> customerDoubleEntry : list) {
                    try {
                        fw.write(customerDoubleEntry.getKey().getName() + ", " + customerDoubleEntry.getValue() + "\n");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            } else {
                for (int i = 0; i < 10; i++) {
                    try {
                        fw.write(list.get(i).getKey().getName() + ", " + list.get(i).getValue() + "\n");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            try {
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable task2 = () -> {
            System.out.println("testing thread");
        };

        Thread thread = new Thread(task);
        thread.start();
        thread.join();

        Thread thread2 = new Thread(task2);
        thread2.start();
    }
}
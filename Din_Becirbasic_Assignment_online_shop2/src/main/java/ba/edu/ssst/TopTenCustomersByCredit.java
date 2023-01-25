package ba.edu.ssst;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

public class TopTenCustomersByCredit implements Runnable {

    ArrayList<Customer> customers;
    Integer start;
    Integer end;
    public TopTenCustomersByCredit(ArrayList<Customer> customers, Integer start, Integer end){
        this.customers = customers;
        this.start = start;
        this.end = end;
    }


    @Override
    public void run() {
        synchronized (customers) {
            for(int i = start; i<end ; i++){
                for(int j = i+1 ; j<=end ; j++){
                    if(customers.get(i).getCredit()<customers.get(j).getCredit()){
                        Customer temp1 = customers.get(i);
                        Customer temp2 = customers.get(j);
                        customers.set(i, temp2);
                        customers.set(j, temp1);
                    }}}}}
    public void start() throws IOException {
        synchronized (customers) {

            Comparator<Customer> sortCredit = new Comparator<Customer>() {
                @Override
                public int compare(Customer o1, Customer o2) {
                    return o2.getCredit().compareTo(o1.getCredit());
                }
            };
            Collections.sort(customers, sortCredit);
            FileWriter fw = new FileWriter("TopTenCustomersByCredit.csv");
            fw.write("Customer Name, Credit\n");
            if(customers.size() < 10) {
                for (Customer c : customers) {
                    fw.write(c.getName() + ", " + c.getCredit() + "\n");
                }
            } else {
                for (int i = 0; i < 10; i++) {
                    fw.write(customers.get(i).getName() + ", " + customers.get(i).getCredit() + "\n");
                }

            }
            fw.close();
        }
    }

    public static void generate(ArrayList<Customer> customers) throws IOException {
        TopTenCustomersByCredit thread = new TopTenCustomersByCredit(customers, 0, customers.size()/2);
        TopTenCustomersByCredit thread2 = new TopTenCustomersByCredit(customers, customers.size()/2, customers.size());
        thread.start();
        thread2.start();





    }


}

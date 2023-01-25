package ba.edu.ssst;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ThreadDef implements Runnable {

    ArrayList<Customer> customers;
    Integer start;
    Integer end;
    public ThreadDef(ArrayList<Customer> customers, Integer start, Integer end){
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
                    }
                }
            }
        }

    }


    public void start() throws IOException {
        synchronized (customers) {

                Comparator<Customer> sortCredit = new Comparator<Customer>() {
                    @Override
                    public int compare(Customer o1, Customer o2) {
                        return o1.getCredit().compareTo(o2.getCredit());
                    }
                };

                Collections.sort(customers, sortCredit);
                FileWriter fw = new FileWriter("TopTenCustomersByCredit.csv");
                for(Customer c : customers) {
                    fw.write(c.getName() + ", " + c.getCredit());
                }
                fw.close();




        }
    }


}

package ba.edu.ssst;

import java.util.ArrayList;

public class Customer {

    String name;



    String email;

    Integer credit;
    String favoriteCategory;
    ArrayList<Purchase> purchases = new ArrayList<>();




    public Customer(String name, String email, Integer credit, String favoriteCategory) {
        this.name = name;
        this.email = email;
        this.credit = credit;
        this.favoriteCategory = favoriteCategory;

    }





    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }

    public Integer getCredit() {
        return credit;
    }
    public String getFavoriteCategory() {
        return favoriteCategory;
    }
    public void setFavoriteCategory(String favoriteCategory) {
        this.favoriteCategory = favoriteCategory;
    }

    public ArrayList<Purchase> getPurchases() {
        return purchases;
    }
    public void addPurchase(Purchase purchase) {
        purchases.add(purchase);
    }

    @Override
    public String toString() {
        return getName() + " " + getEmail();
    }
}




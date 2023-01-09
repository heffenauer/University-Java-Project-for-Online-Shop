package ba.edu.ssst;

public class Item {


    String name;
    Double price;
    String category;
    Integer stock =0 ;
    public Item(String name, Double price, Integer quantity, String category) {
        this.name = name;
        this.price = price;
        this.stock = quantity;
        this.category = category;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public void setStock(Integer quantity) {
        this.stock = stock - quantity;
    }

    public Integer getStock() {
        return stock;
    }


    @Override
    public String toString() {
        return getName() + " " + getPrice() + " " + getStock() + " " + getCategory();
    }

} //end of Item class

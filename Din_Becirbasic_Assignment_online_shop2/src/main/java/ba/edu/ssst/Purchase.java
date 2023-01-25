package ba.edu.ssst;

public class Purchase {

    Item item;
    Integer quantity;

    public Purchase(Item item, Integer quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }
    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return getItem() + " " + getQuantity();
    }
}

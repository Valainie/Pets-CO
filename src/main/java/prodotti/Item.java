package prodotti;

import bean.PBean;

public class Item {
    private PBean product;
    private int quantity;

    public Item() {
    }

    public Item(PBean product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public PBean getProduct() {
        return product;
    }

    public void setProduct(PBean product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}


package controller.prodotti;

import bean.PBean;

import java.util.ArrayList;
import java.util.List;

public class Carrello {

    private List<PBean> products;

    public Carrello() {
        products = new ArrayList<PBean>();
    }

    public void addProduct(PBean product) {
        products.add(product);
    }

    public void deleteProduct(PBean product) {
        for(PBean prod : products) {
            if(prod.getCodice() == product.getCodice()) {
                products.remove(prod);
                break;
            }
        }
    }
    public List<PBean> getProducts() {
        return  products;
    }
}



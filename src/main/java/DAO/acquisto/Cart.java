package DAO.acquisto;

import bean.Bean;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Cart {
    private ArrayList<bean.Carrello> products;
    BigDecimal totale;
    BigDecimal ivaTotale;
    public Cart() {
        products = new ArrayList<bean.Carrello>();
        totale=new BigDecimal("0");
        ivaTotale=new BigDecimal("0");

    }

    public void addProduct(bean.Carrello bce) {
        products.add(bce);

        totale=totale.add(bce.getPrezzoTotale());

    }

    public BigDecimal getTotale()
    {
        ivaTotale.setScale(2, RoundingMode.UNNECESSARY);
        ivaTotale = totale.multiply(new BigDecimal("0.22"));
        System.out.println(ivaTotale);

        return totale.add(ivaTotale).setScale(2, RoundingMode.UNNECESSARY);
    }



    public void deleteProduct(bean.Carrello bce) {
        ArrayList<bean.Carrello> toRemove=new ArrayList<bean.Carrello>();
        for(bean.Carrello prod : products) {
            if(prod.getCodP() == bce.getCodP()) {
                toRemove.add(prod);

                totale=totale.subtract(prod.getPrezzoTotale());
            }

        }

        products.removeAll(toRemove);
    }

    public void setQuant(bean.Carrello bce, int quant)
    {
        bean.Carrello selected = null;

        for(bean.Carrello b: products)
        {
            if(bce.getCodP()==b.getCodP())
            {
                selected = b;
            }
        }

        totale=totale.subtract(BigDecimal.valueOf(selected.getProduct().getPrezzo()*selected.getQuantita()));
        //	oldquantita=selected.getQuantita();
        selected.setQuantita(selected.getQuantita()+quant);
        selected.setPrezzoTotale(BigDecimal.valueOf(selected.getProduct().getPrezzo()*selected.getQuantita()));
        totale=totale.add(BigDecimal.valueOf(selected.getProduct().getPrezzo()*selected.getQuantita()));
    }

    public void refresh(bean.Carrello bce, int quant)
    {
        for(bean.Carrello b: products)
            if(bce.getCodP()==b.getCodP())
            {
                totale=totale.subtract(BigDecimal.valueOf(b.getProduct().getPrezzo()*b.getQuantita()));
                b.setQuantita(quant);
                b.setPrezzoTotale(BigDecimal.valueOf(b.getProduct().getPrezzo()*b.getQuantita()));
                totale=totale.add(BigDecimal.valueOf(b.getProduct().getPrezzo()*b.getQuantita()));
            }
    }


    public ArrayList<bean.Carrello> getProducts() {
        return products;
    }

    public void printCart () {
        for(bean.Carrello bce : products) {
            System.out.println(bce.toString());
        }
    }

    public int cartCardinality()
    {
        int result = 0;

        for(bean.Carrello p: products)
        {
            result = result + p.getQuantita();
        }

        return result;
    }

    public boolean cartContains(bean.Carrello bce)
    {
        for(bean.Carrello p: products)
        {
            if(p.getCodP()==bce.getCodP())
                return true;
        }
        return false;
    }

    public String formatStatoProdotti()
    {
        int c=1;
        String format="[\n";
        for(bean.Carrello b : products)
        {
            if (c < products.size())
            {
                format = format + "\n\t{" + "\n"
                        + "\t\t\"" + "nomeProdotto" + "\" : \"" + b.getProduct().getNome() + "\",\n"
                        + "\t\t\"" + "prezzoProdotto" + "\" : \"" + b.getProduct().getPrezzo() + "\",\n"
                        + "\t\t\"" + "quantita" + "\" : \"" + b.getQuantita() + "\"\n"
                        + "\t},";
            }
            else
            {
                format = format + "\n\t{" + "\n"
                        + "\t\t\"" + "nomeProdotto" + "\" : \"" + b.getProduct().getNome() + "\",\n"
                        + "\t\t\"" + "prezzoProdotto" + "\" : \"" + b.getProduct().getPrezzo() + "\",\n"
                        + "\t\t\"" + "quantita" + "\" : \"" + b.getQuantita() + "\"\n"
                        + "\t}";
            }

            c++;
        }

        return format + "\n]";
    }


    public void addToCart(Bean doRetrieveByKey) {
    }
}



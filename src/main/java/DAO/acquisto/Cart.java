package DAO.acquisto;

import bean.Bean;
import bean.Carrello;

import java.io.Serializable;
import java.math.*;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;

public class Cart implements Serializable {
    private Collection<Carrello> products;
    BigDecimal totale;
    BigDecimal ivaTotale;
    public Cart() {
        products = new ArrayList<Carrello>();
        totale=new BigDecimal("0");
        ivaTotale=new BigDecimal("0");

    }

    public void addProduct(Carrello bce) {
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



    public void deleteProduct(Carrello bce) {
        Collection<Carrello> toRemove=new ArrayList<Carrello>();
        for(Carrello prod : products) {
            if(prod.getCodP() == bce.getCodP()) {
                toRemove.add(prod);

                totale=totale.subtract(prod.getPrezzoTotale());
            }

        }

        products.removeAll(toRemove);
    }

    public void setQuant(Carrello bce,int quant)
    {
        Carrello selected = null;

        for(Carrello b: products)
        {
            if(bce.getCodP()==b.getCodP())
            {
                selected = b;
            }
        }
        totale=totale.subtract(BigDecimal.valueOf(selected.getProduct().getPrezzo()*(selected.getQuantita())));
        selected.setQuantita(selected.getQuantita()+quant);
        selected.setPrezzoTotale(BigDecimal.valueOf(selected.getProduct().getPrezzo()*(selected.getQuantita())));

        totale=totale.add(BigDecimal.valueOf(selected.getProduct().getPrezzo()*(selected.getQuantita())));

    }

    public void refresh(Carrello bce,int quant)
    {
        for(Carrello b: products)
            if(bce.getCodP()==b.getCodP())
            {
                totale=totale.subtract(BigDecimal.valueOf(b.getProduct().getPrezzo()*(b.getQuantita())));
                b.setQuantita(quant);
                b.setPrezzoTotale(BigDecimal.valueOf(b.getProduct().getPrezzo()*(quant)));
                totale=totale.add(BigDecimal.valueOf(b.getProduct().getPrezzo()*(b.getQuantita())));
            }
    }


    public Collection<Carrello> getProducts() {
        return products;
    }

    public void printCart () {
        for(Carrello bce : products) {
            System.out.println(bce.toString());
        }
    }

    public int cartCardinality()
    {
        int result = 0;

        for(Carrello p: products)
        {
            result = result + p.getQuantita();
        }

        return result;
    }

    public boolean cartContains(Carrello bce)
    {
        for(Carrello p: products)
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
        for(Carrello b : products)
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

    public Object getIva() {
        // TODO Auto-generated method stub
        return ivaTotale.setScale(2, RoundingMode.UNNECESSARY);
    }

}
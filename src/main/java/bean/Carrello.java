package bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class Carrello extends Bean implements Serializable {
    private static final long serialVersionUID = 1L;
    PBean product;
    int quantita;
    BigDecimal prezzoTotale;

    public BigDecimal getPrezzoTotale() {
        return prezzoTotale;
    }

    public void setPrezzoTotale(BigDecimal prezzoTotale) {
        this.prezzoTotale = prezzoTotale;
    }

    public Carrello(PBean bp, int q)
    {
        quantita=q;
        product=bp;
        prezzoTotale= BigDecimal.valueOf(bp.getPrezzo()*q);
    }

    public Carrello(PBean bp)
    {
        product=bp;
    }

    public PBean getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "BeanCartEntry [product=" + product + ", quantita=" + quantita + ", prezzoTotale=" + prezzoTotale + "]";
    }
    public void setProduct(PBean product) {
        this.product = product;
    }
    public int getQuantita() {
        return quantita;
    }
    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public int getCodP()
    {
        return product.getCodice();
    }

}


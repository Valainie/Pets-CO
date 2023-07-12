package bean;

import java.io.Serializable;
import java.sql.Date;

public class MetodoDiPagamentoBean extends Bean implements Serializable {

    String circuito;
    long numCarta;
    int cvv;
    Date scadenza;
    String pin;


    public MetodoDiPagamentoBean(String circuito, long numCarta, int cvv,Date scadenza, String pin) {
        this.circuito = circuito;
        this.numCarta = numCarta;
        this.cvv = cvv;
        this.scadenza = scadenza;
        this.pin=pin;
    }

    public MetodoDiPagamentoBean() {

    }

    public String getCircuito() {
        return circuito;
    }

    public void setCircuito(String circuito) {
        this.circuito = circuito;
    }

    public Long getNumCarta() {
        return numCarta;
    }

    public void setNumCarta(int numCarta) {
        this.numCarta = numCarta;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public Date getScadenza() {
        return scadenza;
    }

    public void setScadenza(Date scadenza) {
        this.scadenza = scadenza;
    }

    @Override
    public String toString() {
        return "MetodoDiPagamentoBean{" +
                "circuito='" + circuito + '\'' +
                ", numCarta=" + numCarta +
                ", cvv=" + cvv +
                ", scadenza='" + scadenza + '\'' +
                '}';
    }


    public void setNumCarta(long numCarta) {
        this.numCarta = numCarta;
    }

    public String getPin() {
        return pin;
    }

    public void setPin() {
    }

    public Object getSecureCode() {
        return null;
    }
}

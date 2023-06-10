package bean;

import java.io.Serializable;
import java.math.BigInteger;

public class MetodoDiPagamentoBean extends Bean implements Serializable {

    String circuito;
    int numCarta;
    int cvv;
    String scadenza;
    String pin;


    public MetodoDiPagamentoBean(String circuito, int numCarta, int cvv, String scadenza) {
        this.circuito = circuito;
        this.numCarta = numCarta;
        this.cvv = cvv;
        this.scadenza = scadenza;
    }

    public MetodoDiPagamentoBean() {

    }

    public String getCircuito() {
        return circuito;
    }

    public void setCircuito(String circuito) {
        this.circuito = circuito;
    }

    public int getNumCarta() {
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

    public String getScadenza() {
        return scadenza;
    }

    public void setScadenza(String scadenza) {
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



    public void add() {
    }

    public String getPin() {

        return pin;
    }

    public void setPin() {
        String pin = Long.toString(numCarta);
        pin = pin.substring(pin.length() - 4);
    }
}

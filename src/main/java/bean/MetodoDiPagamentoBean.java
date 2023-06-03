package bean;

import java.io.Serializable;
import java.math.BigInteger;

public class MetodoDiPagamentoBean implements Serializable {

    String circuito;
    BigInteger numCarta;
    int cvv;
    String scadenza;

    public MetodoDiPagamentoBean(String circuito, BigInteger numCarta, int cvv, String scadenza) {
        this.circuito = circuito;
        this.numCarta = numCarta;
        this.cvv = cvv;
        this.scadenza = scadenza;
    }

    public String getCircuito() {
        return circuito;
    }

    public void setCircuito(String circuito) {
        this.circuito = circuito;
    }

    public BigInteger getNumCarta() {
        return numCarta;
    }

    public void setNumCarta(BigInteger numCarta) {
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
}

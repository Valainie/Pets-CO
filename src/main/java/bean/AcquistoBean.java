package bean;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;

public class AcquistoBean implements Serializable {
    private static final long serialVersionUID = 1L;


    LocalDate dataSpedizione, dataOrdine;
    int codiceAcquisto;
    String indirizzoSpedizione;
    float importo;
    String statoProdotti;
    BigInteger metodo;
    int codiceProdotto;

    public AcquistoBean(LocalDate dataSpedizione, LocalDate dataOrdine, int codiceAcquisto, String indirizzoSpedizione, float importo, String statoProdotti, BigInteger metodo, int codiceProdotto) {
        this.dataSpedizione = dataSpedizione;
        this.dataOrdine = dataOrdine;
        this.codiceAcquisto = codiceAcquisto;
        this.indirizzoSpedizione = indirizzoSpedizione;
        this.importo = importo;
        this.statoProdotti = statoProdotti;
        this.metodo = metodo;
        this.codiceProdotto = codiceProdotto;
    }

    public LocalDate getDataSpedizione() {
        return dataSpedizione;
    }

    public void setDataSpedizione(LocalDate dataSpedizione) {
        this.dataSpedizione = dataSpedizione;
    }

    public LocalDate getDataOrdine() {
        return dataOrdine;
    }

    public void setDataOrdine(LocalDate dataOrdine) {
        this.dataOrdine = dataOrdine;
    }

    public int getCodiceAcquisto() {
        return codiceAcquisto;
    }

    public void setCodiceAcquisto(int codiceAcquisto) {
        this.codiceAcquisto = codiceAcquisto;
    }

    public String getIndirizzoSpedizione() {
        return indirizzoSpedizione;
    }

    public void setIndirizzoSpedizione(String indirizzoSpedizione) {
        this.indirizzoSpedizione = indirizzoSpedizione;
    }

    public float getImporto() {
        return importo;
    }

    public void setImporto(float importo) {
        this.importo = importo;
    }

    public String getStatoProdotti() {
        return statoProdotti;
    }

    public void setStatoProdotti(String statoProdotti) {
        this.statoProdotti = statoProdotti;
    }

    public BigInteger getMetodo() {
        return metodo;
    }

    public void setMetodo(BigInteger metodo) {
        this.metodo = metodo;
    }

    public int getCodiceProdotto() {
        return codiceProdotto;
    }

    public void setCodiceProdotto(int codiceProdotto) {
        this.codiceProdotto = codiceProdotto;
    }
}



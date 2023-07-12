package bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Iterator;

public class AcquistoBean extends Bean implements Serializable {
    private static final long serialVersionUID = 1L;


    LocalDate dataSpedizione;
    LocalDate dataOrdine;
    int codiceAcquisto;
    String indirizzoSpedizione;
    BigDecimal importo;
    String statoProdotti;
    Long metodo;
    int codiceProdotto;
    String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AcquistoBean(LocalDate dataSpedizione, LocalDate dataOrdine, int codiceAcquisto, String indirizzoSpedizione, BigDecimal importo, String statoProdotti, Long metodo, int codiceProdotto) {
        this.dataSpedizione = dataSpedizione;
        this.dataOrdine = dataOrdine;
        this.codiceAcquisto = codiceAcquisto;
        this.indirizzoSpedizione = indirizzoSpedizione;
        this.importo = importo;
        this.statoProdotti = statoProdotti;
        this.metodo = metodo;
        this.codiceProdotto = codiceProdotto;
    }

    public AcquistoBean() {

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

    public BigDecimal getImporto() {
        return importo;
    }

    public void setImporto(BigDecimal importo) {
        this.importo = importo;
    }

    public String getStatoProdotti() {
        return statoProdotti;
    }

    public void setStatoProdotti(String statoProdotti) {
        this.statoProdotti = statoProdotti;
    }

    public long getMetodo() {
        return metodo;
    }

    public void setMetodo(Long metodo) {
        this.metodo =metodo;
    }

    public int getCodiceProdotto() {
        return codiceProdotto;
    }

    public void setCodiceProdotto(int codiceProdotto) {
        this.codiceProdotto = codiceProdotto;
    }



    public void setSecureCode() {
        MetodoDiPagamentoBean b = new MetodoDiPagamentoBean();
        b.getSecureCode();

    }

    public void setUsername() {
        UserBean u = new UserBean();
        u.getUsername();
    }



    @Override
    public String toString() {
        return "AcquistoBean{" +
                "dataSpedizione=" + dataSpedizione +
                ", dataOrdine=" + dataOrdine +
                ", codiceAcquisto=" + codiceAcquisto +
                ", indirizzoSpedizione='" + indirizzoSpedizione + '\'' +
                ", importo=" + importo +
                ", statoProdotti='" + statoProdotti + '\'' +
                ", metodo=" + metodo +
                ", codiceProdotto=" + codiceProdotto +
                '}';
    }


}



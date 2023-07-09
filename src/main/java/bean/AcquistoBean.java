package bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Iterator;

public class AcquistoBean extends Bean implements Serializable, Collection<Bean> {
    private static final long serialVersionUID = 1L;


    LocalDate dataSpedizione, dataOrdine;
    int codiceAcquisto;
    String indirizzoSpedizione;
    BigDecimal importo;
    String statoProdotti;
    Long metodo;
    int codiceProdotto;

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

    @Override
    public String toString() {
        return null;
    }

    public void setSecureCode() {
    }

    public void setUsername(String username) {
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Bean> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Bean bean) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Bean> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}



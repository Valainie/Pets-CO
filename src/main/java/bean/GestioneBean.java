package bean;

import java.io.Serializable;

public class GestioneBean implements Serializable {
    private static final long serialVersionUID = 1L;
    String cfAdmin;
    int codiceProdotto;

    public GestioneBean(String cfAdmin, int codiceProdotto) {
        this.cfAdmin = cfAdmin;
        this.codiceProdotto = codiceProdotto;
    }

    public String getCfAdmin() {
        return cfAdmin;
    }

    public void setCfAdmin(String cfAdmin) {
        this.cfAdmin = cfAdmin;
    }

    public int getCodiceProdotto() {
        return codiceProdotto;
    }

    public void setCodiceProdotto(int codiceProdotto) {
        this.codiceProdotto = codiceProdotto;
    }

    @Override
    public String toString() {
        return "GestioneBean{" +
                "cfAdmin='" + cfAdmin + '\'' +
                ", codiceProdotto=" + codiceProdotto +
                '}';
    }
}

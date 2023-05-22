package bean;

import java.io.Serializable;

public class RecensioneBean implements Serializable {
    private static final long serialVersionUID = 1L;

    String componenti;
    int zampette;
    String cfCliente;
    int codiceProdotto;

    public RecensioneBean(String componenti, int zampette, String cfCliente, int codiceProdotto) {
        this.componenti = componenti;
        this.zampette = zampette;
        this.cfCliente = cfCliente;
        this.codiceProdotto = codiceProdotto;
    }

    public String getComponenti() {
        return componenti;
    }

    public void setComponenti(String componenti) {
        this.componenti = componenti;
    }

    public int getZampette() {
        return zampette;
    }

    public void setZampette(int zampette) {
        this.zampette = zampette;
    }

    public String getCfCliente() {
        return cfCliente;
    }

    public void setCfCliente(String cfCliente) {
        this.cfCliente = cfCliente;
    }

    public int getCodiceProdotto() {
        return codiceProdotto;
    }

    public void setCodiceProdotto(int codiceProdotto) {
        this.codiceProdotto = codiceProdotto;
    }

    @Override
    public String toString() {
        return "RecensioneBean{" +
                "componenti='" + componenti + '\'' +
                ", zampette=" + zampette +
                ", cfCliente='" + cfCliente + '\'' +
                ", codiceProdotto=" + codiceProdotto +
                '}';
    }
}


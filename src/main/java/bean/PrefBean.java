package bean;

import java.io.Serializable;

public class PrefBean implements Serializable {
    private static final long serialVersionUID = 1L;

    String cfCliente;
    int codiceProdotto;

    public PrefBean(String cfCliente, int codiceProdotto) {
        this.cfCliente = cfCliente;
        this.codiceProdotto = codiceProdotto;
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
        return "PrefBean{" +
                "cfCliente='" + cfCliente + '\'' +
                ", codiceProdotto=" + codiceProdotto +
                '}';
    }
}

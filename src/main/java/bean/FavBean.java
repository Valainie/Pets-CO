package bean;

import java.io.Serializable;

public class FavBean implements Serializable {

    String usernameCliente;
    int codiceProdotto;

    public FavBean(String usernameCliente, int codiceProdotto) {
        this.usernameCliente = usernameCliente;
        this.codiceProdotto = codiceProdotto;
    }

    public String getUsernameCliente() {
        return usernameCliente;
    }

    public void setUsernameCliente(String usernameCliente) {
        this.usernameCliente = usernameCliente;
    }

    public int getCodiceProdotto() {
        return codiceProdotto;
    }

    public void setCodiceProdotto(int codiceProdotto) {
        this.codiceProdotto = codiceProdotto;
    }

    @Override
    public String toString() {
        return "FavBean{" +
                "usernameCliente='" + usernameCliente + '\'' +
                ", codiceProdotto=" + codiceProdotto +
                '}';
    }
}

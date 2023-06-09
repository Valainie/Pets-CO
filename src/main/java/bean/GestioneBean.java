package bean;

import java.io.Serializable;

public class GestioneBean extends Bean implements Serializable {

    String userAdmin;
    int codiceProdotto;

    public GestioneBean(String usernameAdmin, int codiceProdotto) {
        this.userAdmin = usernameAdmin;
        this.codiceProdotto = codiceProdotto;
    }

    @Override
    public String toString() {
        return "GestioneBean{" +
                "userAdmin='" + userAdmin + '\'' +
                ", codiceProdotto=" + codiceProdotto +
                '}';
    }
}

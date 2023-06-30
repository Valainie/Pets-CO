package bean;

import java.io.Serializable;

public class EffettuaBean extends Bean implements Serializable {
    String username;
    int codiceAcquisto;

    @Override
    public String toString() {
        return "EffettuaBean{}";
    }

    public EffettuaBean(String username, int codiceAcquisto) {
        this.username = username;
        this.codiceAcquisto = codiceAcquisto;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCodiceAcquisto() {
        return codiceAcquisto;
    }

    public void setCodiceAcquisto(int codiceAcquisto) {
        this.codiceAcquisto = codiceAcquisto;
    }


}

package bean;

import java.io.Serializable;

public class RecensioneBean implements Serializable {

    String commenti;
    String username;
    int zampette;
    int codiceProdotto;

    //Generate

    public RecensioneBean(String commenti, String username, int zampette, int codiceProdotto) {
        this.commenti = commenti;
        this.username = username;
        this.zampette = zampette;
        this.codiceProdotto = codiceProdotto;
    }

    public String getCommenti() {
        return commenti;
    }

    public void setCommenti(String commenti) {
        this.commenti = commenti;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getZampette() {
        return zampette;
    }

    public void setZampette(int zampette) {
        this.zampette = zampette;
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
                "commenti='" + commenti + '\'' +
                ", zampette=" + zampette +
                ", codiceProdotto=" + codiceProdotto +
                '}';
    }
}

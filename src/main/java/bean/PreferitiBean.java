package bean;

import java.io.Serializable;

public class PreferitiBean extends Bean implements Serializable {
    @Override
    public String toString() {
        return null;
    }

    String username;
    int codiceProdotto;

    public PreferitiBean(String username, int codiceProdotto) {
        this.username = username;
        this.codiceProdotto = codiceProdotto;
    }

    public String getUsername() {
        return "PreferitiBean{" +
                "username='" + username + '\'' +
                ", codiceProdotto=" + codiceProdotto +
                '}';
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public int getCodiceProdotto() {
        return codiceProdotto;
    }

    public void setCodiceProdotto(int codiceProdotto) {
        this.codiceProdotto = codiceProdotto;
    }

}

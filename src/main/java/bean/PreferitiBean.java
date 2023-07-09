package bean;

import java.io.Serializable;

public class PreferitiBean extends Bean implements Serializable {
    public PreferitiBean() {

    }

    @Override
    public String toString() {
        return "PreferitiBean{" +
                "username='" + username + '\'' +
                ", codiceProdotto=" + codiceProdotto +
                '}';    }

    String username;
    int codiceProdotto;

    public PreferitiBean(String username, int codiceProdotto) {
        this.username = username;
        this.codiceProdotto = codiceProdotto;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public int getCodiceProdotto() {
        return codiceProdotto;
    }

    public String getUsername() {
        return username;
    }

    public void setCodiceProdotto(int codiceProdotto) {
        this.codiceProdotto = codiceProdotto;
    }

}

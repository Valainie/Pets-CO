package bean;

import java.io.Serializable;

public class PreferitiBean  extends Bean implements Serializable{
    String username;
    int codiceProdotto;

    public PreferitiBean(String username, int codiceProdotto) {
        this.username = username;
        this.codiceProdotto = codiceProdotto;
    }

    public PreferitiBean() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        UserBean u= new UserBean();
        this.username=u.getUsername();
    }

    public int getCodiceProdotto() {
        PBean p = new PBean();
        this.codiceProdotto = p.getCodice();
        return codiceProdotto;
    }

    public void setCodiceProdotto(int codiceProdotto) {
        PBean p = new PBean();
        this.codiceProdotto=p.getCodice();

    }

    @Override
    public String toString() {
        return "PreferitiBean{" +
                "username='" + username + '\'' +
                ", CodiceProdotto=" + codiceProdotto +
                '}';
    }
}

package bean;

import java.io.Serializable;

public class NavigazioneBean extends Bean implements Serializable {
    private static final long serialVersionUID = 1L;
    String tag;
    int codiceProdotto;

    public NavigazioneBean(String tag, int codiceProdotto) {
        this.tag = tag;
        this.codiceProdotto = codiceProdotto;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getCodiceProdotto() {
        return codiceProdotto;
    }

    public void setCodiceProdotto(int codiceProdotto) {
        this.codiceProdotto = codiceProdotto;
    }

    @Override
    public String toString() {
        return "NavigazioneBean{" +
                "tag='" + tag + '\'' +
                ", codiceProdotto=" + codiceProdotto +
                '}';
    }
}

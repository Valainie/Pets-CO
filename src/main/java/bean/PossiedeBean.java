package bean;

import java.io.Serializable;

public class PossiedeBean extends Bean implements Serializable {
    String username;
    int numCarta;


    public PossiedeBean(String username, int numCarta) {
        this.username = username;
        this.numCarta = numCarta;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getNumCarta() {
        return numCarta;
    }

    public void setNumCarta(int numCarta) {
        this.numCarta = numCarta;
    }

    @Override
    public String toString() {
        return "PossiedeBean{" +
                "username='" + username + '\'' +
                ", numCarta=" + numCarta +
                '}';
    }
}

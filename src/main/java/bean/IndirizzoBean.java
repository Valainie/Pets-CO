package bean;

import java.io.Serializable;

public class IndirizzoBean extends Bean implements Serializable {
    int codiceIndirizzo;
    String città;
    String via;
    int civico;
    int cap;

    public IndirizzoBean(int codiceIndirizzo, String città, String via, int civico, int cap) {
        this.codiceIndirizzo = codiceIndirizzo;
        this.città = città;
        this.via = via;
        this.civico = civico;
        this.cap = cap;
    }

    public IndirizzoBean() {
        
    }

    public int getCodiceIndirizzo() {
        return codiceIndirizzo;
    }

    public void setCodiceIndirizzo(int codiceIndirizzo) {
        this.codiceIndirizzo = codiceIndirizzo;
    }

    public String getCittà() {
        return città;
    }

    public void setCittà(String città) {
        this.città = città;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public int getCivico() {
        return civico;
    }

    public void setCivico(int civico) {
        this.civico = civico;
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    @Override
    public String toString() {
        return "IndirizzoBean{" +
                "codiceIndirizzo=" + codiceIndirizzo +
                ", città='" + città + '\'' +
                ", via='" + via + '\'' +
                ", civico=" + civico +
                ", cap=" + cap +
                '}';
    }
}

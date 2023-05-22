package bean;

import javafx.scene.chart.XYChart;

import java.io.Serializable;

public class AcquistoBean implements Serializable {
    private static final long serialVersionUID = 1L;
local
    String codice;
    int quantità;
    float prezzoTot;
    String cfCliente;
    int codiceProdotto;

    public AcquistoBean(XYChart.Data data, String codice, int quantità, float prezzoTot, String cfCliente, int codiceProdotto) {
        this.data = data;
        this.codice = codice;
        this.quantità = quantità;
        this.prezzoTot = prezzoTot;
        this.cfCliente = cfCliente;
        this.codiceProdotto = codiceProdotto;
    }

    @Override
    public String toString() {
        return "AcquistoBean{" +
                "data=" + data +
                ", codice='" + codice + '\'' +
                ", quantità=" + quantità +
                ", prezzoTot=" + prezzoTot +
                ", cfCliente='" + cfCliente + '\'' +
                ", codiceProdotto=" + codiceProdotto +
                '}';
    }



    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public int getQuantità() {
        return quantità;
    }

    public void setQuantità(int quantità) {
        this.quantità = quantità;
    }

    public float getPrezzoTot() {
        return prezzoTot;
    }

    public void setPrezzoTot(float prezzoTot) {
        this.prezzoTot = prezzoTot;
    }

    public String getCfCliente() {
        return cfCliente;
    }

    public void setCfCliente(String cfCliente) {
        this.cfCliente = cfCliente;
    }

    public int getCodiceProdotto() {
        return codiceProdotto;
    }

    public void setCodiceProdotto(int codiceProdotto) {
        this.codiceProdotto = codiceProdotto;
    }
}

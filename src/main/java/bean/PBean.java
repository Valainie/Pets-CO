package bean;

public class PBean {
    private static final long serialVersionUID = 1L;

    int codice;
    String tipo;
    String descrizioneBreve;
    String descrizioneLunga;
    String immagine;
    float prezzo;

    @Override
    public String toString() {
        return "PBean{" +
                "codice=" + codice +
                ", tipo='" + tipo + '\'' +
                ", descrizioneBreve='" + descrizioneBreve + '\'' +
                ", descrizioneLunga='" + descrizioneLunga + '\'' +
                ", immagine='" + immagine + '\'' +
                ", prezzo=" + prezzo +
                '}';
    }

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescrizioneBreve() {
        return descrizioneBreve;
    }

    public void setDescrizioneBreve(String descrizioneBreve) {
        this.descrizioneBreve = descrizioneBreve;
    }

    public String getDescrizioneLunga() {
        return descrizioneLunga;
    }

    public void setDescrizioneLunga(String descrizioneLunga) {
        this.descrizioneLunga = descrizioneLunga;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }
}

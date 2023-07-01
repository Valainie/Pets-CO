package bean;

import java.io.Serializable;

public class PBean  extends Bean implements Serializable {
    private static final long serialVersionUID = 1L;

    int codice;
    String categoria;
    String Immagine;
    String nome;
    int disponibilita;
    float prezzo;
    String descrizioneBreve;
    String descrizioneLunga;
    boolean novita;
    boolean offerta;
    
    public PBean(int codice,String categoria, String immagine, String nome, int disponibilita, float prezzo, String descrizioneBreve, String descrizioneLunga, int novita, int offerta) {
        this.codice = codice;
        this.categoria=categoria;
        Immagine = immagine;
        this.nome = nome;
        this.disponibilita = disponibilita;
        this.prezzo = prezzo;
        this.descrizioneBreve = descrizioneBreve;
        this.descrizioneLunga = descrizioneLunga;
        novita = novita;
        offerta = offerta;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isNovita() {
        return novita;
    }

    public boolean isOfferta() {
        return offerta;
    }

    public PBean() {

    }

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public String getImmagine() {
        return Immagine;
    }

    public void setImmagine(String immagine) {
        Immagine = immagine;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDisponibilita() {
        return disponibilita;
    }

    public void setDisponibilita(int disponibilita) {
        this.disponibilita = disponibilita;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
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

    public boolean getNovita() {
        return novita;
    }

    public void setNovita(boolean novita) {
        this.novita = novita;
    }

    public boolean getOfferta() {
        return offerta;
    }

    public void setOfferta(boolean offerta) {
        this.offerta = offerta;
    }

    @Override
    public String toString() {
        return "PBean{" +
                "codice=" + codice +
                ", Immagine='" + Immagine + '\'' +
                ", nome='" + nome + '\'' +
                ", disponibilita=" + disponibilita +
                ", prezzo=" + prezzo +
                ", descrizioneBreve='" + descrizioneBreve + '\'' +
                ", descrizioneLunga='" + descrizioneLunga + '\'' +
                ", novita=" + novita +
                ", offerta=" + offerta +
                '}';
    }

}
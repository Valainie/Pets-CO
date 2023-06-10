package bean;

import java.io.Serializable;

public class AdminBean extends Bean implements Serializable {
    String recapito;
    String username;
    String password;
    String nome;
    String cognome;

    public AdminBean(String recapito, String username, String password, String nome, String cognome) {
        this.recapito = "";
        this.username = "";
        this.password = "";
        this.nome ="";
        this.cognome = "";
    }

    public AdminBean() {

    }

    public String getRecapito() {
        return recapito;
    }

    public void setRecapito(String recapito) {
        this.recapito = recapito;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    @Override
    public String toString() {
        return "AdminBean{" +
                "recapito='" + recapito + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }
}
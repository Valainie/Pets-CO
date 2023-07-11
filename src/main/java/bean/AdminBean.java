package bean;

import java.io.Serializable;

public class AdminBean extends Bean implements Serializable {
    String email;
    String username;
    String password;
    String nome;
    String cognome;

    public AdminBean(String email, String username, String password, String nome, String cognome) {
        this.email = "";
        this.username = "";
        this.password = "";
        this.nome ="";
        this.cognome = "";
    }

    public AdminBean() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String recapito) {
        this.email = recapito;
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
                "recapito='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }
}
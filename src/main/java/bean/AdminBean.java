package bean;

import java.io.Serializable;

public class AdminBean implements Serializable {
    private static final long serialVersionUID = 1L;
    String cf;
    String username;
    String password;
    String nome;
    String cognome;

    public AdminBean() {
        cf = "";
        username = "";
        password = "";
        nome = "";
        cognome = "";
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
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
                "cf='" + cf + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }
}


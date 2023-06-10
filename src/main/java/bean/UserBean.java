package bean;

import java.io.Serializable;

public class UserBean extends Bean implements Serializable {
    private static final long serialVersionUID = 1L;

    String cf;
    String username;
    String password;
    String nome;
    String cognome;
    int tel;
    String email;
    String dettagli;
    private Object cartaPred;

    public UserBean() {
    }

    public UserBean(String cf, String username, String password, String nome, String cognome, int tel, String email, String dettagli) {
        this.cf = cf;
        this.username = username;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
        this.tel = tel;
        this.email = email;
        this.dettagli = dettagli;
        cartaPred=99999;

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

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDettagli() {
        return dettagli;
    }

    public void setDettagli(String dettagli) {
        this.dettagli = dettagli;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "cf='" + cf + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", tel=" + tel +
                ", email='" + email + '\'' +
                ", dettagli='" + dettagli + '\'' +
                '}';
    }

    public boolean valid = false;

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean newValid) {
        valid = newValid;
    }

    public long getCartaPred() {
        this.cartaPred = cartaPred;
        return 0;
    }

}


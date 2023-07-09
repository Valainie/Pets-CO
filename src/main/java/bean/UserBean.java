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
    private Object cartaPred;

    public UserBean() {
    }

    public UserBean(String cf, String username, String password, String nome, String cognome, int tel, String email, int cartaPred) {
        this.cf = cf;
        this.username = username;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
        this.tel = tel;
        this.email = email;
        cartaPred=99999;

    }

    public void setCartaPred(Object cartaPred) {
        this.cartaPred = cartaPred;
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
                ", Carta='" + cartaPred + '\'' +
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
        return 0;
    }

    public void setCartaPred(String dettagli) {
    }
}


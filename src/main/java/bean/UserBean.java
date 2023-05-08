package bean;

    public class UserBean {

        private String username;
        private String password;
        private String email;
        private String nome;
        private String cognome;
        private int telefono;
        private int fax;
        private int civico;
        private String via;
        private int cap;
        private String dettagli;

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public String getEmail() {
            return email;
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

        public int getTelefono() {
            return telefono;
        }

        public void setTelefono(int telefono) {
            this.telefono = telefono;
        }

        public int getFax() {
            return fax;
        }

        public void setFax(int fax) {
            this.fax = fax;
        }

        public int getCivico() {
            return civico;
        }

        public void setCivico(int civico) {
            this.civico = civico;
        }

        public String getVia() {
            return via;
        }

        public void setVia(String via) {
            this.via = via;
        }

        public int getCap() {
            return cap;
        }

        public void setCap(int cap) {
            this.cap = cap;
        }

        public String getDettagli() {
            return dettagli;
        }

        public void setDettagli(String dettagli) {
            this.dettagli = dettagli;
        }

        public boolean valid = false;

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail(String email) {
            return this.email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword(String password) {
            return this.password;
        }

        public void setPassword(String newPassword) {
            password = newPassword;
        }


        public String getUsername(String username) {
            return this.username;
        }

        public void setUserName(String newUsername) {
            username = newUsername;
        }


        public boolean isValid() {
            return valid;
        }

        public void setValid(boolean newValid) {
            valid = newValid;
        }
    }

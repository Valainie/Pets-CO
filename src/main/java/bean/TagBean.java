package bean;

public class TagBean {
    private static final long serialVersionUID = 1L;
    String nome;

    public TagBean(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "TagBean{" +
                "nome='" + nome + '\'' +
                '}';
    }
}

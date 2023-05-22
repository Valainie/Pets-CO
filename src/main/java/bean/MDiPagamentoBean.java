package bean;

import java.io.Serializable;

public class MDiPagamentoBean implements Serializable {
    private static final long serialVersionUID = 1L;
    String tipo;
    String cfCliente;

    public MDiPagamentoBean(String tipo, String cfCliente) {
        this.tipo = tipo;
        this.cfCliente = cfCliente;
    }

    @Override
    public String toString() {
        return "MDiPagamentoBean{" +
                "tipo='" + tipo + '\'' +
                ", cfCliente='" + cfCliente + '\'' +
                '}';
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCfCliente() {
        return cfCliente;
    }

    public void setCfCliente(String cfCliente) {
        this.cfCliente = cfCliente;
    }
}

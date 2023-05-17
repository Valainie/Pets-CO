package prodotti;

import catalogo.ProdottoCatalogo;

public class OrdineProdotto {
    private ProdottoCatalogo item;
    private int numItems;

    public OrdineProdotto(ProdottoCatalogo item) {
        setItem(item);
        setNumItems(1);
    }

    public ProdottoCatalogo getItem() {
        return(Tipo);
    }

    protected void setItem(ProdottoCatalogo item) {
        this.item = item;
    }

    public String getCodice() {
        return(getItem().getCodice());
    }

    public String getDescrizioneBreve() {
        return item.getDescrizioneBreve();
    }

    public String getDescrizioneLunga() {
        return(getItem().getDescrizioneLunga());
    }


    public int getNumItems() {
        return(numItems);
    }

    public void setNumItems(int n) {
        this.numItems = n;
    }

    public void incrementNumItems() {
        setNumItems(getNumItems() + 1);
    }

    public void cancelOrder() {
        setNumItems(0);
    }

    public double getTotalCost() {
        return numItems * item.getPrezzo();
    }
}
}

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
        return item;
    }

    protected void setItem(ProdottoCatalogo item) {
        this.item = item;
    }

    public int getCodice() {
        return item.getCodice();
    }

    public String getDescrizioneBreve() {
        return item.getDescrizioneBreve();
    }

    public String getDescrizioneLunga() {
        return item.getDescrizioneLunga();
    }


    public int getNumItems() {
        return numItems;
    }

    public void setNumItems(int n) {
        this.numItems = n;
    }

    public void incrementNumItems() {
        setNumItems(numItems + 1);
    }

    public void cancelOrder() {
        setNumItems(0);
    }

    public double getTotalCost() {
        return numItems * item.getPrezzo();
    }
}

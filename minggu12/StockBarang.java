public class StockBarang <T> {
    T StockBarang;
    T NamaBarang;
    
    public T getStockBarang(){
        return StockBarang  ;
    }
    public void setStockBarang ( T StockBarang ){
    this.StockBarang = StockBarang;
    }
    public void setstb ( T NamaBarang ){
        this.NamaBarang = NamaBarang;
        System.out.println("Beras");
    }

    public T getNamaBarang() {
        return NamaBarang;
    }
    
}

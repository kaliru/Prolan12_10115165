public class Admin extends Gudang {
    String namaAdmin;
    int idAdmin;
   
    Admin (){
        namaAdmin="harlin";
        idAdmin=10115165;
    }

    public String getNamaAdmin() {
        return namaAdmin;
    }

    public void setNamaAdmin(String namaAdmin) {
        this.namaAdmin = namaAdmin;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }
    
    public void barangMasuk(){
        System.out.println("Gula");
        System.out.println("17 Maret 2017");
        System.out.println("100 Krg");
    }

    public void barangKeluar(){
        System.out.println("Gula");
        System.out.println("20 Maret 2017");
        System.out.println("77 Krg");
    }

    @Override
    public void report() {
        super.report(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
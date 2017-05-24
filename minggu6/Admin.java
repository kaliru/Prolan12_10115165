public class Admin extends Gudang {
    String namaAdmin;
    int idAdmin;
  
    //konstruktor Kelas Admin      
    Admin (){
        namaAdmin="harlin";
        idAdmin=10115165;
    }
    //method Barang Masuk
    public void barangMasuk(){
        System.out.println("Gula");
        System.out.println("17 Maret 2017");
        System.out.println("100 Krg");
    }
   //method Barang Keluar
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
public class Gudang {
    
    //method Report
    public void report (){
        System.out.println("Penjualan bulan maret 100 Ton");
    
    }
           
    
    
    
	public static void main (String[] args){
	 Admin Adm = new Admin();
         Karyawan Kar = new Karyawan();
         //Memanggil Method
            System.out.println("Barang Masuk : ");
            Adm.barangMasuk();
            System.out.println("-----------------------");
            System.out.println("Barang Keluar : ");
            Adm.barangKeluar();
            System.out.println("-----------------------");
            System.out.println("Kuli Barang");
            Kar.ambilBarang();
            System.out.println("-----------------------");
            System.out.println("laporan Maret");
            Adm.report();
            System.out.println("-----------------------");
    }
}

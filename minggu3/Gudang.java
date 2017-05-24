public class Gudang {
	public static void main (String[] args){
	 Admin Adm = new Admin();
         Karyawan Kar = new Karyawan();
         //Memanggil Method
            System.out.println("Barang Masuk : ");
            Adm.barangMasuk();
            System.out.println("Barang Keluar : ");
            Adm.barangKeluar();
            
            System.out.println("Kuli Barang");
            Kar.ambilBarang();
	}
}

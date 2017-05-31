
import java.util.Scanner;

public class mainClass {
public static void main (String[] args){
    //cara membuat objek
         Admin Adm = new Admin();
         Scanner sc = new Scanner (System.in); 
         Karyawan Kar = new Karyawan();
         Yanto yan = new Yanto();
         StockBarang <Integer> sto = new StockBarang();
         
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
            Kar.setNamaKaryawan("jono enkap");
            System.out.println(Kar.getNamaKaryawan());
            System.out.println("---------interface class--------");
            yan.jamKerja();
            yan.PenilaianKaryawan();
            System.out.println("StockBarang");
            int Stock = 100;
            sto.setStockBarang(Stock);
            Adm.barangMasuk();
            int stck = sc.nextInt();
    }
}

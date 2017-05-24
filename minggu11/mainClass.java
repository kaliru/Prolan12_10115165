public class mainClass {
public static void main (String[] args){
         Admin Adm = new Admin();
         Karyawan Kar = new Karyawan();
         Yanto yan = new Yanto();
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
            
            
    }
}

public class Harlin extends Mahasiswa {

    @Override
    protected void kuliah() {
         System.out.println(" Saya Kuliah Dan Akan Lulus dengan Perjuangan ");
    }

    @Override
    protected void lulus() {
        System.out.println("Saya Akan Lulus Dengan Ilmu If Terbaik ");
    }

    @Override
    protected void TidakLulus() {
        System.out.println("kalau Tidak Lulus berjuang sampai Lulus");
    }
    
}

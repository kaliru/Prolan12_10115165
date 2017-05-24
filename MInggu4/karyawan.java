class Karyawan{
	String namaKaryawan;
	int idKaryawan;
        String AmbilBarang;
        
        Karyawan (){
	//konstruktor
            this.namaKaryawan="asep";
            this.idKaryawan=10171617;
            this.AmbilBarang="gula";
        
        }
	//method Ambil Barang
	public void ambilBarang(){
            System.out.println(this.namaKaryawan);
            System.out.println(this.AmbilBarang);
            System.out.println("77 Krg");
	}
}

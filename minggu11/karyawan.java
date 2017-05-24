class Karyawan{
	String namaKaryawan;
	int idKaryawan;
        String AmbilBarang;
        
        Karyawan (){
            namaKaryawan="asep";
            idKaryawan=10171617;
            AmbilBarang="gula";
        
        }

    public String getNamaKaryawan() {
        return namaKaryawan;
    }

    public void setNamaKaryawan(String namaKaryawan) {
        this.namaKaryawan = namaKaryawan;
    }

    public int getIdKaryawan() {
        return idKaryawan;
    }

    public void setIdKaryawan(int idKaryawan) {
        this.idKaryawan = idKaryawan;
    }

    public String getAmbilBarang() {
        return AmbilBarang;
    }

    public void setAmbilBarang(String AmbilBarang) {
        this.AmbilBarang = AmbilBarang;
    }
	
	public void ambilBarang(){
            System.out.println(namaKaryawan);
            System.out.println(AmbilBarang);
            System.out.println("77 Krg");
	}
}

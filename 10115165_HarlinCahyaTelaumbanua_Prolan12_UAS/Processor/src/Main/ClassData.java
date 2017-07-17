package Main;

import java.io.Serializable;

public class ClassData {
    
    private int ID;
    private String Nama;
    private String Versi;
    private String Clock;
    private int tgl_Tgl;
    private int tgl_Bln;
    private int tgl_Thn;
    private String Cache;
    public ClassData(){}
    
    public ClassData(int ID, String Nama,String Versi, int tgl_Tgl, int tgl_Bln, int tgl_Thn, String Clock, String Cache){
        this.ID = ID;
        this.Nama = Nama;
        this.Versi = Versi;
        this.tgl_Tgl = tgl_Tgl;
        this.tgl_Bln = tgl_Bln;
        this.tgl_Thn = tgl_Thn;
        this.Clock = Clock;
        this.Cache = Cache;
    }
    
    public int getID() {
        return ID;
    }

 
    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNama() {
        return Nama;
    }

    
    public void setNama(String Nama) {
        this.Nama = Nama;
    }

  
    public String getVersi() {
        return Versi;
    }

    
    public void setVersi(String Versi) {
        this.Versi = Versi;
    }
    
    
    public int getTgl_tgl(){
        return tgl_Tgl;
    }
    public void setTgl_tgl(int tgl_tgl){
        this.tgl_Tgl = tgl_tgl;
    }
        public int getTgl_bln(){
        return tgl_Bln;
    }
    public void setTgl_bln(int tgl_bln){
        this.tgl_Bln = tgl_bln;
    }
        public int getTgl_thn(){
        return tgl_Tgl;
    }
    public void setTgl_thn(int tgl_thn){
        this.tgl_Thn = tgl_thn;
    }
    
    public String getClock() {
        return Clock;
    }

    
    public void setClock(String Clock) {
        this.Clock = Clock;
    }
    public String getCache() {
        return Cache;
    }

    
    public void setCache(String Cache) {
        this.Cache = Cache;
    }
    
    
}

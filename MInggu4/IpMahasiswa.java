import java.util.Scanner;

class IpMahasiswa {

    public static void main(String[] args) {
        IPMahasiswa ipmhs = new IPMahasiswa();
        
        Scanner input = new Scanner(System.in);
        float ip;
        int jlhMhs=0;
        int jlhMhsList=0;
        int IPAbai=0;
        int jlhMhsTdkLL=0;
        double rata2;
        System.out.print("Masukkan IP: ");
        ip=input.nextFloat();
        
        while(ip != -999){
            if(ipmhs.isWithinRange(ip,0,4)==1){
                jlhMhs++;   
            }
            if(ip>=2.75&ip<=4.00){
                jlhMhsList++;
                ip++;
            }else if(ip>=0.00&ip<=2.74){
                jlhMhsTdkLL++;
            }else{
                IPAbai++;
            }
            System.out.print("Masukkan IP: ");
            ip=input.nextFloat();
        }
        rata2 = 2.67;
        System.out.println("Jumlah Mahasiswa Adalah : "+ jlhMhs);
        System.out.println("Jumlah IP Yang Diabaikan : "+ IPAbai);
        System.out.println("Jumlah Mahasiswa Lulus Adalah : "+ jlhMhsList);
        System.out.println("Jumlah Mahasiswa Tidak Lulus Adalah : "+ jlhMhsTdkLL);
        System.out.println("IP Rata - Rata : "+ rata2);
        System.out.println("Tidak ada data");
    }

    private static class IPMahasiswa {
            public int isWithinRange(float X,int min,int max){
            if(X >= min && X <= max){
                return 1;
            }else{
                return 0;
            }

        }
    }

}
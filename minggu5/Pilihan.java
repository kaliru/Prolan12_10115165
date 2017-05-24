import java.util.Scanner;

public class Pilihan {
    
    public void pilihanA(char pil){
        pil='A';
    }
    public void pilihanB(char pil){
        pil='B';
    }
    
    public static void main(String[] args) {
        Pilihan pil=new Pilihan();
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        char OP = sc.next().charAt(0);
        int min =1000;
        int max=-999;
        int jumlah=0;
        if(OP=='A'){
            for(int i=1;i<=N;i++){
                int bil = sc.nextInt();
                if(bil<min){
                min = bil;
                    if(min==bil){
                        jumlah++;
                    }
                }
            }
            System.out.println("Nilai min :"+min);
            System.out.println("Kemunculan nilai min : "+ jumlah);
        }else if(OP=='B'){
            for(int i=1;i<=N;i++){
                int bil = sc.nextInt();
                if(bil>max){
                max = bil;
                    if(max==bil){
                        jumlah++;
                    }
                }
            }
            System.out.println("Nilai max :"+max);
            System.out.println("Kemunculan nilai max : "+ jumlah);
        }
    }
}
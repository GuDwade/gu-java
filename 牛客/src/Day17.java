
import java.util.Scanner;

public class Day17 {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        String DNA=scanner.nextLine();
        double n=scanner.nextInt();

        String str=GC(DNA,n);
        System.out.println(str);


    }
    //DNA中的GC比例
    public  static  String GC(String DNA,double n){

        double max=0;
        int start=0;

        for(int i=0;i<DNA.length()-n;i++){
            int count=0;
            for(int j=i;j<i+n;j++){
                if (DNA.charAt(j)=='G'||DNA.charAt(j)=='C'){
                    count++;
                }
            }
            double GC=count/n;
            if (GC>max){
                max=GC;
                start=i;
            }
        }
        String str=DNA.substring(start,start+(int)n);
        return  str;
    }
}

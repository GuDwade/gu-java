import java.math.BigInteger;
import java.util.Scanner;

public class Day12 {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n=scanner.nextInt();
            char c=scanner.next().charAt(0);
            print(n,c);
        }
    }
    //画正方形
    public static void print(int n,char c){
        int col=(int) Math.round(n/2.0);
        for(int i=0;i<col;i++){
            if(i==0||i==col-1){
                for(int j=0;j<n;j++){
                    System.out.print(c);
                }

            }else{
                for(int k=0;k<n;k++){
                    if(k==0||k==n-1){
                        System.out.print(c);
                    }else{
                        System.out.print(' ');
                    }
                }
            }
            System.out.println();
        }
    }

    //大整数
    public static  void BigInteger(){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNextLine()){
            String addend=scanner.nextLine();
            String augend=scanner.nextLine();
            System.out.println(AddLongInteger(addend,augend));
        }
    }


    public static String AddLongInteger(String addend,String augend){
        if(addend==null||addend.length()==0){
            return  augend;
        }
        if(augend==null||augend.length()==0){
            return  addend;
        }

        BigInteger x=new BigInteger(addend);

        BigInteger y=new BigInteger(augend);

        BigInteger z=x.add(y);

        return  String.valueOf(z);

    }
}

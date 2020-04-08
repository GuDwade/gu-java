import java.util.Scanner;

public class Day8 {
    public static void main(String[] args) {
        numberOfZero();
    }
    //末尾0的个数
    public static void numberOfZero(){
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n=scanner.nextInt();
            int count=0;
            for(int i=n;i>=5;i--){
                int tmp=i;
                while(tmp%5==0){
                    count++;
                    tmp/=5;
                }
            }
            System.out.println(count);
        }
    }

    public static void reverse(){
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt()){
            StringBuilder sb=new StringBuilder(String.valueOf(scanner.nextInt()));
            System.out.println(sb.reverse().toString());
        }

    }
}

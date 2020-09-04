import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (scan.hasNextInt()){
            int n=scan.nextInt();
            System.out.println(jump(n));
        }
    }

    private static int jump(int n) {
        if (n<=0||n>36){
            return  0;
        }
        if(n<3){
            return  n;
        }
        int a=1;
        int b=2;
        for(int i=3;i<=n;i++){
            int tmp=a+b;
            a=b;
            b=tmp;
        }
        return  b;
    }

    public int house (int[] person) {
        int cnt=person.length;
        int[]house=new int[cnt];
        Arrays.fill(house,1);
        for(int i=0;i<cnt-1;i++){
            if (person[i]<person[i+1]&&house[i]>=house[i+1]){
                house[i+1]=house[i]+1;
            }
            if(person[i]>person[i+1]&&house[i]<=house[i+1]){
                house[i]=house[i+1]+1;
            }
        }
        int sum=0;
        for(int i:house){
            sum+=i;
        }
        return  sum;
    }
}

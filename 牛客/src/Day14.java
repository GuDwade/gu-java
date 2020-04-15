import java.util.Scanner;

public class Day14 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int n=scanner.nextInt();
            System.out.println(step(n,0));
        }
    }

    public  static int step(long n,int step){
        if(step>100000){
            return -1;
        }
        if(n%1000000007==0){
            return step;
        }
        if((4*n+3)%1000000007==0){
            return step+1;
        }
        if((8*n+7)%1000000007==0){
            return  step+1;
        }
        return Math.min(step(4*n+3,step+1),step(8*n+7,step+1));
    }
    //另类加法
    /*
    位的异或运算跟求'和'的结果一致：
    异或 1^1=0 1^0=1 0^0=0
    求和 1+1=0 1+0=1 0+0=0
    位的与运算跟求'进位‘的结果一致：
    位与 1&1=1 1&0=0 0&0=0
    进位 1+1=1 1+0=0 0+0=0
    */
    public int addAB(int A, int B) {
        while(B!=0){
            int add=(A&B)<<1;   //进位
            A=A^B;
            B=add;
        }
        return A;
    }
}


import java.util.Scanner;

public class Day9 {
    //动态规划基础
    public int countWays(int x, int y) {
        int[][]dp=new int [x][y];
        dp[0][0]=1;

        for(int i=1;i<y;i++){
            dp[0][i]=1;
        }

        for(int j=1;j<x;j++){
            dp[j][0]=1;
        }

        for(int i=1;i<x;i++){
            for(int j=1;j<y;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }

        return dp[x-1][y-1];
    }

    //斐波那契数列   成为斐波那契数的最小步骤
    public static void  Fibonacci(){
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int a=0;
        int b=1;
		//寻找离n最接近的左右斐波那契数    
        while(b<=n){
            int tmp=a+b;
            a=b;
            b=tmp;
        }
        System.out.println(Math.min(n-a,b-n));
    }

    public static void main(String[] args) {
        Fibonacci();
    }
}

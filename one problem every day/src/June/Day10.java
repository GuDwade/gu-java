package June;

public class Day10 {
    //爬楼梯
    public int climbStairs(int n) {
        if(n<3){
            return n;
        }
        int a=1;
        int b=2;
        while (n>2){
            int c=a+b;
            a=b;
            b=c;
            n--;
        }
        return b;
    }

    public int climbStairs1(int n) {
        if(n==1){
            return  1;
        }
        if(n==2){
            return 2;
        }
        int[]dp=new int[n];
        dp[0]=1;
        dp[1]=2;
        for(int i=2;i<n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }
}

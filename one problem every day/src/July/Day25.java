package July;

public class Day25 {
    //整数拆分
    public int integerBreak(int n) {
        if(n<=3){
            return n-1;
        }
        int[]dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        for(int i=4;i<=n;i++){
            for(int j=1;j<=i/2;j++){
                dp[i]=Math.max(dp[i],dp[j]*dp[i-j]);
            }
        }
        return  dp[n];
    }

    public static void main(String[] args) {
        Day25 test=new Day25();
        System.out.println(test.integerBreak(10));
    }
}

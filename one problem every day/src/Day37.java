public class Day37 {
    //斐波那契   o(n)  o(1)
    public int fib(int n) {
        if(n<=1){
            return n;
        }

        int prev=0;
        int cur=1;
        for(int i=2;i<=n;i++){
            int sum=(prev+cur)%1000000007;
            prev=cur;
            cur=sum;
        }
        return cur;
    }

    //零钱兑换种类
    public int change(int amount, int[] coins) {

        int[]dp=new int[amount+1];
        dp[0]=1;
        for(int coin:coins){
            for(int i=coin;i<=amount;i++){
                dp[i]+=dp[i-coin];
            }
        }
        return dp[amount];
    }
}

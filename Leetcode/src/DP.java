import java.util.Arrays;

class NumArray {
    private int[]sum;

    public NumArray(int[] nums) {
        sum=new int[nums.length];
        if(nums.length==0){
            return;
        }
        sum[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            sum[i]=nums[i]+sum[i-1];
        }
    }

    public int sumRange(int i, int j) {
        if(i==0){
            return sum[j];
        }else{
            return sum[j]-sum[i-1];
        }
    }
}
public class DP {
    //零钱兑换
    public static int coinChange(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }
        int max=amount+1;
        int[]dp=new int[max];
        Arrays.fill(dp,max);
        dp[0]=0;
        //dp[i]表示能够组成当前金额的最少硬币数量
        //i表示金额
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                //j表示硬币金额
                if(coins[j]<=i){
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                    //dp[i-coins[j]]+1  表示取一枚金额为coins[j]硬币 dp[剩下的金额]
                }
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }

    public static void main(String[] args) {
        int[]coins={2,3,5};
        coinChange(coins,19);
    }
}

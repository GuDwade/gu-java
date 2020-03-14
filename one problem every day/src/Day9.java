import java.util.Arrays;

public class Day9 {
    //最长上升子序列的长度
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0||nums==null){
            return 0;
        }
        //dp[i] 的值代表 nums 前 i个数字的最长子序列长度。
        int []dp=new int[nums.length];
        Arrays.fill(dp,1);
        int maxLen=0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if (nums[j]<nums[i]){
                    // nums[i]可以接在 nums[j]之后，dp[i]=dp[j]+1 ；
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            maxLen=Math.max(maxLen,dp[i]);
        }
        return maxLen;
    }
}

package May;

public class Day3 {
    //最大子序和
    public int maxSubArray(int[] nums) {
        int len=nums.length;
        if (nums==null||len==0) {
            return 0;
        }
        if (len== 1) {
            return nums[0];
        }
        //dp[i]：以数组nums[i]为结尾的最大数组和
        int[]dp=new int[len];
        dp[0]=nums[0];
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i]=Math.max(nums[i],dp[i-1]+nums[i]);
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}

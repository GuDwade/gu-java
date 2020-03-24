public class Day18 {
    //按摩师
    public int massage(int[] nums) {
        int len=nums.length;
        if (len==0) {
            return 0;
        }
        if (len== 1) {
            return nums[0];
        }
        int[]dp=new int[len];
        dp[0]=nums[0];
        dp[1]=Math.max(dp[0],nums[1]);
        for(int i=2;i<len;i++){
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[len-1];
    }

    //打家劫舍
    public int rob1(int[] nums) {
        int len=nums.length;
        if (len==0) {
            return 0;
        }
        if (len== 1) {
            return nums[0];
        }
        int[]dp=new int[len];
        dp[0]=nums[0];
        dp[1]=Math.max(dp[0],nums[1]);
        for(int i=2;i<len;i++){
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[len-1];
    }
    
    //最大子序和
    public int maxSubArray(int[] nums) {
        int len=nums.length;
        if (len==0) {
            return 0;
        }
        if (len== 1) {
            return nums[0];
        }
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

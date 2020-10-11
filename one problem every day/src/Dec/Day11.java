package Dec;

import java.util.Arrays;

public class Day11 {
    //分割等和子集

    //[1, 5, 11, 5]
    public static boolean canPartition(int[] nums) {
        if (nums==null||nums.length<2){
            return false;
        }

        int max=-1;
        int sum=0;
        for(int num:nums){
            sum+=num;
            max=Math.max(num,max);
        }

        if (sum%2!=0){
            return  false;
        }

        int target=sum/2;
        if (max>target){
            return  false;
        }

        int n=nums.length;
        boolean[][] dp = new boolean[n][target + 1];
        // dp[i][j] 表示从数组的 [0,i]下标范围内选取若干个正整数，是否存在一种选取方案使得被选取的正整数的和等于 j
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        dp[0][nums[0]]=true;

        for(int i=1;i<n;i++){
            int num=nums[i];
            for(int j=1;j<=target;j++){
                dp[i][j]=dp[i-1][j];
                if (num<=j){
                    dp[i][j]|=dp[i-1][j-num];
                }
            }
        }

        return  dp[n-1][target];

//        boolean[]isUsed=new boolean[nums.length];
//        boolean flag=dfs(nums,target,isUsed,0,0);
//        return  flag;
    }

    private static boolean dfs(int[] nums,  int target, boolean[] isUsed, int sum, int cnt) {

        if (sum>target){
            return  false;
        }

        if (sum==target){
            if (cnt<nums.length){
                return  true;
            }
            return  false;
        }

        for(int i=0;i<nums.length;i++){
            if (isUsed[i]){
                continue;
            }
            isUsed[i]=true;
            if (dfs(nums,  target, isUsed, sum+nums[i], cnt+1)){
                return  true;
            }
            isUsed[i]=false;
        }

        return  false;
    }



    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1,2,3,6}));
    }
}

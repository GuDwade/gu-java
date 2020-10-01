import java.util.List;

public class Day1 {
    //最大子序和
    public int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0){
            return  0;
        }

        if (nums.length==1){
            return  nums[0];
        }

        int[]dp=new int[nums.length];
        dp[0]=nums[0];
        int max=nums[0];

        for(int i=1;i<nums.length;i++){
            dp[i]=Math.max(nums[i],dp[i-1]+nums[i]);
            max=Math.max(max,dp[i]);
        }
        return  max;
    }

    //三角形最小路径和
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][]dp=new int[n][n];

        for(int i=0;i<n;i++){
            dp[n-1][i]=triangle.get(n-1).get(i);
        }

        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                dp[i][j]=Math.min(dp[i+1][j],dp[i+1][j+1])+triangle.get(i).get(j);
            }
        }

        return  dp[0][0];
    }
}

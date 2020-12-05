package December;

public class Day5 {
    //目标和
    int cnt ;
    public int findTargetSumWays(int[] nums, int S) {
        cnt = 0;
        dfs(nums,0,S,0);
        return  cnt ;
    }

    private void dfs(int[] nums, int idx, int s,int sum) {
        if (idx == nums.length){
            if (sum == s){
                cnt++;
            }
            return;
        }

        dfs(nums,idx+1,s,sum+nums[idx]);
        dfs(nums,idx+1,s,sum-nums[idx]);
    }
}

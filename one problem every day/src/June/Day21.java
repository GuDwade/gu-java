package June;

import java.util.Arrays;

public class Day21 {
    // 长度最小的子数组
    int ret;
    public int minSubArrayLen(int s, int[] nums) {
        ret=nums.length;
        dfs(0,0,0,nums,s);
        return  ret;
    }

    private void dfs(int idx, int count, int sum, int[] nums, int s) {
        if(sum>=s&&count<ret){
            ret=count;
            return;
        }

        for(int i=idx;i<nums.length;i++){
            sum+=nums[i];
            count++;
            dfs(i+1,count,sum,nums,s);
            sum-=nums[i];
            count--;
        }
    }
    public int minSubArrayLen1(int s, int[] nums) {
        int len=nums.length;
        if(len==0){
            return 0;
        }

        int left=0;
        int right=0;
        int sum=0;
        int ret=len;

        while (right<len){
            sum+=nums[right];
            while (sum>=s){
                ret=Math.min(ret,right-left+1);
                sum-=nums[left];
                left++;
            }
            right++;
        }
        return ret==len?0:ret;
    }

    public static void main(String[] args) {
        Day21 test=new Day21();
        System.out.println(test.minSubArrayLen1(213, new int[]{12,28,83,4,25,26,25,2,25,25,25,12}));
    }
}

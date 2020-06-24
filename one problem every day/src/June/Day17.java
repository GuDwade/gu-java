package June;

import java.util.Arrays;

public class Day17 {
    //最接近的三数之和 双指针法
    public int threeSumClosest(int[] nums, int target) {
        int n=nums.length;
        int min=nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);

        for(int i=0;i<n;i++){
            if (i>0&&nums[i-1]==nums[i]){
                continue;
            }

            int left=i+1;
            int right=n-1;

            while (left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if (sum==target){
                    return  target;
                }

                if(Math.abs(sum-target)<Math.abs(min-target)){
                    min=sum;
                }

                if(sum>target){
                    right--;
                }else{
                    left++;
                }
            }


        }

        return  min;
    }
}

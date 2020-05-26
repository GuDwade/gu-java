package May;

public class Day23 {
    //寻找重复数

    public int findDuplicate(int[] nums) {
        int left=1,right=nums.length-1;
        while (left<right){
            int mid=left+right>>1;
            int count=0;
            for(int n:nums){
                if (n>=left&&n<=mid){
                    count++;
                }
            }
            if (count>mid-left+1){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return  left;
    }
}

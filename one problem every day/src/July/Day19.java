package July;

public class Day19 {
    //搜索插入位置
    public int searchInsert(int[] nums, int target) {
        if (nums==null||nums.length==0||nums[nums.length-1]<target){
            return  nums.length;
        }

        int left=0;
        int right=nums.length-1;

        while (left<right){
            int mid=left+right>>1;
            if (nums[mid]>=target){
                right=mid;
            }else{
                left=mid+1;
            }
        }

        return left;
    }
}

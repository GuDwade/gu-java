public class Day50 {
    //搜索旋转排序数组
    //[4,5,6,7,0,1,2]
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if (nums[mid]==target){
                return mid;
            }else if(nums[mid]<nums[right]){
                if (nums[mid]<target&&target<=nums[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }else{
                if (nums[left]<=target&&target<nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
        }
        return -1;
    }
}

package December;

public class Day1 {
    //在排序数组中查找元素的第一个和最后一个位置
    public int[] searchRange(int[] nums, int target) {
        int [] ret = new int[]{-1,-1};
        if (nums.length == 0 || nums == null){
            return  ret;
        }
        int l = 0 , r = nums.length - 1;
        while (l < r){
            int mid = l + r >> 1;
            if (nums[mid] >= target){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        if (nums[l] != target){
            return  ret;
        }
        ret[0] = l;
        l = 0 ;
        r = nums.length - 1;

        while (l < r){
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= target){
                l = mid;
            }else{
                r = mid -1;
            }
        }
        ret[1] = l;
        return  ret;
    }
}

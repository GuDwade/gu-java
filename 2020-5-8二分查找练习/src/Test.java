public class Test {
    //平方根
    public int mySqrt(int x) {

        int left=0;
        int right=x;

        while(left<right){
            int mid=(left+right+1)/2;
            //mid*mid<=x 可能会溢出
            if (mid<=x/mid){
                left=mid;
            }else{
                right=mid-1;
            }
        }
        return  left;
    }

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

    //寻找旋转排序数组中的最小值

    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int sz=nums.length-1;

        while (left<right){
            int mid=left+right>>1;
            if (nums[mid]<=nums[sz]){
                right=mid;
            }else{
                left=mid+1;
            }
        }

        return  nums[left];
    }
}

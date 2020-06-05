public class 调整数组顺序使奇数位于偶数前面 {
    public int[] exchange(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left<right){
            while (left<right&&(nums[left]&1)==1){
                left++;
            }
            while (left<right&&(nums[right]&1)==0){
                right--;
            }
            swap(nums,left,right);
        }
        return nums;
    }

    private void swap(int[] nums, int left, int right) {
        int tmp=nums[left];
        nums[left]=nums[right];
        nums[right]=tmp;
    }

}

public class 调整数组顺序使奇数位于偶数前面 {
    // 保证稳定性
    public int[] exchange1(int[] nums) {
        int l = 0;
        for(int i = 0; i < nums.length; i++ ){
            if ((nums[i] & 1) == 1){
                for(int j = i; j > l; j-- ){
                    swap(nums,j,j - 1);
                }
                l++;
            }
        }
        return nums;
    }

    public int[] exchange(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r){
            if (l < r && (nums[r] & 1 )== 0){
                r--;
            }

            if (l < r && (nums[l] & 1) == 1){
                l++;
            }

            if (l < r){
                swap(nums,l,r);
            }
        }

        return nums;
    }
    private void swap(int[] nums, int j, int i) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

import java.util.Arrays;

public class 调整数组顺序使奇数位于偶数前面 {
    public static int[] exchange(int[] nums) {
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

    public static int[] reOrderArray(int [] array) {
        int start = 0;
        for(int i = 0 ; i < array.length ; i++){
            if(array[i] % 2 == 1){
                int j = i;
                while(j > start){
                    swap(array,j,j-1);
                    j--;
                }
                start ++;
            }
        }
        return  array;
    }
    private static void swap(int[] nums, int left, int right) {
        int tmp=nums[left];
        nums[left]=nums[right];
        nums[right]=tmp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(reOrderArray(new int[]{2, 1, 7, 8, 4, 5})));
        System.out.println(Arrays.toString(exchange(new int[]{2, 1, 7, 8, 4, 5})));

    }
}

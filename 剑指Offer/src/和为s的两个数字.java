import java.util.Arrays;

public class 和为s的两个数字 {

    public static int[] twoSum(int[] nums, int target) {
        int[]ret={-1,-1};
        int left=0;
        int right=nums.length-1;

        while (left<right){
            int sum=nums[left]+nums[right];
            if (sum==target){
                ret=new int[]{nums[left],nums[right]};
                break;
            }else if(sum>target){
                right--;
            }else{
                left++;
            }
        }
        return  ret;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}

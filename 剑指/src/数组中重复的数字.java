import java.util.HashSet;
import java.util.Set;

public class 数组中重复的数字 {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if (!set.add(num)){
                return  num;
            }
        }
        return  -1;
    }


    public int findRepeatNumber1(int[] nums) {
        for(int i = 0; i < nums.length; i++ ){
            if (nums[i] != i){
                if (nums[nums[i]] == nums[i]){
                    return  nums[i];
                }else{
                    swap(nums,i,nums[i]);
                }
            }
        }

        return  -1;
    }

    private void swap(int[] nums, int i, int num) {
        int tmp = nums[i];
        nums[i] = nums[num];
        nums[num] = tmp;
    }


    public int findRepeatNumber2(int[] nums) {
        int[] arr = new int[nums.length];
        for (int num : nums){
            if (++arr[num] > 1){
                return num;
            }
        }
        return  -1;
    }



}

import java.util.Arrays;

public class Day2 {
    public static int removeElement(int[] nums, int val) {
        if(nums.length==0){
            return 0;
        }
        int ret=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=val){
                nums[ret]=nums[j];
                ret++;
            }
        }
        return ret;
    }

    public static int searchInsert(int[] nums, int target) {
        int i=0;
        for(i=0;i<nums.length;i++){
            if(target<=nums[i]){
                return i;
            }
        }
        return nums.length;
    }

    public static int getValue(int i) {
        int result = 0;
        switch (i) {
            case 1:
                result = result + i;
            case 2:
                result = result + i * 2;
            case 3:
                result = result + i * 3;
        }
        return result;
    }

        public static void main(String[] args) {
        int[]nums={2,3,2,4};
        System.out.println(removeElement(nums,2));
        System.out.println(Arrays.toString(nums));
        System.out.println(getValue(2));
        int []arr={3,6,8,10};
        System.out.println(searchInsert(arr,7));
        System.out.println(searchInsert(arr,11));

    }
}


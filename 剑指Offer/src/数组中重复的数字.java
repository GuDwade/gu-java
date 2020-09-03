public class 数组中重复的数字 {
    public static int findRepeatNumber(int[] nums) {
        int sz=nums.length;

        for(int i=0;i<sz;i++){
            while (nums[i]!=nums[nums[i]]){
                swap(nums,i,nums[i]);
            }

            if (nums[i]!=i){
                return  nums[i];
            }
        }

        return -1;
    }

    public static void swap(int[]nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }

    public static void main(String[] args) {
        System.out.println(findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
}

public class MissingNumber {
    public static int missingNumber(int[] nums) {
        int sz=nums.length;
        int sum=0;
        while(sz>0){
            sum+=sz;
            sz--;
        }
        for(int i=0;i<nums.length;i++){
            sum-=nums[i];
        }
        return sum;
    }
    public static int missingNumber1(int[] nums) {
        int ret=nums.length;
        for(int i=0;i<nums.length;i++){
            ret^=nums[i]^i;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[]arr={0,1,3};
        System.out.println(missingNumber(arr));
        System.out.println(missingNumber1(arr));
    }
}

public class Last {
    //快乐数
    public static boolean isHappy(int n) {
        int slow=n;
        int fast=squareSum(n);
        while (slow != fast){
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
        };
        return  slow==1;
    }


    private  static int squareSum(int n) {
        int sum=0;
        while (n!=0){
            int mod=n%10;
            sum+=mod*mod;
            n=n/10;
        }
        return  sum;
    }
    //寻找重复数
    public static int findDuplicate(int[] nums) {

        int fast = 0, slow = 0;
        while(true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if(slow == fast) {
                fast = 0;
                while(nums[slow] != nums[fast]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[slow];
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(isHappy(19));
        System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
    }


}

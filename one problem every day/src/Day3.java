public class Day3 {
    //总和最大的连续数列
    public static int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(sum+nums[i]<nums[i]){
                //舍弃前面的累加
                sum=0;
            }
            sum+=nums[i];
            //更新max
            if(sum>max){
                max=sum;
            }
        }
        return  max;
    }

    public static void main(String[] args) {
        int[]arr={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }
}

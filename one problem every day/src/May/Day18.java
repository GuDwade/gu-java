package May;

public class Day18 {
    //乘积最大子数组
    public int maxProduct(int[] nums) {
        int max= Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            int tmp=1;
            for(int j=i;j<nums.length;j++){
                tmp*=nums[j];
                max=Math.max(max,tmp);
            }
        }
        return max;
    }

    public int maxProduct1(int[] nums) {
        int a=1;
        int max1=nums[0];

        for(int i=0;i<nums.length;i++){
            a=a*nums[i];
            max1=Math.max(a,max1);
            if (nums[i]==0){
                a=1;
            }
        }

        int b=1;
        int max2=nums[nums.length-1];
        for(int j=nums.length-1;j>=0;j--){
            b=b*nums[j];
            max2=Math.max(b,max2);
            if (nums[j]==0){
                b=1;
            }
        }

        return Math.max(max1,max2);
    }

}

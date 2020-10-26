package Dec;

import java.util.Arrays;

public class Day26 {
    //有多少数字小于当前数字
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int [] arr=new int[101];

        for(int i=0;i<nums.length;i++){
            arr[nums[i]]++;
        }


        for(int i=1;i<101;i++){
            arr[i]+=arr[i-1];
        }

        int []ret=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ret[i]=nums[i]==0?0:arr[nums[i]-1];
        }

        return ret;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3})));
    }
}

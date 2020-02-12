import java.util.Arrays;

import static java.lang.Math.abs;

public class Day5 {
    public static boolean containsDuplicate(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsDuplicate1(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int i,j;
        for(i=0;i<nums.length-1;i++){
            for(j=i+1;j<=i+k&&j<nums.length;j++){
                if(nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int i,j;
        for(i=0;i<nums.length-1;i++){
            for(j=i+1;j<=i+k&&j<nums.length;j++){
                if(abs((long)nums[i]-(long)nums[j])<=t){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isLongPressedName(String name, String typed) {
        int len_n=name.length();
        int len_t=typed.length();
        if(len_n>len_t){
            return false;
        }
        int i=0,j=0;
        while(i<len_n&&j<len_t){
            if(name.charAt(i)==typed.charAt(j)){
                i++;
                j++;  //越界
            }else if(j>0&&typed.charAt(j)==typed.charAt(j-1)){
                j++;
            }else if(name.charAt(i)!=typed.charAt(j)){
                return false;
            }
        }
        //让name先走完
        return i==len_n;
    }
    public static void main(String[] args) {
        int []nums={1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate(nums,2));
        System.out.println(containsDuplicate1(nums));
        System.out.println(isLongPressedName("leelee","lleeelee"));
    }
}
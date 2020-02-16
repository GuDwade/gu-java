import java.util.Arrays;

public class Day10 {
    public static int[] searchRange(int[] nums, int target) {
        int[]ret={-1,-1};
       for(int i=0;i<nums.length;i++){
           if(nums[i]==target){
               ret[0]=i;
               break;
           }
       }
       if(ret[0]==-1){
           return  ret;
       }
        for(int j=nums.length-1;j>=0;j--){
            if(nums[j]==target){
                ret[1]=j;
                break;
            }
        }
        return ret;
    }
    public static int myAtoi(String str){
        int i=0;
        int sign=1;
        int ret=0;
        while(i<str.length()){
            if(str.charAt(i)==' '){
                i++;
            }else{
                break;
            }
        }
        if (i==str.length()){
            return 0;
        }
        if (str.charAt(i)=='+'){
            sign=1;
            i++;
        }else if(str.charAt(i)=='-'){
            sign=-1;
            i++;
        }
        while(i<str.length()){
            char currChar = str.charAt(i);
            if (currChar > '9' || currChar < '0') {
                break;
            }
            if (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (ret < Integer.MIN_VALUE / 10 || (ret == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            ret = ret * 10 + sign * (currChar - '0');
            i++;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums={1};
        int[] nums1={1,3,5,5,5,8,7};
        System.out.println(Arrays.toString(searchRange(nums,1)));
        System.out.println(Arrays.toString(searchRange(nums1,5)));
        System.out.println(myAtoi("    -23r6"));
    }
}

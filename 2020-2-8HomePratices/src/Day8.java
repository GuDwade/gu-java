import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Stack;

public class Day8 {
    public static int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            digits[i]++;
            digits[i]=digits[i]%10;
            if(digits[i]!=0){
                return digits;
            }
        }
        digits=new int[digits.length+1];
        digits[0]=1;
        return  digits;
    }
    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);
        Stack<Integer>stack=new Stack<>();
        for(int i=0;i<nums.length;i++){
            if(stack.isEmpty()){
                stack.push(nums[i]);
            }else if(nums[i]==stack.peek()){
                continue;
            }else{
                stack.push(nums[i]);
            }
        }
        int sz=stack.size();
        int []ret=new int[sz];
        for(int j=0;j<sz;j++){
            ret[j]=stack.pop();
        }
        if(sz>=3){
            return ret[2];
        }else{
            return ret[0];
        }
    }
    public static int thirdMax1(int[] nums) {
         Arrays.sort(nums);
        int[] newNums=removeDuplicates(nums);
        int sz=newNums.length;
        if(sz>=3){
            return newNums[sz-3];
        }else{
            return newNums[sz-1];
        }
    }
    public static int[] removeDuplicates(int[] nums) {
        if(nums.length==0||nums.length==1){
            return nums;
        }
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[j]!=nums[i]){
                nums[++i]=nums[j];
            }
        }
        int []ret=Arrays.copyOfRange(nums,0,i+1);//左闭右开
        return ret;
    }

    public static void main(String[] args) {
        int[]nums1={3,2,1};
        int[]nums2={9,9,9};
        int[]nums3=plusOne(nums1);
        int[]nums4=plusOne(nums2);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums3));
        System.out.println(Arrays.toString(nums4));
        int[]nums5={1,4,5,7,8,3,9,2,4,5,7};
        System.out.println(thirdMax(nums5));
        System.out.println(thirdMax1(nums5));
        Arrays.sort(nums5);
        int[] nums6=removeDuplicates(nums5);
        System.out.println(Arrays.toString(nums6));
    }
}

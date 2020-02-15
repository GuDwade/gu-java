import java.util.Arrays;

public class Day9 {
    public static int[] twoSum(int[] nums, int target) {
        if (nums.length<2){
            return null;
        }
        int []ret=new int[2];
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if (nums[i]+nums[j]==target){
                   ret[0]=i;
                   ret[1]=j;
                   return ret;
                }
            }
        }
        return ret;
    }
    public static String addBinary(String a, String b) {
        if(a.length()==0||a==null){
            return b;
        }
        if(b.length()==0||b==null){
            return a;
        }
        int i=a.length()-1;
        int j=b.length()-1;
        int k=0;
        StringBuilder sb=new StringBuilder();
        while(i>=0||j>=0){
            if(i>=0){
                k+=a.charAt(i--)-'0';
            }
            if(j>=0){
                k+=b.charAt(j--)-'0';
            }
            sb.append(k%2);
            k>>=1;
        }
        String str=sb.reverse().toString();
        return k>0 ? 1+str:str;

    }
    public static void main(String[] args) {
        int[]nums={2,5,7,4,9};
        System.out.println(Arrays.toString(twoSum(nums,9)));
        System.out.println(Arrays.toString(twoSum(nums,11)));
        System.out.println(addBinary("1010","1011"));
        System.out.println(addBinary("11","111"));
    }
}

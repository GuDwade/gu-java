import java.util.Arrays;

public class Day7 {
    public static int[] sortArrayByParity(int[] A) {
        if(A.length==0||A.length==1){
            return A;
        }
        int []ret=new int[A.length];
        int i=0;
        int j=0;
        for(i=0;i<A.length;i++){
            if(A[i]%2==0){
                ret[j]=A[i];
                j++;
            }
        }
        for(i=0;i<A.length;i++){
            if(A[i]%2==1){
                ret[j]=A[i];
                j++;
            }
        }
        return ret;
    }

    public static int pivotIndex(int[] nums) {
        if(nums.length<3){
            return -1;
        }
        int sum=0,leftSum=0;
        for(int t:nums){
            sum+=t;
        }
        for(int i=0;i<nums.length;i++){
            if(leftSum==sum-nums[i]-leftSum){
                return i;
            }
            leftSum+=nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums={2,1,2,3,0};
        System.out.println(Arrays.toString(sortArrayByParity(nums)));
        System.out.println(pivotIndex(nums));
    }
}

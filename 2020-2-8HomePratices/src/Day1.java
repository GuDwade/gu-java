import java.lang.reflect.Array;
import java.util.Arrays;

public class Day1 {
    public static String toLowerCase(String str) {
        char[]arr=str.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(arr[i]>='A'&&arr[i]<='Z'){
                arr[i]+=32;
            }
        }
        String s=new String(arr);
        return s;
    }
    public static void rotate(int[] nums, int k) {
        k=k%nums.length;
        int[] right=Arrays.copyOfRange(nums,nums.length-k,nums.length);
        System.arraycopy(nums,0,nums,k,nums.length-k);
        System.arraycopy(right,0,nums,0,k);

    }

    public static void main(String[] args) {
        System.out.println(Day1.toLowerCase("GAhsdhjhfs"));
        int[]array={1,2,3,4,5,6,7};
        rotate(array,3);
        System.out.println(Arrays.toString(array));
    }
}

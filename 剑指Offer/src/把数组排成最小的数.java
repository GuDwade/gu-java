import java.util.Arrays;

public class 把数组排成最小的数 {
    public static String minNumber(int[] nums) {
        String[]arr=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(arr,(x,y)->(x+y).compareTo(y+x));
        StringBuilder sb=new StringBuilder();
        for(String str:arr){
            sb.append(str);
        }
        return  sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(minNumber(new int[]{3, 321, 32}));
    }
}

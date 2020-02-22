import java.util.Arrays;
import java.util.Stack;

public class NextGreater {
    //扩容解决循环数组
    public static int[] nextGreaterElements(int[] nums) {
        int len=nums.length;
        int[]copy=new int[len*2];
        int[]ret=new int[len];
        for(int i=0;i<len;i++){
            copy[i]=nums[i];
            copy[i+len]=nums[i];
        }
        Arrays.fill(ret,-1);
        for(int j=0;j<len;j++){
            for(int k=j;k<copy.length;k++){
                if(copy[k]>nums[j]){
                    ret[j]=copy[k];
                    break;
                }
            }
        }
        return  ret;
    }
    //栈 压入数组下标
    public static int[] nextGreaterElements1(int[] nums) {
        int len=nums.length;
        int[] ret=new int[len];
        Stack<Integer>stack=new Stack<>();
        Arrays.fill(ret,-1);
        for(int i=0;i<2*len;i++){
            int num=nums[i%len];
            while(!stack.isEmpty()&&num>nums[stack.peek()]){
                ret[stack.pop()]=num;
            }
            if(i<len){
                stack.push(i);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[]num={2,-1,5,3,4};
        System.out.println(Arrays.toString(nextGreaterElements(num)));
        System.out.println(Arrays.toString(nextGreaterElements1(num)));
    }
}

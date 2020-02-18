
import java.util.Arrays;
import java.util.Stack;

public class Day12 {
    //最短无序数组
    public static int findUnsortedSubarray(int[] nums) {
        int[]copy=nums.clone();
        Arrays.sort(copy);
        int i;int j;
        for(i=0;i<nums.length;i++){
            if(nums[i]!=copy[i]){
                break;
            }
        }
        for(j=nums.length-1;j>=0;j--){
            if(nums[j]!=copy[j]){
                break;
            }
        }
        return j-i>0?j-i+1:0;
    }
    //逆波兰式
    public static int evalRPN(String[] tokens) {
        Stack<Integer>stack=new Stack<>();
        for(String s:tokens){
            switch (s){
                case "+":
                    stack.push(stack.pop()+stack.pop());
                    break;
                case "-":
                    stack.push(-(stack.pop()-stack.pop()));
                    break;
                case "*":
                    stack.push(stack.pop()*stack.pop());
                    break;
                case "/":
                    int top=stack.pop();
                    stack.push(stack.pop()/top);
                    break;
                default:
                    stack.push(Integer.valueOf(s));
                    break;
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
       int[]nums={2,5,3,6,8,4,9};
       System.out.println(findUnsortedSubarray(nums));
       String[]test={"4", "13", "5", "/", "+"};
       System.out.println(evalRPN(test));
    }
}

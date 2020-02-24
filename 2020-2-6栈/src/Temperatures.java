import java.util.Arrays;
import java.util.Stack;

public class Temperatures {
    public static int[] dailyTemperatures(int[] T) {
        Stack<Integer>stack=new Stack<>();
        int[] ret=new int[T.length];
        Arrays.fill(ret,0);
        for(int i=0;i<ret.length;i++){
            while(!stack.isEmpty()&&T[i]>T[stack.peek()]){
                ret[stack.peek()]=i-stack.pop();
            }
            stack.push(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] temp={73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temp)));
    }
}

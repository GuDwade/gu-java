package August;

import java.util.Stack;

public class Day12 {
    //有效的括号
    public static boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='('){
                stack.push(')');
            }else if(ch=='{'){
                stack.push('}');
            }else if(ch=='['){
                stack.push(']');
            }else if(!stack.isEmpty()&&ch==stack.peek()){
                stack.pop();
            }else if(stack.isEmpty()||stack.peek()!=ch){
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        isValid("()");
    }
}

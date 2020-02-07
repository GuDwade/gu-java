import java.util.Stack;

public class IsValid {
    public static boolean isValid(String s){
        if(s.isEmpty())
            return true;
        if(s.length()%2==1){
            return  false;
        }
        Stack<Character> stack=new Stack<Character>();
        for(char c:s.toCharArray()){
            if(c=='(')
                stack.push(')');
            else if(c=='{')
                stack.push('}');
            else if(c=='[')
                stack.push(']');
            else if(stack.empty()||c!=stack.pop())
                return false;
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));
    }
}

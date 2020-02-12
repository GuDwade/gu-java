import java.util.Stack;

public class RemoveDuplicates {
    public static String removeDuplicates(String S) {
        if(S.length()==1||S.length()==0){
            return S;
        }
        Stack<Character>stack=new Stack<>();
        for(char c:S.toCharArray()){
            if(stack.isEmpty()){
                stack.push(c);
            }else if(c!=stack.peek()){
                stack.push(c);
            }else{
                stack.pop();
            }
        }
        char[]tmp=new char[stack.size()];
        for(int i=tmp.length-1;i>=0;i--){
            tmp[i]=stack.pop();
        }
        return new String(tmp);
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }
}

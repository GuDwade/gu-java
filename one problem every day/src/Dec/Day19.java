package Dec;

import java.util.Stack;

public class Day19 {
	//比较含退格的字符串
    public boolean backspaceCompare(String S, String T) {
        Stack<Character>stack1=new Stack<>();
        Stack<Character>stack2=new Stack<>();

        for(int i=0;i<S.length();i++){
            if (S.charAt(i)!='#'){
                stack1.push(S.charAt(i));
            }else{
                if (!stack1.isEmpty()){
                    stack1.pop();
                }
            }
        }

        for(int i=0;i<T.length();i++){
            if (T.charAt(i)!='#'){
                stack2.push(T.charAt(i));
            }else{
                if (!stack2.isEmpty()){
                    stack2.pop();
                }
            }
        }

        if (stack1.size()!=stack2.size()){
            return  false;
        }

        while (!stack1.isEmpty()&&!stack2.isEmpty()){
            if (stack1.peek()!=stack2.peek()){
                return  false;
            }else{
                stack1.pop();
                stack2.pop();
            }
        }

        return  true;

    }
}

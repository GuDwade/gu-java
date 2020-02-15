import java.util.Stack;

public class HomeWork {
    public static boolean backspaceCompare(String S, String T) {
        return delete(S).equals(delete(T));
    }
    public static String delete(String str) {
        Stack<Character>stack=new Stack<>();
        for(char c:str.toCharArray()){
            if(c!='#'){
                stack.push(c);
            }else if(!stack.isEmpty()){
                stack.pop();
            }
        }
        return String.valueOf(stack);
    }

    public static int calPoints(String[] ops) {
        int sum=0;
        Stack<Integer>stack=new Stack<>();
        for(String s:ops){
            if(s.equals("D")){
                int tmp=2*stack.peek();
                sum+=tmp;
                stack.push(tmp);
            }else if(s.equals("C")){
                int tmp=stack.pop();
                sum-=tmp;
            }else if(s.equals("+")){
                int tmp1=stack.pop();
                int tmp2=stack.peek();
                int tmp=tmp1+tmp2;
                sum+=tmp;
                stack.push(tmp1);
                stack.push(tmp);
            }else{
                sum+=Integer.valueOf(s);
                stack.push(Integer.valueOf(s));
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("safd#hfdjshs##","safd#hfdjs"));
        String[]game={"5","2","C","D","+"};
        System.out.println(calPoints(game));
    }

}

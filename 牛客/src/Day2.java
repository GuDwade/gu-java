import java.util.Scanner;
import java.util.Stack;

public class Day2 {
    //有效括号
    public boolean chkParenthesis(String A, int n) {
        if(n%2!=0||n==0){
            return false;
        }
        Stack<Character>stack=new Stack<>();
        for(char c:A.toCharArray()){
            if(c=='('){
                stack.push(c);
            }else{
                if(stack.isEmpty()||stack.pop()!='(')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isNumber(char ch){
        if(ch>='0'&&ch<='9'){
            return  true;
        }
        return false;
    }
    //最长的数字字符串
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();

        int start=0;
        int end=str.length();
        int max=0;
        int subStart=0;

        while(start<end){
            while(start<end&&!isNumber(str.charAt(start))){
                start++;
            }
            int begin=start;
            int count=0;
            while(start<end&&isNumber(str.charAt(start++))){
                count++;
            }
            if(count>max){
                    subStart=begin;
                    max=count;
            }
        }
        String ret=str.substring(subStart,subStart+max);
        System.out.println(ret);
    }
}

package May;

import java.util.Stack;


public class Day25 {
    //字符串解码    辅助栈
    public static String decodeString(String s) {
        StringBuilder res=new StringBuilder();
        int count=0;
        Stack<Integer>cnt=new Stack<>();//记录每一个子串的次数
        Stack<String>str=new Stack<>();//记录上一个子串
        for(char ch:s.toCharArray()){
            if (ch=='['){
                cnt.push(count);
                count=0;
                str.push(res.toString());
                res=new StringBuilder();
            }else if(ch==']'){
                int n=cnt.pop();
                StringBuilder tmp=new StringBuilder();
                for(int i=0;i<n;i++){
                    tmp.append(res);
                }
                res=new StringBuilder(str.pop()+tmp);
            }else if(ch>='0'&&ch<='9'){
                int cur=ch-48;
                count=count*10+cur;
            }else{
                res.append(ch);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
    }
}

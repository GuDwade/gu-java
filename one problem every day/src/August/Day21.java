package August;

import java.util.ArrayList;

public class Day21 {
    //重复的子字符串
    public static boolean repeatedSubstringPattern(String s) {
        int len=s.length();

        for(int i=1;i<=len/2;i++){
            if (len%i!=0){
                continue;
            }
            boolean flag=true;
            for(int j=i;j<len;j++){
                if (s.charAt(j)!=s.charAt(j-i)){
                    flag=false;
                    break;
                }
            }
            if (flag){
                return  true;
            }
        }

        return  false;
    }

    public static boolean repeatedSubstringPattern1(String s) {
        String S=s+s;
        S=S.substring(1, s.length() * 2 - 1);
        return S.contains(s);
    }

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern1("abab"));

    }
}

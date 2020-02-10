import java.util.Arrays;

public class Day3 {
    //计算字母在两个字符串中的个数
    public static boolean canConstruct(String ransomNote, String magazine) {
        if(magazine.length()<ransomNote.length()){
            return false;
        }
        int []letters=new int[26];
        for(char c:magazine.toCharArray()){
            letters[c-'a']++;
        }
        for(char c:ransomNote.toCharArray()){
            if(letters[c-'a']==0){
                return false;
            }
            if((letters[c-'a']--)<0){
                return false;
            }
        }
        return true;
    }
    //重新构造
    public static boolean isPalindrome1(int x) {
        if(x<0){
            return false;
        }
        int ret=0;
        int tmp=0;
        int cur=x;
        while(cur!=0){
            ret=cur%10;
            tmp=tmp*10+ret;
            cur=cur/10;
        }
        return tmp==x;
    }
    //字符串反转
    public static boolean isPalindrome2(int x) {
       String sb=new StringBuilder(String.valueOf(x)).reverse().toString();
       return  sb.equals(String.valueOf(x));
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("abc","abcd"));
        System.out.println(isPalindrome1(121121));
        System.out.println(isPalindrome2(121121));
    }
}

import java.util.Arrays;

public class Day11 {
    public static boolean isPalindrome(String s) {
        s=s.toLowerCase();
        int i=0;
        int j=s.length()-1;
        while(i<j){
            while(i<j&&!isLetterAndSum(s.charAt(i))){
                i++;
            }
            while(i<j&&!isLetterAndSum(s.charAt(j))){
                j--;
            }
            if(i<j){
                if(s.charAt(i)!=s.charAt(j)){
                    return false;
                }else{
                    i++;
                    j--;
                }
            }
        }
        return true;
    }

    public static boolean isLetterAndSum(char c){
        if(c>='a'&&c<='z'||c>='0'&&c<='9'){
            return true;
        }else{
            return  false;
        }
    }

    public static int compress(char[] chars) {
        if(chars.length<=1){
            return chars.length;
        }
        int start=0;
        int end=0;
        while(start<chars.length&&end<chars.length){
            chars[end++]=chars[start];
            int tmp=start;
            while(start<chars.length&&chars[start]==chars[end-1]){
                start++;
            }
            if(start-tmp>1){
                for(char c:String.valueOf(start-tmp).toCharArray()){//向结果中加入相同字符序列的长度的字符形式
                    chars[end++]=c;
                }

            }
        }
        return  end;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("a man, nam A"));
        char[]nums={'a','a','a','a','a','a','a','a','a','a','a','a','a'};
        System.out.println(compress(nums));
        System.out.println(Arrays.toString(nums));
        char[]nums1={'a','a','b','b','b','c','d','d','d','d','d','e','e'};
        System.out.println(compress(nums1));
        System.out.println(Arrays.toString(nums1));
    }
}

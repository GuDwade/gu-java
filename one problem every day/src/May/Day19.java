package May;

public class Day19 {
    //最长回文子串
    public String longestPalindrome(String s) {
        String ret="";
        for(int i=0;i<s.length();i++){
            //奇数
            for(int left=i,right=i;left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right);left--,right++){
                if (ret.length()<right-left+1){
                    ret=s.substring(left,right+1);
                }
            }
            //偶数
            for(int left=i,right=i+1;left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right);left--,right++){
                if (ret.length()<right-left+1){
                    ret=s.substring(left,right+1);
                }
            }
        }

        return  ret;
    }
}

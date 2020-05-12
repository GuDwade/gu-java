import java.util.HashSet;
import java.util.Set;

public class Again {
    //独特的电子邮件地址 
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for(String str : emails){
            int idx=str.indexOf('@');
            String local=str.substring(0,idx);
            StringBuilder sb = new StringBuilder();
            for(char c : local.toCharArray()){
                if(c == '+'){
                    break;
                }else if(c != '.'){
                    sb.append(c);
                }
            }
            sb.append(str.substring(idx));
            set.add(sb.toString());
        }
        return set.size();
    }

    //最长回文子串
    public String longestPalindrome(String s) {
        String ret="";

        for(int i=0;i<s.length();i++){
            //奇数
            for(int left=i,right=i;left>=0&&right<s.length()
                    &&s.charAt(left)==s.charAt(right);left--,right++){
                if(ret.length()<right-left+1){
                    ret=s.substring(left,right+1);
                }
            }
            //偶数
            for(int left=i,right=i+1;left>=0&&right<s.length()
                    &&s.charAt(left)==s.charAt(right);left--,right++){
                if(ret.length()<right-left+1){
                    ret=s.substring(left,right+1);
                }
            }
        }

        return  ret;
    }

    //Z字形变换
    public String convert(String s, int numRows) {
        if(numRows==1){
            return  s;
        }

        String res="";
        for(int i=0;i<numRows;i++){
            if(i==0||i==numRows-1){
                for(int j=i;j<s.length();j+=2*(numRows-1)){
                    res+=s.charAt(j);
                }
            }else{
                for(int j=i,k=2*(numRows-1)-i;j<s.length()||k<s.length();j+=2*(numRows-1),k+=2*(numRows-1)){
                    if(j<s.length()){
                        res+=s.charAt(j);
                    }
                    if (k<s.length()){
                        res+=s.charAt(k);
                    }
                }
            }
        }

        return  res;
    }
    //实现strStr（）
    public int strStr(String haystack, String needle) {

        int sz1=haystack.length();
        int sz2=needle.length();

        if (sz2>sz1){
            return -1;
        }

        if (sz2==0){
            return 0;
        }
        int i=0;
        while (i<haystack.length()){
            if (haystack.charAt(i)==needle.charAt(0)){
                int start=i;
                int h=i,n=0;
                for(;h<sz1&&n<sz2;h++,n++){
                    if (haystack.charAt(h)!=needle.charAt(n)){
                        break;
                    }
                }
                if (n==sz2){
                    return  start;
                }
            }
            i++;
        }
        return  -1;
    }
}

import java.util.Arrays;
import java.util.Collections;

public class Day36 {
    //翻转字符串里的单词
    //调用Api
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
    //双指针
    public String reverseWords1(String s) {
        String str=s.trim();
        StringBuilder sb=new StringBuilder();
        int right=str.length()-1;
        int left=str.length()-1;
        while(left>=0&&right>=0){
            while (left>=0&&str.charAt(left)!=' '){
                left--;
            }
            if(left==-1){
                sb.append(str.substring(left+1,right+1));
            }else{
                sb.append(str.substring(left+1,right+1));
                sb.append(' ');
            }
            right=left;
            while (right>=0&&str.charAt(right)==' '){
                right--;
            }
            left=right;
        }
        return  sb.toString();
    }

    public static void main(String[] args) {

    }
}

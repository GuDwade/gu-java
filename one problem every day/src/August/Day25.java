package August;

public class Day25 {
    //反转字符串中的单词 III
    public static String reverseWords(String s) {
        StringBuilder sb=new StringBuilder(s.length());
        int l=0,r=0;

        while (r<s.length()){
            while (r<s.length()&&s.charAt(r)!=' '){
                r++;
            }
            for(int i=r-1;i>=l;i--){
                sb.append(s.charAt(i));
            }
            if (r<s.length()){
                sb.append(' ');
            }
            l=r;
            while (l<s.length()&&s.charAt(l)==' '){
                l++;
            }
            r=l;
        }

        return  sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}

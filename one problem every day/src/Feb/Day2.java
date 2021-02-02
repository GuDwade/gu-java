package Feb;

public class Day2 {
    //替换后的最长重复字符  
    public static int characterReplacement(String s, int k) {

       if (s == null || s.length() == 0 ){
           return 0;
       }

       if(s.length() < 2){
           return s.length();
       }

       char[] chars = s.toCharArray();
       int l = 0 , r = 0;
       int[] letters = new int[26];
       int cnt = 0, ret = 0;

       while (r < s.length()){

           letters[chars[r] - 'A']++;
           cnt = Math.max(cnt,letters[chars[r] - 'A']);
           r++;

           if (r - l - cnt > k){
               letters[chars[l] - 'A']--;
               l++;
           }

           ret = Math.max(r - l ,ret);
       }

       return  ret;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA", 1));
    }
}

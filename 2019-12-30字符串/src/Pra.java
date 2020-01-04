public class Pra {
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int k = 0;
        int n = s.length();
        int max = 1, count = 0;
        for(int i = 0; i < n; i++){
            int j = k;
            while(s.charAt(j) != s.charAt(i) && j < i){
                j++;
            }
            if(s.charAt(j) == s.charAt(i) && j < i){
                k = j + 1;
                count = i - k + 1;
            }else{
                count += 1;
            }
            max = count > max ? count : max;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}

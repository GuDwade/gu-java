import java.util.HashSet;
import java.util.Set;

public class 最长不含重复字符的子字符串 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character>set=new HashSet<>();
        int left=0;
        int right=0;
        int max=0;

        while (left<s.length()&&right<s.length()){
            if (!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                max=Math.max(max,right-left+1);
                right++;
            }else{
                set.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }
}

package May;

import java.util.HashSet;
import java.util.Set;

public class Day2 {
    //无重复字符的最大子串  滑动窗口
    //abcabcbb
    public static int lengthOfLongestSubstring(String s) {
        int max=0,start=0,end=0;
        Set<Character> set=new HashSet<>();
        //[start,end)内无重复字符
        while (start<s.length()&&end<s.length()){

            if (!set.contains(s.charAt(end))){
                set.add(s.charAt(end));
                end++;
                max=Math.max(max,end-start);
            }else{
                //如果出现重复字符  即以当前start为头的子串已达到最佳  移动start直到新子串无重复
                set.remove(s.charAt(start));
                start++;
            }
        }
        return  max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcbcbb"));
    }
}

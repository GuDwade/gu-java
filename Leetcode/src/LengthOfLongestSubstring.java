import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    //暴力法
    public int lengthOfLongestSubstring(String s) {
        int maxLength=0;
        for(int i=0;i<s.length();i++){
            Set<Character> set=new HashSet<>();
            set.add(s.charAt(i));
            for(int j=i+1;j<s.length();j++){
                if(!set.contains(s.charAt(j))){
                    set.add(s.charAt(j));
                }else{
                    break;
                }
            }

            if(set.size()>maxLength){
                maxLength=set.size();
            }

        }

        return maxLength;
    }
    //改进  滑动窗口
    //索引从i到j-1的字符串S已经没有重复元素  检查S[j]在不在S中
    public int lengthOfLongestSubstring1(String s) {
        int maxLength=0;
        int i=0;
        int j=0;
        Set<Character>set=new HashSet<>();
        while(i<s.length()&&j<s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                maxLength=Math.max(maxLength,j-i);
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return maxLength;
    }
}

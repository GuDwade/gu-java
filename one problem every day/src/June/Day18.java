package June;

import java.util.*;

public class Day18 {
    //单词拆分
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        //dp[i] 表示字符串 s前 i个字符组成的字符串 s[0,i-1]是否能被空格拆分成若干个字典中出现的单词。
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Day18 test=new Day18();
        String[]arr=new String[]{"apple", "pen"};
        System.out.println(test.wordBreak("applepenapple", Arrays.asList(arr)));
    }
}

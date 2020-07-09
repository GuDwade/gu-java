package July;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Day10 {
    //恢复空格 未匹配的最少字符
    public int respace(String[] dictionary, String sentence) {
        Set<String> dict = new HashSet<>(Arrays.asList(dictionary));
        int n = sentence.length();
        int[] dp = new int[n + 1];
        //dp[i] 表示字符串的前 i 个字符的最少未匹配数。
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int idx = 0; idx < i; idx++) {
                if (dict.contains(sentence.substring(idx, i))) {
                    dp[i] = Math.min(dp[i], dp[idx]);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Day10 test=new Day10();
        test.respace(new String[]{"looked","just","like","her","brother"}, "jesslookedjustliketimherbrother");
    }

}

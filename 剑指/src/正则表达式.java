public class 正则表达式 {
    public static boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        //字符串s的前i个字符 能否与 字符串p的前j个字符串匹配
        boolean[][] dp = new boolean[n + 1][m + 1];

        for(int i = 0; i <= n; i++ ){
            for(int j = 0; j <= m; j++ ){
                if(j == 0){
                    dp[i][j] = i == 0;
                }else{
                    if(p.charAt(j - 1) != '*'){
                        if(i >= 1 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')){
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    }else{
                        if(j >= 2){
                            dp[i][j] |= dp[i][j - 2];
                        }

                        if(i >=1 && j >= 2 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')){
                            dp[i][j] |= dp[i - 1][j];
                        }

                    }
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        isMatch("aab" , "c*a*b");
    }
}

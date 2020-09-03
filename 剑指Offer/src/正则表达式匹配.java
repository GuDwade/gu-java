public class 正则表达式匹配 {

    public static boolean isMatch(String A, String B) {
        int n = A.length();
        int m = B.length();
        boolean[][] f = new boolean[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                //分成空正则和非空正则两种
                if (j == 0) {
                    f[i][j] = i == 0;
                } else {
                    //非空正则分为两种情况 * 和 非*
                    if (B.charAt(j - 1) != '*') {
                        if (i > 0 && (A.charAt(i - 1) == B.charAt(j - 1) || B.charAt(j - 1) == '.')) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    } else {
                        //碰到 * 了，分为看和不看两种情况
                        //不看
                        if (j >= 2) {
                            f[i][j] |= f[i][j - 2];
                        }
                        //看
                        if (i >= 1 && j >= 2 && (A.charAt(i - 1) == B.charAt(j - 2) || B.charAt(j - 2) == '.')) {
                            f[i][j] |= f[i - 1][j];
                        }
                    }
                }
            }
        }
        return f[n][m];
    }
    public static boolean match(char[] str, char[] pattern){
        int m=str.length;
        int n=pattern.length;
        boolean[][]dp=new boolean[m+1][n+1];

        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(j==0){
                    dp[i][j]=(i==0);
                }else{
                    if(pattern[j-1]!='*'){
                        if (i > 0 && (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.')) {
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    }else{
                        if(j>=2){
                            dp[i][j]|=dp[i][j-2];
                        }
                        if(i>=1&&j>=2&&(str[i-1]==pattern[j-2]||pattern[j-2]=='.')){
                            dp[i][j]|=dp[i-1][j];
                        }
                    }
                }
            }
        }

        return dp[m][n];
    }
    public static void main(String[] args) {
        //isMatch("aaa","ab*ac*a");
        match("".toCharArray(),".*".toCharArray());
    }
}

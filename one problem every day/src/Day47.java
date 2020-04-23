public class Day47 {
    //硬币
    public static int waysToChange(int n) {
        int[] coins = new int[]{1, 5, 10, 25};
        //dp[i][j] 表示 i 种硬币组成面值为 j 时的方法数
        int[][] dp = new int[5][n + 1];

        for (int i = 1; i <= 4; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= n; j++) {
                if (j - coins[i-1] < 0){
                    dp[i][j] = dp[i - 1][j] % 1000000007;
                } else {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - coins[i-1]]) % 1000000007;
                }
            }
        }
        return dp[4][n];
    }

    public static void main(String[] args) {
        int n=waysToChange(10);
    }
}

package May;

public class Day8 {
    //最大正方形

    public int maximalSquare(char[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int n = matrix.length;
        int m = matrix[0].length;
        //dp[i][j]表示以第i行第j列元素为右下角所能构成的最大正方形边长
        //当 它的 左 上  左上 三个位置中任意一个为0不能构成更大的正方形
        int[][] dp = new int[n][m];
        int max=0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max*max;
    }

}

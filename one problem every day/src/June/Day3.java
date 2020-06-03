package June;

public class Day3 {

    // 新21点

    public double new21Game(int N, int K, int W) {
        if (K == 0) {
            return 1.0;
        }
        // dp[x] 表示从得分为 x 的情况开始游戏并且获胜的概率，目标是求 dp[0]dp[0] 的值
        double[] dp = new double[K + W];
        for (int i = K; i <= N && i < K + W; i++) {
            dp[i] = 1.0;
        }

        /*
        for (int i = K - 1; i >= 0; i--) {
            for (int j = 1; j <= W; j++) {
                dp[i] += dp[i + j] / W;
            }
        }


        dp[x]=dp[x+1]+dp[x+2]+⋯+dp[x+W]/W
        dp[x]−dp[x+1]= dp[x+1]−dp[x+W+1]/W
​       dp[x]=dp[x+1]− dp[x+W+1]−dp[x+1]/W
​
​
         */
        dp[K - 1] = 1.0 * Math.min(N - K + 1, W) / W;
        for (int i = K - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] - (dp[i + W + 1] - dp[i + 1]) / W;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Day3 test=new Day3();
        test.new21Game(21,17,10);
    }
}

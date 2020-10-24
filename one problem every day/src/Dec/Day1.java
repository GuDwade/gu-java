package Dec;

public class Day1 {
    //秋叶收藏集
    public static int minimumOperations(String leaves) {
        int n=leaves.length();
        int [][] dp = new int[n][3];
        //表示对于第 0片到第 i片叶子（记为 leaves[0..i]）进行调整操作，并且第 i片叶子处于状态 j时的最小操作次数
        dp[0][0] = leaves.charAt(0)== 'r' ? 0 : 1;
        dp[0][1]=dp[0][2]=dp[1][2]=Integer.MAX_VALUE;

        for(int i=1;i<n;i++){
            int r=leaves.charAt(i)=='r'?1:0;
            int y=leaves.charAt(i)=='y'?1:0;

            dp[i][0]=dp[i-1][0]+y;
            dp[i][1]=Math.min(dp[i-1][0],dp[i-1][1])+r;
            if (i>=2){
                dp[i][2]=Math.min(dp[i-1][1],dp[i-1][2])+y;
            }
        }

        return  dp[n-1][2];
    }

    public static void main(String[] args) {
        System.out.println(minimumOperations("yry"));
        System.out.println(minimumOperations("rrryyyrryyyrr"));
    }
}

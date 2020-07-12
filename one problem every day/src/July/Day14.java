package July;

public class Day14 {
	//地下城游戏

    int[][] memo; // 定义记忆化数组
    public int calculateMinimumHP1(int[][] dungeon) {
        memo = new int[dungeon.length][dungeon[0].length];
        return dfs(dungeon, dungeon.length, dungeon[0].length, 0, 0);
    }

    private int dfs(int[][] dungeon, int m, int n, int i, int j) {
        // 到达终点，递归终止。
        if (i == m - 1 && j == n - 1) {
            return Math.max(1 - dungeon[i][j], 1);
        }
        // 如果memo数组中有值，直接取出并返回，不进行后续的搜索。
        if (memo[i][j] > 0) {
            return memo[i][j];
        }
        // 同解法一，向右搜+向下搜
        int minRes = 0;
        if (i == m - 1) {
            minRes =  Math.max(dfs(dungeon, m, n, i, j + 1) - dungeon[i][j], 1);
        } else if (j == n - 1) {
            minRes = Math.max(dfs(dungeon, m, n, i + 1, j) - dungeon[i][j], 1);
        } else {
            minRes = Math.max(Math.min(dfs(dungeon, m, n, i + 1, j), dfs(dungeon, m, n, i, j + 1)) - dungeon[i][j], 1);
        }
        // 将结果存入memo数组
        return memo[i][j] = minRes;
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int m=dungeon.length;
        int n=dungeon[0].length;
        int[][]dp=new int[m][n];

        dp[m-1][n-1]=Math.max(1-dungeon[m-1][n-1],1);

        for(int i=n-2;i>=0;i--){
            dp[m-1][i]=Math.max(dp[m-1][i+1]-dungeon[m-1][i],1);
        }

        for(int j=m-2;j>=0;j--){
            dp[j][n-1]=Math.max(dp[j+1][n-1]-dungeon[j][n-1],1);
        }

        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                dp[i][j]=Math.max(Math.min(dp[i][j+1],dp[i+1][j])-dungeon[i][j],1);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        Day14  test=new Day14();
        System.out.println(test.calculateMinimumHP(new int[][]{
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        }));
    }
}

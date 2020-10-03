import java.util.List;

public class Day2 {
    //三角形最小路径和  优化  从上到下
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][]dp=new int[n][n];
        dp[0][0]=triangle.get(0).get(0);

        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++){
                dp[i][j]=Integer.MAX_VALUE;
                if(j>0){
                    dp[i][j]=Math.min(dp[i][j],dp[i-1][j-1]+triangle.get(i).get(j));
                }
                if (j<i){
                    dp[i][j]=Math.min(dp[i][j],dp[i-1][j]+triangle.get(i).get(j));
                }
            }
        }

        int ret=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            ret=Math.min(ret,dp[n-1][i]);
        }

        return  ret;
    }

    //一维数组
    public int minimumTotal1(List<List<Integer>> triangle) {
        int n=triangle.size();
        int []dp=new int[n];

        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=i;j++){
                dp[j]=Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
            }
        }

        return  dp[0];
    }

    //不同路径 II
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int dp[][]=new int[m][n];

        if (obstacleGrid[0][0]==1){
            return  0;
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                if (i==0&&j==0){
                    dp[i][j]=1;
                }

                if (obstacleGrid[i][j]==1){
                    continue;
                }

                if (i>0){
                    dp[i][j]+=dp[i-1][j];
                }
                if (j>0){
                    dp[i][j]+=dp[i][j-1];
                }

            }
        }

        return  dp[m-1][n-1];
    }

}

package July;

public class Day6 {
    //不同路径 II
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int [][]dp=new int[m][n];

        if(obstacleGrid[0][0]==1){
            return 0;
        }
        dp[0][0]=1;

        for(int i=1;i<n;i++){
            if(obstacleGrid[0][i]==0){
                dp[0][i]=1;
            }else{
                break;
            }
        }

        for(int j=1;j<m;j++){
            if(obstacleGrid[j][0]==0){
                dp[j][0]=1;
            }else{
                break;
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==0){
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }else{
                    dp[i][j]=0;
                }
            }
        }

        return dp[m-1][n-1];

    }
}

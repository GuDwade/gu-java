import java.util.Arrays;

public class Day31 {
    public int uniquePaths(int m, int n) {
        //不同路径
        int[][]dp=new int [m][n];
        dp[0][0]=1;

        for(int i=1;i<n;i++){
            dp[0][i]=1;
        }

        for(int j=1;j<m;j++){
            dp[j][0]=1;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }

        return dp[m-1][n-1];

    }

    ////不同路径 添加障碍
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
                while(i<n){
                    dp[0][i++]=0;
                }
            }
        }

        for(int j=1;j<m;j++){
            if(obstacleGrid[j][0]==0){
                dp[j][0]=1;
            }else{
                while(j<m){
                    dp[j++][0]=0;
                }
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

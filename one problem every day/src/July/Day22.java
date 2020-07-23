package July;

public class Day22 {

    //最小路径和

    int[]dx={1,0};
    int[]dy={0,1};
    int m,n;
    int min;
    public int minPathSum(int[][] grid) {
        min=Integer.MAX_VALUE;
        m=grid.length;
        n=grid[0].length;
        dfs(0,0,grid,0);
        return min;
    }

    private void dfs(int x, int y, int[][] grid,int sum) {
        sum+=grid[x][y];
        if(x==m-1&&y==n-1){
            min=Math.min(min,sum);
            return;
        }
        for(int i=0;i<2;i++){
            int newX=x+dx[i];
            int newY=y+dy[i];
            if(newX>=0&&newX<m&&newY>=0&&newY<n){
                dfs(newX,newY,grid,sum);
            }
        }
        sum-=grid[x][y];
    }

    public int minPathSum1(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int[][]dp=new int[row][col];

        dp[0][0]=grid[0][0];

        //第一行到达只能向右走
        for(int i=1;i<row;i++){
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }

        //第一列到达只能向下走
        for(int j=1;j<col;j++){
            dp[0][j]=dp[0][j-1]+grid[0][j];
        }

        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }

        return dp[row-1][col-1];
    }
}

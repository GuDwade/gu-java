public class 礼物的最大价值 {
    int[]dx={1,0};
    int[]dy={0,1};
    int max=0;
    int n,m;
    public int maxValue(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        dfs(grid,0,0,grid[0][0]);
        return  max;
    }

    private void dfs(int[][] grid, int x, int y, int sum) {
        if(x==n-1&&y==m-1&&sum>max){
            max=sum;
            return;
        }

        for(int i=0;i<2;i++){
            int newX=x+dx[i];
            int newY=y+dy[i];
            if (newX<n&&newY<m){
                sum+=grid[newX][newY];
                dfs(grid,newX,newY,sum);
                sum-=grid[newX][newY];
            }

        }
    }

    public int maxValue1(int[][] grid) {
       int n=grid.length;
       int m=grid[0].length;
       int[][]dp=new int[n][m];

       dp[0][0]=grid[0][0];

       for(int i=1;i<m;i++){
           dp[0][i]=dp[0][i-1]+grid[0][i];
       }

       for(int i=1;i<n;i++){
           dp[i][0]=dp[i-1][0]+grid[i][0];
       }

       for(int i=1;i<n;i++){
           for(int j=1;j<m;j++){
               dp[i][j]=grid[i][j]+Math.max(dp[i][j-1],dp[i-1][j]);
           }
       }

       return dp[n-1][m-1];
    }
}

public class Continue {
    //旋转字符串
    public boolean isFlipedString(String s1, String s2) {
        if(s1.length()!=s2.length()){
            return  false;
        }
        String build=s2+s2;
        return build.contains(s1);
    }

    //爬楼梯
    public int climbStairs(int n) {
        if(n==1){
            return  1;
        }
        if(n==2){
            return 2;
        }
        int[]dp=new int[n];
        dp[0]=1;
        dp[1]=2;
        for(int i=2;i<n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }

    //最小路径和
    public int minPathSum(int[][] grid) {
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

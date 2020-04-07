public class Day33 {
	//旋转二维数组
    public void rotate(int[][] matrix) {
        int N=matrix.length;
        //对角线交换
        for(int i=0;i<N-1;i++){
            for(int j=i+1;j<N;j++){
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=tmp;
            }
        }
        //以每一行中点 进行交换
        for(int i=0;i<N;i++){
            for(int j=0;j<N/2;j++){
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[i][N-1-j];
                matrix[i][N-1-j]=tmp;
            }
        }
    }
    //完全平方数的最小个数
    public int numSquares(int n) {
        int[]dp=new int[n+1];
        for(int i=0;i<=n;i++){
            dp[i]=i;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j*j<=i;j++){
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
    //整数拆分 最大乘机
    public int integerBreak(int n) {
        if(n==2)
            return 1;
        if(n==3)
            return 2;
        if(n==4)
            return 4;

        int []dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        dp[4]=4;
        for(int i=5;i<=n;i++){
            for(int j=1;j<i;j++){
                dp[i]=Math.max(dp[i],dp[j]*dp[i-j]);
            }
        }
        return dp[n];
    }
}

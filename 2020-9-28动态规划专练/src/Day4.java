public class Day4 {

    //最长上升子序列
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[]dp=new int[n];
        int max=-1;

        for(int i=0;i<n;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if (nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            max=Math.max(dp[i],max);
        }

        return  max;
    }


    //编辑距离
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][]dp=new int[n+1][m+1];

        for(int i=0;i<=n;i++){
            dp[i][0]=i;
        }

        for(int j=1;j<=m;j++){
            dp[0][j]=j;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1])+1;
                }
            }
        }

        return  dp[n][m];
    }

    //奇怪的打印机
    public static int strangePrinter(String s) {
        if(s==null||s.length()==0){
            return  0;
        }

        int n=s.length();
        int[][]dp=new int[n+1][n+1];

        for(int len=1;len<=n;len++){
            for(int l=0;l+len-1<n;l++){
                int r=l+len-1;
                dp[l][r]=dp[l+1][r]+1;
                for(int k=l+1;k<=r;k++){
                    if (s.charAt(k)==s.charAt(l)){
                        dp[l][r]=Math.min(dp[l][r],dp[l][k-1]+dp[k+1][r]);
                    }
                }
            }
        }

        return  dp[0][n-1];
    }

    //正则表达式
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        boolean [][] dp=new boolean[n+1][m+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(j==0){
                    dp[i][j]=(i==0);
                }else{
                    if (p.charAt(j-1)!='*'){
                        if (i>0&&(p.charAt(j-1)==s.charAt(i-1)||p.charAt(j-1)=='.')){
                            dp[i][j]=dp[i-1][j-1];
                        }
                    }else{
                        if(j>=2){
                            dp[i][j]|=dp[i][j-2];
                        }

                        if(i>=1&&j>=2&&(s.charAt(i-1)==p.charAt(j-2)||p.charAt(j-2)=='.')){
                            dp[i][j]|=dp[i-1][j];
                        }
                    }
                }
            }
        }

        return dp[n][m];

    }

    public static void main(String[] args) {
        System.out.println(strangePrinter("aba"));
    }

}

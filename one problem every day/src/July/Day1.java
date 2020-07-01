package July;

public class Day1 {
    //最长重复子数组
    public static int findLength(int[] A, int[] B) {
       if(A==null||A.length==0||B==null||B.length==0){
           return 0;
       }
       //dp[i][j]代表以A[i-1]与B[j-1]结尾的公共字串的长度
       int[][]dp=new int[A.length+1][B.length+1];
       int result=0;
       for(int i=1;i<=A.length;i++){
           for(int j=1;j<=A.length;j++){
               if (A[i-1]==B[j-1]){
                   dp[i][j]=dp[i-1][j-1]+1;
                   result=Math.max(result,dp[i][j]);
               }
           }
       }
       return  result;
    }

    public static void main(String[] args) {
        System.out.println(findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }

}

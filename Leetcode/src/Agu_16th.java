import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class Agu_16th {
    public boolean threeConsecutiveOdds(int[] arr) {
        for(int i=0;i<arr.length-2;i++){
            boolean flag=false;
            for(int j=i;j<=i+2;j++){
               if (arr[j]%2==0){
                   flag=true;
                   break;
               }
            }
            if (!flag){
                return  true;
            }

        }
        return  false;
    }

    public static int minOperations(int n) {

        int count=0;
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=2*i+1;
        }
        int ave=(arr[0]+arr[n-1])/2;
        for(int i=0;i<n/2;i++){
            count+=(ave-arr[i]);
        }
        return count;
    }
    static int  min=Integer.MAX_VALUE;
    public static int minDays(int n) {
        if (n==1){
            return 1;
        }
        dfs(n,0);
        return  min;
    }

    private static void dfs(int n, int day) {
        if (n==0){
            min=Math.min(min,day);
            return;
        }
        if (n%2==0){
            dfs(n-(n/2),day+1);
        }
        if (n%3==0){
            dfs(n-2*(n/3),day+1);
        }

        dfs(n-1,day+1);
    }

    public static int minDays1(int n) {
       int []dp=new int[n+1];
       dp[1]=1;
       for(int i=2;i<=n;i++){
           dp[i]=dp[i-1]+1;
         if (i%2==0){
             dp[i]=Math.min(dp[i-i/2]+1,dp[i]);
         }
         if (i%3==0){
             dp[i]=Math.min(dp[i-2*(i/3)]+1,dp[i]);
         }

       }
       return dp[n];
    }

    public static void main(String[] args) {
       // System.out.println(minOperations(6));
        System.out.println(minDays1(56));
        System.out.println(minDays(3));

    }
}

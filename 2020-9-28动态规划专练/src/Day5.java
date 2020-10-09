import java.util.Arrays;

public class Day5 {
    //俄罗斯套娃信封问题
    public static int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b) ->{
            int ret=a[0]-b[0];
            if(ret==0){
                ret=b[1]-a[1];
            }
            return  ret;
        });

        int n=envelopes.length;
        int[]dp=new int[n];
        int ret=0;

        for(int i=0;i<n;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if (envelopes[j][0]<envelopes[i][0]&&envelopes[j][1]<envelopes[i][1]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            ret=Math.max(ret,dp[i]);
        }

        return  ret;
    }

    //比特位计数
    public int[] countBits(int num) {
        int[]dp=new int[num+1];
        dp[0]=0;

        //O(logn)
//        for(int i=1;i<=num;i++){
//            int t=i;
//            while (t>0){
//                if ((t&1)==1){
//                    dp[i]++;
//                }
//                t>>=1;
//            }
//        }

        //dp[i] =dp[i/2]+1;
        for(int i=1;i<=num;i++){
            dp[i]=dp[i>>1];
            if ((i&1)==1){
                dp[i]+=1;
            }
        }

        return dp;
    }



    public static void main(String[] args) {
        System.out.println(maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
    }
}

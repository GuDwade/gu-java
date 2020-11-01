package Dec;


import java.util.Arrays;

public class Day24 {

    //视频拼接
    public int videoStitching(int[][] clips, int T) {
            int[]dp=new int[T+1];
            Arrays.fill(dp,T+1);
            dp[0]=0;

            for(int i=1;i<=T;i++){
                for(int[]clip:clips){
                    if (i>clip[0]&&i<=clip[1]){
                        dp[i]=Math.min(dp[i],dp[clip[0]]+1);
                    }
                }
            }

        return  dp[T]==T+1?-1:dp[T];
    }

    // 按键持续时间最长的键

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int [] times=new int[26];
        times[keysPressed.charAt(0)-'a']+=releaseTimes[0];

        for(int i=1;i<releaseTimes.length;i++){
            times[keysPressed.charAt(i)-'a']+=releaseTimes[i]-releaseTimes[i-1];
        }

        int idx=0;
        int max=times[0];
        for(int i=1;i<26;i++){
            if (times[i]>max){
                max=times[i];
                idx=i;
            }
        }

        return (char)(idx+'a');
    }
}

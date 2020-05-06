package May;

public class Day6 {
    //最低票价

    public static int mincostTickets(int[] days, int[] costs) {
        // 到第I天的最低票价        最大天数
        int dp[] = new int[days[days.length-1]+1];
        for(int i = 0;i<days.length;i++){
            dp[days[i]] = -1;
        }
        for(int i = 1;i<dp.length;i++){
            if(dp[i]==0){
                dp[i] = dp[i-1];
            }else{
                dp[i] = Math.min(costs[0]+dp[i-1],Math.min(i>=7?costs[1]+dp[i-7]:costs[1],i>=30?costs[2]+dp[i-30]:costs[2]));
            }
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        int []days = {1,4,6,7,8,20};
        int[]costs = {2,7,15};
        System.out.println(mincostTickets(days,costs));
    }
}

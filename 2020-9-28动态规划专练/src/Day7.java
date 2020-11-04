public class Day7 {
    int cnt=0;

    public int countArrangement(int N) {
        int []arr=new int[N+1];
        for(int i=0;i<=N;i++){
            arr[i]=i;
        }
        dfs(arr,1);
        return  cnt;
    }

    private void dfs(int[] arr, int idx) {

        if (idx==arr.length){
            cnt++;
        }


        for(int i=idx;i<arr.length;i++){
            swap(arr,i,idx);
            if (arr[idx]%idx==0||idx%arr[idx]==0){
                dfs(arr,idx+1);
            }
            swap(arr,i,idx);
        }

    }

    private void swap(int[] arr, int i, int j) {
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }

    //预测赢家
    public boolean PredictTheWinner(int[] nums) {
        if (nums.length<=1){
            return  true;
        }
        int n=nums.length;
        int[][]dp=new int[n][n];
        //f[i][j]  在[i,j]的区间内第一个玩家的最多得分

        if((n&1)==1){
            for(int i=0;i<n;i++){
                dp[i][i]=nums[i];
            }
        }


        for(int i=2;i<=n;i++){
            for(int j=0;j+i-1<n;j++){
                int l=j,r=j+i-1;
                if ((n-(r-l+1))%2==0){
                    dp[l][r]=Math.max(dp[l+1][r]+nums[l],dp[l][r-1]+nums[r]);
                }else{
                    dp[l][r]=Math.min(dp[l+1][r],dp[l][r-1]);
                }
            }
        }

        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        return dp[0][n-1]>=sum-dp[0][n-1];
    }




    public static void main(String[] args) {
        Day7 test=new Day7();
        System.out.println(test.countArrangement(3));
        System.out.println(test.PredictTheWinner(new int[]{1,5,233,7}));
    }
}

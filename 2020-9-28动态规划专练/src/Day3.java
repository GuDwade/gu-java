public class Day3 {
    //解码方法
    public static int numDecodings(String s) {
        int n=s.length();
        int[]dp=new int[n+1];

        dp[0]=1;

        for(int i=1;i<=n;i++){
            if(s.charAt(i-1)!='0'){
                dp[i]+=dp[i-1];
            }
            if(i>=2){
                int num=(s.charAt(i-2)-'0')*10+s.charAt(i-1)-'0';
                if(num>=10&&num<=26){
                    dp[i]+=dp[i-2];
                }
            }
        }

        return  dp[n];
    }

    //打家劫舍  两个数组
    public int rob(int[] nums) {

        int len=nums.length;
        if (len==0||nums==null) {
            return 0;
        }
        if (len== 1) {
            return nums[0];
        }

        int[]g=new int[len+1]; //不选nums[i]
        int[]f=new int[len+1]; //选nums[i]

        for(int i=1;i<=len;i++){
            g[i]=Math.max(g[i-1],f[i-1]);
            f[i]=g[i-1]+nums[i-1];
        }

        return  Math.max(g[len],f[len]);

    }



    public static void main(String[] args) {
        System.out.println(numDecodings("226"));
    }
}

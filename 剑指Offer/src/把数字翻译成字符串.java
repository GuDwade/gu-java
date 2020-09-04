public class 把数字翻译成字符串 {
    public static int translateNum(int num) {
        String str=String.valueOf(num);
        int n=str.length();
        int[]dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1];
            int t= (str.charAt(i-2)-'0')*10+str.charAt(i-1)-'0';
            if(t>=10&&t<=25){
                dp[i]+=dp[i-2];
            }
        }

        return  dp[n];
    }

    public static void main(String[] args) {
        System.out.println(translateNum(12258));
    }
}

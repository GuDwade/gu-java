public class Day32 {
    //给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数
    public int minDistance(String word1, String word2) {
        int len1=word1.length();
        int len2=word2.length();
        //dp[i][j]表示把word1的前i个元素转换为word2的前j个元素所使用的最少操作数
        int[][]dp=new int[len1+1][len2+1];

        for(int i=0;i<=len1;i++){
            dp[i][0]=i;
        }

        for(int j=1;j<=len2;j++){
            dp[0][j]=j;
        }

        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1])+1;
                    //dp[i][j-1]  :增加   把word1的前i个元素转换为word2的前j-1个元素     在word1后添加相同元素
                    //dp[i-1][j]  :删除   把word1的前i-1个元素转换为word2的前j个元素     删除word1的第i个元素
                    //dp[i-1][j-1]:替换   把word1的前i-1个元素转换为word2的前j-1个元素   把word1的第i个元素替换为word2的前j个元素
                }
            }
        }

        return dp[len1][len2];

    }
}

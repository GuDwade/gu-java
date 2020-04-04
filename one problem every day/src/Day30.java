public class Day30 {
    //接雨水
    //每个柱子顶部可以储水的高度为：该柱子的左右两侧最大高度的较小者减去此柱子的高度。
    public int trap(int[] height) {

        int water=0;

        for(int i=1;i<height.length-1;i++){
            int leftMax=0;
            int rightMax=0;
            //找到左边的最高柱子
            for(int j=0;i<i;j++){
                leftMax = Math.max(leftMax, height[j]);
            }
            //找到右边的最高柱子
            for(int k=i+1;k<height.length;k++){
                rightMax=Math.max(rightMax, height[k]);
            }
            //取小的
            int heightMin=Math.min(leftMax,rightMax);
            //如果比我小 或者相等存不了水
            if(heightMin>height[i]){
                water+=heightMin-height[i];
            }
        }
        return  water;
    }

    //动态规划
    public int trap1(int[] height) {
        int n=height.length;
        if (n == 0) {
            return 0;
        }
        //dp[i][0]表示当前柱子左边最大高度
        //dp[i][1]表示当前柱子右边最大高度
        int[][]dp=new int[n][2];
        dp[0][0]=height[0];
        dp[n-1][1]=height[n-1];

        //左边最大高度=前一个柱子左边的最大高度与前一个柱子高度的大者
        for(int i=1;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][0],height[i-1]);
        }
        //右边最大高度=后一个柱子右边的最大高度与后一个柱子高度的大者
        for(int j=n-2;j>=0;j--){
            dp[j][1]=Math.max(dp[j+1][1],height[j+1]);
        }

        int water=0;
        for(int k=0;k<n;k++){
            int min=Math.min(dp[k][0],dp[k][1]);
            if(min>height[k]){
                water+=min-height[k];
            }
        }
        return  water;
    }
}

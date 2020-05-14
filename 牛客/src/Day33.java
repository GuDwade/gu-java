public class Day33 {
    //百万富翁
    public static void main(String[] args) {
        int sumRich=10*30;
        long sumStrange=0;
        int day=0;
        int i=1;
        while (day<30){
            sumStrange+=i;
            i=i<<1;
        }
        System.out.println(sumRich+" "+sumStrange);
    }
    //中国牛市

    public int calculateMax(int[] prices) {
        int ret=0;
        for(int i=1; i<prices.length; i++){
            int tmp = maxProfit(prices,0,i) + maxProfit(prices,i,prices.length-1);
            if(tmp>ret) {
                ret=tmp;
            }
        }
        return ret;
    }
    // 求最大start到end之间的最大利润函数
    public int maxProfit(int[] prices, int left, int right){
        int max = 0;
        int min = prices[left];
        for(int i=left+1; i<=right; i++){
            if(prices[i] < min)
                min = prices[i];
            if(prices[i]-min > max)
                max = prices[i] - min;
        }
        return max;
    }
}

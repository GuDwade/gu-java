public class Day4 {
    //买股票的最佳时机
    //暴力法
    public static int maxProfit(int[] prices) {
        int max=0;
        for(int i=0;i<prices.length-1;i++){
            for(int j=i+1;j<prices.length;j++){
                if(prices[j]>prices[i]){
                    int money=prices[j]-prices[i];
                    if(money>max){
                        max=money;
                    }
                }
            }
        }
        return max;
    }
    //找最小值 记录每段最小值内的最大lir
    public static int maxProfit1(int[] prices) {
        int minPrice=Integer.MAX_VALUE;
        int maxProfit=0;
        for(int i=0;i<prices.length;i++){
            //找到低的价格
            if(prices[i]<minPrice){
                minPrice=prices[i];
            }else if(prices[i]-minPrice>maxProfit){
                //计算当前价格到下一更低价格区间内的最大利润
                maxProfit=prices[i]-minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[]prices={2,5,1,3};
        //int profit=maxProfit(prices);
        int profit=maxProfit1(prices);
        System.out.println(profit);
    }
}

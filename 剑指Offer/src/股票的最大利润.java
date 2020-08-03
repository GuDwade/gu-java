public class 股票的最大利润 {
    public int maxProfit(int[] prices) {
        int ret=0;
        int min=1000000;

        for(int price:prices){
            min=Math.min(min,price);
            ret=Math.max(ret,price-min);
        }

        return ret;
    }
}

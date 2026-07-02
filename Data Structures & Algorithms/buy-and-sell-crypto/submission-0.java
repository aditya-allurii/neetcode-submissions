class Solution {
    public int maxProfit(int[] prices) {
        int minprice = prices[0];//buy one first day
        int maxprofit = 0;//initially 0 profit
        //now selling
        for(int i = 1;i<prices.length;i++){
            
            minprice = Math.min(minprice,prices[i]);//if we find least price on other days buy it
            maxprofit = Math.max(maxprofit,prices[i] - minprice);
            
        }
        return maxprofit;
    }
}

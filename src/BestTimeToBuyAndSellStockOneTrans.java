public class BestTimeToBuyAndSellStockOneTrans {
    public int maxProfit(int[] prices) {
        int buying=1000000,profit=0;
        for(int moneyMake: prices){
            buying=Math.min(moneyMake,buying);
            profit=Math.max(profit,moneyMake-buying);
        }
        return profit;
    }
}

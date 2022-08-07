import java.util.ArrayList;
public class BestTimeToBuyAndSellStockOneTrans {
    // Time Complexity :- O(N)
    // Space Complexity :- O(1)
    // Link :- https://www.codingninjas.com/codestudio/problems/stocks-are-profitable_893405?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=1
    public static int maximumProfit(ArrayList<Integer> prices){
        int mini=prices.get(0),profit=0;
        for(int i=1;i<prices.size();i++){
            int cost=prices.get(i)-mini;
            profit=Math.max(profit,cost);
            mini=Math.min(mini,prices.get(i));
        }
        return profit;

    }

    // Time Complexity :- O(N)
    // Space Complexity :- O(1)
    public int maxProfit(int[] prices) {
        int buying=1000000,profit=0;
        for(int moneyMake: prices){
            buying=Math.min(moneyMake,buying);
            profit=Math.max(profit,moneyMake-buying);
        }
        return profit;
    }
}

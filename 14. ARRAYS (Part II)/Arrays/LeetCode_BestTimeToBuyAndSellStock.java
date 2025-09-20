// LeetCode: 121. Best Time to Buy and Sell Stock

package Arrays;

public class LeetCode_BestTimeToBuyAndSellStock {
    public static int buyAndSellStocks(int prices[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i ++) {
            if(buyPrice < prices[i]) {
                int profit = prices[i] - buyPrice; // Today's Profit
                maxProfit = Math.max(maxProfit, profit); // Global Profit
            } else {
                buyPrice = prices[i];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int prices[] = {7, 1, 5 , 3, 6, 4};
        System.out.println(buyAndSellStocks(prices));
    }
}

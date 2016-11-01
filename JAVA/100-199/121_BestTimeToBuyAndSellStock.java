// Say you have an array for which the ith element is the price of a given stock on day i.

// If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
// design an algorithm to find the maximum profit.

//Idea: Dynamic Programming. Notation P[i] means the maximum profit we can get if we sell it on day i. 
//min_price is the minimal price in the first i days, the maximum profit is prices[i] - min_price.
//P[i] = max{P[i-1], prices[i] - min_price}
//The total time complexity is O(n)

public class Solution {
    public int maxProfit(int[] prices) {
        int min_price = Integer.MAX_VALUE,max_profit = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < min_price) min_price = prices[i];
            max_profit = Math.max(max_profit, prices[i] - min_price);
        }
        return max_profit;
    }
}

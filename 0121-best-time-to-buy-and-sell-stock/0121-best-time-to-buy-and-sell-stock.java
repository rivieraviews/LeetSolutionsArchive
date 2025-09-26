class Solution {
    public int maxProfit(int[] prices) {
        int diff = 0;
        int currMin = prices[0];
        for (int i = 0; i < prices.length; i++)
        {
            currMin = (currMin < prices[i]) ? currMin : prices[i];
            diff = (diff > (prices[i] - currMin)) ? diff : (prices[i] - currMin);
        }

        return diff;
    }
}
public class Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        int maxi = 0;
        int mini = prices[0];
        for(int i=1;i<prices.length;i++){
            mini = Math.min(mini , prices[i]);
            maxi = Math.max(maxi , prices[i]-mini);
        }
        return maxi;
    }
}

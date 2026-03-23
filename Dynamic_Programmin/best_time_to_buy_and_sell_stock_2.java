class Solution {
    public int maxProfit(int[] prices) {
        // return solve(0, prices, -1,true);

        // solve using Memorization

        // int n = prices.length;
        // int[][][] dp = new int[n + 1][n + 1][2];

        // for (int i = 0; i <= n; i++) {
        //     for (int j = 0; j <= n; j++) {
        //         for (int k = 0; k < 2; k++) {
        //             dp[i][j][k] = -1;
        //         }
        //     }
        // }
        // return solveDP(0, prices, -1, true, dp);

        // return solveTab(prices);
        return solveOptimal(prices);
    }

    private int solve(int index, int[] prices, int prevInd, boolean isBuy) {
        if (index >= prices.length)
            return 0;

        if (isBuy) {
            // buy
            int a = solve(index + 1, prices, index, false);
            // no buy
            int b = solve(index + 1, prices, prevInd, true);

            return Math.max(a, b);
        }
        // sell
        int c = prices[index] - prices[prevInd] + solve(index + 1, prices, prevInd, true);

        // no sell
        int d = solve(index + 1, prices, prevInd, false);

        return Math.max(c, d);

    }

    private int solveDP(int index, int[] prices, int prevInd, boolean isBuy, int[][][] dp) {
        if (index >= prices.length)
            return 0;

        int isBuyIndex = isBuy == true ? 1 : 0;

        if (prevInd != -1 && dp[index][prevInd][isBuyIndex] != -1)
            return dp[index][prevInd][isBuyIndex];
        if (isBuy) {
            // buy
            int a = solveDP(index + 1, prices, index, false, dp);
            // no buy
            int b = solveDP(index + 1, prices, prevInd, true, dp);

            if (prevInd != -1) {
                dp[index][prevInd][isBuyIndex] = Math.max(a, b);
            }
            return Math.max(a, b);
        }
        // sell
        int c = prices[index] - prices[prevInd] + solveDP(index + 1, prices, prevInd, true, dp);

        // no sell
        int d = solveDP(index + 1, prices, prevInd, false, dp);
        if (prevInd != -1) {
            dp[index][prevInd][isBuyIndex] = Math.max(c, d);
        }

        return Math.max(c, d);
    }

    private int solveTab(int[] prices) {

        int n = prices.length;
        int dp[][][] = new int[n + 1][n + 1][2];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                for (int k = 1; k >= 0; k--) {
                    if (k==1) {
                        // buy
                        int a = dp[i + 1][i][0];
                        // no buy
                        int b = dp[i + 1][j][1];

                        dp[i][j][k] = Math.max(a, b);

                    } else {
                        // sell
                        int c = prices[i] - prices[j] + dp[i + 1][j][1];

                        // no sell
                        int d = dp[i + 1][j][0];
                        dp[i][j][k] = Math.max(c, d);

                    }

                }
            }
        }
        return dp[0][0][0];

    }

    private int solveOptimal(int prices[]){
        int ans = 0;
        int n = prices.length;
        int buy = 0;
        int sell = 0;
        for(int i=n-1;i>=0;i--){
            int currbuy = Math.max(-prices[i]+sell , buy);
            int currsell = Math.max(prices[i]+buy , sell);

            buy = currbuy;
            sell = currsell;
        }
        return buy;
    }

}
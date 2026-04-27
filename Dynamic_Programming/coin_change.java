public class coin_change {
    public int coinChange(int[] coins, int amount) {
        // int n = coins.length;

        // int[][] dp = new int[n][amount + 1];
        // for (int[] row : dp)
        //     Arrays.fill(row, -2);

        // Arrays.sort(coins);

        // return solveDP(n - 1, coins, amount, dp);

        return solveTAB(amount, coins);
    }

    private int solveDP(int index, int[] coins, int amount, int dp[][]) {
        if (amount == 0)
            return 0;
        if (index < 0)
            return -1;

        if (dp[index][amount] != -2)
            return dp[index][amount];

        int in = -1;
        if (amount >= coins[index]) {
            int temp = solveDP(index, coins, amount - coins[index], dp);
            if (temp != -1)
                in = 1 + temp;
        }

        int ex = solveDP(index - 1, coins, amount, dp);

        int res;
        if (in == -1)
            res = ex;
        else if (ex == -1)
            res = in;
        else
            res = Math.min(in, ex);

        return dp[index][amount] = res;
    }

    private int solveTAB(int amount, int[] coins) {
        int n = coins.length;
        int INF = (int) 1e9;

        int[][] dp = new int[n][amount + 1];

        // Base case
        for (int j = 0; j <= amount; j++) {
            if (j % coins[0] == 0)
                dp[0][j] = j / coins[0];
            else
                dp[0][j] = INF;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {

                int notTake = dp[i - 1][j];

                int take = INF;
                if (j >= coins[i]) {
                    take = 1 + dp[i][j - coins[i]];
                }

                dp[i][j] = Math.min(take, notTake);
            }
        }

        return dp[n - 1][amount] >= INF ? -1 : dp[n - 1][amount];
    }

}

class Solution {
    public int minDistance(String word1, String word2) {
        // return solve(0, 0, word1, word2);

        // int n1 = word1.length();
        // int n2 = word2.length();
        // int[][] dp = new int[n1 + 1][n2 + 1];

        // for (int i = 0; i <= n1; i++) {
        //     for (int j = 0; j <= n2; j++) {
        //         dp[i][j] = -1;
        //     }
        // }
        // return solveDP(0, 0, word1, word2, dp);

        return solveTab(word1, word2);
    }

    private int solve(int ind1, int ind2, String word1, String word2) {
        if (ind2 >= word2.length()) {
            return word1.length() - ind1;
        }
        if (ind1 >= word1.length())
            return word2.length() - ind2;

        // matches
        if (word1.charAt(ind1) == word2.charAt(ind2)) {
            int a = solve(ind1 + 1, ind2 + 1, word1, word2);
            return a;
        } else {
            // replace
            int b = 1 + solve(ind1 + 1, ind2 + 1, word1, word2);
            // remove
            int c = 1 + solve(ind1 + 1, ind2, word1, word2);

            // insert
            int d = 1 + solve(ind1, ind2 + 1, word1, word2);
            return Math.min(b, Math.min(c, d));
        }
    }

    private int solveDP(int ind1, int ind2, String word1, String word2, int[][] dp) {
        if (ind2 >= word2.length()) {
            return word1.length() - ind1;
        }
        if (ind1 >= word1.length())
            return word2.length() - ind2;

        if (dp[ind1][ind2] != -1)
            return dp[ind1][ind2];
        // matches
        if (word1.charAt(ind1) == word2.charAt(ind2)) {
            int a = solveDP(ind1 + 1, ind2 + 1, word1, word2, dp);
            return dp[ind1][ind2] = a;
        } else {
            // replace
            int b = 1 + solveDP(ind1 + 1, ind2 + 1, word1, word2, dp);
            // remove
            int c = 1 + solveDP(ind1 + 1, ind2, word1, word2, dp);
            // insert
            int d = 1 + solveDP(ind1, ind2 + 1, word1, word2, dp);
            return dp[ind1][ind2] = Math.min(b, Math.min(c, d));
        }
    }

    private int solveTab(String word1, String word2) {

        int n1 = word1.length();
        int n2 = word2.length();

        // // base case
        // if (ind2 >= word2.length()) {
        //     return word1.length() - ind1;
        // }
        // if (ind1 >= word1.length())
        //     return word2.length() - ind2;

        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 0; i <= n1; i++) {
            dp[i][n2] = n1 - i;
        }

        for (int j = 0; j <= n2; j++) {
            dp[n1][j] = n2 - j;
        }

        for (int ind1 = n1 - 1; ind1 >= 0; ind1--) {
            for (int ind2 = n2 - 1; ind2 >= 0; ind2--) {
                // matches
                if (word1.charAt(ind1) == word2.charAt(ind2)) {
                    int a = dp[ind1 + 1][ind2 + 1];
                    dp[ind1][ind2] = a;
                } else {
                    // replace
                    int b = 1 + dp[ind1 + 1][ind2 + 1];
                    // remove
                    int c = 1 + dp[ind1 + 1][ind2];
                    // insert
                    int d = 1 + dp[ind1][ind2 + 1];
                    dp[ind1][ind2] = Math.min(b, Math.min(c, d));
                }
            }
        }
        return dp[0][0];
    }

}
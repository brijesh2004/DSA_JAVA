class Solution {
    public int longestPalindromeSubseq(String s) {
        int st = 0;
        int e = s.length() - 1;
        // return solve(st , e , s);

        int[][] dp = new int[e + 1][e + 1];

        for (int i = 0; i <= e; i++) {
            for (int j = 0; j <= e; j++) {
                dp[i][j] = -1;
            }
        }
        // return solveDP(st, e, s, dp);

        return solveTab(s);

    }

    private int solve(int st, int e, String s) {
        if (st > e)
            return 0;
        if (st == e)
            return 1;

        int a = 0, b = 0, c = 0;
        if (s.charAt(st) == s.charAt(e)) {
            a = 2 + solve(st + 1, e - 1, s);
        } else {
            b = solve(st, e - 1, s);
            c = solve(st + 1, e, s);
        }
        return Math.max(a, Math.max(b, c));
    }

    private int solveDP(int st, int e, String s, int[][] dp) {
        if (st > e)
            return 0;
        if (st == e)
            return 1;

        if (dp[st][e] != -1)
            return dp[st][e];

        int a = 0, b = 0, c = 0;
        if (s.charAt(st) == s.charAt(e)) {
            a = 2 + solveDP(st + 1, e - 1, s, dp);
        } else {
            b = solveDP(st, e - 1, s, dp);
            c = solveDP(st + 1, e, s, dp);
        }
        return dp[st][e] = Math.max(a, Math.max(b, c));
    }

    private int solveTab(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // base case
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // fill DP
        for (int st = n - 1; st >= 0; st--) {
            for (int e = st + 1; e < n; e++) {

                if (s.charAt(st) == s.charAt(e)) {
                    dp[st][e] = 2 + dp[st + 1][e - 1];
                } else {
                    dp[st][e] = Math.max(dp[st + 1][e], dp[st][e - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }

}
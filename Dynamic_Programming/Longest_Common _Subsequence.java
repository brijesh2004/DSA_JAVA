class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        return solveTab(text1 , text2);
        // int n1 = text1.length();
        // int n2 = text2.length();
        // int[][] dp = new int[n1 + 1][n2 + 1];
        // for (int i = 0; i < n1; i++) {
        //     for (int j = 0; j < n2; j++) {
        //         dp[i][j] = -1;
        //     }
        // }
        // return solve(0, text1, 0, text2, dp);  
    }

    private int solve(int i1, String text1, int i2, String text2, int[][] dp) {
        if (i1 >= text1.length() || i2 >= text2.length())
            return 0;
        if (dp[i1][i2] != -1) {
            return dp[i1][i2];
        }
        int a = 0;
        if (text1.charAt(i1) == text2.charAt(i2)) {
            a = 1 + solve(i1 + 1, text1, i2 + 1, text2, dp);
        }
        int b = solve(i1 + 1, text1, i2, text2, dp);
        int c = solve(i1, text1, i2 + 1, text2, dp);

        return dp[i1][i2] = Math.max(a, Math.max(b, c));
    }

    private int solveTab(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <n1; i++) {
            for (int j = 0; j < n2; j++) {
                dp[i][j] = 0;
            }
        }

        for (int i = n1-1; i >=0; i--) {
            for (int j = n2-1; j >=0; j--) {
                int a = 0;
                if (text1.charAt(i) == text2.charAt(j)) {
                    a =  1 + dp[i + 1][j + 1];
                }
                int b = dp[i + 1][j];
                int c = dp[i][j + 1];

                dp[i][j] = Math.max(a, Math.max(b, c));
            }
        }
        return dp[0][0];
    }

     private int solveSpace(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <n1; i++) {
            for (int j = 0; j < n2; j++) {
                dp[i][j] = 0;
            }
        }

        

        for (int i = n1-1; i >=0; i--) {
            for (int j = n2-1; j >=0; j--) {
                int a = 0;
                if (text1.charAt(i) == text2.charAt(j)) {
                    a =  1 + dp[i + 1][j + 1];
                }
                int b = dp[i + 1][j];
                int c = dp[i][j + 1];

                dp[i][j] = Math.max(a, Math.max(b, c));
            }
        }
        return dp[0][0];
    }
}
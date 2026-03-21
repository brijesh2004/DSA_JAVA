class Solution {
    public int lengthOfLIS(int[] nums) {
        // return solve(nums , 0 , -1);
        // int len = nums.length;
        // int [][] dp = new int[len+1][len+1];
        // for(int i = 0;i<len;i++){
        //     for(int j=0;j<len;j++){
        //         dp[i][j]=-1;
        //     }
        // }

        // return solveDp(nums ,0 , -1 , dp);

        return solveTab(nums);

    }

    private int solve(int[] nums, int index, int prevInd) {
        if (index >= nums.length)
            return 0;

        int a = 0;
        if (prevInd == -1 || nums[index] > nums[prevInd]) {
            a = 1 + solve(nums, index + 1, index);
        }

        // exclude
        int b = solve(nums, index + 1, prevInd);

        return Math.max(a, b);
    }

    private int solveDp(int[] nums, int index, int prevInd, int[][] dp) {
        if (index >= nums.length)
            return 0;

        if (prevInd != -1 && dp[index][prevInd] != -1)
            return dp[index][prevInd];

        int a = 0;
        if (prevInd == -1 || nums[index] > nums[prevInd]) {
            a = 1 + solveDp(nums, index + 1, index, dp);
        }

        // exclude
        int b = solveDp(nums, index + 1, prevInd, dp);

        if (prevInd != -1) {
            dp[index][prevInd] = Math.max(a, b);
        }
        return Math.max(a, b);
    }

    private int solveTab(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int prev = i - 1; prev >= -1; prev--) {

                int take = 0;

                if (prev==-1 || nums[i] > nums[prev]) {
                    take = 1 + dp[i + 1][i+1]; 
                }

                int notTake = dp[i + 1][prev+1];

                dp[i][prev+1] = Math.max(take, notTake);
            }
        }
        return dp[0][0];

    }
}
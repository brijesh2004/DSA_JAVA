package sliding_window;

public class Minimum_Size_Subarray_Sum {
   public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int prevInd = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                if (sum >= target) {
                    ans = Math.min(ans, i - prevInd + 1);
                }
                sum -= nums[prevInd];
                prevInd++;
            }

        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}

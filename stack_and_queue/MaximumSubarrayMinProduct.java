import java.util.Stack;

public class MaximumSubarrayMinProduct {
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        Stack<Integer> st = new Stack<>();
        long ans = 0;

        for (int i = 0; i <= n; i++) {
            int cur = (i == n) ? 0 : nums[i];

            while (!st.isEmpty() && cur < nums[st.peek()]) {
                int mid = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                int right = i;

                long sum = prefix[right] - prefix[left + 1];
                ans = Math.max(ans, sum * nums[mid]);
            }

            st.push(i);
        }

        return (int) (ans % 1_000_000_007);
    }
}

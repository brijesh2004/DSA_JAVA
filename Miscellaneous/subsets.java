class Solution {
    private List<List<Integer>> ans;

    private void solve(int ind, int[] nums, List<Integer> l) {
        if (ind >= nums.length) {
            // if (ans.size() == 0 || ans.get(ans.size() - 1) != l) {
            //     ans.add(l);
            // }
            ans.add(new ArrayList<>(l));
            return;
        }
        // no take
        solve(ind + 1, nums, l);

        // take
        l.add(nums[ind]);
        solve(ind + 1, nums, l);
        l.remove(l.size() - 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();

        List<Integer> l = new ArrayList<>();
        solve(0, nums, l);
        return ans;
    }
}
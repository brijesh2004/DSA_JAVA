class Minimum_Absolute_Difference_In_BST {
    private int first = -1;
    private int ans = Integer.MAX_VALUE;
    private void solve(TreeNode root){
        if(root==null){
            return;
        }
        solve(root.left);
        
        int val = root.val;
        if(first!=-1){
            ans = Math.min(ans , val-first);
        }
        // System.out.println("val : "+ val + " first : "+first);
        first = val;

        solve(root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        first = -1;
        ans =  Integer.MAX_VALUE;
        solve(root);
        return ans;
    }
}
class Kth_Smallest_Element_In_BST {
    private int ans = 0;
    private int cnt = 0;
    private void solve(TreeNode root){
        if(root==null) return;

        solve(root.left);
        cnt--;
        if(cnt==0) {
            ans = root.val;
            return;
        }
        solve(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        cnt = k;
        solve(root);
        return ans;
    }
}
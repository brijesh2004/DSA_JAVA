class Validate_Binary_Search_Tree {


     private boolean solve(TreeNode root , long left , long right){
        if(root==null) return true;

        if(!(root.val>left && root.val < right)){
            return false;
        }
        return solve(root.left , left , root.val) && solve(root.right , root.val , right);
    }

    public boolean isValidBST(TreeNode root) {
        long left = Long.MIN_VALUE;
        long right = Long.MAX_VALUE;
        return solve(root , left , right);
    }
}

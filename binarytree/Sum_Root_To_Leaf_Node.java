public class Sum_Root_To_Leaf_Node{
    private int solve(TreeNode root , int sum){
        if(root==null) return 0;
        // if leaf node
        if(root.left==null&&root.right==null) return sum*10+root.val;
        return solve(root.left , sum*10+root.val) + solve(root.right , sum*10+root.val);
    }
    public int sumNumbers(TreeNode root) {
        return solve(root , 0);
    }
}
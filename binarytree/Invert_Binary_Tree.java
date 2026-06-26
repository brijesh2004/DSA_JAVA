public class Invert_Binary_Tree{
    public void solve(TreeNode root){
        if(root==null) return ;

        if(root.left==null && root.right==null) return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        solve(root.left);
        solve(root.right);
    }
    public TreeNode invertTree(TreeNode root) {
        solve(root);
        return root;
    }
}
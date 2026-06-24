public class Maximum_Depth_of_Binary_Tree {
   private int height(TreeNode root){
        if(root==null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left , right)+1;
    }

    public int maxDepth(TreeNode root) {
        return height(root);
    }
}
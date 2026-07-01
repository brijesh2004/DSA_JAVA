public class Count_Complete_Tree_Node{
     private int solve(TreeNode root){
        if(root==null) return 0;

        return 1+solve(root.left)+solve(root.right);
    }
    public int countNodes(TreeNode root) {
      int ans = 0;
      return solve(root);

    }
}
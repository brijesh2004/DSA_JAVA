public class PathSum{
    private boolean solve(TreeNode root , int targetSum){
        if(root==null){
            if(targetSum==0) return true;
            return false;
        }

        if(root.left==null&& root.right==null){
            if(targetSum-root.val==0) return true;
            return false;
        }
        boolean a=false , b = false;
        if(root.left!=null)
          a = solve(root.left , targetSum-root.val); 
        if(root.right!=null)
          b = solve(root.right , targetSum-root.val);
        return a || b;        
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
          return false;
        }
        return solve(root , targetSum);
    }
}
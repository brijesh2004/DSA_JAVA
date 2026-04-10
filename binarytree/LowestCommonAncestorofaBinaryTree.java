package binarytree;

import javax.swing.tree.TreeNode;

public class LowestCommonAncestorofaBinaryTree {
    private TreeNode solve(TreeNode root,TreeNode p , TreeNode q){
        if(root==null) return null;
        if(p==root || q==root) return root;

       
        TreeNode left = solve(root.left , p , q);
        TreeNode right = solve(root.right , p , q);

        if(left!=null&&right!=null) return root;

        return left!=null?left:right;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return solve(root , p ,q);
    }
}

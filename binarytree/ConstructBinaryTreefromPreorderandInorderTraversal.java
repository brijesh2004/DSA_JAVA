package binarytree;

import java.util.HashMap;
import java.util.Map;

import javax.swing.tree.TreeNode;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int s = 0;
        int n = preorder.length;

        Map<Integer ,Integer>mp = new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            mp.put(inorder[i] , i);
        }
        return buildTreeNode(preorder , 0 , n-1 , inorder , 0 , n-1 , mp);

    }

    private TreeNode buildTreeNode(int []preorder , int preSt , int preEnd , int [] inorder , int inSt , int inEnd , Map<Integer ,Integer>mp){
        if(preSt>preEnd || inSt>inEnd) return null;

        TreeNode root =new TreeNode(preorder[preSt]);

        int rootVal = mp.get(root.val);
        
        int left = rootVal-inSt;

        root.left = buildTreeNode(preorder , preSt+1 , preSt+left , inorder , inSt , rootVal-1 , mp);
        root.right = buildTreeNode(preorder , preSt+left+1 ,preEnd , inorder , rootVal+1 , inEnd , mp);

        return root;
    }
}

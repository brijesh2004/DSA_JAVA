import javax.swing.tree.TreeNode;

public class RecoverBinarySearchTree {
    private TreeNode firstNode = null;
    private TreeNode secondNode = null;
    private TreeNode prevNode = null;
    public void recoverTree(TreeNode root) {
        firstNode = null;
        secondNode = null;
        prevNode = null;
        if(root==null) return ;

        inorder(root);
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }
    private void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);

        if(prevNode!=null && prevNode.val>root.val){

            if(firstNode==null){
                firstNode = prevNode;
            }
            secondNode = root;
        }
        prevNode = root;
        inorder(root.right);
    }
}

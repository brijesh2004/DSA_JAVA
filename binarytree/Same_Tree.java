public class Same_Tree{
     private boolean same(TreeNode p , TreeNode q){
        if(p==null&&q==null) return true;
        if(p==null&&q!=null) return false;
        if(p!=null&&q==null) return false;
        if(p.val!=q.val) return false;

        return same(p.left , q.left) && same(p.right , q.right);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return same(p ,q);
    }
}
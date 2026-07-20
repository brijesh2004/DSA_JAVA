public class Binary_search_Tree_Iterator {
     int index = 0;
    List<Integer> list = new ArrayList<>();

    public BSTIterator(TreeNode root) {
        insertToPQ(root);
    }

    private void insertToPQ(TreeNode root) {
        if (root == null)
            return;
        insertToPQ(root.left);
        list.add(root.val);
        insertToPQ(root.right);
    }

    public int next() {
        int t = list.get(index++);
        return t;
    }

    public boolean hasNext() {
        return index<list.size();
    }
}
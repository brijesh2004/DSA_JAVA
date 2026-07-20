class Binary_Tree_Level_Order_Traversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<Pair<TreeNode , Integer>> q = new LinkedList<>(); 
        q.add(new Pair<>(root , 0));
        List<Integer>l = new ArrayList<>();
        int currLevel = 0;

        while(!q.isEmpty()){
            Pair<TreeNode , Integer> front = q.poll();
            int level = front.getValue();
            if(level!=currLevel){
                ans.add(l);
                l = new ArrayList<>();
                currLevel = level;
            }
            TreeNode fr = front.getKey();
            l.add(fr.val);
            if(fr.left!=null){
                q.add(new Pair<>(fr.left , level+1));
            }
            if(fr.right!=null){
                q.add(new Pair<>(fr.right , level+1));
            }
        }
        if(l.size()!=0){
            ans.add(l);
        }
        return ans;
    }
}
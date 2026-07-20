public class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }
    public V getValue() { return value; }
}

class Binary_Tree_Right_View {
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> ans = new ArrayList<>();

        if(root==null) return ans;
        Queue<Pair<TreeNode , Integer>>q = new LinkedList<>();
        q.add(new Pair<>(root , 0));
        int lev = 0;
        TreeNode prev = null;

        while(!q.isEmpty()){

            Pair<TreeNode , Integer>ft = q.poll();

            if(ft.getValue()!=lev){
                ans.add(prev.val);
                lev++;
            }

            prev = ft.getKey();
            if(ft.getKey().left!=null){
                q.add(new Pair<>(ft.getKey().left , ft.getValue()+1));
            }

            if(ft.getKey().right!=null){
                q.add(new Pair<>(ft.getKey().right , ft.getValue()+1));
            }
        }

        if(prev!=null){
            ans.add(prev.val);
        }

        return ans;
    }
}
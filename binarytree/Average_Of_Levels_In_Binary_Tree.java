
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

class Average_Of_Levels_In_Binary_Tree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();

        if(root==null) return ans;
        Queue<Pair<TreeNode , Integer>>q = new LinkedList<>();
        q.add(new Pair<>(root , 0));
        int lev = 0;
        Long sum = 0L;
        Long cnt = 0L;

        while(!q.isEmpty()){

            Pair<TreeNode , Integer>ft = q.poll();

            if(ft.getValue()!=lev){
                ans.add(sum*1.0/cnt);
                lev++;
                cnt=0L;
                sum=0L;
            }

            sum+=ft.getKey().val;
            cnt++;
            if(ft.getKey().left!=null){
                q.add(new Pair<>(ft.getKey().left , ft.getValue()+1));
            }

            if(ft.getKey().right!=null){
                q.add(new Pair<>(ft.getKey().right , ft.getValue()+1));
            }
        }

        if(cnt!=0){
            ans.add(sum*1.0/cnt);
        }

        return ans;
    }
}
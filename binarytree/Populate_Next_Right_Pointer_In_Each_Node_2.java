
 class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }
    public V getValue() { return value; }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}

public class Populate_Next_Right_Pointer_In_Each_Node_2{
    public Node connect(Node root) {
        if(root==null) return root;
        int lev = 0;
        Queue<Pair<Node , Integer>>q = new LinkedList<>();
        q.add(new Pair<>(root , 0));
        Node prevNode = null;

        while(!q.isEmpty()){
            Pair<Node , Integer>first = q.poll();
            Node front = first.getKey();
            int level = first.getValue();

            if(level!=lev){
                if(prevNode!=null){
                    prevNode.next = null;
                }
                lev++;
            }else {
                if(prevNode!=null){
                    prevNode.next = front;
                }
            }

            if(front.left!=null){
                q.add(new Pair<>(front.left , level+1));
            }

            if(front.right!=null){
                q.add(new Pair<>(front.right , level+1));
            }
            prevNode = front;
        }
        return root;
    }
}
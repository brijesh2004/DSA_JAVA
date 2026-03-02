
class Populating_Next_Right_Pointers_in_Each_Node {
    public Node connect(Node root) {
        
        if(root==null) return null;
        
        Queue<Pair<Node , Integer>>q = new LinkedList<>();
        q.add(new Pair<>(root , 1));
        int currLevel = 0;
        Node prevNode = null;

        while(!q.isEmpty()){
            Pair<Node , Integer>first = q.poll();
            Node  front = first.getKey();
            int level = first.getValue();
            front.next = null;

            if(level!=currLevel){
                prevNode = front;
                currLevel=level;
            }else{
                prevNode.next = front;
                prevNode = front;
            }

            if(front.left!=null){
                q.add(new Pair<>(front.left , level+1));
            }
            if(front.right!=null){
                q.add(new Pair<>(front.right , level+1));
            }
        }
        return root;
    }
}
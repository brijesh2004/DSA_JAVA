class Solution {
    public Node copyRandomList(Node head) {
        // index , Node Val
        if(head==null) return null;
        Map<Node , Node>store = new HashMap<>();
        // Node head = null;
        Node temp = head;
        while(temp!=null){
            store.put(temp , new Node(temp.val));
            temp =temp.next;
        }

        temp = head;
        while(temp!=null){
            Node copy = store.get(temp);
            copy.next =store.get(temp.next);
            copy.random = store.get(temp.random);
            temp = temp.next;
        }
        return store.get(head);
    }
}
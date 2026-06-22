public class Copy_List_With_Random_Pointer_New{
    public Node copyRandomList(Node head) {
        Map<Node, Node> mp = new HashMap<>();

        Node ans = null;
        Node res = null;

        while (head != null) {
            Node next = head.next;
            Node newNode;

            if (mp.containsKey(head)) {
                newNode = mp.get(head);
            } else {
                newNode = new Node(head.val);
                mp.put(head, newNode);
            }

            if (head.random != null) {

                if (mp.containsKey(head.random)) {
                    newNode.random = mp.get(head.random);
                } else {
                    Node temp = new Node(head.random.val);
                    mp.put(head.random, temp);
                    newNode.random = temp;
                }
            }

            if (ans == null) {
                ans = newNode;
                res = newNode;
            } else {
                res.next = newNode;
                res = res.next;
            }

            head = next;
        }
        return ans;
    }
}
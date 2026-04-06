import org.w3c.dom.Node;

public class Flatten_a_Multilevel_Doubly_Linked_List {
    public Node solve(Node head){
    Node curr = head;
    Node last = head;

    while(curr != null){
        Node nextElement = curr.next;

        if(curr.child != null){
            Node childHead = curr.child;
            Node childTail = solve(childHead);

            curr.next = childHead;
            childHead.prev = curr;

            curr.child = null;

            if(nextElement != null){
                childTail.next = nextElement;
                nextElement.prev = childTail;
            }

            last = childTail;
        }
        else{
            last = curr;
        }

        curr = nextElement;
    }

    return last;
}

    public Node flatten(Node head) {
      solve(head);
      return head; 
    }
}

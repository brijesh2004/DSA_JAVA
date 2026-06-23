public class Reverse_Linked_List_Two{
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int i = 1;
        ListNode prev = null;
        ListNode ans = head;
        while(i<left){
            prev = head;
            head = head.next;
            i++;
        }

        ListNode newTail = head;
        ListNode newHead = head;
        ListNode newPrev = null;

        while(i<=right){
            ListNode next = newHead.next;
            System.out.println("h : "+ newHead.val);
            newHead.next = newPrev;
            newPrev = newHead; 
            newHead = next;
            i++;
        }

        if(prev==null){
            ans = newPrev;
        }else{
            prev.next = newPrev;
        }

        newTail.next = newHead;
        return ans;
        
    }
}
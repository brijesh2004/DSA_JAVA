public class LInked_List_Cycle {
   public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast!=null){
            if(slow==fast) return true;
            slow = slow.next;
            fast = fast.next;
            if(fast!=null){
                fast = fast.next;
            }
        }
        return false;
    }
}
public class Remove_Nth_Node_From_The_List {
   private int listLen(ListNode head){
        int len=0;
        while(head!=null){
            len++;
            head = head.next;
        }
        return len;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ans = head;
        int len = listLen(head);
        int rm = len-n;
        head = ans;
        ListNode prev = null;
        int curr = 0;
        while(head!=null){
            if(curr==rm){
                if(prev==null){
                    ans = head.next;
                }else{
                    prev.next = head.next;
                }
            }
            prev = head;
            head = head.next;
            curr++;
        }
        return ans;
    }
}
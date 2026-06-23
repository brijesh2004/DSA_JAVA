public class Remove_Duplicated_From_Sorted_List_2 {
   
     public ListNode deleteDuplicates(ListNode head) {
        ListNode ans = null;
        ListNode res = null;
        ListNode prev = null;

        while(head!=null){
            ListNode next = head.next;
            // only one element
            head.next = null;
            if(prev==null && next==null){
                if(ans == null){
                    ans = head;
                    res = head;
                }else{
                  res.next = head;
                  res = res.next;
                }
            }
            else if(prev==null &&next!=null){
                if(head.val!=next.val){
                    if(ans==null){
                        ans = head;
                        res = head;
                    }else{
                        res.next = head;
                        res = res.next;
                    }
                }
                
            }
            // two element
            else if(prev!=null&&next==null){
                if(prev.val!=head.val){
                    if(ans==null){
                        ans = head;
                        res = head;
                    }else{
                        res.next = head;
                        res = res.next;
                    }
                }
            }
            else if(prev!=null && next!=null){
                if(head.val!=prev.val && head.val!=next.val){
                    if(ans == null){
                        ans = head;
                        res = head;
                    }else {
                        res.next = head;
                        res = res.next;
                    }
                }
            }
            prev = head;
            head = next;
        }
        return ans;
    }
}
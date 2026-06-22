public class Add_Two_Number{
     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int rem = 0;
        ListNode ans = l1;
        ListNode prev = l1;
        

        while(l1!=null&&l2!=null){
            int l1Val = l1.val;
            int l2Val = l2.val;
            int sum = (l2Val+l1Val+rem);
            int val = sum%10;
            rem = sum/10;
            l1.val = val;
            prev = l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l2!=null){
            
            int l2Val = l2.val;
            int sum = (l2Val+rem);
            int val = sum%10;
            rem = sum/10;
            l2.val = val;
            prev.next = l2;
            prev = l2;
            l2 = l2.next;
        }
        while(l1!=null){
            int l1Val = l1.val;
            int sum = (l1Val+rem);
            int val = sum%10;
            rem = sum/10;
            l1.val = val;
            prev.next = l1;
            prev = l1;
            l1 = l1.next;
        }

        while(rem>0){
             int sum = (rem);
            int val = sum%10;
            rem = sum/10;
            ListNode newNode = new ListNode(val);
            prev.next = newNode;
            prev = newNode;
        }
        return ans;
    }
}
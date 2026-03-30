class Solution {
    private ListNode[] reverse(ListNode head ,int cnt, int right){
        ListNode prev = null;
        ListNode next = head;
        ListNode temp = head;

        while(next!=null && right>=cnt){
            ListNode tempnext = next.next;
            next.next = prev;
            prev = next;
            next = tempnext;
            cnt++;
        }

        ListNode[] ans = {temp , prev , next};
        // if(temp!=null){
        //     System.out.print("temp0: "+ temp.val+ " ");
        // }

        // if(prev!=null){
        //     System.out.print("prev1: "+ prev.val+ " ");
        // }
        // if(next!=null){
        //     System.out.print("next2: "+ next.val+ " ");
        // }
        return ans;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp = head;
        ListNode prev = null;
        int cnt = 1;
        // if(left==right) return head;
        while(cnt<left && temp!=null){
            prev = temp;
            temp = temp.next;
            cnt++;
        }
        ListNode newTemp = prev;
        ListNode[] r = reverse(temp , cnt , right);
        // if(r[0]!=null){
        //     System.out.print("r0: "+ r[0].val+ " ");
        // }

        // if(r[1]!=null){
        //     System.out.print("r1: "+ r[1].val+ " ");
        // }
        // if(r[2]!=null){
        //     System.out.print("r2: "+ r[2].val+ " ");
        // }

        if(left==1){
            r[0].next = r[2];
            return r[1];
        }
        else{
            newTemp.next = r[1];
            r[0].next = r[2];
        }
        return head;
    }
}
public class Merge_Two_Sorted_List{
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = null;
        ListNode prev = null;

        while (list1 != null && list2 != null) {

            if (list1.val > list2.val) {
                if (ans == null) {
                    ans = list2;
                    prev = list2;
                } else {
                    prev.next = list2;
                    prev = prev.next;
                }
                list2 = list2.next;
            } else {
                if (ans == null) {
                    ans = list1;
                    prev = list1;
                } else {
                    prev.next = list1;
                    prev = prev.next;
                }
                list1 = list1.next;
            }
        }

        while (list1 != null) {
            if (ans == null) {
                ans = list1;
                prev = list1;
            } else {
                prev.next = list1;
                prev = prev.next;
            }
            list1 = list1.next;
        }
        while (list2 != null) {
            if (ans == null) {
                ans = list2;
                prev = list2;
            } else {
                prev.next = list2;
                prev = prev.next;
            }
            list2 = list2.next;
        }

        return ans;
    }
}
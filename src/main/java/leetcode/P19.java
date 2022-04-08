package leetcode;


import jianzhi.ListNode;

public class P19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) return null;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode first = dummy, last = dummy;
        int count = 0;
        while (last != null) {
            if (count > n) {
                first = first.next;
            } else {
                count++;
            }
            last = last.next;
        }
        if (first.next != null)
            first.next = first.next.next;
        return dummy.next;
    }
}

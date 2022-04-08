package leetcode;

import jianzhi.ListNode;

public class P876 {
    public ListNode middleNode(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        while (fast != null) {
            fast = fast.next == null ? null : fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}

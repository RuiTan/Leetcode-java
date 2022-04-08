package leetcode;

import jianzhi.ListNode;

public class P142 {
    public ListNode detectCycle(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        boolean circle = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                circle = true;
                break;
            }
        }
        if (!circle) return null;
        fast = dummy;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}

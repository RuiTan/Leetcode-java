package jianzhi;

public class P23 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode la = headA, lb = headB;
        int lenA = 1, lenB = 1;
        while (la.next != null){
            la = la.next;
            ++lenA;
        }
        while (lb.next != null){
            lb = lb.next;
            ++lenB;
        }
        if (la != lb){
            return null;
        }
        la.next = lenA > lenB ? headB : headA;
        ListNode head = lenA > lenB ? headA : headB;

        ListNode slow = head.next;
        ListNode fast = slow.next;
        while (fast != slow){
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        la.next = null;
        return fast;
    }
}

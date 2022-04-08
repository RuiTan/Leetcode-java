package leetcode;

import jianzhi.ListNode;

public class P160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode la = headA, lb = headB;
        int lenA = 0, lenB = 0;
        while (la != null) {
            la = la.next;
            lenA++;
        }
        while (lb != null) {
            lb = lb.next;
            lenB++;
        }
        if (lenA > lenB) {
            for (int i = 0; i < (lenA - lenB); i++)
                headA = headA.next;
        }else {
            for (int i = 0; i < (lenB - lenA); i++)
                headB = headB.next;
        }
        la = headA; lb = headB;
        while (la != lb) {
            if (la == null || lb == null) return null;
            la = la.next;
            lb = lb.next;
        }
        return la;
    }
}

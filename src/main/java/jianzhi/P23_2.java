package jianzhi;

public class P23_2 {
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
        int ia = 0, ib = 0;
        boolean aBigger = lenA > lenB;
        ListNode move = aBigger ? headA : headB;
        for (int i = 0; i < Math.abs(lenA - lenB); i++){
            move = move.next;
        }
        ListNode startA = aBigger ? move : headA;
        ListNode startB = aBigger ? headB : move;
        while (startA != startB){
            startA = startA.next;
            startB = startB.next;
        }
        return startA;
    }
}

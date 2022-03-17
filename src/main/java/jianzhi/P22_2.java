package jianzhi;

public class P22_2 {
    public ListNode detectCycle(ListNode head) {
        if (head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != slow){
            if (fast.next == null){
                return null;
            }else{
                fast = fast.next.next;
                slow = slow.next;
            }
        }
        fast = fast.next;
        slow = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        ListNode l4 = new ListNode(-4);
        ListNode l3 = new ListNode(0, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(3, l2);
        l4.next = l2;
        System.out.println(new P22_2().detectCycle(l1));
    }
}

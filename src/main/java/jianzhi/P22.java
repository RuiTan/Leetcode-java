package jianzhi;

public class P22 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow){
            if (fast == null || fast.next == null){
                return null;
            }else{
                fast = fast.next.next;
                slow = slow.next;
            }
        }
        int len = 1;
        fast = slow.next;
        while (fast != slow){
            fast = fast.next;
            ++len;
        }
        fast = head;
        slow = head;
        int i = 0;
        while (i < len){
            slow = slow.next;
            ++i;
        }
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
        System.out.println(new P22().detectCycle(l1));
    }
}

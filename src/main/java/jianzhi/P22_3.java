package jianzhi;

public class P22_3 {
    private ListNode getNodeInLoop(ListNode head){
        if (head == null || head.next == null){
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = slow.next;
        while (slow != null && fast != null){
            if (slow == fast){
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast != null){
                fast = fast.next;
            }
        }
        return null;
    }
    public ListNode detectCycle(ListNode head) {
        ListNode inLoop = getNodeInLoop(head);
        if (inLoop == null) {
            return null;
        }
        ListNode node = head;
        while (node != inLoop){
            node = node.next;
            inLoop = inLoop.next;
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode l4 = new ListNode(-4);
        ListNode l3 = new ListNode(0, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(3, l2);
        l4.next = l2;
        System.out.println(new P22_3().detectCycle(l1));
    }
}

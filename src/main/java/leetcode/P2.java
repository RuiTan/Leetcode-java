package leetcode;
import jianzhi.ListNode;

public class P2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        int r = 0;
        ListNode currentNode = result;
        while (l1 != null && l2 != null){
            currentNode.next = new ListNode();
            currentNode = currentNode.next;
            currentNode.val = l1.val + l2.val + r;
            r = currentNode.val / 10;
            currentNode.val = currentNode.val % 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null && l2 != null){
            while (l2 != null) {
                currentNode.next = new ListNode();
                currentNode = currentNode.next;
                currentNode.val = l2.val + r;
                r = currentNode.val / 10;
                currentNode.val = currentNode.val % 10;
                l2 = l2.next;
            }
        }
        else if (l2 == null && l1 != null) {
            while (l1 != null) {
                currentNode.next = new ListNode();
                currentNode = currentNode.next;
                currentNode.val = l1.val + r;
                r = currentNode.val / 10;
                currentNode.val = currentNode.val % 10;
                l1 = l1.next;
            }
        }
        if (r == 1){
            currentNode.next = new ListNode();
            currentNode.next.val = 1;
        }
        return result.next;
    }
}

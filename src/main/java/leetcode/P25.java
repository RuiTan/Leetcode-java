package leetcode;

import jianzhi.ListNode;

public class P25 {
    ListNode cut = null;
    ListNode dummy = new ListNode(-1);
    private ListNode reverseN(ListNode head, int n){
        if (n == 1){
            cut = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n-1);
        head.next.next = head;
        head.next = cut;
        return last;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        dummy.next = head;
        ListNode p = dummy;
        cut = head;
        ListNode start = dummy;
        int size = 0;
        while (p.next != null) {
            size++;
            p = p.next;
        }
        p = dummy;
        int n = size / k;
        for (int i = 0; i < n; i++){
            start = cut;
            p.next = reverseN(cut, k);
            p = start;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode.printList(new P25().reverseKGroup(ListNode.buildList(new int[]{1,2,3,4,5,6,7}), 2));
    }
}

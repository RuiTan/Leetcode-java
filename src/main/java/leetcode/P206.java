package leetcode;

import jianzhi.ListNode;

public class P206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    ListNode cut = null;

    public ListNode reverseListN(ListNode head, int n){
        if (n == 1) {
            cut = head.next;
            return head;
        }
        ListNode last = reverseListN(head.next, n-1);
        head.next.next = head;
        head.next = cut;
        return last;
    }

    public static void main(String[] args) {
        ListNode.printList(new P206().reverseListN(ListNode.buildList(new int[]{1,2,3,4}), 4));
    }
}

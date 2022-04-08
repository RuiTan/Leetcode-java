package leetcode;

import jianzhi.ListNode;

public class P92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode leftNode = dummy, rightNode = dummy;
        ListNode start = dummy, start2 = head, temp = null;
        for (int i = 0; i < right; i++){
            if (i < left) {
                leftNode = leftNode.next;
                rightNode = rightNode.next;
            }
            if (i == left - 2){
                start = leftNode;
                start2 = leftNode.next;
            }
            else if (i == left - 1) {
                rightNode = leftNode.next;
                leftNode.next = null;
            }
            else if (i >= left) {
                temp = rightNode;
                rightNode = rightNode.next;
                temp.next = leftNode;
                leftNode = temp;
            }
        }
        start.next = leftNode;
        start2.next = rightNode;
        return dummy.next;
    }

    public ListNode recursion(ListNode cur, int length){
        if (length == 1) {
            return cur;
        }
        ListNode tmpHead = recursion(cur.next, length - 1);
        ListNode tail = cur.next.next;
        cur.next.next = cur;
        cur.next = tail;
        return tmpHead;
    }

    public ListNode reverseBetweenRecursion(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        if (left == right) {
            return dummyNode.next;
        }
        ListNode cur = head, prev = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
            cur = cur.next;
        }
        prev.next = recursion(cur, right - left + 1);
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode.printList(new P92().reverseBetweenRecursion(ListNode.buildList(new int[]{1,2,3,4,5,6,7}), 1, 3));
    }
}

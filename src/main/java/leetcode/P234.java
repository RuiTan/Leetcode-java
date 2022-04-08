package leetcode;

import jianzhi.ListNode;

public class P234 {
    public ListNode reverse(ListNode a, ListNode b){
        ListNode prev = null, curr = a, next = a;
        while (curr != b) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        int size = 0;
        ListNode p = head;
        while (p != null){
            size++;
            p = p.next;
        }
        if (size == 1) return true;
        else if (size == 2) return head.val == head.next.val;
        else if (size == 3) return head.val == head.next.next.val;
        int n = size/2;
        ListNode start = head;
        for (int i = 0; i < n; i++){
            start = start.next;
        }
        head = reverse(head, start);
        start = size % 2 == 1 ? start.next : start;
        while (start != null && head != null) {
            if (start.val != head.val) return false;
            start = start.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverse2(ListNode start, ListNode end){
        if (start == end) {
            return end;
        }
        ListNode tmpHead = reverse2(start.next, end);
        ListNode tail = start.next.next;
        start.next.next = start;
        start.next = tail;
        return tmpHead;
    }

    public boolean isPalindromeRecursion(ListNode head){
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode fast = dummyNode, slow = dummyNode;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast.next == null) fast = slow.next;
        else fast = slow.next.next;
        head = reverse2(head, slow);
        while (fast != null) {
            if (fast.val != slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode left;

    private boolean postRecursion(ListNode head){
        if (head == null) return true;
        boolean res = postRecursion(head.next);
        res = res & head.val == left.val;
        left = left.next;
        return res;
    }

    public boolean isPalindromePostRecursion(ListNode head) {
        left = head;
        return postRecursion(left);
    }

    public static void main(String[] args) {
        System.out.println(new P234().isPalindromePostRecursion(ListNode.buildList(new int[]{1,2,3,3,1})));
    }
}

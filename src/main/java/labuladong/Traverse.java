package labuladong;

import jianzhi.ListNode;

public class Traverse {
    public static void traverse(ListNode node){
        if (node == null) return;
        traverse(node.next);
        System.out.print(node.val + ", ");
    }

    public static void main(String[] args) {
        ListNode head = ListNode.buildList(new int[]{1,2,3,4,5});
        Traverse.traverse(head);
    }
}

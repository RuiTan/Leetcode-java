package jianzhi;

import java.util.ArrayList;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode buildList(int[] nums){
        ListNode head = new ListNode(nums[0]);
        ListNode h = head;
        for (int i = 1; i < nums.length; i++){
            h.next = new ListNode(nums[i]);
            h = h.next;
        }
        return head;
    }
    public static void printList(ListNode head) {
        System.out.print("[");
        while (head != null) {
            System.out.print(head.val + ",");
            head = head.next;
        }
        System.out.print("]");
    }
    public static Integer[] toArray(ListNode head){
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list.toArray(new Integer[0]);
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}

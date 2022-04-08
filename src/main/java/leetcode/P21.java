package leetcode;
import jianzhi.ListNode;

public class P21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head1 = list1, head2 = list2, dummy = new ListNode(-101);
        ListNode temp = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val){
                temp.next = head1;
                head1 = head1.next;
            }else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        if (head1 != null) {
            temp.next = head1;
        }
        if (head2 != null) {
            temp.next = head2;
        }
        return dummy.next;
    }
    private static ListNode buildList(int[] nums){
        ListNode head = new ListNode(nums[0]);
        ListNode h = head;
        for (int i = 1; i < nums.length; i++){
            h.next = new ListNode(nums[i]);
            h = h.next;
        }
        return head;
    }
    private static void printList(ListNode head) {
        System.out.print("[");
        while (head != null) {
            System.out.print(head.val + ",");
            head = head.next;
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
//        System.out.println(new P21().mergeTwoLists(buildList(new int[]{1,2,4}), buildList(new int[]{1,3,4})));
        printList(new P21().mergeTwoLists(buildList(new int[]{1,2,4}), buildList(new int[]{1,3,4})));
    }
}

package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import jianzhi.ListNode;

import static jianzhi.ListNode.buildList;
import static jianzhi.ListNode.printList;

public class P23 {

    public ListNode mergeKListsMinHeap(ListNode[] lists){
        if (lists == null || lists.length == 0) return null;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
        for (ListNode head : lists){
            if (head != null) pq.add(head);
        }
        while (!pq.isEmpty()){
            ListNode poll = pq.poll();
            p.next = poll;
            p = p.next;
            if (poll.next != null){
                pq.add(poll.next);
            }
        }
        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        while (true){
            boolean allNull = true;
            for (int i = 0; i < lists.length; i++){
                if (lists[i] == null) {
                    continue;
                }
                allNull = false;
                if (min > lists[i].val){
                    min = lists[i].val;
                    minIndex = i;
                }
            }
            if (allNull) break;
            p.next = lists[minIndex];
            p = p.next;
            lists[minIndex] = lists[minIndex].next;
            min = Integer.MAX_VALUE;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
//        System.out.println(new P21().mergeTwoLists(buildList(new int[]{1,2,4}), buildList(new int[]{1,3,4})));
        ListNode[] lists = new ListNode[3];
        lists[0] = buildList(new int[]{1,4,5});
        lists[1] = buildList(new int[]{1,3,4});
        lists[2] = buildList(new int[]{2,6});

        printList(new P23().mergeKLists(lists));
    }
}

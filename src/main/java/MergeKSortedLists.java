import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        ListNode head;
        ListNode tail;
        PriorityQueue<ListNode> heads = new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));
        for(ListNode node : lists) {
            if (node != null)
                heads.offer(node);
        }

        head = tail = heads.poll();
        if (head != null && head.next != null) heads.offer((head.next));

        while(!heads.isEmpty()) {
            ListNode node = heads.poll();
            if (node.next != null) heads.offer(node.next);
            tail.next = node;
            tail = node;
        }

        return head;
    }
}

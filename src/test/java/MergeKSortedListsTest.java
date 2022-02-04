import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergeKSortedListsTest {
    MergeKSortedLists mksl = new MergeKSortedLists();

    @Test
    public void testExample1() {
        ListNode[] list = new ListNode[3];
        list[0] = new ListNode(1);
        list[0].next = new ListNode(4);
        list[0].next.next = new ListNode(5);
        list[1] = new ListNode(1);
        list[1].next = new ListNode(3);
        list[1].next.next = new ListNode(4);
        list[2] = new ListNode(2);
        list[2].next = new ListNode(6);
        ListNode results = mksl.mergeKLists(list);
        int[] expected = new int[]{1,1,2,3,4,4,5,6};
        for(int i = 0; i < expected.length; ++i) {
            assertEquals(expected[i], results.val);
            results = results.next;
        }
    }

    @Test
    public void testExample2() {
        ListNode[] list = new ListNode[]{};
        ListNode results = mksl.mergeKLists(list);
        assertEquals(null, results);
    }

    @Test
    public void testExample3() {
        ListNode[] list = new ListNode[1];
        ListNode results = mksl.mergeKLists(list);
        assertEquals(null, results);
    }
}

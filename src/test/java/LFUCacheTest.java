import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LFUCacheTest {
    @Test
    public void testExample1() {
        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
        lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        assertEquals(1, lfu.get(1));      // return 1
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
        // cache=[3,1], cnt(3)=1, cnt(1)=2
        assertEquals(-1, lfu.get(2));      // return -1 (not found)
        assertEquals(3, lfu.get(3));      // return 3
        // cache=[3,1], cnt(3)=2, cnt(1)=2
        lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
        // cache=[4,3], cnt(4)=1, cnt(3)=2
        assertEquals(-1, lfu.get(1));      // return -1 (not found)
        assertEquals(3, lfu.get(3));      // return 3
        // cache=[3,4], cnt(4)=1, cnt(3)=3
        assertEquals(4, lfu.get(4));      // return 4
        // cache=[4,3], cnt(4)=2, cnt(3)=3
    }

    @Test
    public void testExample2() {
        LFUCache lfu = new LFUCache(0);
        lfu.put(0, 0);
        assertEquals(-1, lfu.get(0));
    }

    @Test
    public void testExample3() {
        LFUCache lfu = new LFUCache(1);
        lfu.put(2, 1);
        assertEquals(1, lfu.get(2));
    }
}

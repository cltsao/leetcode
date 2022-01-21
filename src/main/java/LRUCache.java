import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class Node {
        Node prev;
        Node next;
        int key;
        int value;

        Node(int key) {
            this.key = key;
        }
    }

    class LinkedList {
        Node head;
        Node tail;

        void remove(Node node) {
            if (head == node) head = node.next;
            if (tail == node) tail = node.prev;
            if (node.prev != null) node.prev.next = node.next;
            if (node.next != null) node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }

        void addToHead(Node node) {
            node.next = head;
            if (head != null) head.prev = node;
            head = node;
            if (tail == null) tail = node;
        }

        int removeTail() {
            int removedKey = tail.key;
            if (tail.prev != null) tail.prev.next = null;
            tail = tail.prev;
            return removedKey;
        }
    }

    int capacity;
    LinkedList cache = new LinkedList();
    Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            cache.remove(node);
            cache.addToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node node;
        if (map.containsKey(key)) {
            node = map.get(key);
            cache.remove(node);
        } else {
            node = new Node(key);
            map.put(key, node);
        }
        node.value = value;
        cache.addToHead(node);

        if (map.size() > capacity) {
            int removedKey = cache.removeTail();
            map.remove(removedKey);
        }
    }
}

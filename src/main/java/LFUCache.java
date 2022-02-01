import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class LFUCache {
    class Entry {
        int key;
        int value;
        int accessTime;
        int count;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
            this.count = 1;
            accessTime = ++systemTime;
        }
    }

    int capacity;
    int systemTime = 0; // monotonically increasing access time
    Map<Integer, Entry> cacheMap = new HashMap<>();
    SortedMap<Integer, SortedMap<Integer, Entry>> cacheSorting = new TreeMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    private void removeEntry(Entry entry) {
        cacheSorting.get(entry.count).remove(entry.accessTime);
        if (cacheSorting.get(entry.count).isEmpty()) cacheSorting.remove(entry.count);
    }

    private void addEntry(Entry entry) {
        cacheSorting.putIfAbsent(entry.count, new TreeMap<>());
        cacheSorting.get(entry.count).put(entry.accessTime, entry);
    }

    public int get(int key) {
       if (cacheMap.containsKey(key)) {
            Entry entry = cacheMap.get(key);
            removeEntry(entry);
            ++entry.count;
            entry.accessTime = ++systemTime;
            addEntry(entry);
            return entry.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        Entry entry = cacheMap.get(key);
        if (entry == null) {
            entry = new Entry(key, value);

            if (cacheMap.size() == capacity) {
                SortedMap<Integer, Entry> leastUsedEntries = cacheSorting.get(cacheSorting.firstKey());
                Entry leastUsedEntry = leastUsedEntries.get(leastUsedEntries.firstKey());
                cacheMap.remove(leastUsedEntry.key);
                removeEntry(leastUsedEntry);
            }

            addEntry(entry);
            cacheMap.put(key, entry);
        } else {
            entry.value = value;
            removeEntry(entry);
            ++entry.count;
            entry.accessTime = ++systemTime;
            addEntry(entry);
        }
    }
}

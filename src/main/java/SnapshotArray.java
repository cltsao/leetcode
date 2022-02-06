import java.util.TreeMap;

public class SnapshotArray {
    TreeMap<Integer, Integer>[] arrayHistory;
    int nextSnap = 0;

    public SnapshotArray(int length) {
        arrayHistory = new TreeMap[length];
        for(int i = 0; i < length; ++i) {
            arrayHistory[i] = new TreeMap<>();
            arrayHistory[i].put(0, 0);
        }
    }

    public void set(int index, int val) {
        arrayHistory[index].put(nextSnap, val);
    }

    public int snap() {
        return nextSnap++;
    }

    public int get(int index, int snap_id) {
        int lastSnap = arrayHistory[index].floorKey(snap_id);
        return arrayHistory[index].get(lastSnap);
    }
}

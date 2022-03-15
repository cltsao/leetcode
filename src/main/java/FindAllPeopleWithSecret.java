import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllPeopleWithSecret {
    class UnionFind {
        int[] array;

        UnionFind(int n) {
            array = new int[n];
            for(int i = 0; i < n; ++i) array[i] = i;
        }

        void join(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI == rootJ) return;

            // Keep the lower root for quick union check later
            int root = Math.min(rootI, rootJ);
            while (array[i] != root) {
                int next = array[i];
                array[i] = root;
                i = next;
            }
            while (array[j] != root) {
                int next = array[j];
                array[j] = root;
                j = next;
            }
        }

        int find(int i) {
            if (array[i] == i) return i;
            return array[i] = find(array[i]);
        }

        boolean connected(int i, int j) {
            return find(i) == find(j);
        }

        void reset(int i) {
            array[i] = i;
        }
    }

    // Group meetings by time and then maintain set of people with secret
    // Time complexity: O(M log M)
    // Space complexity: O(M + N)
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        // Conduct meetings by ascending time
        Arrays.sort(meetings, Comparator.comparingInt(m -> m[2]));

        UnionFind uf = new UnionFind(n);
        uf.join(0, firstPerson);

        for(int m = 0; m < meetings.length;) {
            Set<Integer> peopleMet = new HashSet<>();
            int meetingTime = meetings[m][2];
            for(;m < meetings.length && meetings[m][2] == meetingTime; ++m) {
                uf.join(meetings[m][0], meetings[m][1]);
                peopleMet.add(meetings[m][0]);
                peopleMet.add(meetings[m][1]);
            }
            for(int p : peopleMet) {
                if (!uf.connected(0, p)) uf.reset(p);
            }
        }

        List<Integer> peopleWithSecret = new ArrayList<>();
        for(int p = 0; p < n; ++p) {
            if (uf.connected(0, p)) peopleWithSecret.add(p);
        }
        return peopleWithSecret;
    }
}

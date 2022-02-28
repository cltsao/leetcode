import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestCommonSubpath {
    // Must pick proper hashing parameters to avoid conflict
    static int hashExponent = 100001;
    static final long mod = 100000000019L;

    private boolean findCommonSubpath(int[][] paths, int length) {
        Map<Long, Set<Integer>> hashToUsers = new HashMap<>();

        for(int user = 0; user < paths.length; ++user) {
            if (paths[user].length < length) return false;
            int[] path = paths[user];

            long topExponent = 1;
            long hashCode = 0;
            for (int i = 0; i < length; ++i) {
                hashCode = (hashCode * hashExponent + path[i]) % mod;
                topExponent = (topExponent * hashExponent) % mod;
            }
            hashToUsers.putIfAbsent(hashCode, new HashSet<>());
            hashToUsers.get(hashCode).add(user);
            for (int i = 1; i <= path.length - length; ++i) {
                hashCode = (hashCode * hashExponent - path[i - 1] * topExponent + path[i + length - 1]) % mod;
                while(hashCode < 0) hashCode += mod;
                hashToUsers.putIfAbsent(hashCode, new HashSet<>());
                hashToUsers.get(hashCode).add(user);
            }
        }
        return hashToUsers.values().stream().anyMatch(set -> set.size() == paths.length);
    }

    public int longestCommonSubpath(int n, int[][] paths) {
        // hashExponent = n;
        int min = 0;  // Last length that a common subpath is found
        int max = 1;
        while(findCommonSubpath(paths, max)) {
            min = max;
            max *= 2;
        }
        while(max > min + 1) {
            int mid = (max + min) / 2;
            if (findCommonSubpath(paths, mid)) {
                min = mid;
            } else {
                max = mid;
            }
        }
        return min;
    }
}

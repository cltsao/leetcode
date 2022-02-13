public class StringCompression2 {
    private int getLength(int count) {
        if (count == 0) return 0;
        if (count == 1) return 1;
        if (count < 10) return 2;
        if (count < 100) return 3;
        return 4;
    }

    public int getLengthOfOptimalCompression(String s, int k) {
        // [p][r], value: min length of substring [0,p] with r characters removed
        int[][] state = new int[s.length() + 1][k + 1];

        for(int p = 1; p <= s.length(); ++p) {
            // At current position p-1, if removing character at p-1, state[p][r] = state[p-1][r-1]
            // If keeping character at p, then it must remove several different characters before it to merge with the last same character
            for(int r = 0; r <= k; ++r) {
                state[p][r] =state[p-1][r] + 1; // Appending this character increase length by 1

                if (r > 0) state[p][r] = Math.min(state[p][r], state[p-1][r-1]); // Try to remove character at p

                // Keep character at p-1
                // Go backward from p-2 to 0 to see if the characters can be either removed to merged
                int removed = 0, count = 1;
                for(int q = p - 2; q >= 0; --q) {
                    if (s.charAt(q) == s.charAt(p - 1)) ++count;
                    else ++removed;
                    if (removed > r) break;
                    state[p][r] = Math.min(state[p][r], state[q][r-removed] + getLength(count));
                }
            }
        }

        return state[s.length()][k];
    }
}

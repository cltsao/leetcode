public class FlipStringMonotoneIncreasing {
    public int minFlipsMonoIncr(String s) {
        // If the flipped string contains zeros in [0, i) and ones in [i, n), number of flips = number of ones in [0, 1) + number of zeros in [i, n)
        int[] onesBefore = new int[s.length() + 1]; // number of ones in [0, i)
        int[] zerosAfter = new int[s.length() + 1]; // number of zeros in [i, n)
        onesBefore[0] = 0;
        for(int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '1') onesBefore[i + 1] = onesBefore[i] + 1;
            else onesBefore[i + 1] = onesBefore[i];
        }
        zerosAfter[s.length()] = 0;
        for(int i = s.length() - 1; i >= 0; --i) {
            if (s.charAt(i) == '0') zerosAfter[i] = zerosAfter[i + 1] + 1;
            else zerosAfter[i] = zerosAfter[i + 1];
        }

        int minFlips = Integer.MAX_VALUE;
        for(int i = 0; i <= s.length(); i++) {
            int flips = onesBefore[i] + zerosAfter[i];
            if (flips < minFlips) minFlips = flips;
        }
        return minFlips;
    }
}

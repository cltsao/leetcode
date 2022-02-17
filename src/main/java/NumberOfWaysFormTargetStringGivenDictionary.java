public class NumberOfWaysFormTargetStringGivenDictionary {
    public int numWays(String[] words, String target) {
        int wordLength = words[0].length();
        int targetLength = target.length();
        final int mod = 1000000007;
        int[][] charCount = new int[wordLength][26];

        for(String word : words) {
            for(int i = 0; i < wordLength; ++i) {
                ++charCount[i][word.charAt(i) - 'a'];
            }
        }

        // Dynamic programming: i = index to use in words, j = index to form in target
        // state[i][j] = state[i-1][j] (doesn't use word[i] at target[j]) + state[i-1][j-1] * charCount[i][target[j]] (use word[i] at target[j])
        long[][] state = new long[wordLength][targetLength];
        for(int wordIndex = 0; wordIndex < wordLength; ++wordIndex) {
            for(int targetIndex = 0; targetIndex <= Math.min(wordIndex, targetLength - 1); ++targetIndex) {
                if (wordIndex > 0) state[wordIndex][targetIndex] = state[wordIndex-1][targetIndex];
                if (targetIndex == 0) state[wordIndex][targetIndex] += charCount[wordIndex][target.charAt(0) - 'a']; // Special case to form the first target char
                else state[wordIndex][targetIndex] += state[wordIndex-1][targetIndex-1] * charCount[wordIndex][target.charAt(targetIndex) - 'a'];
                state[wordIndex][targetIndex] = state[wordIndex][targetIndex] % mod;
            }
        }
        return (int)state[wordLength - 1][targetLength - 1];
    }
}

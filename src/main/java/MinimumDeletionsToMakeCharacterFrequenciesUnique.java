import java.util.Arrays;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {
    public int minDeletions(String s) {
        int[] charCount = new int[26];
        for(char c : s.toCharArray()) {
            ++charCount[c - 'a'];
        }

        int maxCount = Arrays.stream(charCount).max().getAsInt();
        int[] freqCount = new int[maxCount + 1];
        for(int count : charCount) ++freqCount[count];

        int deletions = 0;
        for(int freq = maxCount; freq > 0; --freq) {
            if(freqCount[freq] > 1) {
                deletions += freqCount[freq] - 1;
                freqCount[freq - 1] += freqCount[freq] - 1;
            }
        }
        return deletions;
    }
}

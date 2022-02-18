import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SentenceScreenFitting {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int sentenceLength = 0;
        for(String word : sentence) sentenceLength += word.length() + 1;
        int[] prefixLength = new int[sentenceLength];
        int pos = 0;
        for(String word : sentence) {
            for(int i = 0; i < word.length(); ++i) {
                prefixLength[pos++] = i + 1;
            }
            prefixLength[pos++] = 0;
        }

        int numSentences = 0;
        pos = 0;
        for(int r = 0; r < rows; ++r) {
            pos += cols;
            numSentences += pos / sentenceLength;
            pos = pos % sentenceLength;
            if (prefixLength[pos] == 0) {
                // Land on a space when ending a row
                ++pos;
            } else {
                // Move to the beginning of the word
                pos -= prefixLength[pos] - 1;
            }
        }
        if (pos == sentenceLength) ++numSentences; // Completing last sentence at last row
        return numSentences;
    }

    // Attempt to optimize by finding repeats but it fails at edge cases
    public int wordsTypingOptimizationFail(String[] sentence, int rows, int cols) {
        TreeMap<Integer, Integer> rowsNeeded = new TreeMap<>();
        rowsNeeded.put(0, 0);
        int rIndex = 0, cIndex = 0;
        Map<Integer, Integer> cIndexToRow = new HashMap<>();
        int rowsBeforeRepeating = 0;
        int numSentences = 0;
        while (cIndex + sentence[0].length() <= cols) {
            for (String word : sentence) {
                if (word.length() > cols) return 0; // Cannot even fit a word
                if (cIndex + word.length() > cols) {
                    ++rIndex;
                    cIndex = word.length() + 1;
                } else {
                    cIndex += word.length() + 1;
                }
            }
            if (!cIndexToRow.containsKey(cIndex)) {
                cIndexToRow.put(cIndex, rIndex + 1);
            } else {
                rowsBeforeRepeating = rowsNeeded.floorKey(rIndex);
                break;
            }
            rowsNeeded.put(rIndex + 1, ++numSentences);
            //if (rIndex >= rows) break;
        }
        if (rowsNeeded.size() == 1) return 0;  // Cannot event fit a sentence
        if (rowsBeforeRepeating == rowsNeeded.lastKey()) rowsBeforeRepeating = 0;

        if (rows <= rowsBeforeRepeating)
            return rowsNeeded.floorEntry(rows).getValue();
        int rowsToRepeat = rowsNeeded.lastKey() - rowsBeforeRepeating;
        int countRepeats = (rows - rowsBeforeRepeating) / rowsToRepeat;
        int remainingRows = (rows - rowsBeforeRepeating) % rowsToRepeat;
        return countRepeats * (rowsNeeded.lastEntry().getValue() - rowsNeeded.get(rowsBeforeRepeating)) + rowsNeeded.floorEntry(remainingRows + rowsBeforeRepeating).getValue();
    }
}

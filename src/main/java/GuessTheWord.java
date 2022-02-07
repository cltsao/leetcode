import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

interface Master {
    public int guess(String word);
}

public class GuessTheWord {
    // What is the smallest size of groups that this guess divide the remaining words into?
    int getMinChildSize(Set<Integer> possibleWords, int[][] mutualMatch, int index) {
        int[] childSize = new int[6];
        for(int another : possibleWords) {
            ++childSize[mutualMatch[index][another]];
        }
        return Arrays.stream(childSize).filter(i -> i > 0).min().getAsInt();
    }

    // How many of remaining words match with this guess by at least one character?
    int getMatchChildSize(Set<Integer> possibleWords, int[][] mutualMatch, int index) {
        int[] childSize = new int[6];
        for(int another : possibleWords) {
            ++childSize[mutualMatch[index][another]];
        }
        return possibleWords.size() - childSize[0];
    }

    // How many group can this guess divide the remaining words into?
    int getChildrenNumber(Set<Integer> possibleWords, int[][] mutualMatch, int index) {
        int[] childSize = new int[6];
        for(int another : possibleWords) {
            ++childSize[mutualMatch[index][another]];
        }
        return (int) Arrays.stream(childSize).filter(i -> i > 0).count();
    }

    int getChildrenNumberAndSize(Set<Integer> possibleWords, int[][] mutualMatch, int index) {
        int[] childSize = new int[6];
        for(int another : possibleWords) {
            ++childSize[mutualMatch[index][another]];
        }
        return (int) Arrays.stream(childSize).filter(i -> i > 0).count() + Arrays.stream(childSize).filter(i -> i > 0).min().getAsInt();
    }

    public void findSecretWord(String[] wordlist, Master master) {
        int[][] mutualMatch = new int[wordlist.length][wordlist.length];
        // Each word is 6 character long
        for(int pos = 0; pos < 6; ++pos) {
            List<Integer>[] wordsByChar = new List[26];
            for(int c = 0; c < 26; ++c) wordsByChar[c] = new ArrayList<>();
            for(int index = 0; index < wordlist.length; ++index)
                wordsByChar[wordlist[index].charAt(pos) - 'a'].add(index);

            for(int c = 0; c < 26; ++c) {
                for(int i = 0; i < wordsByChar[c].size(); ++i) {
                    for (int j = i + 1; j < wordsByChar[c].size(); ++j) {
                        ++mutualMatch[wordsByChar[c].get(i)][wordsByChar[c].get(j)];
                        ++mutualMatch[wordsByChar[c].get(j)][wordsByChar[c].get(i)];
                    }
                }
            }
        }

        Set<Integer> possibleWords = new HashSet<>();
        for(int i = 0; i < wordlist.length; ++i) possibleWords.add(i);

        String answer = null;
        for(int round = 0; round < 10; ++round) {
            if (answer != null) master.guess(answer);
            else {
                // Guess the word with max-min child size
                int maxScore = 0;
                int guessIndex = 0;
                for(int index : possibleWords) {
                    int score = getChildrenNumberAndSize(possibleWords, mutualMatch, index);
                    if (score > maxScore) {
                        maxScore = score;
                        guessIndex = index;
                    }
                }
                int result = master.guess(wordlist[guessIndex]);
                if (result == 6) {
                    // Found the answer
                    answer = wordlist[guessIndex];
                } else {
                    possibleWords.remove(guessIndex);
                    for (int wordIndex = 0; wordIndex < wordlist.length; ++wordIndex) {
                        if (mutualMatch[guessIndex][wordIndex] != result) possibleWords.remove(wordIndex);
                    }
                }
            }
        }
    }
}

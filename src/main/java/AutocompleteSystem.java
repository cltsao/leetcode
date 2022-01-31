import java.util.*;

public class AutocompleteSystem {
    int getCharIndex(char c) {
        return (c == ' ') ? 26 : c - 'a';
    }
    Map<String, Integer> sentenceTimes = new HashMap<>();

    class TrieNode {
        TrieNode[] children = new TrieNode[27];
        List<String> sentences = new ArrayList<>();
        List<Integer> times = new ArrayList<>();

        void addSentenceTime(String sentence, int time) {
            for(int i = 0; i < sentences.size(); ++i) {
                if (sentence.equals(sentences.get(i))) {
                    sentences.remove(i);
                    times.remove(i);
                }
            }

            if (sentences.size() < 3) {
                for (int i = 0; i < sentences.size(); ++i) {
                    if (time > times.get(i) || (time == times.get(i) && sentence.compareTo(sentences.get(i)) < 0)) {
                        sentences.add(i, sentence);
                        times.add(i, time);
                        return;
                    }
                }
                sentences.add(sentence);
                times.add(time);
            }
            else {
                for (int i = 0; i < 3; ++i) {
                    if (time > times.get(i) || (time == times.get(i) && sentence.compareTo(sentences.get(i)) < 0)) {
                        sentences.add(i, sentence);
                        times.add(i, time);
                        if (sentences.size() == 4) {
                            sentences.remove(3);
                            times.remove(3);
                        }
                        return;
                    }
                }
            }
        }

        void addSentence(String sentence, int time, int pos) {
            addSentenceTime(sentence, time);

            if(pos < sentence.length()) {
                int childIndex = getCharIndex(sentence.charAt(pos));
                if (children[childIndex] == null) {
                    children[childIndex] = new TrieNode();
                }
                children[childIndex].addSentence(sentence, time,pos + 1);
            }
        }
    }

    TrieNode root = new TrieNode();

    public AutocompleteSystem(String[] sentences, int[] times) {
        for(int i = 0; i < sentences.length; ++i) {
            root.addSentence(sentences[i], times[i], 0);
            sentenceTimes.put(sentences[i], times[i]);
        }
    }

    TrieNode node = root;
    StringBuilder characters = new StringBuilder();

    public List<String> input(char c) {
        if (c == '#') {
            node = root;
            String sentence = characters.toString();
            characters = new StringBuilder();
            Integer time = sentenceTimes.get(sentence);
            if (time == null) time = 1;
            else ++time;
            sentenceTimes.put(sentence, time);
            root.addSentence(sentence, time, 0);
            return List.of();
        } else {
            characters.append(c);
            if (node == null) return List.of();
            if (node.children[getCharIndex(c)] != null) {
                node = node.children[getCharIndex(c)];
                return node.sentences;
            } else {
                node = null;
                return List.of();
            }
        }
    }
}

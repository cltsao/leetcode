import java.util.*;

public class AutocompleteSystem {
    int getCharIndex(char c) {
        return (c == ' ') ? 26 : c - 'a';
    }
    Map<String, Integer> sentenceTimes = new HashMap<>();
    Comparator<Map.Entry<String, Integer>> sentenceComparator = new Comparator<Map.Entry<String, Integer>>() {
        @Override
        public int compare(Map.Entry<String, Integer> s1, Map.Entry<String, Integer> s2) {
            if (s1.getValue() == s2.getValue()) return s1.getKey().compareTo(s2.getKey());
            return s2.getValue() - s1.getValue();
        }
    };

    class TrieNode {
        TrieNode[] children = new TrieNode[27];
        Map<String, Integer> sentences = new HashMap<>();

        void addSentenceTime(String sentence, int time) {
            sentences.put(sentence, time);

            if (sentences.size() > 3) {
                Map.Entry<String, Integer> leastEntry = Collections.max(sentences.entrySet(), sentenceComparator);
                sentences.remove(leastEntry.getKey());
            }
        }

        List<String> getSentences() {
            PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<>(3, sentenceComparator);
            for(Map.Entry<String, Integer> entry : sentences.entrySet()) heap.offer(entry);
            List<String> sortedSentences = new ArrayList<>();
            while(!heap.isEmpty()) sortedSentences.add(heap.poll().getKey());
            return sortedSentences;
        }
    }

    TrieNode root = new TrieNode();

    void addSentence(String sentence, int time) {
        TrieNode node = root;
        for(int pos = 0; pos < sentence.length(); ++pos) {
            node.addSentenceTime(sentence, time);
            int childIndex = getCharIndex(sentence.charAt(pos));
            if (node.children[childIndex] == null) {
                node.children[childIndex] = new TrieNode();
            }
            node = node.children[childIndex];
        }
        node.addSentenceTime(sentence, time);
    }

    public AutocompleteSystem(String[] sentences, int[] times) {
        for(int i = 0; i < sentences.length; ++i) {
            addSentence(sentences[i], times[i]);
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
            addSentence(sentence, time);
            return List.of();
        } else {
            characters.append(c);
            if (node == null) return List.of();
            if (node.children[getCharIndex(c)] != null) {
                node = node.children[getCharIndex(c)];
                return node.getSentences();
            } else {
                node = null;
                return List.of();
            }
        }
    }
}

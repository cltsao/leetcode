import java.util.*;

public class WordLadder {
    class Search {
        String word;
        int steps;

        public Search(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int N = wordList.size();
        int M = beginWord.length();
        Map<String, List<String>> neighborMap = new HashMap<>();
        for(String word : wordList) neighborMap.put(word, new ArrayList<>());
        if (!neighborMap.containsKey(endWord)) return 0;

        // At each position, build a map from substring that removed the character at position, to the list of such words
        // This reduces time complexity of building word graph from N^2 * M to N * M^2
        Map<String, List<String>>[] substringMap = new Map[M];
        for(int pos = 0; pos < M; ++pos) {
            substringMap[pos] = new HashMap<>();
            for(String word : wordList) {
                List wordNeighbors = neighborMap.get(word);
                String substring = word.substring(0, pos) + word.substring(pos + 1, M);
                substringMap[pos].putIfAbsent(substring, new ArrayList<>());
                for(String neighborWord : substringMap[pos].get(substring)) {
                    wordNeighbors.add(neighborWord);
                    neighborMap.get(neighborWord).add(word);
                }
                substringMap[pos].get(substring).add(word);
            }
        }

        // BFS
        Set<String> visitedNodes = new HashSet<>();
        Queue<Search> toVisit = new LinkedList<>();
        for(int pos = 0; pos < M; ++pos) {
            String substring = beginWord.substring(0, pos) + beginWord.substring(pos + 1, M);
            for(String neighborWord : substringMap[pos].getOrDefault(substring, List.of())) {
                if(!visitedNodes.contains(neighborWord)) {
                    visitedNodes.add(neighborWord);
                    if (neighborWord.equals(endWord)) return 2;
                    toVisit.add(new Search(neighborWord, 2));
                }
            }
        }

        while(!toVisit.isEmpty()) {
            Search thisStep = toVisit.poll();
            for(String neighborWord : neighborMap.get(thisStep.word)) {
                if (!visitedNodes.contains(neighborWord)) {
                    visitedNodes.add(neighborWord);
                    if (neighborWord.equals(endWord)) return thisStep.steps + 1;
                    toVisit.add(new Search(neighborWord, thisStep.steps + 1));
                }
            }
        }
        return 0;
    }
}

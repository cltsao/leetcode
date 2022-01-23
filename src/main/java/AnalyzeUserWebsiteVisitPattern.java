import java.util.*;

public class AnalyzeUserWebsiteVisitPattern {

    List<String> mostCommonPattern;
    int mostCommonPatternCount = -1;

    Map<String, Map<String, Map<String, Integer>>> websitePatternCount;

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        // Map from username to history, which is map from timestamp to website
        Map<String, SortedMap<Integer, String>> userVisitHistories = new HashMap<>();

        for(int i = 0; i < username.length; ++i) {
            if (!userVisitHistories.containsKey(username[i])) userVisitHistories.put(username[i], new TreeMap<>());
            userVisitHistories.get(username[i]).put(timestamp[i], website[i]);
        }

        websitePatternCount = new HashMap<>();
        for(SortedMap<Integer, String> visitHistory : userVisitHistories.values()) {
            countPatterns(visitHistory);
        }

        return mostCommonPattern;
    }

    void countPatterns(SortedMap<Integer, String> visitHistory) {
        Set<String> websites = new HashSet<>();
        Map<String, Set<String>> websitePairs = new HashMap<>();
        Map<String, Map<String, Set<String>>> foundPatterns = new HashMap<>();

        for(Map.Entry<Integer, String> entry : visitHistory.entrySet()) {
            String website = entry.getValue();
            // Update pattern count: any previous pair and this website forms a pattern
            for(String prevWeb1 : websitePairs.keySet()) {
                for(String prevWeb2 : websitePairs.get(prevWeb1)) {
                    if (!foundPatterns.get(prevWeb1).get(prevWeb2).contains(website)) {
                        foundPatterns.get(prevWeb1).get(prevWeb2).add(website);
                        int count;
                        if (!websitePatternCount.get(prevWeb1).get(prevWeb2).containsKey(website)) {
                            count = 1;
                        } else {
                            count = websitePatternCount.get(prevWeb1).get(prevWeb2).get(website) + 1;
                        }
                        websitePatternCount.get(prevWeb1).get(prevWeb2).put(website, count);

                        if (count > mostCommonPatternCount) {
                            mostCommonPatternCount = count;
                            mostCommonPattern = List.of(prevWeb1, prevWeb2, website);
                        } else if (count == mostCommonPatternCount) {
                            List<String> newPattern = List.of(prevWeb1, prevWeb2, website);
                            if (compare(mostCommonPattern, newPattern) > 0) {
                                mostCommonPattern = newPattern;
                            }
                        }
                    }
                }
            }

            // Update pair count: any previous website and this website forms a pair
            for(String prevWeb : websites) {
                if (!websitePairs.get(prevWeb).contains(website)) {
                    websitePairs.get(prevWeb).add(website);
                    foundPatterns.get(prevWeb).put(website, new HashSet<>());
                    if (!websitePatternCount.get(prevWeb).containsKey(website)) websitePatternCount.get(prevWeb).put(website, new HashMap<>());
                }
            }

            // Update website count
            if (!websites.contains(website)) {
                websites.add(website);
                websitePairs.put(website, new HashSet<>());
                foundPatterns.put(website, new HashMap<>());
                if (!websitePatternCount.containsKey(website)) websitePatternCount.put(website, new HashMap<>());
            }
        }
    }

    int compare(List<String> pattern1, List<String> pattern2) {
        for(int i = 0; i < pattern1.size(); ++i) {
            int diff = pattern1.get(i).compareTo(pattern2.get(i));
            if (diff != 0) return diff;
        }
        return 0;
    }
}

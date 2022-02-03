import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

public class SellDiminishingValuedColoredBalls {
    public int maxProfit(int[] inventory, int orders) {
        // Map from count of balls to number of colors with such count
        SortedMap<Integer, Integer> invCounts = new TreeMap<>((o1, o2) -> o2 - o1);

        for(int count : inventory) {
            invCounts.put(count, invCounts.getOrDefault(count, 0) + 1);
        }
        long totalProfit = 0;
        while (orders > 0) {
            // Greedy algorithm: sell balls with max count until it's the same as balls with second max count.
            Iterator<Integer> countIterator = invCounts.keySet().iterator();
            int maxCount = countIterator.next();
            int secondMaxCount = countIterator.hasNext() ? countIterator.next() : 0;
            long numWithMaxMarginalProfit = (maxCount - secondMaxCount) * invCounts.get(maxCount);
            if (numWithMaxMarginalProfit < orders) {
                totalProfit += numWithMaxMarginalProfit * (maxCount + secondMaxCount + 1) / 2;
                orders -= numWithMaxMarginalProfit;
                invCounts.put(secondMaxCount, invCounts.get(secondMaxCount) + invCounts.get(maxCount));
                invCounts.remove(maxCount);
            } else {
                long salesWithAllColors = orders / invCounts.get(maxCount);
                long remainingSales = orders % invCounts.get(maxCount);
                totalProfit += salesWithAllColors * invCounts.get(maxCount) * (maxCount * 2 - salesWithAllColors + 1) / 2;
                totalProfit += remainingSales * (maxCount - salesWithAllColors);
                orders = 0;
            }
        }
        return (int)(totalProfit % 1000000007);
    }
}

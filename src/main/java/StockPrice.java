import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class StockPrice {
    TreeMap<Integer, Integer> timePriceMap;
    TreeMap<Integer, Set<Integer>> priceTimeMap;

    public StockPrice() {
        timePriceMap = new TreeMap<>();
        priceTimeMap = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        if (timePriceMap.containsKey(timestamp)) {
            int oldPrice = timePriceMap.get(timestamp);
            priceTimeMap.get(oldPrice).remove(timestamp);
            if (priceTimeMap.get(oldPrice).size() == 0) priceTimeMap.remove(oldPrice);
        }
        timePriceMap.put(timestamp, price);
        if (!priceTimeMap.containsKey(price)) priceTimeMap.put(price, new HashSet<>());
        priceTimeMap.get(price).add(timestamp);
    }

    public int current() {
        return timePriceMap.lastEntry().getValue();
    }

    public int maximum() {
        return priceTimeMap.lastKey();
    }

    public int minimum() {
        return priceTimeMap.firstKey();
    }
}

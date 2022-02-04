import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class ConnectingCitiesWithMinimumCost {
    // Prime's algorithm
    public int minimumCost(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i <= n; ++i)
            graph.add(new ArrayList<>());

        for(int[] connection : connections) {
            graph.get(connection[0]).add(new int[]{connection[1], connection[2]});
            graph.get(connection[1]).add(new int[]{connection[0], connection[2]});
        }

        int totalCost = 0;
        Set<Integer> connectedNodes = new HashSet<>();

        PriorityQueue<int[]> reachableEdges = new PriorityQueue<>(connections.length, Comparator.comparingInt(e -> e[1]));
        reachableEdges.offer(new int[]{1, 0}); // Start from any node

        while(!reachableEdges.isEmpty()) {
            int[] edge = reachableEdges.poll();
            int newNode = edge[0];
            if (connectedNodes.contains(newNode)) continue;
            totalCost += edge[1];
            connectedNodes.add(newNode);
            for(int[] newEdge : graph.get(newNode)) {
                if (!connectedNodes.contains(newEdge[0]))
                    reachableEdges.offer(newEdge);
            }
        }

        if (connectedNodes.size() == n) return totalCost;
        else return -1;
    }
}

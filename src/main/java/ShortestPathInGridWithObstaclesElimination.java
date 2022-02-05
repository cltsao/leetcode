import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInGridWithObstaclesElimination {
    // Number of eliminations left to arrive at a point
    int[][] maxEliminations;

    // int[] visit = [row, col, steps, eliminations]
    Queue<int[]> visitQueue;

    void checkNextVisit(int[][] grid, int row, int col, int steps, int elimination) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return;
        elimination -= grid[row][col];
        if (elimination >= 0 && elimination > maxEliminations[row][col]) {
            maxEliminations[row][col] = elimination;
            visitQueue.add(new int[] {row, col, steps + 1, elimination});
        }
    }

    public int shortestPath(int[][] grid, int k) {
        maxEliminations = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; ++i) {
            Arrays.fill(maxEliminations[i], -1);
        }
        visitQueue = new LinkedList<>();
        visitQueue.add(new int[] {0, 0, 0, k});

        while(!visitQueue.isEmpty()) {
            int[] visit = visitQueue.poll();
            int row = visit[0];
            int col = visit[1];
            int steps = visit[2];
            int elimination = visit[3];
            if (row == grid.length - 1 && col == grid[0].length - 1) return steps;
            checkNextVisit(grid, row - 1, col, steps, elimination);
            checkNextVisit(grid, row + 1, col, steps, elimination);
            checkNextVisit(grid, row, col - 1, steps, elimination);
            checkNextVisit(grid, row, col + 1, steps, elimination);
        }

        return -1;
    }
}

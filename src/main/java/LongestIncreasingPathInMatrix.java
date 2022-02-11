import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LongestIncreasingPathInMatrix {
    int numRows = 0;
    int numCols = 0;

    List<int[]> getLargerNeighbors(int[][] matrix, int row, int col) {
        List<int[]> largerNeighbors = new ArrayList<>();
        int value = matrix[row][col];
        if (row > 0 && matrix[row - 1][col] > value) largerNeighbors.add(new int[] {row - 1, col});
        if (row < numRows - 1 && matrix[row + 1][col] > value) largerNeighbors.add(new int[] {row + 1, col});
        if (col > 0 && matrix[row][col - 1] > value) largerNeighbors.add(new int[] {row, col - 1});
        if (col < numCols - 1 && matrix[row][col + 1] > value) largerNeighbors.add(new int[] {row, col + 1});
        return largerNeighbors;
    }

    boolean isSmallestInProximity(int[][] matrix, int row, int col) {
        int value = matrix[row][col];
        if (row > 0 && matrix[row - 1][col] < value) return false;
        if (row < numRows - 1 && matrix[row + 1][col] < value) return false;
        if (col > 0 && matrix[row][col - 1] < value) return false;
        if (col < numCols - 1 && matrix[row][col + 1] < value) return false;
        return true;
    }

    public int longestIncreasingPath(int[][] matrix) {
        numRows = matrix.length;
        numCols = matrix[0].length;

        // int[] {row, col, val, pathLength}
        PriorityQueue<int[]> visits = new PriorityQueue<>(10, new Comparator<int[]>() {
            @Override
            public int compare(int[] visit1, int[] visit2) {
                if (visit1[3] != visit2[3]) return visit2[3] - visit1[3]; // Prefer longer path
                return visit1[2] - visit2[2]; // If path length is the same, prefer smaller value which has better chance of creating a longer path
            }
        });
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        int[][] maxVisit = new int[numRows][numCols];
        for (int row = 0; row < numRows; ++row) {
            for (int col = 0; col < numCols; ++col) {
                if (isSmallestInProximity(matrix, row, col)) {
                    visits.add(new int[]{row, col, matrix[row][col], 1});
                    maxVisit[row][col] = 1;
                }
            }
        }

        int longestPath = 0;
        while (!visits.isEmpty()) {
            int[] visit = visits.poll();
            if (visit[3] > longestPath) longestPath = visit[3];
            for(int[] next : getLargerNeighbors(matrix, visit[0], visit[1])) {
                if (visit[3] >= maxVisit[next[0]][next[1]]) {
                    visits.add(new int[]{next[0], next[1], matrix[next[0]][next[1]], visit[3] + 1});
                    maxVisit[next[0]][next[1]] = visit[3] + 1;
                }
            }
        }

        return longestPath;
    }
}

import java.util.Arrays;

public class MaximumNumberOfPointsWithCost {
    // Dynamic programming by row: O (R * C * C)
    public long maxPointsDPRow(int[][] points) {
        int numRows = points.length;
        int numCols = points[0].length;
        long[][] maxPoints = new long[numRows][];
        maxPoints[0] = Arrays.stream(points[0]).asLongStream().toArray();

        for (int row = 1; row < numRows; ++row) {
            maxPoints[row] = new long[points[row].length];
            for(int col = 0; col < numCols; ++col) {
                maxPoints[row][col] = maxPoints[row - 1][0] - col;
                for(int fromCol = 1; fromCol < numCols; ++fromCol) {
                    maxPoints[row][col] = Math.max(maxPoints[row][col], maxPoints[row - 1][fromCol] - Math.abs(fromCol - col));
                }
                maxPoints[row][col] += points[row][col];
            }
        }

        return Arrays.stream(maxPoints[numRows - 1]).max().getAsLong();
    }

    // Dynamic programming by row and column: O (R * C)
    public long maxPoints(int[][] points) {
        int numRows = points.length;
        int numCols = points[0].length;
        long[] lastRow = Arrays.stream(points[0]).asLongStream().toArray();
        long[] currentRow = lastRow;

        for (int row = 1; row < numRows; ++row) {
            currentRow = new long[numCols];
            long runningMax = currentRow[0] = lastRow[0];
            for(int col = 1; col < numCols; ++col) {
                currentRow[col] = runningMax = Math.max(runningMax - 1, lastRow[col]);
            }

            for(int col = numCols - 1; col >= 0; --col) {
                runningMax = Math.max(runningMax - 1, lastRow[col]);
                currentRow[col] = Math.max(runningMax, currentRow[col]) + points[row][col];
            }

            lastRow = currentRow;
        }

        return Arrays.stream(currentRow).max().getAsLong();
    }
}

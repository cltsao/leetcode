import java.util.stream.IntStream;

public class RemoveAllOnesWithRowAndColumnFlips {
    // Flip column by first row and then only flip rows
    public boolean removeOnes(int[][] grid) {
        int numRows = grid.length;
        int numCols = grid[0].length;

        for(int col = 0; col < numCols; ++col) {
            if (grid[0][col] == 1)
                for(int row = 0; row < numRows; ++row) {
                    grid[row][col] = 1 - grid[row][col];
                };
        };

        for(int row = 1; row < numRows; ++row) {
            for(int col = 1; col < numCols; ++col) {
                if (grid[row][col] != grid[row][col - 1]) return false;
            }
        }

        return true;
    }

    // Simple heuristic, always try to flip a row with at least half ones.
    public boolean removeOnesHeuristic(int[][] grid) {
        int numRows = grid.length;
        int numCols = grid[0].length;
        int[] onesByRow = new int[grid.length];
        int[] onesByCol = new int[grid[0].length];
        int totalOnes = 0;

        for(int row = 0; row < numRows; ++row) {
            for (int col = 0; col < numCols; ++col) {
                if (grid[row][col] == 1) {
                    ++onesByRow[row];
                    ++onesByCol[col];
                    ++totalOnes;
                }
            }
        }

        // Limit number of rounds that allow flipping a row/column with half ones
        int equalsRounds = 3;
        while(totalOnes > 0) {
            // Find line with most decrement in ones; such line must have at least half ones
            int maxDecrement = --equalsRounds >= 0 ? -1 : 0;
            int maxRow = -1;
            int maxCol = -1;
            for(int row = 0; row < numRows; ++row) {
                int decrement = 2 * onesByRow[row] - numCols;
                if (decrement > maxDecrement) {
                    maxDecrement = decrement;
                    maxRow = row;
                }
            }
            for(int col = 0; col < numCols; ++col) {
                int decrement = 2 * onesByCol[col] - numRows;
                if (decrement > maxDecrement) {
                    maxDecrement = decrement;
                    maxRow = -1;
                    maxCol = col;
                }
            }

            if (maxRow == -1 && maxCol == -1) return false;

            if (maxRow >= 0) {
                for(int col = 0; col < numCols; ++col) {
                    grid[maxRow][col] = 1 - grid[maxRow][col];
                    if (grid[maxRow][col] == 1) {
                        ++onesByRow[maxRow];
                        ++onesByCol[col];
                        ++totalOnes;
                    } else {
                        --onesByRow[maxRow];
                        --onesByCol[col];
                        --totalOnes;
                    }
                }
            } else {
                for(int row = 0; row < numRows; ++row) {
                    grid[row][maxCol] = 1 - grid[row][maxCol];
                    if (grid[row][maxCol] == 1) {
                        ++onesByRow[row];
                        ++onesByCol[maxCol];
                        ++totalOnes;
                    } else {
                        --onesByRow[row];
                        --onesByCol[maxCol];
                        --totalOnes;
                    }
                }
            }
        }

        return true;
    }
}

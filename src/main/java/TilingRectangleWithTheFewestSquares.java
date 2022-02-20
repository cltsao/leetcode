import java.util.Arrays;

public class TilingRectangleWithTheFewestSquares {
    private int limit;
    private int minDepth;
    private int n;
    private int m;

    // n rows, m cols
    public int tilingRectangle(int n, int m) {
        this.n = n;
        this.m = m;
        int[] state = new int[m]; // height in m columns
        limit = Math.max(n, m); // Limit search depth
        minDepth = Integer.MAX_VALUE;
        for(int size = Math.min(n, m); size > 0; --size) {
            dfs(state, 0, size, 1);
        }
        return minDepth;
    }

    // Place a square of size at pos at a step
    public void dfs(int[] state, int pos, int size, int step) {
        if (step > limit) return;

        // Place square
        for(int col = pos; col < pos + size; ++col) {
            state[col] += size;
        }

        // Find next position to place a square
        int colMinHeight = 0;
        int height = Integer.MAX_VALUE;
        int colWithHigherHeight = -1;
        for(int col = 0; col < m; ++col) {
            if (state[col] < height)
            {
                height = state[col];
                colMinHeight = col;
                colWithHigherHeight = -1;
            } else if (state[col] > height && colWithHigherHeight == -1) {
                colWithHigherHeight = col;
            }
        }

        if (height == n) {
            // Found an answer
            minDepth = step;
            limit = step - 1; // Limit depth to search only a better solution
        } else {
            int maxWidth = (colWithHigherHeight < 0) ? (m - colMinHeight) : (colWithHigherHeight - colMinHeight);
            int maxSize = Math.min(n - height, maxWidth);
            for (int nextSize = maxSize; nextSize > 0; --nextSize) {
                dfs(state, colMinHeight, nextSize, step + 1);
            }
        }

        // Remove square
        for(int col = pos; col < pos + size; ++col) {
            state[col] -= size;
        }
    }
}

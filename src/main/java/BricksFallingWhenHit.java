public class BricksFallingWhenHit {
    class DisjointSet {
        int[] parent;
        int[] size;
        DisjointSet(int n) {
            parent = new int[n];
            size = new int[n];
        }

        void add(int x) {
            parent[x] = x;
            size[x] = 1;
        }

        int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]]; // compress parent by the way
                x = parent[x];
            }
            return x;
        }

        // join y into x
        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
        }
    }

    int numRows;
    int numCols;
    int[][] grid;
    DisjointSet bricks;

    private int getBrickId(int row, int col) {
        return row * numCols + col + 1;
    }

    static final int[][] directions = new int[][]{new int[]{-1, 0}, new int[]{1, 0}, new int[]{0, -1}, new int[]{0, 1}};

    void unionAround(int row, int col) {
        int x = getBrickId(row, col);

        if (row == 0) bricks.union(0, x);  // top row is connected to top root

        for(int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numCols && grid[newRow][newCol] == 1) {
                bricks.union(x, getBrickId(newRow, newCol));
            }
        }
    }

    public int[] hitBricks(int[][] grid, int[][] hits) {
        numRows = grid.length;
        numCols = grid[0].length;
        this.grid = grid;
        bricks = new DisjointSet(numRows * numCols + 1);
        bricks.add(0);  // brick 0 is the root that top row connects to

        // Remove all bricks that will be hit
        for(int[] hit : hits) {
            if (grid[hit[0]][hit[1]] == 1)
                grid[hit[0]][hit[1]] = 2;
        }

        for(int row = 0; row < numRows; ++row) {
            for(int col = 0; col < numCols; ++col) {
                if (grid[row][col] == 1) {
                    bricks.add(getBrickId(row, col));
                }
            }
        }
        for(int row = 0; row < numRows; ++row) {
            for(int col = 0; col < numCols; ++col) {
                if (grid[row][col] == 1) {
                    unionAround(row, col);
                }
            }
        }

        // Add hit bricks backward
        int numBricksLeft = bricks.size[bricks.find(0)];
        int[] falls = new int[hits.length];
        for(int i = hits.length - 1; i >= 0; --i) {
            int[] hit = hits[i];
            grid[hit[0]][hit[1]] -= 1;
            if (grid[hit[0]][hit[1]] == 1) {
                bricks.add(getBrickId(hit[0], hit[1]));
                unionAround(hit[0], hit[1]);
                int newNumBricksLeft = bricks.size[bricks.find(0)];
                falls[i] = (newNumBricksLeft > numBricksLeft) ? (newNumBricksLeft - numBricksLeft - 1) : 0; // exclude the hit brick
                numBricksLeft = newNumBricksLeft;
            } else {
                falls[i] = 0;
            }
        }
        return falls;
    }
}

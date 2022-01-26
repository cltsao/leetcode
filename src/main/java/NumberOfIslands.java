public class NumberOfIslands {
    void visitNode(char[][] grid, int i, int j) {
        if (grid[i][j] == '1') {
            grid[i][j] = '2';
            if (i > 0) visitNode(grid, i - 1, j);
            if (i < grid.length - 1) visitNode(grid, i + 1, j);
            if (j > 0) visitNode(grid, i, j - 1);
            if (j < grid[i].length - 1) visitNode(grid, i, j + 1);
        }
    }

    public int numIslands(char[][] grid) {
        int numIslands = 0;

        for(int i = 0; i < grid.length; ++i) {
            for(int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == '1') {
                    ++numIslands;
                    visitNode(grid, i, j);
                }
            }
        }

        return numIslands;
    }
}

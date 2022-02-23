import java.util.PriorityQueue;

public class TrappingRainWaterII {
    int[][] heightMap;

    class Block {
        int row;
        int col;
        int boundary;

        public Block(int row, int col, int boundary) {
            this.row = row;
            this.col = col;
            this.boundary = boundary;
        }

        @Override
        public String toString() {
            return "Block[" + row + "][" + col + "] height=" + heightMap[row][col] + ", boundary=" + boundary;
        }
    }

    private static final int[][] directions = new int[][]{new int[]{-1, 0}, new int[]{1, 0}, new int[]{0, -1}, new int[]{0, 1}};

    public int trapRainWater(int[][] heightMap) {
        this.heightMap = heightMap;
        int numRows = heightMap.length;
        int numCols = heightMap[0].length;
        boolean[][] visited = new boolean[numRows][numCols];

        // row, col, height, boundaryHeight
        PriorityQueue<Block> blocksToCheck = new PriorityQueue<>((b1, b2) -> {
            return b1.boundary - b2.boundary;  // Prefer lower boundary
        });

        // All edge blocks can flow to outside
        for(int col = 0; col < numCols; ++col) {
            visited[0][col] = true;
            blocksToCheck.offer(new Block(0, col, heightMap[0][col]));
            visited[numRows - 1][col] = true;
            blocksToCheck.offer(new Block(numRows - 1, col, heightMap[numRows - 1][col]));
        }
        // All edge blocks can flow to outside
        for(int row = 1; row < numRows - 1; ++row) {
            visited[row][0] = true;
            blocksToCheck.offer(new Block(row, 0, heightMap[row][0]));
            visited[row][numCols - 1] = true;
            blocksToCheck.offer(new Block(row, numCols - 1, heightMap[row][numCols - 1]));
        }

        int trappedWater = 0;
        while(!blocksToCheck.isEmpty()) {
            Block block = blocksToCheck.poll();
            if (block.boundary > heightMap[block.row][block.col])
                trappedWater += block.boundary - heightMap[block.row][block.col];
            for(int[] direction : directions) {
                int newRow = block.row + direction[0];
                int newCol = block.col + direction[1];
                if (newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numCols){
                    if(!visited[newRow][newCol]) {
                        visited[newRow][newCol] = true;
                        blocksToCheck.offer(new Block(newRow, newCol, Math.max(block.boundary, heightMap[newRow][newCol])));
                    }
                }
            }
        }

        return trappedWater;
    }
}

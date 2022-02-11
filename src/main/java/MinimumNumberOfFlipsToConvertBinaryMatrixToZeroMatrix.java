import java.util.*;

public class MinimumNumberOfFlipsToConvertBinaryMatrixToZeroMatrix {
    class Candidate {
        int[][] matrix;
        int numberFlips;
        Candidate(int[][] matrix, int numberFlips) {
            this.matrix = matrix;
            this.numberFlips = numberFlips;
        }

        @Override
        public String toString() {
            return Arrays.deepToString(matrix) + ":" + numberFlips;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Candidate candidate = (Candidate) o;
            if (matrix.length != candidate.matrix.length) return false;
            for(int i = 0; i < matrix.length; ++i)
                if (!Arrays.equals(matrix[i], candidate.matrix[i])) return false;
            return true;
        }

        @Override
        public int hashCode() {
            int result = 1;

            for(int[] row : matrix)
                result = 31 * result + Arrays.hashCode(row);

            return result;
        }
    }

    boolean isZeroMatrix(int[][] matrix) {
        for(int[] row : matrix)
            for(int cell : row)
                if(cell != 0) return false;
        return true;
    }

    int[][] generateFlip(int[][] matrix, int row, int col) {
        int[][] flippedMatrix = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[i].length; ++j) {
                if ((Math.abs(i - row) <= 1 && j == col) || (i == row && Math.abs(j - col) <= 1))
                    flippedMatrix[i][j] = 1 - matrix[i][j];
                else
                    flippedMatrix[i][j] = matrix[i][j];
            }
        }
        return flippedMatrix;
    }

    int[][][] generateFlips(int[][] matrix) {
        int[][][] flippedMatrices = new int[matrix.length * matrix[0].length][][];
        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[i].length; ++j) {
                flippedMatrices[i * matrix[0].length + j] = generateFlip(matrix, i, j);
            }
        }
        return flippedMatrices;
    }

    public int minFlips(int[][] mat) {
        if (isZeroMatrix(mat)) return 0;
        Queue<Candidate> candidates = new LinkedList<>();
        Candidate candidate1 = new Candidate(mat, 0);
        candidates.add(candidate1);
        Set<Candidate> visitedMatrices = new HashSet<>();
        visitedMatrices.add(candidate1);
        while(!candidates.isEmpty()) {
            Candidate candidate = candidates.poll();
            for(int[][] flippedMatrix : generateFlips(candidate.matrix)) {
                if (isZeroMatrix(flippedMatrix)) return candidate.numberFlips + 1;
                Candidate next = new Candidate(flippedMatrix, candidate.numberFlips + 1);
                if (!visitedMatrices.contains(next)) {
                    visitedMatrices.add(next);
                    candidates.add(next);
                }
            }
        }
        return -1;
    }
}

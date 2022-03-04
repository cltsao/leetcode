import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> sequence = new ArrayList<>();
        int R = matrix.length, C = matrix[0].length, M = Math.min(R, C);
        int r, c;
        for(int i = 0; i < M / 2; ++i) {
            r = c = i;
            for(;c < C - i - 1; ++c) sequence.add(matrix[r][c]);
            for(;r < R - i - 1; ++r) sequence.add(matrix[r][c]);
            for(;c > i; --c) sequence.add(matrix[r][c]);
            for(;r > i; --r) sequence.add(matrix[r][c]);
        }
        if (M % 2 == 1) {
            r = c = M/2;
            if (R < C) {
                for(; c <= M/2 + C - R; ++c) sequence.add(matrix[r][c]);
            } else {
                for(; r <= M/2 + R - C; ++r) sequence.add(matrix[r][c]);
            }
        }
        return sequence;
    }
}

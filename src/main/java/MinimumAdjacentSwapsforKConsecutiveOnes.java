import java.util.ArrayList;

public class MinimumAdjacentSwapsforKConsecutiveOnes {
    int getMoves(ArrayList<Integer> onePositions, int positionIndex, int k) {
        int headPosition = onePositions.get(positionIndex);
        int tailPosition = onePositions.get(positionIndex);
        int headPositionIndex = positionIndex;
        int tailPositionIndex = positionIndex;
        int moves = 0;
        while(tailPositionIndex - headPositionIndex + 1 < k) {
            int headMoves = headPositionIndex > 0 ? headPosition - onePositions.get(headPositionIndex - 1) - 1 : Integer.MAX_VALUE;
            int tailMoves = tailPositionIndex < onePositions.size() - 1 ? onePositions.get(tailPositionIndex + 1) - tailPosition - 1 : Integer.MAX_VALUE;
            if (headMoves < tailMoves) {
                --headPositionIndex;
                --headPosition;
                moves += headMoves;
            } else {
                ++tailPositionIndex;
                ++tailPosition;
                moves += tailMoves;
            }
        }
        return moves;
    }

    // Anchor each one and calculate number of swaps using greedy algorithm. Time complexity: O(N * K)
    public int minMoves(int[] nums, int k) {
        long startTime = System.currentTimeMillis();

        ArrayList<Integer> onePositions = new ArrayList<>();
        for(int pos = 0; pos < nums.length; ++pos) {
            if (nums[pos] == 1)
                onePositions.add(pos);
        }

        int minMoves = Integer.MAX_VALUE;
        for(int i = 0; i < onePositions.size(); ++i) {
            minMoves = Math.min(minMoves, getMoves(onePositions, i, k));
        }

        System.out.println("Execution time: " + (System.currentTimeMillis() - startTime) + " ms");
        return minMoves;
    }
}

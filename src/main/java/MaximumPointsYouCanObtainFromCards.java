public class MaximumPointsYouCanObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int start = cardPoints.length - k;
        for(int i = start; i < cardPoints.length; ++i) {
            sum += cardPoints[i];
        }
        int maxSum = sum;
        for(++start; start <= cardPoints.length; ++start) {
            sum -= cardPoints[start - 1];
            sum += cardPoints[start + k - 1 - cardPoints.length];
            if (sum > maxSum) maxSum = sum;
        }
        return maxSum;
    }
}

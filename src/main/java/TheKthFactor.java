public class TheKthFactor {
    public int kthFactor(int n, int k) {
        int numFactors = 0;
        int i;
        for(i = 1; i * i < n; ++i) {
            if (n % i == 0) ++numFactors;
            if (numFactors == k) return i;
        }

        if (i * i == n) {
            ++numFactors;
            if (numFactors == k) return i;
        }

        for(i = i - 1; i >= 1; --i) {
            if (n % i == 0) ++numFactors;
            if (numFactors == k) return n / i;
        }

        return -1;
    }
}

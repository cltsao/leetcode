public class NumberOfUniqueGoodSubsequences {
    public int numberOfUniqueGoodSubsequences(String binary) {
        final int mod = 1000000007;
        int end0 = 0;
        int end1 = 0;
        for(char c : binary.toCharArray()) {
            switch(c) {
                case '1':
                    end1 = (end0 + end1 + 1) % mod;
                    break;
                case '0':
                    end0 = (end0 + end1) % mod;
                    break;
            }
        }
        return (end0 + end1 + (binary.contains("0") ? 1 : 0)) % mod;
    }
}

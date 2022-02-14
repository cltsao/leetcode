public class NumberOfDigitOne {
    public int countDigitOne(int n) {
        int lastModulo = 1;
        int modulo = 10;
        int count = 0;
        while(true) {
            int multiple = n / modulo;
            int remainder = n % modulo;
            count += multiple * lastModulo;
            count += Math.max(0, Math.min(remainder - lastModulo + 1, lastModulo));
            if (multiple == 0) break;
            lastModulo = modulo;
            modulo *= 10;
        }
        return count;
    }
}

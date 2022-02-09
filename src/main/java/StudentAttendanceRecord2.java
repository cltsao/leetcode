public class StudentAttendanceRecord2 {
    public int checkRecord(int n) {
        // index1: number of absences, index2: number of consecutive lates
        long[][] count = new long[2][3];
        final long mod = 1000000007;
        count[0][0] = 1;
        while (--n >= 0) {
            long[][] nextCount = new long[2][3];
            // count[0][0]: A->[1][0], L->[0][1], P->[0][0]
            // count[0][1]: A->[1][0], L->[0][2], P->[0][0]
            // count[0][2]: A->[1][0], L->x, P->[0][0]
            // count[1][0]: A->x, L->[1][1], P->[1][0]
            // count[1][1]: A->x, L->[1][2], P->[1][0]
            // count[1][2]: A->x, L->x, P->[1][0]
            nextCount[0][0] = (count[0][0] + count[0][1] + count[0][2]) % mod; // P, P, P
            nextCount[0][1] = count[0][0]; // L
            nextCount[0][2] = count[0][1]; // L
            nextCount[1][0] = (count[0][0] + count[0][1] + count[0][2] + count[1][0] + count[1][1] + count[1][2]) % mod; // A, A, A, P
            nextCount[1][1] = count[1][0]; // L
            nextCount[1][2] = count[1][1]; // L
            count = nextCount;
        }
        long total = 0;
        for (long[] row : count)
            for (long num : row)
                total = (total + num) % mod;

        return (int) total;
    }
}

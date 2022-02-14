import java.util.HashMap;
import java.util.Map;

public class CinemaSeatAllocation {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // Bit 0, 1, 2 represents if group seat assigned to 2~5, 4~7, or 6~9
        Map<Integer, Byte> groupSeatReserved = new HashMap<>();
        for(int[] reservedSeat : reservedSeats) {
            int row = reservedSeat[0] - 1;
            byte currentSeats = groupSeatReserved.getOrDefault(row, (byte)0);
            switch(reservedSeat[1] - 1) {
                case 1:
                case 2:
                    groupSeatReserved.put(row, (byte) (currentSeats | 1));
                    break;
                case 3:
                case 4:
                    groupSeatReserved.put(row, (byte) (currentSeats | 3));
                    break;
                case 5:
                case 6:
                    groupSeatReserved.put(row, (byte) (currentSeats | 6));
                    break;
                case 7:
                case 8:
                    groupSeatReserved.put(row, (byte) (currentSeats | 4));
                    break;
            }
        }

        int groupsReserved = 0;
        for(Byte seats : groupSeatReserved.values()) {
            if (seats == 7) groupsReserved += 2;
            else if ((seats & 5) != 0) ++groupsReserved;
        }

        return n * 2 - groupsReserved;
    }
}

import java.util.Arrays;

public class MaximumVacationDays {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int numCities = flights.length;
        int numWeeks = days[0].length;
        int[] maxVac = new int[numCities];

        // Initial city = 0
        maxVac[0] = days[0][0];
        for (int dst = 1; dst < numCities; ++dst) {
            if (flights[0][dst] == 1)
                maxVac[dst] = days[dst][0];
            else
                maxVac[dst] = -1; // can't reach destination
        }

        for (int week = 1; week < numWeeks; ++week) {
            int[] newMaxVac = new int[numCities];
            Arrays.fill(newMaxVac, -1);

            for(int dst = 0; dst < numCities; ++dst) {
                for(int src = 0; src < numCities; ++src) {
                    if (src == dst || flights[src][dst] == 1) {
                        newMaxVac[dst] = Math.max(newMaxVac[dst], maxVac[src]);
                    }
                }
                if (newMaxVac[dst] >= 0)
                    newMaxVac[dst] += days[dst][week];
            }

            maxVac = newMaxVac;
        }

        return Arrays.stream(maxVac).max().getAsInt();
    }
}

public class SuperWashingMachines {
    public int findMinMoves(int[] machines) {
        int total = 0;
        for(int machine : machines) total += machine;
        if (total % machines.length != 0) return -1;
        int average = total / machines.length;
        int maxSurplus = 0, maxDiff = 0;
        int surplus = 0;
        for(int machine : machines) {
            int diff = machine - average;
            surplus += diff;
            maxSurplus = Math.max(maxSurplus, Math.abs(surplus));
            maxDiff = Math.max(maxDiff, diff);
        }
        return Math.max(maxDiff, maxSurplus);
    }
}

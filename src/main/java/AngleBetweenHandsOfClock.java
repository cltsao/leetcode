public class AngleBetweenHandsOfClock {
    public double angleClock(int hour, int minutes) {
        double angle = Math.abs((hour % 12 + minutes / 60.0) * 30 - minutes * 6);
        if (angle > 180) angle = 360 - angle;
        return angle;
    }
}

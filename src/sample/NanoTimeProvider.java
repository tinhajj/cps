package sample;

public class NanoTimeProvider implements CurrentTimeProvider{
    public TimeDifference<NanoTime> currentTime() {
        return new NanoTime();
    }
}

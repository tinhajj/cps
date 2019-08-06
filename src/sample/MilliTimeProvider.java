package sample;

public class MilliTimeProvider implements CurrentTimeProvider{
    public TimeDifference<MilliTime> currentTime() {
        return new MilliTime();
    }
}

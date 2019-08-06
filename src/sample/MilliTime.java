package sample;

import java.time.Duration;

public class MilliTime implements TimeDifference<MilliTime> {
    private long time;

    public MilliTime() {
        time = System.currentTimeMillis();
    }

    public Duration timeDifference(MilliTime otherTime) {
        return Duration.ofMillis(time - otherTime.time);
    }
}

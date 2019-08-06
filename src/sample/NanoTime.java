package sample;

import java.time.Duration;

public class NanoTime implements TimeDifference<NanoTime> {
    private long time;

    public NanoTime() {
        time = System.nanoTime();
    }

    @Override
    public Duration timeDifference(NanoTime otherTime) {
        return Duration.ofNanos(time - otherTime.time);
    }
}

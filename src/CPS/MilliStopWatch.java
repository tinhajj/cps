package CPS;

import java.time.Duration;

public class MilliStopWatch implements StopWatch {
    private long time;

    public MilliStopWatch() {
        time = System.currentTimeMillis();
    }

    public Duration elapsedTime() {
        return Duration.ofMillis(System.currentTimeMillis() - time);
    }

    public void reset() {
        time = System.currentTimeMillis();
    }
}

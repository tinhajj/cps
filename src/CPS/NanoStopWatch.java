package CPS;

import java.time.Duration;

public class NanoStopWatch implements StopWatch {
    private long time;

    public NanoStopWatch() {
        time = System.nanoTime();
    }

    public Duration elapsedTime() {
        return Duration.ofMillis(System.nanoTime() - time);
    }

    public void reset() {
        time = System.nanoTime();
    }
}

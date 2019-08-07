package CPS;

import java.time.Duration;

public interface StopWatch {
    Duration elapsedTime();

    void reset();
}
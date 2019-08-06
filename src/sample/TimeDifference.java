package sample;

import java.time.Duration;

public interface TimeDifference<T> {
    Duration timeDifference(T otherTime);
}
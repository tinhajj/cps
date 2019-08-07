package CPS;

enum StopWatchType {
    Milli,
    Nano
}

public class StopWatchFactory {
    private StopWatchType stopWatchType;

    public StopWatchFactory(StopWatchType stopWatchType) {
        this.stopWatchType = stopWatchType;
    }

    public StopWatch getStopWatch() {
        switch(stopWatchType) {
            case Nano:
                return new NanoStopWatch();
            case Milli:
                return new MilliStopWatch();
            default:
                return new MilliStopWatch();
        }
    }
}

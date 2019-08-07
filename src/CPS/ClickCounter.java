package CPS;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.time.Duration;

public class ClickCounter {
    StopWatchFactory stopWatchFactory;

    private StopWatch initialClickStopWatch;
    private StopWatch lastClickStopWatch;

    private int rightClicksTotal;
    private int leftClicksTotal;

    public ClickCounter(StopWatchFactory stopWatchFactory) {
        rightClicksTotal = 0;
        leftClicksTotal = 0;

        this.stopWatchFactory = stopWatchFactory;

        this.initialClickStopWatch = stopWatchFactory.getStopWatch();
        this.lastClickStopWatch = stopWatchFactory.getStopWatch();
    }

    public void countClick(MouseEvent event) {
        if (!clickedInPastSecond()) {
            reset();
        }

        recordClick(event);
    }

    public boolean clickedInPastSecond() {
        Duration elapsedTime = lastClickStopWatch.elapsedTime();

        return elapsedTime.toMillis() <= 1000;

    }

    public void reset() {
        rightClicksTotal = 0;
        leftClicksTotal = 0;
        initialClickStopWatch.reset();
    }

    public void recordClick(MouseEvent event) {
        MouseButton button = event.getButton();

        switch (button) {
            case PRIMARY:
                leftClicksTotal++;
                break;
            case SECONDARY:
                rightClicksTotal++;
                break;
            default:
                System.out.println("Unknown key pressed");
        }

        lastClickStopWatch.reset();
    }

    public double getRightClicksPerSecond() {
        Duration elapsedTime = initialClickStopWatch.elapsedTime();

        Double elapsedSeconds = elapsedTime.toMillis() / 1000d;

        return (double) rightClicksTotal / elapsedSeconds;
    }

    public double getLeftClicksPerSecond() {
        Duration elapsedTime = initialClickStopWatch.elapsedTime();

        Double elapsedSeconds = elapsedTime.toMillis() / 1000d;

        return (double) leftClicksTotal / elapsedSeconds;
    }

    public double totalClicksPerSecond() {
        return getRightClicksPerSecond() + getLeftClicksPerSecond();
    }
}

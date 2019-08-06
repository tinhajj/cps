package sample;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.time.Duration;

public class ClickCounter {
    CurrentTimeProvider timeProvider;

    private TimeDifference initialClickTime;
    private TimeDifference lastClickTime;

    private int rightClicksTotal;
    private int leftClicksTotal;

    public ClickCounter(CurrentTimeProvider timeProvider) {
        rightClicksTotal = 0;
        leftClicksTotal = 0;

        this.timeProvider = timeProvider;
    }

    public void countClick(MouseEvent event) {
        if (!clickedInPastSecond()) {
            reset();
        }

        recordClick(event);
    }

    public boolean clickedInPastSecond() {
        if (lastClickTime == null) {
            return false;
        }

        TimeDifference currentTime = timeProvider.currentTime();
        Duration elapsedTime = currentTime.timeDifference(lastClickTime);

        if (elapsedTime.toMillis() <= 1000) {
            return true;
        }

        return false;
    }

    public void reset() {
        rightClicksTotal = 0;
        leftClicksTotal = 0;
        initialClickTime = timeProvider.currentTime();
    }

    public void recordClick(MouseEvent event) {
        MouseButton button = event.getButton();

        switch(button) {
            case PRIMARY:
                leftClicksTotal++;
                break;
            case SECONDARY:
                rightClicksTotal++;
                break;
            default:
                System.out.println("Unknown key pressed");
        }

        lastClickTime = timeProvider.currentTime();
    }

    public double getRightClicksPerSecond() {
        TimeDifference currentTime = timeProvider.currentTime();

        Duration elapsedTime = currentTime.timeDifference(initialClickTime);
        Double elapsedSeconds = elapsedTime.toMillis() / 1000d;

        return (double) rightClicksTotal / elapsedSeconds;
    }

    public double getLeftClicksPerSecond() {
        TimeDifference currentTime = timeProvider.currentTime();

        Duration elapsedTime = currentTime.timeDifference(initialClickTime);
        Double elapsedSeconds = elapsedTime.toMillis() / 1000d;

        return (double) leftClicksTotal / elapsedSeconds;
    }

    public double totalClicksPerSecond() {
        return getRightClicksPerSecond() + getLeftClicksPerSecond();
    }
}

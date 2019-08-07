package CPS;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    Text totalClicksText;
    @FXML
    Text leftClicksText;
    @FXML
    Text rightClicksText;
    private ClickCounter clickCounter;

    public void initialize(URL location, ResourceBundle resource) {
        StopWatchFactory stopWatchFactory = new StopWatchFactory(StopWatchType.Milli);
        clickCounter = new ClickCounter(stopWatchFactory);
    }

    public void handleClick(MouseEvent event) {
        clickCounter.countClick(event);

        totalClicksText.setText("Total Clicks: " + (clickCounter.totalClicksPerSecond()));
        leftClicksText.setText("Left Clicks: " + (clickCounter.getLeftClicksPerSecond()));
        rightClicksText.setText("Right Clicks: " + (clickCounter.getRightClicksPerSecond()));
    }
}

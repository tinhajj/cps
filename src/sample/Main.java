package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        CurrentTimeProvider timeProvider = new NanoTimeProvider();
        ClickCounter clickCounter = new ClickCounter(timeProvider);

        Text totalClicksText = new Text();
        totalClicksText.setText("Total Clicks: ");

        totalClicksText.setX(50);
        totalClicksText.setY(50);

        Text rightClicksText = new Text();
        rightClicksText.setText("Right Clicks: ");

        rightClicksText.setX(50);
        rightClicksText.setY(80);

        Text leftClicksText = new Text();
        leftClicksText.setText("Left Clicks: ");

        leftClicksText.setX(50);
        leftClicksText.setY(100);

        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Group root = new Group(totalClicksText, rightClicksText, leftClicksText);

        primaryStage.setTitle("CPS");

        Scene scene = new Scene(root, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.setOnMouseClicked(
                (MouseEvent event) -> {
                    clickCounter.countClick(event);

                    leftClicksText.setText("Left Clicks: " + Double.toString(clickCounter.getLeftClicksPerSecond()));
                    rightClicksText.setText("Right Clicks: " + Double.toString(clickCounter.getRightClicksPerSecond()));
                    totalClicksText.setText("Total Clicks: " + Double.toString(clickCounter.totalClicksPerSecond()));
                }
        );
    }


    public static void main(String[] args) {
        launch(args);
    }
}

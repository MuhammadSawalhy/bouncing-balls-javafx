package zagazig.cse.bouncingballs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.util.Duration;
import zagazig.cse.bouncingballs.balls.Ball;
import zagazig.cse.bouncingballs.controller.Controller;

/**
 * JavaFX App
 */
public final class App extends Application {
    Timeline timeline;
    Controller controller;
    AppSettings settings = new AppSettings();
    Boolean isRunning = true; // to know whether or not the timeline is running

    @Override
    public void start(Stage stage) {
        settings.width = 700;
        settings.height = 600;
        settings.speedMulitplier = 1;

        controller = new Controller(settings);
        timeline = new Timeline(new KeyFrame(Duration.millis(10), new TimelineEventHandler()));
        var root = new Pane();
        var scene = new Scene(root, settings.width, settings.height);
        var settingsContainer = new GridPane();
        var runStopBtn = new Button("Stop");
        var speedSlider = new Slider(0.5, 2, 1);

        settingsContainer.add(new Label("Run/Stop"), 0, 0); // row 0, column 0
        settingsContainer.add(new Label("Speed"), 0, 1); // row 1, column 0
        settingsContainer.add(runStopBtn, 1, 0);
        settingsContainer.add(speedSlider, 1, 1);
        settingsContainer.setBackground(Background.fill(Color.web("#ADDBCB")));
        settingsContainer.setPadding(new Insets(10));
        settingsContainer.setHgap(20);
        settingsContainer.setVgap(10);
        // stick the settingsContainer to the top right corner
        settingsContainer.layoutXProperty().bind(root.widthProperty().subtract(settingsContainer.widthProperty()));

        for (Ball b : controller.balls)
            root.getChildren().add(b.shape);

        root.getChildren().add(settingsContainer);

        stage.widthProperty().addListener((obs, oldVal, newVal) -> {
            settings.width = newVal.intValue();
        });

        stage.heightProperty().addListener((obs, oldVal, newVal) -> {
            settings.height = newVal.intValue();
        });

        runStopBtn.setOnAction((e) -> {
            if (isRunning) {
                timeline.pause();
                runStopBtn.setText("Run");
                isRunning = false;
            } else {
                timeline.play();
                runStopBtn.setText("Stop");
                isRunning = true;
            }
        });

        speedSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            settings.speedMulitplier = newVal.doubleValue();
        });

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        stage.setScene(scene);
        stage.setTitle("Bouncing Balls");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private class TimelineEventHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent actionEvent) {
            controller.moveBalls();
        }
    }
}

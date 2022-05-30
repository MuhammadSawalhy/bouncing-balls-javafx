package zagazig.cse.bouncingballs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import zagazig.cse.bouncingballs.controller.Controller;

/**
 * JavaFX App
 */
public final class App extends Application {
    Timeline timeline;
    Controller controller;
    AppSettings settings = new AppSettings();

    @Override
    public void start(Stage stage) {
        settings.width = 700;
        settings.height = 600;
        settings.speedMulitplier = 1;
        controller = new Controller(settings);

        var root = new Pane();
        var scene = new Scene(root, settings.width, settings.height);
        root.getChildren().addAll(controller.balls.stream().map(ball -> ball.shape).toList());

        timeline = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controller.moveBalls();
            }
        }));

        stage.widthProperty().addListener((obs, oldVal, newVal) -> {
            settings.width = newVal.intValue();
        });

        stage.heightProperty().addListener((obs, oldVal, newVal) -> {
            settings.height = newVal.intValue();
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
}

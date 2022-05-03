package zagazig.cse.bouncingballs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var root = new StackPane();

        var circleBackgroundColor = new Color(0.1, 0.1, 0.1, 0.3);
        var circle = new Circle(100, circleBackgroundColor);
        circle.centerXProperty().bind(stage.widthProperty().divide(2));
        circle.centerYProperty().bind(stage.heightProperty().divide(2));

        var label = new Label("Assalamu Alaikum, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");

        root.getChildren().addAll(circle, label);
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}

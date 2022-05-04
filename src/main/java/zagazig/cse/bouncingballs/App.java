package zagazig.cse.bouncingballs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.util.Duration;

/**
 * JavaFX App
 */
public class App extends Application {
    static int radius = 100;
    static Circle circle;
    static Timeline timeline;

    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var root = new Pane();

        var circleBackgroundColor = new Color(0.1, 0.1, 0.1, 0.3);
        circle = new Circle(radius, circleBackgroundColor);
        circle.setCenterX(getRandomInt(radius, 640 - radius));
        circle.setCenterY(getRandomInt(radius, 480 - radius));

        var label = new Label("Assalamu Alaikum, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        label.layoutXProperty().bind(root.widthProperty().divide(2).subtract(label.widthProperty().divide(2)));
        label.layoutYProperty().bind(root.heightProperty().divide(2).subtract(label.heightProperty().divide(2)));

        root.getChildren().addAll(circle, label);
        var scene = new Scene(root, 640, 480);

    
        timeline = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {

            double deltaX = 2;
            double deltaY = 2;

            @Override
            public void handle(ActionEvent actionEvent) {
                circle.setCenterX(circle.getCenterX() + deltaX);
                circle.setCenterY(circle.getCenterY() + deltaY);

                Bounds bounds = root.getBoundsInLocal();
                boolean rightBorder  = circle.getCenterX() >= (bounds.getMaxX() - circle.getRadius());
                boolean leftBorder   = circle.getCenterX() <= (bounds.getMinX() + circle.getRadius());
                boolean bottomBorder = circle.getCenterY() >= (bounds.getMaxY() - circle.getRadius());
                boolean topBorder    = circle.getCenterY() <= (bounds.getMinY() + circle.getRadius());

                if (rightBorder || leftBorder) deltaX *= -1;
                if (bottomBorder || topBorder) deltaY *= -1;
            }
        }));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        stage.setScene(scene);
        stage.show();
    }

    public static int getRandomInt(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package application;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Controller {

    @FXML
    private Button button;

    @FXML
    private Rectangle rectangle;

    @FXML
    public void initialize() {
        button.setOnAction(event -> rotateRectangle());
    }

    private void rotateRectangle() {
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(1), rectangle);
        rotateTransition.setByAngle(360);
        rotateTransition.play();
    }
}

package wolfish.physics;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RocketController {

    @FXML
    TextField velocityField;
    @FXML
    TextField angleField;
    @FXML
    TextField secondsField;
    @FXML
    Button calculateButton;
    @FXML
    Label flightTime;
    @FXML
    Label position;
    @FXML
    RocketCanvas rocketCanvas;



    public void calculateRocket(ActionEvent actionEvent) {
        double velocity = Double.parseDouble(velocityField.getText());
        double angle = Double.parseDouble(angleField.getText());
        double seconds = Double.parseDouble(secondsField.getText());


        Rocket rocket = new Rocket(velocity, angle);
        String location = String.format("(%.2f, %.2f)", rocket.getX(seconds), rocket.getFlightTime());
        position.setText(location);
        flightTime.setText(String.format("The total flight time was: %.2f seconds", rocket.getFlightTime()));

        rocketCanvas.drawRocket(rocket);
    }
}

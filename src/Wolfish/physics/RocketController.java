package Wolfish.physics;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    TextField flightTime;
    @FXML
    TextField xPosition;
    @FXML
    TextField yPosition;

    public void calculateRocket(ActionEvent actionEvent){
        double velocity = Double.parseDouble(velocityField.getText());
        double angle = Double.parseDouble(angleField.getText());
        double seconds = Double.parseDouble(secondsField.getText());


        Rocket rocket = new Rocket(velocity, angle);
        xPosition.setText(Double.toString(rocket.getX(seconds)));
        yPosition.setText(Double.toString(rocket.getY(seconds)));
        flightTime.setText(Double.toString(rocket.getFlightTime()));
    }
}

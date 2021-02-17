package Wolfish.scrabble;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;

public class DictionaryController {
    @FXML
    TextField wordField;
    @FXML
    Button searchButton;
    @FXML
    Label result;


    public void searchWord(ActionEvent event) throws FileNotFoundException {
        Dictionary dict = new Dictionary("dictionary.txt");
        String word = wordField.getText();

        if (dict.determineIfWordIsValid(word)) {
            result.setText("This is a valid word");
        } else {
            result.setText("This is not a valid word");
        }
    }
}

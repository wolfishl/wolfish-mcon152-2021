package wolfish.scrabble;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class DictionaryController {
    @FXML
    TextField wordField;
    @FXML
    Button searchButton;
    @FXML
    Label result;


    public void searchWord(ActionEvent event) throws IOException {
        DictionaryService  service = new DictionaryService();
        Dictionary dict = service.dictionary();
        String word = wordField.getText();

        if (dict.determineIfWordIsValid(word)) {
            result.setText("This is a valid word");
        } else {
            result.setText("This is not a valid word");
        }
    }
}

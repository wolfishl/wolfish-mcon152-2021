package wolfish.scrabble;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;

public class DictionaryGameController {
    @FXML
    Button tile1;



    public void searchWord(ActionEvent event) throws FileNotFoundException {
        Dictionary dict = new Dictionary("dictionary.txt");


    }
}

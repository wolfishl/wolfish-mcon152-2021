package Wolfish.scrabble;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DictionaryController {
    @FXML
    TextField wordField;
    @FXML
    Button searchButton;
    @FXML
    TextField result;


    public void searchWord(ActionEvent event)
    {
        Dictionary dict = new Dictionary("dictionary.txt");
        String word = wordField.getText();

        if(dict.determineIfWordIsValid(word))
        {
            result.setText("Yes");
        }
        else
        {
            result.setText("No");
        }
    }
}

package wolfish.scrabble;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

public class DictionaryGameController {
    @FXML
    List<Button> tiles;
    @FXML
    TextField word;
    @FXML
    Label score;
    @FXML
    Label invalid;


    private LetterBag letterBag = new LetterBag();

    private Dictionary dict;

    public DictionaryGameController() {
        try {
            DictionaryService  service = new DictionaryService();
            dict = service.dictionary();
        } catch (IOException error) {
            error.printStackTrace();
        }

    }

    @FXML
    public void initialize() {
        for (Button button : tiles) {
            button.setText(letterBag.nextLetter());
        }
    }

    public void onTileClick(ActionEvent event) {
        Button button = (Button) event.getSource();
        String letter = button.getText();
        if (!letter.equals("  ")) {
            word.setText(word.getText() + letter);
            button.setText("  ");
        }
    }

    public void onClear(ActionEvent event) {
        String current = word.getText();
        if (!current.equals("")) {
            String letter = current.substring(current.length() - 1);
            resetTiles(letter);
            word.setText(current.substring(0, current.length() - 1));
        }
    }



    public void onSubmit(ActionEvent event) {
        if (dict.determineIfWordIsValid(word.getText()) && word.getText().length() > 1) {
            int points = 0;
            switch (word.getText().length()) {
                case 2:
                    points = 1;
                    break;
                case 3:
                    points = 3;
                    break;
                case 4:
                    points = 5;
                    break;
                case 5:
                    points = 7;
                    break;
                case 6:
                    points = 11;
                    break;
                case 7:
                    points = 13;
                    break;
                default:
                    points = 0;
            }
            String[] words = score.getText().split(" ");
            int number = Integer.parseInt(words[2]);
            number += points;
            score.setText(words[0] + " " + words[1] + " " + number);
            word.setText("");
            for (Button tile : tiles) {
                if (tile.getText().equals("  ") && !letterBag.isEmpty()) {
                    tile.setText(letterBag.nextLetter());
                }
            }
            invalid.setText("");
        } else {
            char[] letters = word.getText().toCharArray();
            for (char letter : letters) {
                resetTiles(Character.toString(letter));
            }
            word.setText("");
            invalid.setText("invalid word");
        }
    }

    public void resetTiles(String letter) {
        for (Button tile : tiles) {
            if (tile.getText().equals("  ")) {
                tile.setText(letter);
                break;
            }
        }
    }
}

package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {
    @FXML
    public TextField textField;
    @FXML
    public TextArea textArea;


    public void textField(ActionEvent actionEvent) {
        textArea.appendText(textField.getText() + "\n");
        textField.setText("");
        textArea.setStyle("-fx-text-fill: green;" +
                "-fx-control-inner-background: black;" +
                "-fx-highlight-fill: white;" +
                "-fx-highlight-text-fill: black");
    }

    public void onActionBtn1(MouseEvent mouseEvent) {
        textArea.appendText(textField.getText() + "\n");
        textField.setText("");
        textArea.setStyle("-fx-text-fill: green;" +
                "-fx-control-inner-background: black;" +
                "-fx-highlight-fill: white;" +
                "-fx-highlight-text-fill: black");
    }


}

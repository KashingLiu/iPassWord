package first_set;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;


public class Controller {
    @FXML
    public TextField main_password;

    @FXML
    public void press_button (ActionEvent event) {
        System.out.println(main_password.getText());
//        if (pass) { turn to the other page }
//        else alert
    }
}

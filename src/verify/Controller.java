package verify;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.SVGPath;

import java.awt.event.InputMethodEvent;

public class Controller {
    @FXML
    public SVGPath lock;
    @FXML
    public Button mybutton;

    /* 当密码与要求相符合，按下按钮后开锁，并跳转到新页面*/
    public void verify_press_button (ActionEvent event) {
        lock.setLayoutX(-615.0);
        lock.setLayoutY(-73.0);
    }
}

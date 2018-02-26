package first_set;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.SVGPath;

public class Controller {
    public Label mylabel;
    public SVGPath lock;
    public Button mybutton;

    public void verify_press_button (ActionEvent event) {
        lock.setLayoutX(-615.0);
        lock.setLayoutY(-73.0);
    }
}

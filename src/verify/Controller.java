package verify;

import com.sun.javafx.robot.impl.FXRobotHelper;
import first_set.Main;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;

import java.io.IOException;


public class Controller {
    @FXML
    public SVGPath lock;
    public Button mybutton;
    public PasswordField password;

    /* 当密码与要求相符合，按下按钮后开锁，并跳转到新页面*/
    public void verify_press_button (ActionEvent event) {
        if (password.getText().equals(Main.user.getMain_password())) {
            lock.setLayoutX(-615.0);
            lock.setLayoutY(-73.0);
            Platform.runLater(() -> {
                try {
                    ObservableList<Stage> stage = FXRobotHelper.getStages();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("../Main_menu/Main_menu.fxml")));
                    stage.get(0).setScene(scene);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            });
        }
    }


}

package first_set;

import com.sun.javafx.robot.impl.FXRobotHelper;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class Controller {
    @FXML
    public PasswordField main_password;
    public Button first_set_btn;

    @FXML
    //初始化
    public void initialize() {
        // 绑定密码框和按钮，当文本框有输入时按钮为可点击
//        BooleanBinding booleanBind = Bindings.createBooleanBinding(()-> 符合要求的非 ,main_password.textProperty());
//        first_set_btn.disableProperty().bind(booleanBind);
    }

    @FXML
    public void press_button (ActionEvent event) throws Exception {
//        ((javafx.scene.Node)event.getSource()).getScene().get;
    }

    public void press(KeyEvent event) {
//        System.out.println(main_password.getText());
//        if (pass) { turn to the other page }
//        else alert
    }

    //当按钮按下时切换界面，原来的界面消失
    public void ButtonPressed(ActionEvent evt) throws Exception {
        Main.user.setMain_password(main_password.getText());
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

//如果空or非空的话就显示or不显示
//        BooleanBinding booleanBind = main_password.textProperty().isEmpty();
//        first_set_btn.disableProperty().bind(booleanBind);
//        first_set_btn.setDisable(true);


// onKeyReleased="#press_button" 用getText来检测文字

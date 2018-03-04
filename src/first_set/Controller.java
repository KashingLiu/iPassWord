package first_set;
//这是进入软件的第一个页面，里面涉及到了用户主密码的设置与检测、跳转到使用界面

import com.nulabinc.zxcvbn.Feedback;
import com.nulabinc.zxcvbn.Strength;
import com.nulabinc.zxcvbn.Zxcvbn;
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
import javafx.scene.control.ProgressBar;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class Controller {
    @FXML
    public PasswordField main_password;     //用户输入的密码框
    public Button first_set_btn;            //确认按钮
    public ProgressBar pb;                  //进度条，用来显示密码强度
    public Text tt1;                        //这几个text用来显示提示信息或者建议信息
    public Text tt2;
    public Text tt3;
    public Text tt4;
    public Text tt5;
    private static int score = 0;           //用户密码的评分
    @FXML
    //初始化
    public void initialize() {
        //把text加到列表里，方便用下标来索引
        ArrayList<Text> texts = new ArrayList<>(5);
        texts.add(tt1);texts.add(tt2);texts.add(tt3);texts.add(tt4);texts.add(tt5);
        //确认的按钮在开始时是不能点击的
        first_set_btn.setDisable(true);
        main_password.setOnKeyReleased((event -> {
            //对于用户的每一次输入，监听输入信息
            //新建一个密码检测类，用来获取评分以及评价
            Zxcvbn zxcvbn = new Zxcvbn();
            Strength measure = zxcvbn.measure(main_password.getText());
            Feedback feedback = measure.getFeedback();
            int i;
            //先将列表中的信息添加给对应的text
            for (i = 0; i< feedback.getSuggestions(Locale.CHINESE).size(); i++) {
                texts.get(i).setText(feedback.getSuggestions(Locale.CHINESE).get(i));
            }
            //然后将文字的提醒添加给text
            if (i<5&&!feedback.getWarning(Locale.CHINESE).isEmpty()) {
                texts.get(i).setText(feedback.getWarning(Locale.CHINESE));
            }
            //评分从0开始，分为0、1、2、3、4五个等级
            if (main_password.getText().isEmpty()) {
                score = -1;
            } else {
                score = measure.getScore();
            }
            pb.setProgress((score+1)/5.0);
            //将分数和按钮相绑定
            BooleanBinding booleanBind = Bindings.createBooleanBinding(()-> measure.getScore()*20 < 80  ,main_password.textProperty());
            first_set_btn.disableProperty().bind(booleanBind);
        }));
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

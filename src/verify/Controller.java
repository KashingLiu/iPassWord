package verify;

import Util.AesCtr;
import Util.Users;
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

import java.io.*;


public class Controller {
    @FXML
    public SVGPath lock;                //那个锁的图片
    public Button mybutton;             //确认按钮
    public PasswordField password;      //密码框

    /* 当密码与要求相符合，按下按钮后开锁，并跳转到新页面*/
    public void verify_press_button (ActionEvent event) {
        //首先新建一个用户的对象
        Users users;
        try
        {
            //从文件中读数据
            FileInputStream fileIn = new FileInputStream("user.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            //初始化读到的数据
            users = (Users) in.readObject();
            Main.user = users;
            in.close();
            fileIn.close();
        }catch(IOException i)
        {
            i.printStackTrace();
            return;
        }catch(ClassNotFoundException c)
        {
            System.out.println("class not found");
            c.printStackTrace();
            return;
        }
        //校验密码，如果输入正确就跳转窗口
        if (AesCtr.encrypt(password.getText()).equals(Main.user.getMain_password())) {
            lock.setLayoutX(-615.0);
            lock.setLayoutY(-73.0);
            Platform.runLater(() -> {
                try {
                    ObservableList<Stage> stage = FXRobotHelper.getStages();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getClassLoader().getResource("Main_menu/Main_menu.fxml")));
                    stage.get(0).setScene(scene);
                    //如果在当前页面关闭的话要保存
                    stage.get(0).setOnCloseRequest((event1 -> {
                        Main.save();
                    }));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            });
        }
    }


}

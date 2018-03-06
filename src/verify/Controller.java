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
    public SVGPath lock;
    public Button mybutton;
    public PasswordField password;

    /* 当密码与要求相符合，按下按钮后开锁，并跳转到新页面*/
    public void verify_press_button (ActionEvent event) {
        Users users = null;
        try
        {
            FileInputStream fileIn = new FileInputStream("user.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
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
        if (AesCtr.encrypt(password.getText()).equals(Main.user.getMain_password())) {
            lock.setLayoutX(-615.0);
            lock.setLayoutY(-73.0);
            Platform.runLater(() -> {
                try {
                    ObservableList<Stage> stage = FXRobotHelper.getStages();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getClassLoader().getResource("Main_menu/Main_menu.fxml")));
                    stage.get(0).setScene(scene);
                    stage.get(0).setOnCloseRequest((event1 -> {
                        try {
                            FileOutputStream fileOut = new FileOutputStream("user.ser");
                            ObjectOutputStream out = new ObjectOutputStream(fileOut);
                            out.writeObject(Main.user);
                            out.close();
                            fileOut.close();
                        } catch (Exception e) {

                        }
                    }));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            });
        }
    }


}

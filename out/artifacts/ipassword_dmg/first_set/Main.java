package first_set;

import Util.Password;
import Util.Users;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.util.Stack;

public class Main extends Application {
    //用户的对象，和用于撤回的密码信息栈
    public static Users user = new Users();
    public static Stack<Password> back_up = new Stack<>();
    @Override
    public void start(Stage primarystage) throws Exception{
        Parent root = new Parent() {};
//        File file = new File("../first_set/first_set.fxml");
//        System.out.println(file.exists());
        try {
            File file = new File("user.ser");
            if (!file.exists()) {
//                System.out.println("no");
                root = FXMLLoader.load(getClass().getClassLoader().getResource("first_set/first_set.fxml"));
                System.out.println(root);
            } else {
                root = FXMLLoader.load(getClass().getClassLoader().getResource("verify/verify.fxml"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        primarystage.setResizable(false);
        primarystage.setTitle("iPassword");
        primarystage.setScene(new Scene(root));
        primarystage.show();
        primarystage.setOnCloseRequest((event -> {
            System.out.println("close0");
        }));


    }

    public static void main(String[] args) {
        launch(args);
    }

}


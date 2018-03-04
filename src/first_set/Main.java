package first_set;

import Util.Password;
import Util.Users;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Stack;

public class Main extends Application {
    //用户的对象，和用于撤回的密码信息栈
    public static Users user = new Users();
    public static Stack<Password> back_up = new Stack<>();
    @Override
    public void start(Stage primarystage) throws Exception{
//        if ( File is exist ) { ../verify/verify.fxml } else { first_set.fxml }
//        如果有了文件，说明用户已经不是第一次使用了，所以直接显示verify那个页面
        Parent root = FXMLLoader.load(getClass().getResource("../first_set/first_set.fxml"));

        primarystage.setResizable(false);
        primarystage.setTitle("iPassword");
        primarystage.setScene(new Scene(root));
        primarystage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}


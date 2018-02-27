package first_set;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primarystage) throws Exception{
//        if ( File is exist ) { ../verify/verify.fxml } else { first_set.fxml }
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


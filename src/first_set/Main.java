package first_set;

import Util.Password;
import Util.Users;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Random;
import java.util.Stack;

public class Main extends Application {
    //用户的对象，和用于撤回的密码信息栈
    public static Users user = new Users();
    public static Stack<Password> back_up = new Stack<>();
    @Override
    public void start(Stage primarystage) {
        Parent root = new Parent() {};
        try {
            File file = new File("user.ser");
            if (!file.exists()) {
                root = FXMLLoader.load(getClass().getClassLoader().getResource("first_set/first_set.fxml"));
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
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void save() {
        try {
            FileOutputStream fileOut = new FileOutputStream("user.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(Main.user);
            out.close();
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String produce() {
        String all_char = "a,b,c,d,e,f,g,h,i,g,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z" +
                ",A,B,C,D,E,F,G,H,I,G,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,~,@,#,$,%,&,*,(,),."+
                ",1,2,3,4,5,6,7,8,9,0";
        String[] all = all_char.split(",");
        Random random = new Random();
        String result = "";
        for (int i = 0; i<18; i++) {
            int j = Math.abs(random.nextInt()%72);
            result = result.concat(String.valueOf(all[j]));
        }
        return result;
    }
}


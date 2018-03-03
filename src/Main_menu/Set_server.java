package Main_menu;

import Util.Password;
import Util.Server;
import first_set.Main;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class Set_server {
    private static TextField name_tf = new TextField();
    private static TextField username_tf = new TextField();
    private static PasswordField password_tf = new PasswordField();
    private static TextField IP_tf = new TextField();
    private static TextField console_username_tf = new TextField();
    private static PasswordField console_password_tf = new PasswordField();

    private static Label name = new Label("全名");
    private static Label username = new Label("用户名");
    private static Label password = new Label("密码");
    private static Label IP = new Label("IP");
    private static Label console_username = new Label("控制台用户名");
    private static Label console_password = new Label("控制台密码");
    private static Label Note = new Label("备注");

    private static Label title = new Label("服务器");
    private static TextArea Note_tf = new TextArea();
    private static Label set_Date_la = new Label("创建日期");
    private static Label set_Date_con = new Label();

    private static void pre_set_Server() {
        name_tf.setEditable(true);
        username_tf.setEditable(true);
        password_tf.setEditable(true);
        IP_tf.setEditable(true);
        console_username_tf.setEditable(true);
        console_password_tf.setEditable(true);
        Note_tf.setEditable(true);

        name_tf.setText("");
        username_tf.setText("");
        password_tf.setText("");
        IP_tf.setText("");
        console_username_tf.setText("");
        console_password_tf.setText("");
        Note_tf.setText("");

        name_tf.setStyle("-fx-background-color: white");
        username_tf.setStyle("-fx-background-color: white");
        password_tf.setStyle("-fx-background-color: white");
        IP_tf.setStyle("-fx-background-color: white");
        console_username_tf.setStyle("-fx-background-color: white");
        console_password_tf.setStyle("-fx-background-color: white");
        Note_tf.setStyle("-fx-background-color: white");

        name.setStyle("-fx-text-fill:#707070");
        username.setStyle("-fx-text-fill:#707070");
        password.setStyle("-fx-text-fill:#707070");
        IP.setStyle("-fx-text-fill:#707070");
        console_username.setStyle("-fx-text-fill:#707070");
        console_password.setStyle("-fx-text-fill:#707070");
        Note.setStyle("-fx-text-fill:#707070");
        set_Date_la.setStyle("-fx-text-fill:#707070");
        set_Date_con.setStyle("-fx-text-fill:#707070");

        name.setFont(new Font(15.0));
        username.setFont(new Font(15.0));
        password.setFont(new Font(15.0));
        IP.setFont(new Font(15.0));
        console_username.setFont(new Font(15.0));
        console_password.setFont(new Font(15.0));
        Note.setFont(new Font(15.0));
        title.setFont(new Font(15.0));
        set_Date_la.setFont(new Font(15.0));
        set_Date_con.setFont(new Font(15.0));

        AnchorPane.setRightAnchor(name,437.0);
        AnchorPane.setRightAnchor(username,437.0);
        AnchorPane.setRightAnchor(password,437.0);
        AnchorPane.setRightAnchor(IP,437.0);
        AnchorPane.setRightAnchor(console_username,437.0);
        AnchorPane.setRightAnchor(console_password,437.0);
        AnchorPane.setRightAnchor(Note,437.0);
        AnchorPane.setRightAnchor(set_Date_la,437.0);

        AnchorPane.setTopAnchor(name,162.0);
        AnchorPane.setTopAnchor(username,190.0);
        AnchorPane.setTopAnchor(password,218.0);
        AnchorPane.setTopAnchor(IP,246.0);
        AnchorPane.setTopAnchor(console_username,273.0);
        AnchorPane.setTopAnchor(console_password,302.0);
        AnchorPane.setTopAnchor(Note,330.0);
        AnchorPane.setTopAnchor(set_Date_la,330.0+166.0);

        AnchorPane.setLeftAnchor(name_tf,250.0);
        AnchorPane.setLeftAnchor(username_tf,250.0);
        AnchorPane.setLeftAnchor(password_tf,250.0);
        AnchorPane.setLeftAnchor(IP_tf,250.0);
        AnchorPane.setLeftAnchor(console_username_tf,250.0);
        AnchorPane.setLeftAnchor(console_password_tf,250.0);
        AnchorPane.setLeftAnchor(Note_tf,250.0);
        AnchorPane.setLeftAnchor(set_Date_con,250.0);

        AnchorPane.setTopAnchor(name_tf,158.0);
        AnchorPane.setTopAnchor(username_tf,186.0);
        AnchorPane.setTopAnchor(password_tf,214.0);
        AnchorPane.setTopAnchor(IP_tf,242.0);
        AnchorPane.setTopAnchor(console_username_tf,269.0);
        AnchorPane.setTopAnchor(console_password_tf,298.0);
        AnchorPane.setTopAnchor(Note_tf,327.0);
        AnchorPane.setTopAnchor(set_Date_con,330.0+166.0);
        Note_tf.setPrefSize(350,138);

        title.fontProperty().setValue(new Font("System",20));
        title.setLayoutX(244.0);
        title.setLayoutY(94.0);
        AnchorPane.setTopAnchor(title,64.0);
        AnchorPane.setLeftAnchor(title,243.0);
        AnchorPane.setRightAnchor(title,255.0);
        AnchorPane.setBottomAnchor(title,575.0);
    }

    public static void set_Server(ListView<Password> choice_list, ObservableList<Password> mid_list_items, Button add_button, AnchorPane main_page, AnchorPane bottom_page) {
        GlobalMenu.ServerMenuItem.setOnAction((ActionEvent event1)->{
            main_page.getChildren().clear();
            main_page.getChildren().removeAll(name_tf,Note_tf,name,username_tf,password_tf,IP_tf,console_username_tf,console_password_tf,username,password,IP,console_username,console_password,Note,title);
            pre_set_Server();
            add_button.setDisable(true);
            choice_list.setDisable(true);
            main_page.getChildren().addAll(name_tf,Note_tf,name,username_tf,password_tf,IP_tf,console_username_tf,console_password_tf,username,password,IP,console_username,console_password,Note,title);

            Button ok = new Button("保存");
            Button cancel = new Button("取消");

            AnchorPane.setBottomAnchor(cancel,5.0);
            AnchorPane.setRightAnchor(cancel,166.0);

            //取消按钮
            cancel.setOnAction((ActionEvent action)->{
                main_page.getChildren().removeAll(name_tf,Note_tf,name,username_tf,password_tf,IP_tf,console_username_tf,console_password_tf,username,password,IP,console_username,console_password,Note,title);
                add_button.setDisable(false);
                choice_list.setDisable(false);
                bottom_page.getChildren().removeAll(cancel,ok);
            });

            //保存按钮
            ok.setOnAction((ActionEvent action2)->{
                //获取输入内容->构造一个对象->将对象添加至password数组->更新列表(add_list)->其他构件消失
                String name_input = name_tf.getText();
                String Note_input = Note_tf.getText();
                if (name_input.equals("")) {
                    name_input = "服务器";
                }
                if (Note_input.equals("")) {
                    Note_input = "";
                }
                Server sv = new Server(name_input, Note_input);
                sv.setUsername(username_tf.getText());
                sv.setPassword(password_tf.getText());
                sv.setIP(IP_tf.getText());
                sv.setConsole_username(console_username_tf.getText());
                sv.setConsole_password(console_password_tf.getText());
                set_Date_con.setText(sv.getSetUpDate());
                Main.user.add_password(sv);
                add_list(choice_list,mid_list_items,sv);
                add_button.setDisable(false);
                choice_list.setDisable(false);
                main_page.getChildren().removeAll(name_tf,Note_tf,name,username_tf,password_tf,IP_tf,console_username_tf,console_password_tf,username,password,IP,console_username,console_password,Note,title);
                bottom_page.getChildren().removeAll(ok,cancel);
            });
            bottom_page.getChildren().addAll(cancel,ok);
            AnchorPane.setBottomAnchor(ok,5.0);
            AnchorPane.setRightAnchor(ok,100.0);
        });
    }
    private static void add_list(ListView<Password> choice_list, ObservableList<Password> mid_list_items, Password password) {
        mid_list_items.add(password);
        choice_list.setItems(mid_list_items);
    }
    public static void display_Server(ListView<Password> choice_list, ObservableList<Password> mid_list_items,Button add_button,AnchorPane main_page,AnchorPane bottom_page, Server server) {
        pre_set_Server();
        main_page.getChildren().clear();
        main_page.getChildren().addAll(set_Date_con,set_Date_la,name_tf,Note_tf,name,username_tf,password_tf,IP_tf,
                console_username_tf,console_password_tf,username,password,IP,console_username,
                console_password,Note,title);
        name_tf.setEditable(false);
        username_tf.setEditable(false);
        password_tf.setEditable(false);
        IP_tf.setEditable(false);
        console_username_tf.setEditable(false);
        console_password_tf.setEditable(false);
        Note_tf.setEditable(false);

        //这里的细节很重要！
        name_tf.setText(server.getname());
        username_tf.setText(server.getUsername());
        password_tf.setText("********");
        IP_tf.setText(server.getIP());
        console_username_tf.setText(server.getConsole_username());
        console_password_tf.setText("********");
        Note_tf.setText(server.getNote());

        Button change = new Button("编辑");
        Button delete = new Button("删除");

        change.setOnAction((ActionEvent ae) -> {
            bottom_page.getChildren().removeAll(change, delete);
            main_page.getChildren().clear();
            pre_set_Server();
            add_button.setDisable(true);
            choice_list.setDisable(true);
            main_page.getChildren().addAll(set_Date_con,set_Date_la,name_tf,Note_tf,name,username_tf,
                    password_tf,IP_tf, console_username_tf,console_password_tf,username,password,IP,
                    console_username,console_password,Note,title);

            Button ok = new Button("保存");
            Button cancel = new Button("取消");

            AnchorPane.setBottomAnchor(cancel,5.0);
            AnchorPane.setRightAnchor(cancel,166.0);

            //取消按钮
            cancel.setOnAction((ActionEvent action)->{
                main_page.getChildren().clear();
                add_button.setDisable(false);
                bottom_page.getChildren().removeAll(cancel,ok);
                choice_list.setDisable(false);
            });

            //保存按钮
            ok.setOnAction((ActionEvent action2)->{
                //获取输入内容->构造一个对象->将对象添加至password数组->更新列表(add_list)->其他构件消失
                server.setName(name_tf.getText());
                server.setUsername(username_tf.getText());
                server.setPassword(password_tf.getText());
                server.setIP(IP_tf.getText());
                server.setConsole_username(console_username_tf.getText());
                server.setConsole_password(console_password_tf.getText());
                server.setNote(Note_tf.getText());
                add_button.setDisable(false);
                choice_list.setDisable(false);
                main_page.getChildren().clear();
                bottom_page.getChildren().removeAll(ok,cancel);
                mid_list_items.addAll(Main.user.all_passwords);
                choice_list.setItems(mid_list_items);
            });
            bottom_page.getChildren().addAll(cancel,ok);
            AnchorPane.setBottomAnchor(ok,5.0);
            AnchorPane.setRightAnchor(ok,100.0);

            name_tf.setText(server.getname());
            username_tf.setText(server.getUsername());
            password_tf.setText(server.getPassword());
            IP_tf.setText(server.getIP());
            console_username_tf.setText(server.getConsole_username());
            console_password_tf.setText(server.getConsole_password());
            Note_tf.setText(server.getNote());
            choice_list.setItems(mid_list_items);
        });

        delete.setOnAction((ActionEvent ae1)->{
            bottom_page.getChildren().removeAll(change, delete);
            Main.user.all_passwords.remove(server);
            mid_list_items.remove(server);
            choice_list.setItems(mid_list_items);
        });

        AnchorPane.setBottomAnchor(delete,5.0);
        AnchorPane.setRightAnchor(delete,166.0);
        bottom_page.getChildren().addAll(delete,change);
        AnchorPane.setBottomAnchor(change,5.0);
        AnchorPane.setRightAnchor(change,100.0);
    }

}

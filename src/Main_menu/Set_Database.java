package Main_menu;

import Util.Database;
import Util.Password;
import first_set.Main;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class Set_Database {
    private static TextField name_tf = new TextField();
    private static MenuButton type_mb = new MenuButton();
    private static TextField server_tf = new TextField();
    private static TextField port_tf = new TextField();
    private static TextField username_tf = new TextField();
    private static TextField password_tf = new TextField();
    private static TextField connection_options_tf = new TextField();
    private static TextField type_tf = new TextField();

    private static Label name = new Label("全名");
    private static Label type = new Label("数据库类型");
    private static Label server = new Label("服务器");
    private static Label port = new Label("端口");
    private static Label username = new Label("用户名");
    private static Label password = new Label("密码");
    private static Label connection_options = new Label("连接选项");
    private static Label Note = new Label("备注");
    private static Label title = new Label("数据库");

    private static TextArea Note_tf = new TextArea();

    private static void pre_set_Database() {
        name_tf.setEditable(true);
        server_tf.setEditable(true);
        port_tf.setEditable(true);
        username_tf.setEditable(true);
        password_tf.setEditable(true);
        connection_options_tf.setEditable(true);
        Note_tf.setEditable(true);

        name_tf.setText("");
        server_tf.setText("");
        port_tf.setText("");
        username_tf.setText("");
        password_tf.setText("");
        connection_options_tf.setText("");
        Note_tf.setText("");

        type_mb.setStyle("-fx-background-color: white");
        name_tf.setStyle("-fx-background-color: white");
        server_tf.setStyle("-fx-background-color: white");
        port_tf.setStyle("-fx-background-color: white");
        username_tf.setStyle("-fx-background-color: white");
        password_tf.setStyle("-fx-background-color: white");
        connection_options_tf.setStyle("-fx-background-color: white");
        Note_tf.setStyle("-fx-background-color: white");

        name.setStyle("-fx-text-fill:#707070");
        type.setStyle("-fx-text-fill:#707070");
        server.setStyle("-fx-text-fill:#707070");
        port.setStyle("-fx-text-fill:#707070");
        username.setStyle("-fx-text-fill:#707070");
        password.setStyle("-fx-text-fill:#707070");
        connection_options.setStyle("-fx-text-fill:#707070");
        Note.setStyle("-fx-text-fill:#707070");


        name.setFont(new Font(15.0));
        type.setFont(new Font(15.0));
        server.setFont(new Font(15.0));
        port.setFont(new Font(15.0));
        username.setFont(new Font(15.0));
        password.setFont(new Font(15.0));
        connection_options.setFont(new Font(15.0));
        Note.setFont(new Font(15.0));

        //nametf-type-server-port-username-password-option-note

        AnchorPane.setRightAnchor(name,437.0);
        AnchorPane.setRightAnchor(type,437.0);
        AnchorPane.setRightAnchor(server,437.0);
        AnchorPane.setRightAnchor(port,437.0);
        AnchorPane.setRightAnchor(username,437.0);
        AnchorPane.setRightAnchor(password,437.0);
        AnchorPane.setRightAnchor(connection_options,437.0);
        AnchorPane.setRightAnchor(Note,437.0);

        AnchorPane.setTopAnchor(name,162.0);
        AnchorPane.setTopAnchor(type,190.0);
        AnchorPane.setTopAnchor(server,218.0);
        AnchorPane.setTopAnchor(port,246.0);
        AnchorPane.setTopAnchor(username,273.0);
        AnchorPane.setTopAnchor(password,302.0);
        AnchorPane.setTopAnchor(connection_options,330.0);
        AnchorPane.setTopAnchor(Note,358.0);

        AnchorPane.setLeftAnchor(name_tf,250.0);
        AnchorPane.setLeftAnchor(type_mb,250.0);
        AnchorPane.setLeftAnchor(server_tf,250.0);
        AnchorPane.setLeftAnchor(port_tf,250.0);
        AnchorPane.setLeftAnchor(username_tf,250.0);
        AnchorPane.setLeftAnchor(password_tf,250.0);
        AnchorPane.setLeftAnchor(connection_options_tf,250.0);
        AnchorPane.setLeftAnchor(Note_tf,250.0);

        AnchorPane.setTopAnchor(name_tf,158.0);
        AnchorPane.setTopAnchor(type_mb,186.0);
        AnchorPane.setTopAnchor(server_tf,214.0);
        AnchorPane.setTopAnchor(port_tf,242.0);
        AnchorPane.setTopAnchor(username_tf,271.0);
        AnchorPane.setTopAnchor(password_tf,298.0);
        AnchorPane.setTopAnchor(connection_options_tf,327.0);
        AnchorPane.setTopAnchor(Note_tf,360.0);
        Note_tf.setPrefSize(350,138);

        title.fontProperty().setValue(new Font("System",20));
        title.setLayoutX(244.0);
        title.setLayoutY(94.0);
        AnchorPane.setTopAnchor(title,64.0);
        AnchorPane.setLeftAnchor(title,243.0);
        AnchorPane.setRightAnchor(title,255.0);
        AnchorPane.setBottomAnchor(title,575.0);
    }

    public static void set_Database(ListView<Password> choice_list, ObservableList<Password> mid_list_items, Button add_button, AnchorPane main_page, AnchorPane bottom_page) {
        GlobalMenu.DBMenuItem.setOnAction((ActionEvent event1)->{
            main_page.getChildren().clear();
            pre_set_Database();
            add_button.setDisable(true);
            choice_list.setDisable(true);
            main_page.getChildren().addAll(type_mb,name_tf,server_tf,port_tf,username_tf,password_tf,connection_options_tf,name,type,server,port,username,password,connection_options,Note,title,Note_tf);

            Button ok = new Button("保存");
            Button cancel = new Button("取消");

            AnchorPane.setBottomAnchor(cancel,5.0);
            AnchorPane.setRightAnchor(cancel,166.0);

            //取消按钮
            cancel.setOnAction((ActionEvent action)->{
                main_page.getChildren().clear();
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
                    name_input = "数据库";
                }
                if (Note_input.equals("")) {
                    Note_input = "";
                }
                Util.Database db = new Util.Database(name_input, Note_input);
                db.setConnection_options(connection_options_tf.getText());
                db.setPassword(password_tf.getText());
                db.setPort(port_tf.getText());
                db.setServer(server_tf.getText());
                db.setType(type_mb.getText());
                db.setUsername(username_tf.getText());
                Main.user.add_password(db);
                add_list(choice_list,mid_list_items,db);
                add_button.setDisable(false);
                choice_list.setDisable(false);
                main_page.getChildren().clear();
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

    public static void display_Database(ListView<Password> choice_list, ObservableList<Password> mid_list_items,Button add_button,AnchorPane main_page,AnchorPane bottom_page, Database database) {
        pre_set_Database();
        main_page.getChildren().clear();
        main_page.getChildren().addAll(type_tf,name_tf,server_tf,port_tf,username_tf,password_tf,connection_options_tf,name,type,server,port,username,password,connection_options,Note,title,Note_tf);
        name_tf.setEditable(false);
        server_tf.setEditable(false);
        port_tf.setEditable(false);
        username_tf.setEditable(false);
        password_tf.setEditable(false);
        connection_options_tf.setEditable(false);
        Note_tf.setEditable(false);

        //这里的细节很重要！
        name_tf.setText(database.getname());
        server_tf.setText(database.getServer());
        port_tf.setText(database.getPort());
        username_tf.setText(database.getUsername());
        password_tf.setText("********");
        connection_options_tf.setText(database.getConnection_options());
        Note_tf.setText(database.getNote());
        type_tf.setText(database.getType());

        AnchorPane.setLeftAnchor(type_tf,250.0);
        AnchorPane.setTopAnchor(type_tf,242.0);

        Button change = new Button("编辑");
        Button delete = new Button("删除");

        change.setOnAction((ActionEvent ae) -> {
            bottom_page.getChildren().removeAll(change, delete);
            main_page.getChildren().clear();
            pre_set_Database();
            add_button.setDisable(true);
            choice_list.setDisable(true);
            main_page.getChildren().addAll(type_tf,name_tf,server_tf,port_tf,username_tf,password_tf,connection_options_tf,name,type,server,port,username,password,connection_options,Note,title,Note_tf);

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
                String name_input = name_tf.getText();
                String Note_input = Note_tf.getText();
                if (name_input.equals("")) {
                    name_input = "数据库";
                }
                if (Note_input.equals("")) {
                    Note_input = "";
                }
                Util.Database db = new Util.Database(name_input, Note_input);
                db.setConnection_options(connection_options_tf.getText());
                db.setPassword(password_tf.getText());
                db.setPort(port_tf.getText());
                db.setServer(server_tf.getText());
                db.setType(type_mb.getText());
                db.setUsername(username_tf.getText());
                add_button.setDisable(false);
                choice_list.setDisable(false);
                main_page.getChildren().clear();
                bottom_page.getChildren().removeAll(ok,cancel);
                mid_list_items.clear();
                mid_list_items.addAll(Main.user.all_passwords);
                choice_list.setItems(mid_list_items);
            });
            bottom_page.getChildren().addAll(cancel,ok);
            AnchorPane.setBottomAnchor(ok,5.0);
            AnchorPane.setRightAnchor(ok,100.0);

            name_tf.setText(database.getname());
            server_tf.setText(database.getServer());
            port_tf.setText(database.getPort());
            username_tf.setText(database.getUsername());
            password_tf.setText(database.getPassword());
            connection_options_tf.setText(database.getConnection_options());
            Note_tf.setText(database.getNote());
            type_tf.setText(database.getType());

            AnchorPane.setLeftAnchor(type_tf,250.0);
            AnchorPane.setTopAnchor(type_tf,242.0);

            choice_list.setItems(mid_list_items);
        });

        delete.setOnAction((ActionEvent ae1)->{
            bottom_page.getChildren().removeAll(change, delete);
            Main.user.all_passwords.remove(password);
            mid_list_items.remove(password);
            choice_list.setItems(mid_list_items);
        });

        AnchorPane.setBottomAnchor(delete,5.0);
        AnchorPane.setRightAnchor(delete,166.0);
        bottom_page.getChildren().addAll(delete,change);
        AnchorPane.setBottomAnchor(change,5.0);
        AnchorPane.setRightAnchor(change,100.0);
    }


}

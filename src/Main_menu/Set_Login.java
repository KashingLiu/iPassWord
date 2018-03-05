package Main_menu;

import Util.Login;
import Util.Password;
import first_set.Main;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class Set_Login {
    private static TextField username_tf = new TextField();
    private static TextField password_tf = new TextField();
    private static TextField site_tf = new TextField();
    private static Label name = new Label("站点名称");
    private static Label username = new Label("用户名");
    private static Label password = new Label("密码");
    private static Label site = new Label("网址");
    private static Label Note = new Label("备注");
    private static Label title = new Label("登录信息");

    private static TextArea Note_tf = new TextArea();
    private static TextField name_tf = new TextField();
    private static Label set_Date_la = new Label("创建日期");
    private static Label set_Date_con = new Label();


    private static void pre_set_login() {
        name_tf.setEditable(true);
        username_tf.setEditable(true);
        password_tf.setEditable(true);
        site_tf.setEditable(true);
        Note_tf.setEditable(true);

        name_tf.setText("");
        username_tf.setText("");
        password_tf.setText("");
        site_tf.setText("");
        Note_tf.setText("");

        name_tf.setStyle("-fx-background-color: white");
        username_tf.setStyle("-fx-background-color: white");
        password_tf.setStyle("-fx-background-color: white");
        site_tf.setStyle("-fx-background-color: white");
        Note_tf.setStyle("-fx-background-color: white");

        name.setStyle("-fx-text-fill:#707070");
        username.setStyle("-fx-text-fill:#707070");
        password.setStyle("-fx-text-fill:#707070");
        site.setStyle("-fx-text-fill:#707070");
        Note.setStyle("-fx-text-fill:#707070");
        set_Date_la.setStyle("-fx-text-fill:#707070");
        set_Date_con.setStyle("-fx-text-fill:#707070");


        name.setFont(new Font(15.0));
        username.setFont(new Font(15.0));
        password.setFont(new Font(15.0));
        site.setFont(new Font(15.0));
        Note.setFont(new Font(15.0));
        title.setFont(new Font(15.0));
        set_Date_la.setFont(new Font(15.0));
        set_Date_con.setFont(new Font(15.0));

        AnchorPane.setRightAnchor(name,437.0);
        AnchorPane.setRightAnchor(username,437.0);
        AnchorPane.setRightAnchor(password,437.0);
        AnchorPane.setRightAnchor(site,437.0);
        AnchorPane.setRightAnchor(Note,437.0);
        AnchorPane.setRightAnchor(set_Date_la,437.0);

        AnchorPane.setTopAnchor(name,162.0);
        AnchorPane.setTopAnchor(username,190.0);
        AnchorPane.setTopAnchor(password,218.0);
        AnchorPane.setTopAnchor(site,246.0);
        AnchorPane.setTopAnchor(Note,273.0);
        AnchorPane.setTopAnchor(set_Date_la,273.0+166.0);

        AnchorPane.setLeftAnchor(name_tf,250.0);
        AnchorPane.setLeftAnchor(username_tf,250.0);
        AnchorPane.setLeftAnchor(password_tf,250.0);
        AnchorPane.setLeftAnchor(site_tf,250.0);
        AnchorPane.setLeftAnchor(Note_tf,250.0);
        AnchorPane.setLeftAnchor(set_Date_con,250.0);

        AnchorPane.setTopAnchor(name_tf,158.0);
        AnchorPane.setTopAnchor(username_tf,186.0);
        AnchorPane.setTopAnchor(password_tf,214.0);
        AnchorPane.setTopAnchor(site_tf,242.0);
        AnchorPane.setTopAnchor(Note_tf,269.0);
        AnchorPane.setTopAnchor(set_Date_con,273.0+166.0);
        Note_tf.setPrefSize(350,138);

        title.fontProperty().setValue(new Font("System",20));
        title.setLayoutX(244.0);
        title.setLayoutY(94.0);
        AnchorPane.setTopAnchor(title,64.0);
        AnchorPane.setLeftAnchor(title,243.0);
        AnchorPane.setRightAnchor(title,255.0);
        AnchorPane.setBottomAnchor(title,575.0);
    }
    public static void set_login(ListView<Password> choice_list, ObservableList<Password> mid_list_items, Button add_button, AnchorPane main_page, AnchorPane bottom_page) {
        GlobalMenu.LoginMenuItem.setOnAction((ActionEvent event1)->{
            main_page.getChildren().clear();
            pre_set_login();
            add_button.setDisable(true);
            choice_list.setDisable(true);
            main_page.getChildren().addAll(username_tf,password_tf,site_tf,name,username,password,site,Note,title,Note_tf,name_tf);

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
                    name_input = "登录信息";
                }
                if (Note_input.equals("")) {
                    Note_input = "";
                }
                Login lg = new Login(name_input, Note_input);
                lg.setUsername(username_tf.getText());
                lg.setPassword(password_tf.getText());
                lg.setSite(site_tf.getText());
                set_Date_con.setText(lg.getSetUpDate());
                Main.user.add_password(lg);
                add_list(choice_list,mid_list_items,lg);
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
    public static void display_login(ListView<Password> choice_list, ObservableList<Password> mid_list_items,Button add_button,AnchorPane main_page,AnchorPane bottom_page, Login login) {
        pre_set_login();
        main_page.getChildren().clear();
        main_page.getChildren().addAll(set_Date_con,set_Date_la,username_tf,password_tf,site_tf,name,username,password,site,Note,title,Note_tf,name_tf);
        name_tf.setEditable(false);
        username_tf.setEditable(false);
        password_tf.setEditable(false);
        site_tf.setEditable(false);
        Note_tf.setEditable(false);

        //这里的细节很重要！
        name_tf.setText(login.getname());
        username_tf.setText(login.getUsername());
        password_tf.setText("********");
        site_tf.setText(login.getSite());
        Note_tf.setText(login.getNote());


        Button change = new Button("编辑");
        Button delete = new Button("删除");

        change.setOnAction((ActionEvent ae) -> {
            bottom_page.getChildren().removeAll(change, delete);
            main_page.getChildren().clear();
            pre_set_login();
            add_button.setDisable(true);
            choice_list.setDisable(true);
            main_page.getChildren().addAll(set_Date_con,set_Date_la,username_tf,password_tf,site_tf,name,username,password,site,Note,title,Note_tf,name_tf);

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
                login.setName(name_tf.getText());
                login.setUsername(username_tf.getText());
                login.setPassword(password_tf.getText());
                login.setSite(site_tf.getText());
                login.setNote(Note_tf.getText());
                add_button.setDisable(false);
                choice_list.setDisable(false);
                main_page.getChildren().clear();
                bottom_page.getChildren().removeAll(ok,cancel);
                mid_list_items.removeAll(Main.user.all_passwords);
                mid_list_items.addAll(Main.user.all_passwords);
                choice_list.setItems(mid_list_items);
            });
            bottom_page.getChildren().addAll(cancel,ok);
            AnchorPane.setBottomAnchor(ok,5.0);
            AnchorPane.setRightAnchor(ok,100.0);

            name_tf.setText(login.getname());
            username_tf.setText(login.getUsername());
            password_tf.setText(login.getPassword());
            site_tf.setText(login.getSite());
            Note_tf.setText(login.getNote());
            choice_list.setItems(mid_list_items);
        });

        delete.setOnAction((ActionEvent ae1)->{
            bottom_page.getChildren().removeAll(change, delete);
            Main.user.all_passwords.remove(login);
            mid_list_items.remove(login);
            choice_list.setItems(mid_list_items);
            Main.back_up.push(login);
        });

        AnchorPane.setBottomAnchor(delete,5.0);
        AnchorPane.setRightAnchor(delete,166.0);
        bottom_page.getChildren().addAll(delete,change);
        AnchorPane.setBottomAnchor(change,5.0);
        AnchorPane.setRightAnchor(change,100.0);
    }
}

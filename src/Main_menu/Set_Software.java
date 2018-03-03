package Main_menu;

import Util.Password;
import Util.Software;
import first_set.Main;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class Set_Software {
    private static TextField name_tf = new TextField();
    private static TextField version_tf = new TextField();
    private static TextField key_tf = new TextField();
    private static TextField email_tf = new TextField();
    private static TextField buy_date_tf = new TextField();
    private static TextField expiry_date_tf = new TextField();

    private static Label name = new Label("软件名称");
    private static Label version = new Label("软件版本");
    private static Label key = new Label("软件序列号");
    private static Label email = new Label("注册邮箱");
    private static Label buy_date = new Label("购买日期");
    private static Label expiry_date = new Label("有效期");

    private static Label Note = new Label("备注");
    private static Label title = new Label("软件许可证");
    private static TextArea Note_tf = new TextArea();

    private static void pre_set_software() {
        name_tf.setEditable(true);
        version_tf.setEditable(true);
        key_tf.setEditable(true);
        email_tf.setEditable(true);
        buy_date_tf.setEditable(true);
        expiry_date_tf.setEditable(true);
        Note_tf.setEditable(true);

        name_tf.setText("");
        version_tf.setText("");
        key_tf.setText("");
        email_tf.setText("");
        buy_date_tf.setText("");
        expiry_date_tf.setText("");
        Note_tf.setText("");

        name_tf.setStyle("-fx-background-color: white");
        version_tf.setStyle("-fx-background-color: white");
        key_tf.setStyle("-fx-background-color: white");
        email_tf.setStyle("-fx-background-color: white");
        buy_date_tf.setStyle("-fx-background-color: white");
        expiry_date_tf.setStyle("-fx-background-color: white");
        Note_tf.setStyle("-fx-background-color: white");

        name.setStyle("-fx-text-fill:#707070");
        version.setStyle("-fx-text-fill:#707070");
        key.setStyle("-fx-text-fill:#707070");
        email.setStyle("-fx-text-fill:#707070");
        buy_date.setStyle("-fx-text-fill:#707070");
        expiry_date.setStyle("-fx-text-fill:#707070");
        Note.setStyle("-fx-text-fill:#707070");

        name.setFont(new Font(15.0));
        version.setFont(new Font(15.0));
        key.setFont(new Font(15.0));
        email.setFont(new Font(15.0));
        buy_date.setFont(new Font(15.0));
        expiry_date.setFont(new Font(15.0));
        Note.setFont(new Font(15.0));
        title.setFont(new Font(15.0));

        AnchorPane.setRightAnchor(name,437.0);
        AnchorPane.setRightAnchor(version,437.0);
        AnchorPane.setRightAnchor(key,437.0);
        AnchorPane.setRightAnchor(email,437.0);
        AnchorPane.setRightAnchor(buy_date,437.0);
        AnchorPane.setRightAnchor(expiry_date,437.0);
        AnchorPane.setRightAnchor(Note,437.0);

        AnchorPane.setTopAnchor(name,162.0);
        AnchorPane.setTopAnchor(version,190.0);
        AnchorPane.setTopAnchor(key,218.0);
        AnchorPane.setTopAnchor(email,246.0);
        AnchorPane.setTopAnchor(buy_date,273.0);
        AnchorPane.setTopAnchor(expiry_date,302.0);
        AnchorPane.setTopAnchor(Note,330.0);

        AnchorPane.setLeftAnchor(name_tf,250.0);
        AnchorPane.setLeftAnchor(version_tf,250.0);
        AnchorPane.setLeftAnchor(key_tf,250.0);
        AnchorPane.setLeftAnchor(email_tf,250.0);
        AnchorPane.setLeftAnchor(buy_date_tf,250.0);
        AnchorPane.setLeftAnchor(expiry_date_tf,250.0);
        AnchorPane.setLeftAnchor(Note_tf,250.0);


        AnchorPane.setTopAnchor(name_tf,158.0);
        AnchorPane.setTopAnchor(version_tf,186.0);
        AnchorPane.setTopAnchor(key_tf,214.0);
        AnchorPane.setTopAnchor(email_tf,242.0);
        AnchorPane.setTopAnchor(buy_date_tf,269.0);
        AnchorPane.setTopAnchor(expiry_date_tf,298.0);
        AnchorPane.setTopAnchor(Note_tf,327.0);
        Note_tf.setPrefSize(350,138);

        title.fontProperty().setValue(new Font("System",20));
        title.setLayoutX(244.0);
        title.setLayoutY(94.0);
        AnchorPane.setTopAnchor(title,64.0);
        AnchorPane.setLeftAnchor(title,243.0);
        AnchorPane.setRightAnchor(title,255.0);
        AnchorPane.setBottomAnchor(title,575.0);
    }
    public static void set_software(ListView<Password> choice_list, ObservableList<Password> mid_list_items, Button add_button, AnchorPane main_page, AnchorPane bottom_page) {
        GlobalMenu.AppMenuItem.setOnAction((ActionEvent event1)->{
            main_page.getChildren().clear();
            pre_set_software();
            add_button.setDisable(true);
            choice_list.setDisable(true);
            main_page.getChildren().addAll(name_tf,version_tf,key_tf,email_tf,buy_date_tf,expiry_date_tf,Note_tf,name,version,key,email,buy_date,expiry_date,Note,title);

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
                    name_input = "软件许可证";
                }
                if (Note_input.equals("")) {
                    Note_input = "";
                }
                Software sw = new Software(name_input, Note_input);
                sw.setBuy_date(buy_date_tf.getText());
                sw.setEmail(email_tf.getText());
                sw.setExpiry_date(expiry_date_tf.getText());
                sw.setKey(key_tf.getText());
                sw.setVersion(version_tf.getText());
                Main.user.add_password(sw);
                add_list(choice_list,mid_list_items,sw);
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
    public static void display_software(ListView<Password> choice_list, ObservableList<Password> mid_list_items,Button add_button,AnchorPane main_page,AnchorPane bottom_page, Software software) {
        pre_set_software();
        main_page.getChildren().clear();
        main_page.getChildren().addAll(name_tf,version_tf,key_tf,email_tf,buy_date_tf,expiry_date_tf,Note_tf,name,version,key,email,buy_date,expiry_date,Note,title);
        name_tf.setEditable(false);
        version_tf.setEditable(false);
        key_tf.setEditable(false);
        email_tf.setEditable(false);
        buy_date_tf.setEditable(false);
        expiry_date_tf.setEditable(false);
        Note_tf.setEditable(false);

        //这里的细节很重要！
        name_tf.setText(software.getname());
        version_tf.setText(software.getVersion());
        key_tf.setText(software.getKey());
        email_tf.setText(software.getEmail());
        buy_date_tf.setText(software.getBuy_date());
        expiry_date_tf.setText(software.getExpiry_date());
        Note_tf.setText(software.getNote());


        Button change = new Button("编辑");
        Button delete = new Button("删除");

        change.setOnAction((ActionEvent ae) -> {
            bottom_page.getChildren().removeAll(change, delete);
            main_page.getChildren().clear();
            pre_set_software();
            add_button.setDisable(true);
            choice_list.setDisable(true);
            main_page.getChildren().addAll(name_tf,version_tf,key_tf,email_tf,buy_date_tf,expiry_date_tf,Note_tf,name,version,key,email,buy_date,expiry_date,Note,title);

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
                software.setName(name_tf.getText());
                software.setNote(Note_tf.getText());
                software.setBuy_date(buy_date_tf.getText());
                software.setEmail(email_tf.getText());
                software.setExpiry_date(expiry_date_tf.getText());
                software.setKey(key_tf.getText());
                software.setVersion(version_tf.getText());
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

            name_tf.setText(software.getname());
            version_tf.setText(software.getVersion());
            key_tf.setText(software.getKey());
            email_tf.setText(software.getEmail());
            buy_date_tf.setText(software.getBuy_date());
            expiry_date_tf.setText(software.getExpiry_date());
            Note_tf.setText(software.getNote());
            choice_list.setItems(mid_list_items);
        });

        delete.setOnAction((ActionEvent ae1)->{
            bottom_page.getChildren().removeAll(change, delete);
            Main.user.all_passwords.remove(software);
            mid_list_items.remove(software);
            choice_list.setItems(mid_list_items);
        });

        AnchorPane.setBottomAnchor(delete,5.0);
        AnchorPane.setRightAnchor(delete,166.0);
        bottom_page.getChildren().addAll(delete,change);
        AnchorPane.setBottomAnchor(change,5.0);
        AnchorPane.setRightAnchor(change,100.0);
    }
}

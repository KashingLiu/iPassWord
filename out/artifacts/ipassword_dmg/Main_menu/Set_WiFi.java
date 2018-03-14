package Main_menu;

import Util.AesCtr;
import Util.Password;
import Util.WirelessRouter;
import first_set.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class Set_WiFi {
    private static Label WiFi_title = new Label("无线路由器");
    private static Label WiFi_name = new Label("全名");               //全名
    private static Label WiFi_Password = new Label("无线网络密码");    //无线网络密码
    private static Label WiFi_ServerIP = new Label("服务器/IP地址");   //服务器/IP地址
    private static Label WiFi_SSID = new Label("网络名称");            //网络名称
    private static Label WiFi_security = new Label("安全性");         //安全性
    private static Label WiFi_Password_add = new Label("附加密码");    //附加密码
    private static Label WiFi_Note = new Label("备注");
    private static TextField WiFi_name_tf = new TextField();
    private static TextField WiFi_Password_tf = new TextField();
    private static TextField WiFi_ServerIP_tf = new TextField();
    private static TextField WiFi_SSID_tf = new TextField();
    private static TextField WiFi_security_tf = new TextField();
    private static TextField WiFi_Password_add_tf = new TextField();
    private static TextArea WiFi_Note_tf = new TextArea();
    private static MenuItem mi1 = new MenuItem("无");
    private static MenuItem mi2 = new MenuItem("WPA2 个人");
    private static MenuItem mi3 = new MenuItem("WPA2 企业");
    private static MenuItem mi4 = new MenuItem("WPA");
    private static MenuItem mi5 = new MenuItem("WEP");
    private static MenuButton WiFi_security_mb = new MenuButton("加密方式",null,mi1,mi2,mi3,mi4,mi5);
    private static Label set_Date_la = new Label("创建日期");
    private static Label set_Date_con = new Label();

    private static Image see_1 = new Image("Util/icon/see_before.png");
    private static Image see_2 = new Image("Util/icon/see_after.png");
    private static Image clip = new Image("Util/icon/clip.png");


    private static void pre_set_WiFi() {

        mi1.setOnAction((ace)->{
            WiFi_security_mb.setText(mi1.getText());
        });
        mi2.setOnAction((ace1)->{
            WiFi_security_mb.setText(mi2.getText());
        });
        mi3.setOnAction((ace2)->{
            WiFi_security_mb.setText(mi3.getText());
        });
        mi4.setOnAction((ace3)->{
            WiFi_security_mb.setText(mi4.getText());
        });
        mi5.setOnAction((ace4)->{
            WiFi_security_mb.setText(mi5.getText());
        });

        //预先把这些tf设置成可编辑，内容为空
        WiFi_name_tf.setEditable(true);
        WiFi_SSID_tf.setEditable(true);
        WiFi_Password_tf.setEditable(true);
        WiFi_security_tf.setEditable(true);
        WiFi_ServerIP_tf.setEditable(true);
        WiFi_Password_add_tf.setEditable(true);
        WiFi_Note_tf.setEditable(true);

        WiFi_name_tf.setText("");
        WiFi_SSID_tf.setText("");
        WiFi_Password_tf.setText("");
        WiFi_security_tf.setText("");
        WiFi_ServerIP_tf.setText("");
        WiFi_Password_add_tf.setText("");
        WiFi_Note_tf.setText("");

        //设置背景为白色
        WiFi_name_tf.setStyle("-fx-background-color: white");
        WiFi_Password_tf.setStyle("-fx-background-color: white");
        WiFi_ServerIP_tf.setStyle("-fx-background-color: white");
        WiFi_SSID_tf.setStyle("-fx-background-color: white");
        WiFi_security_mb.setStyle("-fx-background-color: white");
        WiFi_Password_add_tf.setStyle("-fx-background-color: white");
        WiFi_Note_tf.setStyle("-fx-background-color: white");
        WiFi_security_tf.setStyle("-fx-background-color: white");

        //label的颜色是灰的
        WiFi_name.setStyle("-fx-text-fill:#707070");
        WiFi_Password.setStyle("-fx-text-fill:#707070");
        WiFi_ServerIP.setStyle("-fx-text-fill:#707070");
        WiFi_SSID.setStyle("-fx-text-fill:#707070");
        WiFi_security.setStyle("-fx-text-fill:#707070");
        WiFi_Password_add.setStyle("-fx-text-fill:#707070");
        WiFi_Note.setStyle("-fx-text-fill:#707070");
        set_Date_la.setStyle("-fx-text-fill:#707070");
        set_Date_con.setStyle("-fx-text-fill:#707070");

        //字体大小
        WiFi_name.setFont(new Font(15.0));
        WiFi_Password.setFont(new Font(15.0));
        WiFi_ServerIP.setFont(new Font(15.0));
        WiFi_SSID.setFont(new Font(15.0));
        WiFi_security.setFont(new Font(15.0));
        WiFi_Password_add.setFont(new Font(15.0));
        WiFi_Note.setFont(new Font(15.0));
        set_Date_la.setFont(new Font(15.0));
        set_Date_con.setFont(new Font(15.0));

        //设置标题和文本框位置
        AnchorPane.setRightAnchor(WiFi_name,437.0);
        AnchorPane.setRightAnchor(WiFi_Password,437.0);
        AnchorPane.setRightAnchor(WiFi_ServerIP,437.0);
        AnchorPane.setRightAnchor(WiFi_SSID,437.0);
        AnchorPane.setRightAnchor(WiFi_security,437.0);
        AnchorPane.setRightAnchor(WiFi_Password_add,437.0);
        AnchorPane.setRightAnchor(WiFi_Note,437.0);
        AnchorPane.setRightAnchor(set_Date_la,437.0);

        AnchorPane.setTopAnchor(WiFi_name,162.0);
        AnchorPane.setTopAnchor(WiFi_SSID,190.0);
        AnchorPane.setTopAnchor(WiFi_Password,218.0);
        AnchorPane.setTopAnchor(WiFi_security,246.0);
        AnchorPane.setTopAnchor(WiFi_ServerIP,274.0);
        AnchorPane.setTopAnchor(WiFi_Password_add,302.0);
        AnchorPane.setTopAnchor(WiFi_Note,330.0);
        AnchorPane.setTopAnchor(set_Date_la,330.0+166.0);

        AnchorPane.setLeftAnchor(WiFi_name_tf,250.0);
        AnchorPane.setLeftAnchor(WiFi_Password_tf,250.0);
        AnchorPane.setLeftAnchor(WiFi_ServerIP_tf,250.0);
        AnchorPane.setLeftAnchor(WiFi_SSID_tf,250.0);
        AnchorPane.setLeftAnchor(WiFi_security_mb,250.0);
        AnchorPane.setLeftAnchor(WiFi_Password_add_tf,250.0);
        AnchorPane.setLeftAnchor(WiFi_Note_tf,250.0);
        AnchorPane.setLeftAnchor(set_Date_con,250.0);

        AnchorPane.setTopAnchor(WiFi_name_tf,158.0);
        AnchorPane.setTopAnchor(WiFi_SSID_tf,186.0);
        AnchorPane.setTopAnchor(WiFi_Password_tf,214.0);
        AnchorPane.setTopAnchor(WiFi_security_mb,242.0);
        AnchorPane.setTopAnchor(WiFi_ServerIP_tf,271.0);
        AnchorPane.setTopAnchor(WiFi_Password_add_tf,298.0);
        AnchorPane.setTopAnchor(WiFi_Note_tf,329.0);
        AnchorPane.setTopAnchor(set_Date_con,330.0+166.0);
        WiFi_Note_tf.setPrefSize(350,138);
        WiFi_title.fontProperty().setValue(new Font("System",20));
        WiFi_title.setLayoutX(244.0);
        WiFi_title.setLayoutY(94.0);

        AnchorPane.setTopAnchor(WiFi_title,64.0);
        AnchorPane.setLeftAnchor(WiFi_title,243.0);
        AnchorPane.setRightAnchor(WiFi_title,255.0);
        AnchorPane.setBottomAnchor(WiFi_title,575.0);
    }

    //点击WiFi那个menu之后进入的设置页面
    public static void set_WiFi(ListView<Password> choice_list, ObservableList<Password> mid_list_items,Button add_button,AnchorPane main_page,AnchorPane bottom_page) {
        GlobalMenu.WiFiMenuItem.setOnAction((ActionEvent event1)->{
            main_page.getChildren().clear();
            pre_set_WiFi();
            add_button.setDisable(true);
            choice_list.setDisable(true);
            main_page.getChildren().addAll(WiFi_title,WiFi_name,WiFi_Password,WiFi_ServerIP,WiFi_SSID,WiFi_security,WiFi_Note,WiFi_Password_add,WiFi_name_tf,WiFi_SSID_tf,WiFi_Password_tf,WiFi_security_mb,WiFi_ServerIP_tf,WiFi_Password_add_tf,WiFi_Note_tf);

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
                String name_input = WiFi_name_tf.getText();
                String Note_input = WiFi_Note_tf.getText();
                String WiFi_security = WiFi_security_mb.getText();
                if (name_input.equals("")) {
                    name_input = "无线路由器";
                }
                if (Note_input.equals("")) {
                    Note_input = "";
                }
                if (WiFi_security.equals("加密方式")) {
                    WiFi_security = "无";
                }
                Util.WirelessRouter wr = new Util.WirelessRouter(name_input, Note_input);
                wr.setPassword(AesCtr.encrypt(WiFi_Password_tf.getText()));
                wr.setPassword_add(AesCtr.encrypt(WiFi_Password_add_tf.getText()));
                wr.setSecurity(WiFi_security);
                wr.setSSID(WiFi_SSID_tf.getText());
                wr.setServerIP(WiFi_ServerIP_tf.getText());
                set_Date_con.setText(wr.getSetUpDate());
                Main.user.add_password(wr);
                add_list(choice_list,mid_list_items,wr);
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

    public static void add_list(ListView<Password> choice_list, ObservableList<Password> mid_list_items, Password password) {
        mid_list_items.add(password);
        choice_list.setItems(mid_list_items);
    }

    public static void display_WiFi(ListView<Password> choice_list, ObservableList<Password> mid_list_items,Button add_button,AnchorPane main_page,AnchorPane bottom_page, WirelessRouter password) {
        main_page.getChildren().clear();
        pre_set_WiFi();

        ImageView imageView1 = new ImageView();
        ImageView clipboard1 = new ImageView(clip);
        imageView1.setImage(see_1);
        imageView1.setFitWidth(16);
        imageView1.setFitHeight(16);
        imageView1.hoverProperty().addListener((observable -> {
            if (imageView1.isHover()) {
                WiFi_Password_tf.setText(AesCtr.decrypt(password.getPassword()));
                imageView1.setImage(see_2);
            } else {
                WiFi_Password_tf.setText("********");
                imageView1.setImage(see_1);
            }
        }));

        clipboard1.setFitHeight(16);
        clipboard1.setFitWidth(16);
        clipboard1.setOnMouseClicked((event -> {
            Clipboard clipboard2 = Clipboard.getSystemClipboard();
            ClipboardContent cc = new ClipboardContent();
            cc.putString(AesCtr.decrypt(password.getPassword()));
            clipboard2.setContent(cc);
        }));
        AnchorPane.setTopAnchor(imageView1,302.0);
        AnchorPane.setLeftAnchor(imageView1,500.0);
        AnchorPane.setTopAnchor(clipboard1,302.0);
        AnchorPane.setLeftAnchor(clipboard1,520.0);

        ImageView imageView = new ImageView();
        ImageView clipboard = new ImageView(clip);
        imageView.setImage(see_1);
        imageView.setFitWidth(16);
        imageView.setFitHeight(16);
        imageView.hoverProperty().addListener((observable -> {
            if (imageView.isHover()) {
                WiFi_Password_add_tf.setText(AesCtr.decrypt(password.getPassword_add()));
                imageView.setImage(see_2);
            } else {
                WiFi_Password_add_tf.setText("********");
                imageView.setImage(see_1);
            }
        }));

        clipboard.setFitHeight(16);
        clipboard.setFitWidth(16);
        clipboard.setOnMouseClicked((event -> {
            Clipboard clipboard0 = Clipboard.getSystemClipboard();
            ClipboardContent cc = new ClipboardContent();
            cc.putString(AesCtr.decrypt(password.getPassword_add()));
            clipboard0.setContent(cc);
        }));
        AnchorPane.setTopAnchor(imageView,302.0);
        AnchorPane.setLeftAnchor(imageView,500.0);
        AnchorPane.setTopAnchor(clipboard,302.0);
        AnchorPane.setLeftAnchor(clipboard,520.0);


        set_Date_con.setText(password.getSetUpDate());
        main_page.getChildren().addAll(imageView,clipboard,imageView1,clipboard1,set_Date_con,set_Date_la,WiFi_title,WiFi_name,
                WiFi_Password,WiFi_ServerIP,WiFi_SSID,WiFi_security,WiFi_Note,WiFi_Password_add,
                WiFi_name_tf,WiFi_SSID_tf,WiFi_Password_tf,WiFi_security_tf,WiFi_ServerIP_tf,
                WiFi_Password_add_tf,WiFi_Note_tf);
        WiFi_name_tf.setEditable(false);
        WiFi_SSID_tf.setEditable(false);
        WiFi_Password_tf.setEditable(false);
        WiFi_security_tf.setEditable(false);
        WiFi_ServerIP_tf.setEditable(false);
        WiFi_Password_add_tf.setEditable(false);
        WiFi_Note_tf.setEditable(false);

        //这里的细节很重要！
        WiFi_name_tf.setText(password.getName());
        WiFi_SSID_tf.setText(password.getSSID());
        WiFi_Password_tf.setText("********");
        WiFi_security_tf.setText(password.getSecurity());
        WiFi_ServerIP_tf.setText(password.getServerIP());
        WiFi_Password_add_tf.setText("********");
        WiFi_Note_tf.setText(password.getNote());

        AnchorPane.setLeftAnchor(WiFi_security_tf,250.0);
        AnchorPane.setTopAnchor(WiFi_security_tf,242.0);

        Button change = new Button("编辑");
        Button delete = new Button("删除");

        change.setOnAction((ActionEvent ae) -> {
            bottom_page.getChildren().removeAll(change, delete);
            main_page.getChildren().clear();
            pre_set_WiFi();
            add_button.setDisable(true);
            choice_list.setDisable(true);
            main_page.getChildren().addAll(set_Date_con,set_Date_la,WiFi_title,WiFi_name,
                    WiFi_Password,WiFi_ServerIP,WiFi_SSID,WiFi_security,WiFi_Note,WiFi_Password_add,
                    WiFi_name_tf,WiFi_SSID_tf,WiFi_Password_tf,WiFi_security_mb,WiFi_ServerIP_tf,
                    WiFi_Password_add_tf,WiFi_Note_tf);
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
                String WiFi_security = WiFi_security_mb.getText();
                if (WiFi_security.equals("加密方式")) {
                    WiFi_security = "无";
                }
                password.setName(WiFi_name_tf.getText());
                password.setSSID(WiFi_SSID_tf.getText());
                password.setPassword(AesCtr.encrypt(WiFi_Password_tf.getText()));
                password.setSecurity(WiFi_security);
                password.setServerIP(WiFi_ServerIP_tf.getText());
                password.setPassword_add(AesCtr.encrypt(WiFi_Password_add_tf.getText()));
                password.setNote(WiFi_Note_tf.getText());

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

            WiFi_name_tf.setText(password.getName());
            WiFi_SSID_tf.setText(password.getSSID());
            WiFi_Password_tf.setText(AesCtr.decrypt(password.getPassword()));
            WiFi_security_tf.setText(password.getSecurity());
            WiFi_ServerIP_tf.setText(password.getServerIP());
            WiFi_Password_add_tf.setText(AesCtr.decrypt(password.getPassword_add()));
            WiFi_Note_tf.setText(password.getNote());
            choice_list.setItems(mid_list_items);
        });

        delete.setOnAction((ActionEvent ae1)->{
            bottom_page.getChildren().removeAll(change, delete);
            Main.user.all_passwords.remove(password);
            mid_list_items.remove(password);
            choice_list.setItems(mid_list_items);
            Main.back_up.push(password);
        });

        AnchorPane.setBottomAnchor(delete,5.0);
        AnchorPane.setRightAnchor(delete,166.0);
        bottom_page.getChildren().addAll(delete,change);
        AnchorPane.setBottomAnchor(change,5.0);
        AnchorPane.setRightAnchor(change,100.0);
    }
}

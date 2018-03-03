package Main_menu;


import Util.Membership;
import Util.Password;
import first_set.Main;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class Set_Membership {
    private static TextField name_tf = new TextField();
    private static TextField site_tf = new TextField();
    private static TextField Phone_tf = new TextField();
    private static TextField username_tf = new TextField();
    private static TextField joinDate_tf = new TextField();
    private static TextField expiryDate_tf = new TextField();
    private static TextField PIN_tf = new TextField();

    private static Label name = new Label("公司名称");
    private static Label site = new Label("网站");
    private static Label Phone = new Label("电话");
    private static Label username = new Label("会员姓名");
    private static Label joinDate = new Label("入会日期");
    private static Label expiryDate = new Label("有效期");
    private static Label PIN = new Label("PIN码");
    private static Label Note = new Label("备注");
    private static Label title = new Label("会员信息");

    private static TextArea Note_tf = new TextArea();

    private static void pre_set_membership() {
        name_tf.setEditable(true);
        site_tf.setEditable(true);
        Phone_tf.setEditable(true);
        username_tf.setEditable(true);
        joinDate_tf.setEditable(true);
        expiryDate_tf.setEditable(true);
        PIN_tf.setEditable(true);
        Note_tf.setEditable(true);

        name_tf.setText("");
        site_tf.setText("");
        Phone_tf.setText("");
        username_tf.setText("");
        joinDate_tf.setText("");
        expiryDate_tf.setText("");
        PIN_tf.setText("");
        Note_tf.setText("");

        name_tf.setStyle("-fx-background-color: white");
        site_tf.setStyle("-fx-background-color: white");
        Phone_tf.setStyle("-fx-background-color: white");
        username_tf.setStyle("-fx-background-color: white");
        joinDate_tf.setStyle("-fx-background-color: white");
        expiryDate_tf.setStyle("-fx-background-color: white");
        PIN_tf.setStyle("-fx-background-color: white");
        Note_tf.setStyle("-fx-background-color: white");

        name.setStyle("-fx-text-fill:#707070");
        site.setStyle("-fx-text-fill:#707070");
        Phone.setStyle("-fx-text-fill:#707070");
        username.setStyle("-fx-text-fill:#707070");
        joinDate.setStyle("-fx-text-fill:#707070");
        expiryDate.setStyle("-fx-text-fill:#707070");
        PIN.setStyle("-fx-text-fill:#707070");
        Note.setStyle("-fx-text-fill:#707070");



        name.setFont(new Font(15.0));
        site.setFont(new Font(15.0));
        Phone.setFont(new Font(15.0));
        username.setFont(new Font(15.0));
        joinDate.setFont(new Font(15.0));
        expiryDate.setFont(new Font(15.0));
        PIN.setFont(new Font(15.0));
        Note.setFont(new Font(15.0));
        title.setFont(new Font(15.0));


        AnchorPane.setRightAnchor(name,437.0);
        AnchorPane.setRightAnchor(site,437.0);
        AnchorPane.setRightAnchor(Phone,437.0);
        AnchorPane.setRightAnchor(username,437.0);
        AnchorPane.setRightAnchor(joinDate,437.0);
        AnchorPane.setRightAnchor(expiryDate,437.0);
        AnchorPane.setRightAnchor(PIN,437.0);
        AnchorPane.setRightAnchor(Note,437.0);

        AnchorPane.setTopAnchor(name,162.0);
        AnchorPane.setTopAnchor(site,190.0);
        AnchorPane.setTopAnchor(Phone,218.0);
        AnchorPane.setTopAnchor(username,246.0);
        AnchorPane.setTopAnchor(joinDate,273.0);
        AnchorPane.setTopAnchor(PIN,301.0);
        AnchorPane.setTopAnchor(expiryDate,330.0);
        AnchorPane.setTopAnchor(Note,358.0);


        AnchorPane.setLeftAnchor(name_tf,250.0);
        AnchorPane.setLeftAnchor(site_tf,250.0);
        AnchorPane.setLeftAnchor(Phone_tf,250.0);
        AnchorPane.setLeftAnchor(username_tf,250.0);
        AnchorPane.setLeftAnchor(joinDate_tf,250.0);
        AnchorPane.setLeftAnchor(expiryDate_tf,250.0);
        AnchorPane.setLeftAnchor(PIN_tf,250.0);
        AnchorPane.setLeftAnchor(Note_tf,250.0);


        AnchorPane.setTopAnchor(name_tf,158.0);
        AnchorPane.setTopAnchor(site_tf,186.0);
        AnchorPane.setTopAnchor(Phone_tf,214.0);
        AnchorPane.setTopAnchor(username_tf,242.0);
        AnchorPane.setTopAnchor(joinDate_tf,269.0);
        AnchorPane.setTopAnchor(expiryDate_tf,297.0);
        AnchorPane.setTopAnchor(PIN_tf,327.0);
        AnchorPane.setTopAnchor(Note_tf,354.0);
        Note_tf.setPrefSize(350,138);

        title.fontProperty().setValue(new Font("System",20));
        title.setLayoutX(244.0);
        title.setLayoutY(94.0);
        AnchorPane.setTopAnchor(title,64.0);
        AnchorPane.setLeftAnchor(title,243.0);
        AnchorPane.setRightAnchor(title,255.0);
        AnchorPane.setBottomAnchor(title,575.0);
    }
    public static void set_membership(ListView<Password> choice_list, ObservableList<Password> mid_list_items, Button add_button, AnchorPane main_page, AnchorPane bottom_page) {
        GlobalMenu.VipMenuItem.setOnAction((ActionEvent event1)->{
            main_page.getChildren().clear();
            pre_set_membership();
            add_button.setDisable(true);
            choice_list.setDisable(true);
            main_page.getChildren().addAll(name_tf,site_tf,PIN_tf,Phone_tf,
                    username_tf,joinDate_tf,expiryDate_tf,name,site,Phone,
                    username,joinDate,expiryDate,PIN,Note,title,Note_tf);

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
                    name_input = "会员信息";
                }
                if (Note_input.equals("")) {
                    Note_input = "";
                }
                Membership ms = new Membership(name_input, Note_input);
                ms.setExpiryDate(expiryDate_tf.getText());
                ms.setJoinDate(joinDate_tf.getText());
                ms.setPhone(Phone_tf.getText());
                ms.setPIN(PIN_tf.getText());
                ms.setSite(site_tf.getText());
                ms.setUsername(username_tf.getText());
                Main.user.add_password(ms);
                add_list(choice_list,mid_list_items,ms);
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
    public static void display_membership(ListView<Password> choice_list, ObservableList<Password> mid_list_items,Button add_button,AnchorPane main_page,AnchorPane bottom_page, Membership membership) {
        pre_set_membership();
        main_page.getChildren().clear();
        main_page.getChildren().addAll(name_tf,site_tf,PIN_tf,Phone_tf,
                username_tf,joinDate_tf,expiryDate_tf,name,site,Phone,
                username,joinDate,expiryDate,PIN,Note,title,Note_tf);
        name_tf.setEditable(false);
        site_tf.setEditable(false);
        Phone_tf.setEditable(false);
        username_tf.setEditable(false);
        joinDate_tf.setEditable(false);
        expiryDate_tf.setEditable(false);
        PIN_tf.setEditable(false);
        Note_tf.setEditable(false);

        //这里的细节很重要！
        name_tf.setText(membership.getname());
        site_tf.setText(membership.getSite());
        username_tf.setText(membership.getUsername());
        joinDate_tf.setText(membership.getJoinDate());
        PIN_tf.setText(membership.getPIN());
        Phone_tf.setText(membership.getPhone());
        expiryDate_tf.setText(membership.getExpiryDate());
        Note_tf.setText(membership.getNote());


        Button change = new Button("编辑");
        Button delete = new Button("删除");

        change.setOnAction((ActionEvent ae) -> {
            bottom_page.getChildren().removeAll(change, delete);
            main_page.getChildren().clear();
            pre_set_membership();
            add_button.setDisable(true);
            choice_list.setDisable(true);
            main_page.getChildren().addAll(name_tf,site_tf,PIN_tf,Phone_tf,
                    username_tf,joinDate_tf,expiryDate_tf,name,site,Phone,
                    username,joinDate,expiryDate,PIN,Note,title,Note_tf);

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
                    name_input = "会员信息";
                }
                if (Note_input.equals("")) {
                    Note_input = "";
                }
                Membership ms = new Membership(name_input, Note_input);
                ms.setExpiryDate(expiryDate_tf.getText());
                ms.setJoinDate(joinDate_tf.getText());
                ms.setPhone(Phone_tf.getText());
                ms.setPIN(PIN_tf.getText());
                ms.setSite(site_tf.getText());
                ms.setUsername(username_tf.getText());
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

            name_tf.setText(membership.getname());
            site_tf.setText(membership.getSite());
            username_tf.setText(membership.getUsername());
            joinDate_tf.setText(membership.getJoinDate());
            PIN_tf.setText(membership.getPIN());
            Phone_tf.setText(membership.getPhone());
            expiryDate_tf.setText(membership.getExpiryDate());
            Note_tf.setText(membership.getNote());
            choice_list.setItems(mid_list_items);
        });

        delete.setOnAction((ActionEvent ae1)->{
            bottom_page.getChildren().removeAll(change, delete);
            Main.user.all_passwords.remove(membership);
            mid_list_items.remove(membership);
            choice_list.setItems(mid_list_items);
        });

        AnchorPane.setBottomAnchor(delete,5.0);
        AnchorPane.setRightAnchor(delete,166.0);
        bottom_page.getChildren().addAll(delete,change);
        AnchorPane.setBottomAnchor(change,5.0);
        AnchorPane.setRightAnchor(change,100.0);
    }
}

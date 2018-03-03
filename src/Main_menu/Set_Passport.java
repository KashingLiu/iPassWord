package Main_menu;

import Util.Passport;
import Util.Password;
import first_set.Main;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class Set_Passport {
    private static TextField name_tf = new TextField();
    private static TextField full_name_tf = new TextField();
    private static TextField nationality_tf = new TextField();
    private static TextField authority_tf = new TextField();
    private static TextField birthday_tf = new TextField();
    private static TextField address_tf = new TextField();
    private static TextField issued_date_tf = new TextField();
    private static TextField expiry_date_tf = new TextField();

    private static Label name = new Label("签发国家");
    private static Label full_name = new Label("全名");
    private static Label nationality = new Label("国籍");
    private static Label authority = new Label("签发机关");
    private static Label birthday = new Label("出生日期");
    private static Label address = new Label("出生地");
    private static Label issued_date = new Label("签发日期");
    private static Label expiry_date = new Label("有效期");

    private static Label Note = new Label("备注");
    private static Label title = new Label("护照信息");
    private static TextArea Note_tf = new TextArea();
    private static Label set_Date_la = new Label("创建日期");
    private static Label set_Date_con = new Label();


    private static void pre_set_passport() {
        name_tf.setEditable(true);
        full_name_tf.setEditable(true);
        nationality_tf.setEditable(true);
        authority_tf.setEditable(true);
        birthday_tf.setEditable(true);
        address_tf.setEditable(true);
        issued_date_tf.setEditable(true);
        expiry_date_tf.setEditable(true);
        Note_tf.setEditable(true);

        name_tf.setText("");
        full_name_tf.setText("");
        nationality_tf.setText("");
        authority_tf.setText("");
        birthday_tf.setText("");
        address_tf.setText("");
        issued_date_tf.setText("");
        expiry_date_tf.setText("");
        Note_tf.setText("");

        name_tf.setStyle("-fx-background-color: white");
        full_name_tf.setStyle("-fx-background-color: white");
        nationality_tf.setStyle("-fx-background-color: white");
        authority_tf.setStyle("-fx-background-color: white");
        birthday_tf.setStyle("-fx-background-color: white");
        address_tf.setStyle("-fx-background-color: white");
        issued_date_tf.setStyle("-fx-background-color: white");
        expiry_date_tf.setStyle("-fx-background-color: white");
        Note_tf.setStyle("-fx-background-color: white");

        name.setStyle("-fx-text-fill:#707070");
        full_name.setStyle("-fx-text-fill:#707070");
        nationality.setStyle("-fx-text-fill:#707070");
        authority.setStyle("-fx-text-fill:#707070");
        birthday.setStyle("-fx-text-fill:#707070");
        address.setStyle("-fx-text-fill:#707070");
        issued_date.setStyle("-fx-text-fill:#707070");
        expiry_date.setStyle("-fx-text-fill:#707070");
        Note.setStyle("-fx-text-fill:#707070");
        set_Date_la.setStyle("-fx-text-fill:#707070");
        set_Date_con.setStyle("-fx-text-fill:#707070");


        name.setFont(new Font(15.0));
        full_name.setFont(new Font(15.0));
        nationality.setFont(new Font(15.0));
        authority.setFont(new Font(15.0));
        birthday.setFont(new Font(15.0));
        address.setFont(new Font(15.0));
        issued_date.setFont(new Font(15.0));
        expiry_date.setFont(new Font(15.0));
        Note.setFont(new Font(15.0));
        title.setFont(new Font(15.0));
        set_Date_la.setFont(new Font(15.0));
        set_Date_con.setFont(new Font(15.0));

        AnchorPane.setRightAnchor(name,437.0);
        AnchorPane.setRightAnchor(full_name,437.0);
        AnchorPane.setRightAnchor(nationality,437.0);
        AnchorPane.setRightAnchor(authority,437.0);
        AnchorPane.setRightAnchor(birthday,437.0);
        AnchorPane.setRightAnchor(address,437.0);
        AnchorPane.setRightAnchor(issued_date,437.0);
        AnchorPane.setRightAnchor(expiry_date,437.0);
        AnchorPane.setRightAnchor(Note,437.0);
        AnchorPane.setRightAnchor(set_Date_la,437.0);

        AnchorPane.setTopAnchor(name,162.0);
        AnchorPane.setTopAnchor(full_name,190.0);
        AnchorPane.setTopAnchor(nationality,218.0);
        AnchorPane.setTopAnchor(authority,246.0);
        AnchorPane.setTopAnchor(birthday,273.0);
        AnchorPane.setTopAnchor(address,302.0);
        AnchorPane.setTopAnchor(issued_date,330.0);
        AnchorPane.setTopAnchor(expiry_date,358.0);
        AnchorPane.setTopAnchor(Note,386.0);
        AnchorPane.setTopAnchor(set_Date_la,386.0+166.0);

        AnchorPane.setLeftAnchor(name_tf,250.0);
        AnchorPane.setLeftAnchor(full_name_tf,250.0);
        AnchorPane.setLeftAnchor(nationality_tf,250.0);
        AnchorPane.setLeftAnchor(authority_tf,250.0);
        AnchorPane.setLeftAnchor(birthday_tf,250.0);
        AnchorPane.setLeftAnchor(address_tf,250.0);
        AnchorPane.setLeftAnchor(issued_date_tf,250.0);
        AnchorPane.setLeftAnchor(expiry_date_tf,250.0);
        AnchorPane.setLeftAnchor(Note_tf,250.0);
        AnchorPane.setLeftAnchor(set_Date_con,250.0);

        AnchorPane.setTopAnchor(name_tf,158.0);
        AnchorPane.setTopAnchor(full_name_tf,186.0);
        AnchorPane.setTopAnchor(nationality_tf,214.0);
        AnchorPane.setTopAnchor(authority_tf,242.0);
        AnchorPane.setTopAnchor(birthday_tf,269.0);
        AnchorPane.setTopAnchor(address_tf,298.0);
        AnchorPane.setTopAnchor(issued_date_tf,327.0);
        AnchorPane.setTopAnchor(expiry_date_tf,354.0);
        AnchorPane.setTopAnchor(Note_tf,382.0);
        AnchorPane.setTopAnchor(set_Date_con,386.0+166.0);
        Note_tf.setPrefSize(350,138);

        title.fontProperty().setValue(new Font("System",20));
        title.setLayoutX(244.0);
        title.setLayoutY(94.0);
        AnchorPane.setTopAnchor(title,64.0);
        AnchorPane.setLeftAnchor(title,243.0);
        AnchorPane.setRightAnchor(title,255.0);
        AnchorPane.setBottomAnchor(title,575.0);
    }
    public static void set_passport(ListView<Password> choice_list, ObservableList<Password> mid_list_items, Button add_button, AnchorPane main_page, AnchorPane bottom_page) {
        GlobalMenu.PassMenuItem.setOnAction((ActionEvent event1)->{
            main_page.getChildren().clear();
            pre_set_passport();
            add_button.setDisable(true);
            choice_list.setDisable(true);
            main_page.getChildren().addAll(name,name_tf,Note,Note_tf,title,full_name,full_name_tf,nationality,nationality_tf,authority,authority_tf,birthday,birthday_tf,address,address_tf,issued_date,issued_date_tf,expiry_date,expiry_date_tf);

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
                    name_input = "护照信息";
                }
                if (Note_input.equals("")) {
                    Note_input = "";
                }
                Passport pp = new Passport(name_input, Note_input);
                pp.setAddress(address_tf.getText());
                pp.setAuthority(authority_tf.getText());
                pp.setBirthday(birthday_tf.getText());
                pp.setExpiry_date(expiry_date_tf.getText());
                pp.setFull_name(full_name_tf.getText());
                pp.setIssued_date(issued_date_tf.getText());
                pp.setNationality(nationality_tf.getText());
                set_Date_con.setText(pp.getSetUpDate());
                Main.user.add_password(pp);
                add_list(choice_list,mid_list_items,pp);
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
    public static void display_passport(ListView<Password> choice_list, ObservableList<Password> mid_list_items,Button add_button,AnchorPane main_page,AnchorPane bottom_page, Passport passport) {
        pre_set_passport();
        main_page.getChildren().clear();
        main_page.getChildren().addAll(set_Date_con,set_Date_la,name,name_tf,Note,Note_tf,title,full_name,full_name_tf,nationality,nationality_tf,authority,authority_tf,birthday,birthday_tf,address,address_tf,issued_date,issued_date_tf,expiry_date,expiry_date_tf);
        name_tf.setEditable(false);
        full_name_tf.setEditable(false);
        nationality_tf.setEditable(false);
        authority_tf.setEditable(false);
        birthday_tf.setEditable(false);
        address_tf.setEditable(false);
        issued_date_tf.setEditable(false);
        expiry_date_tf.setEditable(false);
        Note_tf.setEditable(false);

        //这里的细节很重要！
        name_tf.setText(passport.getname());
        full_name_tf.setText(passport.getFull_name());
        nationality_tf.setText(passport.getNationality());
        authority_tf.setText(passport.getAuthority());
        birthday_tf.setText(passport.getBirthday());
        address_tf.setText(passport.getAddress());
        issued_date_tf.setText(passport.getIssued_date());
        expiry_date_tf.setText(passport.getExpiry_date());
        Note_tf.setText(passport.getNote());


        Button change = new Button("编辑");
        Button delete = new Button("删除");

        change.setOnAction((ActionEvent ae) -> {
            bottom_page.getChildren().removeAll(change, delete);
            main_page.getChildren().clear();
            pre_set_passport();
            add_button.setDisable(true);
            choice_list.setDisable(true);
            main_page.getChildren().addAll(set_Date_con,set_Date_la,name,name_tf,Note,Note_tf,title,full_name,full_name_tf,nationality,nationality_tf,authority,authority_tf,birthday,birthday_tf,address,address_tf,issued_date,issued_date_tf,expiry_date,expiry_date_tf);

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
                passport.setName(name_tf.getText());
                passport.setNote(Note_tf.getText());
                passport.setAddress(address_tf.getText());
                passport.setAuthority(authority_tf.getText());
                passport.setBirthday(birthday_tf.getText());
                passport.setExpiry_date(expiry_date_tf.getText());
                passport.setFull_name(full_name_tf.getText());
                passport.setIssued_date(issued_date_tf.getText());
                passport.setNationality(nationality_tf.getText());
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

            name_tf.setText(passport.getname());
            full_name_tf.setText(passport.getFull_name());
            nationality_tf.setText(passport.getNationality());
            authority_tf.setText(passport.getAuthority());
            birthday_tf.setText(passport.getBirthday());
            address_tf.setText(passport.getAddress());
            issued_date_tf.setText(passport.getIssued_date());
            expiry_date_tf.setText(passport.getExpiry_date());
            Note_tf.setText(passport.getNote());

            choice_list.setItems(mid_list_items);
        });

        delete.setOnAction((ActionEvent ae1)->{
            bottom_page.getChildren().removeAll(change, delete);
            Main.user.all_passwords.remove(passport);
            mid_list_items.remove(passport);
            choice_list.setItems(mid_list_items);
        });

        AnchorPane.setBottomAnchor(delete,5.0);
        AnchorPane.setRightAnchor(delete,166.0);
        bottom_page.getChildren().addAll(delete,change);
        AnchorPane.setBottomAnchor(change,5.0);
        AnchorPane.setRightAnchor(change,100.0);
    }

}

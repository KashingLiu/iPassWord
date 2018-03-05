package Main_menu;

import Util.BankAccount;
import Util.Password;
import first_set.Main;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class Set_Bankaccount {
    private static TextField name_tf = new TextField();
    private static TextField account_tf = new TextField();

    private static TextField alias_tf = new TextField();
    private static TextField account_number_tf = new TextField();
    private static TextField PIN_tf = new TextField();
    private static TextField Swift_tf = new TextField();
    private static TextField Phone_tf = new TextField();
    private static TextField address_tf = new TextField();
    private static TextField type_tf = new TextField();

    private static Label name = new Label("银行名称");
    private static Label account = new Label("账户名称");
    private static Label type = new Label("账户类型");
    private static Label alias = new Label("银行代号");
    private static Label account_number = new Label("账号");
    private static Label PIN = new Label("PIN码");
    private static Label Swift = new Label("SWIFT代码");
    private static Label Phone = new Label("分行电话号");
    private static Label address = new Label("分行地址");

    private static Label Note = new Label("备注");
    private static Label title = new Label("银行账户");
    private static TextArea Note_tf = new TextArea();
    private static MenuItem mi1 = new MenuItem("ATM");
    private static MenuItem mi2 = new MenuItem("储蓄账户");
    private static MenuItem mi3 = new MenuItem("支票");
    private static MenuItem mi4 = new MenuItem("债券");
    private static MenuItem mi5 = new MenuItem("生活缴费");
    private static MenuItem mi6 = new MenuItem("其他");
    private static MenuButton type_mb = new MenuButton("类型",null,mi1,mi2,mi3,mi4,mi5,mi6);

    private static Label set_Date_la = new Label("创建日期");
    private static Label set_Date_con = new Label();

    private static void pre_set_bankaccount() {
        mi1.setOnAction((ActionEvent ae1)->{
            type_mb.setText(mi1.getText());
        });
        mi2.setOnAction((ActionEvent ae2)->{
            type_mb.setText(mi2.getText());
        });
        mi3.setOnAction((ActionEvent ae3)->{
            type_mb.setText(mi3.getText());
        });
        mi4.setOnAction((ActionEvent ae4)->{
            type_mb.setText(mi4.getText());
        });
        mi5.setOnAction((ActionEvent ae5)->{
            type_mb.setText(mi5.getText());
        });
        mi6.setOnAction((ActionEvent ae6)->{
            type_mb.setText(mi6.getText());
        });
        name_tf.setEditable(true);
        account_tf.setEditable(true);
        alias_tf.setEditable(true);
        account_number_tf.setEditable(true);
        PIN_tf.setEditable(true);
        Swift_tf.setEditable(true);
        Phone_tf.setEditable(true);
        address_tf.setEditable(true);
        type_tf.setEditable(true);
        Note_tf.setEditable(true);

        name_tf.setText("");
        account_tf.setText("");
        alias_tf.setText("");
        account_number_tf.setText("");
        PIN_tf.setText("");
        Swift_tf.setText("");
        Phone_tf.setText("");
        address_tf.setText("");
        type_tf.setText("");
        Note_tf.setText("");

        name_tf.setStyle("-fx-background-color: white");
        account_tf.setStyle("-fx-background-color: white");
        type_mb.setStyle("-fx-background-color: white");
        alias_tf.setStyle("-fx-background-color: white");
        account_number_tf.setStyle("-fx-background-color: white");
        PIN_tf.setStyle("-fx-background-color: white");
        Swift_tf.setStyle("-fx-background-color: white");
        Phone_tf.setStyle("-fx-background-color: white");
        address_tf.setStyle("-fx-background-color: white");
        type_tf.setStyle("-fx-background-color: white");
        Note_tf.setStyle("-fx-background-color: white");

        name.setStyle("-fx-text-fill:#707070");
        account.setStyle("-fx-text-fill:#707070");
        type.setStyle("-fx-text-fill:#707070");
        alias.setStyle("-fx-text-fill:#707070");
        account_number.setStyle("-fx-text-fill:#707070");
        PIN.setStyle("-fx-text-fill:#707070");
        Swift.setStyle("-fx-text-fill:#707070");
        Phone.setStyle("-fx-text-fill:#707070");
        address.setStyle("-fx-text-fill:#707070");
        Note.setStyle("-fx-text-fill:#707070");
        set_Date_la.setStyle("-fx-text-fill:#707070");
        set_Date_con.setStyle("-fx-text-fill:#707070");

        name.setFont(new Font(15.0));
        account.setFont(new Font(15.0));
        type.setFont(new Font(15.0));
        alias.setFont(new Font(15.0));
        account_number.setFont(new Font(15.0));
        PIN.setFont(new Font(15.0));
        Swift.setFont(new Font(15.0));
        Phone.setFont(new Font(15.0));
        address.setFont(new Font(15.0));
        Note.setFont(new Font(15.0));
        set_Date_la.setFont(new Font(15.0));
        set_Date_con.setFont(new Font(15.0));

        AnchorPane.setRightAnchor(name,437.0);
        AnchorPane.setRightAnchor(account,437.0);
        AnchorPane.setRightAnchor(type,437.0);
        AnchorPane.setRightAnchor(alias,437.0);
        AnchorPane.setRightAnchor(account_number,437.0);
        AnchorPane.setRightAnchor(PIN,437.0);
        AnchorPane.setRightAnchor(Swift,437.0);
        AnchorPane.setRightAnchor(Phone,437.0);
        AnchorPane.setRightAnchor(address,437.0);
        AnchorPane.setRightAnchor(Note,437.0);
        AnchorPane.setRightAnchor(set_Date_la,437.0);

        AnchorPane.setTopAnchor(name,162.0);
        AnchorPane.setTopAnchor(account,190.0);
        AnchorPane.setTopAnchor(type,218.0);
        AnchorPane.setTopAnchor(alias,246.0);
        AnchorPane.setTopAnchor(account_number,273.0);
        AnchorPane.setTopAnchor(PIN,302.0);
        AnchorPane.setTopAnchor(Swift,330.0);
        AnchorPane.setTopAnchor(Phone,358.0);
        AnchorPane.setTopAnchor(address,386.0);
        AnchorPane.setTopAnchor(Note,414.0);
        AnchorPane.setTopAnchor(set_Date_la,580.0);

        AnchorPane.setLeftAnchor(name_tf,250.0);
        AnchorPane.setLeftAnchor(account_tf,250.0);
        AnchorPane.setLeftAnchor(type_mb,250.0);
        AnchorPane.setLeftAnchor(alias_tf,250.0);
        AnchorPane.setLeftAnchor(account_number_tf,250.0);
        AnchorPane.setLeftAnchor(PIN_tf,250.0);
        AnchorPane.setLeftAnchor(Swift_tf,250.0);
        AnchorPane.setLeftAnchor(Phone_tf,250.0);
        AnchorPane.setLeftAnchor(address_tf,250.0);
        AnchorPane.setLeftAnchor(Note_tf,250.0);
        AnchorPane.setLeftAnchor(set_Date_con,250.0);

        AnchorPane.setTopAnchor(name_tf,158.0);
        AnchorPane.setTopAnchor(account_tf,186.0);
        AnchorPane.setTopAnchor(type_mb,214.0);
        AnchorPane.setTopAnchor(alias_tf,242.0);
        AnchorPane.setTopAnchor(account_number_tf,269.0);
        AnchorPane.setTopAnchor(PIN_tf,298.0);
        AnchorPane.setTopAnchor(Swift_tf,327.0);
        AnchorPane.setTopAnchor(Phone_tf,354.0);
        AnchorPane.setTopAnchor(address_tf,382.0);
        AnchorPane.setTopAnchor(Note_tf,414.0);
        AnchorPane.setTopAnchor(set_Date_con,580.0);
        Note_tf.setPrefSize(350,138);

        title.fontProperty().setValue(new Font("System",20));
        title.setLayoutX(244.0);
        title.setLayoutY(94.0);
        AnchorPane.setTopAnchor(title,64.0);
        AnchorPane.setLeftAnchor(title,243.0);
        AnchorPane.setRightAnchor(title,255.0);
        AnchorPane.setBottomAnchor(title,575.0);
    }

    public static void set_bankaccount(ListView<Password> choice_list, ObservableList<Password> mid_list_items, Button add_button, AnchorPane main_page, AnchorPane bottom_page) {
        GlobalMenu.BankMenuItem.setOnAction((ActionEvent event1)->{
            main_page.getChildren().clear();
            pre_set_bankaccount();
            add_button.setDisable(true);
            choice_list.setDisable(true);
            main_page.getChildren().addAll(name_tf,account_tf,type_mb,alias_tf,account_number_tf,PIN_tf,Swift_tf,Phone_tf,address_tf,Note_tf,name,account,type,alias,account_number,PIN,Swift,Phone,address,Note,title);

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
                    name_input = "银行账户";
                }
                if (Note_input.equals("")) {
                    Note_input = "";
                }
                BankAccount ba = new BankAccount(name_input, Note_input);
                ba.setAccount(account_tf.getText());
                ba.setAccount_number(account_number_tf.getText());
                ba.setAddress(address_tf.getText());
                ba.setAlias(alias_tf.getText());
                ba.setPhone(Phone_tf.getText());
                ba.setPIN(PIN_tf.getText());
                ba.setSwift(Swift_tf.getText());
                ba.setType(type_mb.getText());
                set_Date_con.setText(ba.getSetUpDate());
                Main.user.add_password(ba);
                add_list(choice_list,mid_list_items,ba);
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
    public static void display_bankaccount(ListView<Password> choice_list, ObservableList<Password> mid_list_items,Button add_button,AnchorPane main_page,AnchorPane bottom_page, BankAccount bankAccount) {
        pre_set_bankaccount();
        main_page.getChildren().clear();
        main_page.getChildren().addAll(set_Date_con,type_tf,set_Date_la,name_tf,account_tf,alias_tf,account_number_tf,PIN_tf,Swift_tf,Phone_tf,address_tf,Note_tf,name,account,type,alias,account_number,PIN,Swift,Phone,address,Note,title);
        name_tf.setEditable(false);
        account_tf.setEditable(false);
        type_tf.setEditable(false);
        alias_tf.setEditable(false);
        account_number_tf.setEditable(false);
        PIN_tf.setEditable(false);
        Swift_tf.setEditable(false);
        Phone_tf.setEditable(false);
        address_tf.setEditable(false);
        Note_tf.setEditable(false);

        //这里的细节很重要！
        name_tf.setText(bankAccount.getname());
        account_tf.setText(bankAccount.getAccount());
        type_tf.setText(bankAccount.getType());
        alias_tf.setText(bankAccount.getAlias());
        account_number_tf.setText(bankAccount.getAccount_number());
        PIN_tf.setText(bankAccount.getPIN());
        Swift_tf.setText(bankAccount.getSwift());
        Phone_tf.setText(bankAccount.getPhone());
        address_tf.setText(bankAccount.getAddress());
        Note_tf.setText(bankAccount.getNote());

        AnchorPane.setLeftAnchor(type_tf,250.0);
        AnchorPane.setTopAnchor(type_tf,242.0);

        Button change = new Button("编辑");
        Button delete = new Button("删除");

        change.setOnAction((ActionEvent ae) -> {
            bottom_page.getChildren().removeAll(change, delete);
            main_page.getChildren().clear();
            pre_set_bankaccount();
            add_button.setDisable(true);
            choice_list.setDisable(true);
            main_page.getChildren().addAll(set_Date_con,set_Date_la,name_tf,account_tf,type_mb,alias_tf,account_number_tf,PIN_tf,Swift_tf,Phone_tf,address_tf,Note_tf,name,account,type,alias,account_number,PIN,Swift,Phone,address,Note,title);

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
                bankAccount.setName(name_tf.getText());
                bankAccount.setAccount(account_tf.getText());
                bankAccount.setType(type_mb.getText());
                bankAccount.setAccount_number(account_number_tf.getText());
                bankAccount.setAddress(address_tf.getText());
                bankAccount.setAlias(alias_tf.getText());
                bankAccount.setPhone(Phone_tf.getText());
                bankAccount.setPIN(PIN_tf.getText());
                bankAccount.setSwift(Swift_tf.getText());
                bankAccount.setNote(Note_tf.getText());

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

            name_tf.setText(bankAccount.getname());
            account_tf.setText(bankAccount.getAccount());
            type_tf.setText(bankAccount.getType());
            alias_tf.setText(bankAccount.getAlias());
            account_number_tf.setText(bankAccount.getAccount_number());
            PIN_tf.setText(bankAccount.getPIN());
            Swift_tf.setText(bankAccount.getSwift());
            Phone_tf.setText(bankAccount.getPhone());
            address_tf.setText(bankAccount.getAddress());
            Note_tf.setText(bankAccount.getNote());
            choice_list.setItems(mid_list_items);
        });

        delete.setOnAction((ActionEvent ae1)->{
            bottom_page.getChildren().removeAll(change, delete);
            Main.user.all_passwords.remove(bankAccount);
            mid_list_items.remove(bankAccount);
            choice_list.setItems(mid_list_items);
            Main.back_up.push(bankAccount);
        });

        AnchorPane.setBottomAnchor(delete,5.0);
        AnchorPane.setRightAnchor(delete,166.0);
        bottom_page.getChildren().addAll(delete,change);
        AnchorPane.setBottomAnchor(change,5.0);
        AnchorPane.setRightAnchor(change,100.0);
    }
}

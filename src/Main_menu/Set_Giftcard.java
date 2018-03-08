package Main_menu;

import Util.GiftCard;
import Util.Password;
import first_set.Main;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class Set_Giftcard {
    private static TextField name_tf = new TextField();
    private static TextField memberName_tf = new TextField();
    private static TextField memberID_tf = new TextField();
    private static TextField PIN_tf = new TextField();
    private static TextField memberID_att_tf = new TextField();
    private static TextField In_date_tf = new TextField();
    private static TextField Phone_tf = new TextField();
    private static TextField site_tf = new TextField();

    private static Label name = new Label("公司名称");
    private static Label memberName = new Label("会员姓名");
    private static Label memberID = new Label("会员号");
    private static Label PIN = new Label("PIN");
    private static Label memberID_att = new Label("附加会员号");
    private static Label In_date = new Label("入会日期");
    private static Label Phone = new Label("电话号");
    private static Label site = new Label("网站");
    private static Label Note = new Label("备注");
    private static Label title = new Label("奖励活动");

    private static Label set_Date_la = new Label("创建日期");
    private static Label set_Date_con = new Label();

    private static TextArea Note_tf = new TextArea();
    private static void pre_set_giftcard() {
        name_tf.setEditable(true);
        memberName_tf.setEditable(true);
        memberID_tf.setEditable(true);
        PIN_tf.setEditable(true);
        memberID_att_tf.setEditable(true);
        In_date_tf.setEditable(true);
        Phone_tf.setEditable(true);
        site_tf.setEditable(true);
        Note_tf.setEditable(true);

        name_tf.setText("");
        memberName_tf.setText("");
        memberID_tf.setText("");
        PIN_tf.setText("");
        memberID_att_tf.setText("");
        In_date_tf.setText("");
        Phone_tf.setText("");
        site_tf.setText("");
        Note_tf.setText("");

        name_tf.setStyle("-fx-background-color: white");
        memberName_tf.setStyle("-fx-background-color: white");
        memberID_tf.setStyle("-fx-background-color: white");
        PIN_tf.setStyle("-fx-background-color: white");
        memberID_att_tf.setStyle("-fx-background-color: white");
        In_date_tf.setStyle("-fx-background-color: white");
        Phone_tf.setStyle("-fx-background-color: white");
        site_tf.setStyle("-fx-background-color: white");
        Note_tf.setStyle("-fx-background-color: white");

        name.setStyle("-fx-text-fill:#707070");
        memberName.setStyle("-fx-text-fill:#707070");
        memberID.setStyle("-fx-text-fill:#707070");
        PIN.setStyle("-fx-text-fill:#707070");
        memberID_att.setStyle("-fx-text-fill:#707070");
        In_date.setStyle("-fx-text-fill:#707070");
        Phone.setStyle("-fx-text-fill:#707070");
        site.setStyle("-fx-text-fill:#707070");
        Note.setStyle("-fx-text-fill:#707070");
        set_Date_la.setStyle("-fx-text-fill:#707070");
        set_Date_con.setStyle("-fx-text-fill:#707070");

        name.setFont(new Font(15.0));
        memberName.setFont(new Font(15.0));
        memberID.setFont(new Font(15.0));
        PIN.setFont(new Font(15.0));
        memberID_att.setFont(new Font(15.0));
        In_date.setFont(new Font(15.0));
        Phone.setFont(new Font(15.0));
        site.setFont(new Font(15.0));
        Note.setFont(new Font(15.0));
        title.setFont(new Font(15.0));
        set_Date_la.setFont(new Font(15.0));
        set_Date_con.setFont(new Font(15.0));

        AnchorPane.setRightAnchor(name,437.0);
        AnchorPane.setRightAnchor(memberName,437.0);
        AnchorPane.setRightAnchor(memberID,437.0);
        AnchorPane.setRightAnchor(PIN,437.0);
        AnchorPane.setRightAnchor(memberID_att,437.0);
        AnchorPane.setRightAnchor(In_date,437.0);
        AnchorPane.setRightAnchor(Phone,437.0);
        AnchorPane.setRightAnchor(site,437.0);
        AnchorPane.setRightAnchor(Note,437.0);
        AnchorPane.setRightAnchor(set_Date_la,437.0);

        AnchorPane.setTopAnchor(name,162.0);
        AnchorPane.setTopAnchor(memberName,190.0);
        AnchorPane.setTopAnchor(memberID,218.0);
        AnchorPane.setTopAnchor(PIN,246.0);
        AnchorPane.setTopAnchor(memberID_att,273.0);
        AnchorPane.setTopAnchor(In_date,302.0);
        AnchorPane.setTopAnchor(Phone,330.0);
        AnchorPane.setTopAnchor(site,358.0);
        AnchorPane.setTopAnchor(Note,386.0);
        AnchorPane.setTopAnchor(set_Date_la,552.0);

        AnchorPane.setLeftAnchor(name_tf,250.0);
        AnchorPane.setLeftAnchor(memberName_tf,250.0);
        AnchorPane.setLeftAnchor(memberID_tf,250.0);
        AnchorPane.setLeftAnchor(PIN_tf,250.0);
        AnchorPane.setLeftAnchor(memberID_att_tf,250.0);
        AnchorPane.setLeftAnchor(In_date_tf,250.0);
        AnchorPane.setLeftAnchor(Phone_tf,250.0);
        AnchorPane.setLeftAnchor(site_tf,250.0);
        AnchorPane.setLeftAnchor(Note_tf,250.0);
        AnchorPane.setLeftAnchor(set_Date_con,250.0);

        AnchorPane.setTopAnchor(name_tf,158.0);
        AnchorPane.setTopAnchor(memberName_tf,186.0);
        AnchorPane.setTopAnchor(memberID_tf,214.0);
        AnchorPane.setTopAnchor(PIN_tf,242.0);
        AnchorPane.setTopAnchor(memberID_att_tf,269.0);
        AnchorPane.setTopAnchor(In_date_tf,298.0);
        AnchorPane.setTopAnchor(Phone_tf,327.0);
        AnchorPane.setTopAnchor(site_tf,354.0);
        AnchorPane.setTopAnchor(Note_tf,382.0);
        AnchorPane.setTopAnchor(set_Date_con,552.0);
        Note_tf.setPrefSize(350,138);

        title.fontProperty().setValue(new Font("System",20));
        title.setLayoutX(244.0);
        title.setLayoutY(94.0);
        AnchorPane.setTopAnchor(title,64.0);
        AnchorPane.setLeftAnchor(title,243.0);
        AnchorPane.setRightAnchor(title,255.0);
        AnchorPane.setBottomAnchor(title,575.0);
    }
    public static void set_Giftcard(ListView<Password> choice_list, ObservableList<Password> mid_list_items, Button add_button, AnchorPane main_page, AnchorPane bottom_page) {
        GlobalMenu.GiftMenuItem.setOnAction((ActionEvent event1)->{
            main_page.getChildren().clear();
            pre_set_giftcard();
            add_button.setDisable(true);
            choice_list.setDisable(true);
            main_page.getChildren().addAll(name,name_tf,memberName,memberID,PIN,memberID_att,In_date,Phone,site,memberName_tf,memberID_tf,PIN_tf,memberID_att_tf,In_date_tf,Phone_tf,site_tf,Note_tf,Note,title);

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
                    name_input = "奖励信息";
                }
                if (Note_input.equals("")) {
                    Note_input = "";
                }
                GiftCard gc = new GiftCard(name_input, Note_input);
                gc.setIn_date(In_date_tf.getText());
                gc.setMemberID(memberID_tf.getText());
                gc.setMemberID_att(memberID_att_tf.getText());
                gc.setMemberName(memberName_tf.getText());
                gc.setPhone(Phone_tf.getText());
                gc.setPIN(PIN_tf.getText());
                gc.setSite(site_tf.getText());
                set_Date_con.setText(gc.getSetUpDate());
                Main.user.add_password(gc);
                Main.save();
                add_list(choice_list,mid_list_items,gc);
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
    public static void display_giftcard(ListView<Password> choice_list, ObservableList<Password> mid_list_items,Button add_button,AnchorPane main_page,AnchorPane bottom_page, GiftCard giftCard) {
        pre_set_giftcard();
        main_page.getChildren().clear();
        set_Date_con.setText(giftCard.getSetUpDate());
        main_page.getChildren().addAll(set_Date_con,set_Date_la,name_tf,memberName,memberID,PIN,memberID_att,In_date,Phone,site,memberName_tf,memberID_tf,PIN_tf,memberID_att_tf,In_date_tf,Phone_tf,site_tf,Note_tf,name,Note,title);
        name_tf.setEditable(false);
        memberName_tf.setEditable(false);
        memberID_tf.setEditable(false);
        PIN_tf.setEditable(false);
        memberID_att_tf.setEditable(false);
        In_date_tf.setEditable(false);
        Phone_tf.setEditable(false);
        site_tf.setEditable(false);
        Note_tf.setEditable(false);

        //这里的细节很重要！
        name_tf.setText(giftCard.getname());
        PIN_tf.setText(giftCard.getPIN());
        Phone_tf.setText(giftCard.getPhone());
        Note_tf.setText(giftCard.getNote());
        In_date_tf.setText(giftCard.getIn_date());
        memberID_tf.setText(giftCard.getMemberID());
        memberID_att_tf.setText(giftCard.getMemberID_att());
        memberName_tf.setText(giftCard.getMemberName());
        site_tf.setText(giftCard.getSite());

        Button change = new Button("编辑");
        Button delete = new Button("删除");

        change.setOnAction((ActionEvent ae) -> {
            bottom_page.getChildren().removeAll(change, delete);
            main_page.getChildren().clear();
            pre_set_giftcard();
            add_button.setDisable(true);
            choice_list.setDisable(true);
            main_page.getChildren().addAll(set_Date_con,set_Date_la,name_tf,memberName,memberID,PIN,memberID_att,In_date,Phone,site,memberName_tf,memberID_tf,PIN_tf,memberID_att_tf,In_date_tf,Phone_tf,site_tf,Note_tf,name,Note,title);

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
                giftCard.setName(name_tf.getText());
                giftCard.setIn_date(In_date_tf.getText());
                giftCard.setMemberID(memberID_tf.getText());
                giftCard.setMemberID_att(memberID_att_tf.getText());
                giftCard.setMemberName(memberName_tf.getText());
                giftCard.setPhone(Phone_tf.getText());
                giftCard.setPIN(PIN_tf.getText());
                giftCard.setSite(site_tf.getText());
                giftCard.setNote(Note_tf.getText());
                Main.user.all_passwords.remove(giftCard);
                Main.user.all_passwords.add(giftCard);
                Main.save();
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

            name_tf.setText(giftCard.getname());
            PIN_tf.setText(giftCard.getPIN());
            Phone_tf.setText(giftCard.getPhone());
            Note_tf.setText(giftCard.getNote());
            In_date_tf.setText(giftCard.getIn_date());
            memberID_tf.setText(giftCard.getMemberID());
            memberID_att_tf.setText(giftCard.getMemberID_att());
            memberName_tf.setText(giftCard.getMemberName());
            site_tf.setText(giftCard.getSite());
            choice_list.setItems(mid_list_items);
        });

        delete.setOnAction((ActionEvent ae1)->{
            bottom_page.getChildren().removeAll(change, delete);
            Main.user.all_passwords.remove(giftCard);
            Main.save();
            mid_list_items.remove(giftCard);
            choice_list.setItems(mid_list_items);
            Main.back_up.push(giftCard);
        });

        AnchorPane.setBottomAnchor(delete,5.0);
        AnchorPane.setRightAnchor(delete,166.0);
        bottom_page.getChildren().addAll(delete,change);
        AnchorPane.setBottomAnchor(change,5.0);
        AnchorPane.setRightAnchor(change,100.0);
    }
}

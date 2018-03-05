package Main_menu;

import Util.BankAccount;
import Util.Password;
import first_set.Main;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class Set_Main {
    private static TextField main_password_tf = new TextField();
    private static Label main_password = new Label("主密码");
    private static Label set_Main_la = new Label("创建日期");
    private static Label set_Main_con = new Label();

    private static Label title = new Label("主密码");

    private static void pre_set_main() {
        main_password_tf.setEditable(true);
        main_password_tf.setText("");
        main_password_tf.setStyle("-fx-background-color: white");
        main_password.setStyle("-fx-text-fill:#707070");
        set_Main_la.setStyle("-fx-text-fill:#707070");
        set_Main_con.setStyle("-fx-text-fill:#707070");
        main_password.setFont(new Font(15.0));
        set_Main_la.setFont(new Font(15.0));
        set_Main_con.setFont(new Font(15.0));

        AnchorPane.setRightAnchor(main_password,437.0);
        AnchorPane.setRightAnchor(set_Main_la,437.0);
        AnchorPane.setRightAnchor(set_Main_con,437.0);

        AnchorPane.setTopAnchor(main_password,162.0);
        AnchorPane.setTopAnchor(set_Main_la,218.0);
        AnchorPane.setTopAnchor(set_Main_con,246.0);

        AnchorPane.setLeftAnchor(main_password_tf,250.0);
        AnchorPane.setLeftAnchor(set_Main_con,250.0);

        AnchorPane.setTopAnchor(main_password_tf,158.0);
        AnchorPane.setTopAnchor(set_Main_con,246.0);

        title.fontProperty().setValue(new Font("System",20));
        title.setLayoutX(244.0);
        title.setLayoutY(94.0);
        AnchorPane.setTopAnchor(title,64.0);
        AnchorPane.setLeftAnchor(title,243.0);
        AnchorPane.setRightAnchor(title,255.0);
        AnchorPane.setBottomAnchor(title,575.0);
    }
    private static void add_list(ListView<Password> choice_list, ObservableList<Password> mid_list_items, Password password) {
        mid_list_items.add(password);
        choice_list.setItems(mid_list_items);
    }
    public static void display_main(ListView<Password> choice_list, ObservableList<Password> mid_list_items,Button add_button,AnchorPane main_page,AnchorPane bottom_page, Password password) {
        pre_set_main();
        main_page.getChildren().clear();
        main_page.getChildren().addAll(main_password_tf,main_password,set_Main_la,set_Main_con,title);
        main_password_tf.setEditable(false);

        //这里的细节很重要！
        main_password_tf.setText("********");
//        set_Main_con.setText(password.getSetUpDate());

        Button change = new Button("编辑");

        change.setOnAction((ActionEvent ae) -> {
            bottom_page.getChildren().removeAll(change);
            main_page.getChildren().clear();
            pre_set_main();
            add_button.setDisable(true);
            choice_list.setDisable(true);
            main_page.getChildren().addAll(main_password_tf,main_password,set_Main_la,set_Main_con,title);

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
                Main.user.setMain_password(main_password_tf.getText());

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

            main_password_tf.setText("********");
            choice_list.setItems(mid_list_items);
        });

        bottom_page.getChildren().addAll(change);
        AnchorPane.setBottomAnchor(change,5.0);
        AnchorPane.setRightAnchor(change,100.0);
    }



}

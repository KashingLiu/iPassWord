package Main_menu;

import Util.AesCtr;
import Util.Password;
import first_set.Main;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class Set_Main {
    private static TextField main_password_tf = new TextField();
    private static Label main_password = new Label("主密码");
    private static Label set_Main_la = new Label("创建日期");
    private static Label set_Main_con = new Label();
    private static Label title = new Label("主密码");

    private static Image see_1 = new Image("Util/icon/see_before.png");
    private static Image see_2 = new Image("Util/icon/see_after.png");
    private static Image clip = new Image("Util/icon/clip.png");
    private static Image out = new Image("Util/icon/safe.png");

    private static void pre_set_main() {
        main_password_tf.setEditable(false);
        main_password_tf.setText("********");
        main_password_tf.setStyle("-fx-background-color: white");
        main_password.setStyle("-fx-text-fill:#707070");
        set_Main_la.setStyle("-fx-text-fill:#707070");
        set_Main_con.setStyle("-fx-text-fill:#707070");
        main_password.setFont(new Font(15.0));
        set_Main_la.setFont(new Font(15.0));
        set_Main_con.setFont(new Font(15.0));

        AnchorPane.setRightAnchor(main_password,437.0);
        AnchorPane.setRightAnchor(set_Main_la,437.0);

        AnchorPane.setTopAnchor(main_password,162.0);
        AnchorPane.setTopAnchor(set_Main_la,246.0);

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

    public static void display_main(ListView<Password> choice_list, ObservableList<Password> mid_list_items,Button add_button,AnchorPane main_page,AnchorPane bottom_page) {
        bottom_page.getChildren().clear();

        main_page.getChildren().clear();
        pre_set_main();
        set_Main_con.setText(Main.user.main.getSetUpDate());
        ImageView imageView = new ImageView();
        ImageView clipboard = new ImageView(clip);
        imageView.setImage(see_1);
        imageView.setFitWidth(16);
        imageView.setFitHeight(16);
        imageView.hoverProperty().addListener((observable -> {
            if (imageView.isHover()) {
                main_password_tf.setText(AesCtr.decrypt(Main.user.getMain_password()));
                imageView.setImage(see_2);
            } else {
                main_password_tf.setText("********");
                imageView.setImage(see_1);
            }
        }));

        clipboard.setFitHeight(16);
        clipboard.setFitWidth(16);
        clipboard.setOnMouseClicked((event -> {
            Clipboard clipboard1 = Clipboard.getSystemClipboard();
            ClipboardContent cc = new ClipboardContent();
            cc.putString(AesCtr.decrypt(Main.user.getMain_password()));
            clipboard1.setContent(cc);
        }));
        main_page.getChildren().addAll(imageView,clipboard,main_password_tf,main_password,set_Main_la,set_Main_con,title);

        AnchorPane.setTopAnchor(imageView,160.0);
        AnchorPane.setLeftAnchor(imageView,500.0);
        AnchorPane.setTopAnchor(clipboard,160.0);
        AnchorPane.setLeftAnchor(clipboard,520.0);

        Button change = new Button("编辑");

        change.setOnAction((ActionEvent ae) -> {
            bottom_page.getChildren().removeAll(change);
            main_page.getChildren().clear();
            pre_set_main();
            main_password_tf.setEditable(true);
            main_password_tf.setText(AesCtr.decrypt(Main.user.getMain_password()));
            add_button.setDisable(true);
            choice_list.setDisable(true);

            ImageView safe = new ImageView(out);
            safe.setFitWidth(23);
            safe.setFitHeight(23);
            AnchorPane.setTopAnchor(safe,160.0);
            AnchorPane.setLeftAnchor(safe,500.0);
            safe.setOnMouseClicked((event -> {
                main_password_tf.setText(Main.produce());
            }));

            main_page.getChildren().addAll(safe,main_password_tf,main_password,set_Main_la,set_Main_con,title);

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
                Main.user.change_password(AesCtr.encrypt(main_password_tf.getText()));
                Main.save();
                add_button.setDisable(false);
                choice_list.setDisable(false);
                main_page.getChildren().clear();
                bottom_page.getChildren().removeAll(ok,cancel);
            });
            bottom_page.getChildren().addAll(cancel,ok);
            AnchorPane.setBottomAnchor(ok,5.0);
            AnchorPane.setRightAnchor(ok,100.0);
            choice_list.setItems(mid_list_items);
        });

        bottom_page.getChildren().addAll(change);
        AnchorPane.setBottomAnchor(change,5.0);
        AnchorPane.setRightAnchor(change,100.0);
//        bottom_page.getChildren().addAll(add_button, change);
    }
}

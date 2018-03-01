package Main_menu;

import Util.Password;
import Util.WirelessRouter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Callback;

import java.util.ArrayList;

public class Controller {

    @FXML
    //在左边的所有项目那里
    public ListView<String> list_view;
    public Button add_button;
    public AnchorPane main_page;
    public AnchorPane bottom_page;
    public ListView<Password> choice_list;

    private final Image login_lock  = new Image("./Util/icon/lock_login.png");
    private Image[] left_list_Image = {login_lock/*,two,three*/};

    private final Image router = new Image("./Util/icon/4.png");
//    private Image[] mid_list_Image = {};

    public ArrayList<Password> all_password = new ArrayList<>(10);
    public ObservableList<Password> mid_list_items;

    @FXML
    //初始化
    public void initialize() {

        //设置左边的列表
        ObservableList<String> left_list_items = FXCollections.observableArrayList (
                "所有项目"/*, " ", " "*/);
        list_view.setItems(left_list_items);

        list_view.setCellFactory(param -> new ListCell<String>() {
            private ImageView imageView = new ImageView();
            @Override
            public void updateItem(String name, boolean empty) {
                super.updateItem(name, empty);
                //设置左面所有项目那个图片的长和宽
                imageView.setFitHeight(20.0);
                imageView.setFitWidth(20.0);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    if(name.equals("所有项目"))
                        imageView.setImage(left_list_Image[0]);
//                    else if(name.equals("APPLE"))
//                        imageView.setImage(listOfImages[1]);
//                    else if(name.equals("TWITTER"))
//                        imageView.setImage(listOfImages[2]);
                    setText(name);
                    setGraphic(imageView);
                }
                setHeight(1.0);     //？？？
            }
        });

        mid_list_items = FXCollections.observableArrayList();
        choice_list.setItems(mid_list_items);
        choice_list.setCellFactory(param -> new ListCell<Password>() {
            private ImageView imageView = new ImageView();
            @Override
            public void updateItem(Password pwd, boolean empty) {
                super.updateItem(pwd, empty);
                AnchorPane cellpane = new AnchorPane();

                //设置左面所有项目那个图片的长和宽
                imageView.setFitHeight(35.0);
                imageView.setFitWidth(35.0);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                    setHeight(15.0);
                } else {
                    if(pwd.tag.equals("WiFi")) {
                        imageView.setImage(router);
                        Text name = new Text(pwd.name);
                        Text title = new Text("无线路由器");
                        cellpane.getChildren().addAll(imageView,title,name);
                        cellpane.setPrefSize(274.0,40.0);
                        AnchorPane.setLeftAnchor(imageView,25.0);
                        AnchorPane.setTopAnchor(imageView,3.0);
                        title.setFont(Font.font(null, FontWeight.BOLD, 15));
                        AnchorPane.setLeftAnchor(title,95.0);
                        AnchorPane.setTopAnchor(title,3.5);
                        name.setFont(Font.font(null,13));
                        AnchorPane.setLeftAnchor(name,95.0);
                        AnchorPane.setTopAnchor(name,23.0);
                        setGraphic(cellpane);
                    }
//                        imageView.setImage(router);
//                    else if(name.equals("APPLE"))
//                        imageView.setImage(listOfImages[1]);
//                    else if(name.equals("TWITTER"))
//                        imageView.setImage(listOfImages[2]);
//                    setText(pwd.name);
//                    setGraphic(imageView);
                }
            }
        });

    }

    public void add_list(Password password) {
        choice_list.setItems(null);
        mid_list_items.add(password);
        choice_list.setItems(mid_list_items);
    }

    @FXML
    //这是右下角的那个按钮
    public void press_button (ActionEvent event) throws Exception {
        //在按钮上方添加一个弹出栏
        set_WiFi();
        GlobalMenu.getInstance().show(add_button, Side.TOP,0,0);
    }

    public void set_WiFi() {
        GlobalMenu.WiFiMenuItem.setOnAction((ActionEvent event1)->{
            TextField title = new TextField("Wireless Router");
            Label name = new Label("全名");               //全名
            Label Password = new Label("无线网络密码");    //无线网络密码
            Label ServerIP = new Label("服务器/IP地址");   //服务器/IP地址
            Label SSID = new Label("网络名称");            //网络名称
            Label security = new Label("安全性");         //安全性
            Label Password_add = new Label("附加密码");    //附加密码
            Label Note = new Label("添加备注");
            TextField name_tf = new TextField();
            PasswordField Password_tf = new PasswordField();
            TextField ServerIP_tf = new TextField();
            TextField SSID_tf = new TextField();
            MenuButton security_tf = new MenuButton();
            TextField Password_add_tf = new TextField();
            TextArea Note_tf = new TextArea();
            name_tf.setStyle("-fx-background-color: white");
            Password_tf.setStyle("-fx-background-color: white");
            ServerIP_tf.setStyle("-fx-background-color: white");
            SSID_tf.setStyle("-fx-background-color: white");
            security_tf.setStyle("-fx-background-color: white");
            Password_add_tf.setStyle("-fx-background-color: white");
            Note_tf.setStyle("-fx-background-color: white");

            name.setStyle("-fx-text-fill:#707070");
            Password.setStyle("-fx-text-fill:#707070");
            ServerIP.setStyle("-fx-text-fill:#707070");
            SSID.setStyle("-fx-text-fill:#707070");
            security.setStyle("-fx-text-fill:#707070");
            Password_add.setStyle("-fx-text-fill:#707070");
            Note.setStyle("-fx-text-fill:#707070");

            name.setFont(new Font(15.0));
            Password.setFont(new Font(15.0));
            ServerIP.setFont(new Font(15.0));
            SSID.setFont(new Font(15.0));
            security.setFont(new Font(15.0));
            Password_add.setFont(new Font(15.0));
            Note.setFont(new Font(15.0));
            AnchorPane.setRightAnchor(name,437.0);
            AnchorPane.setRightAnchor(Password,437.0);
            AnchorPane.setRightAnchor(ServerIP,437.0);
            AnchorPane.setRightAnchor(SSID,437.0);
            AnchorPane.setRightAnchor(security,437.0);
            AnchorPane.setRightAnchor(Password_add,437.0);
            AnchorPane.setRightAnchor(Note,437.0);
            AnchorPane.setTopAnchor(name,162.0);
            AnchorPane.setTopAnchor(SSID,190.0);
            AnchorPane.setTopAnchor(Password,218.0);
            AnchorPane.setTopAnchor(security,246.0);
            AnchorPane.setTopAnchor(ServerIP,274.0);
            AnchorPane.setTopAnchor(Password_add,302.0);
            AnchorPane.setTopAnchor(Note,330.0);
            AnchorPane.setLeftAnchor(name_tf,250.0);
            AnchorPane.setLeftAnchor(Password_tf,250.0);
            AnchorPane.setLeftAnchor(ServerIP_tf,250.0);
            AnchorPane.setLeftAnchor(SSID_tf,250.0);
            AnchorPane.setLeftAnchor(security_tf,250.0);
            AnchorPane.setLeftAnchor(Password_add_tf,250.0);
            AnchorPane.setLeftAnchor(Note_tf,250.0);
            AnchorPane.setTopAnchor(name_tf,158.0);
            AnchorPane.setTopAnchor(SSID_tf,186.0);
            AnchorPane.setTopAnchor(Password_tf,214.0);
            AnchorPane.setTopAnchor(security_tf,242.0);
            AnchorPane.setTopAnchor(ServerIP_tf,271.0);
            AnchorPane.setTopAnchor(Password_add_tf,298.0);
            AnchorPane.setTopAnchor(Note_tf,329.0);
            Note_tf.setPrefSize(350,138);

            add_button.setDisable(true);
            title.setStyle("-fx-background-color: white;");
            title.fontProperty().setValue(new Font("System",20));
            title.setLayoutX(244.0);
            title.setLayoutY(94.0);

            AnchorPane.setTopAnchor(title,64.0);
            AnchorPane.setLeftAnchor(title,243.0);
            AnchorPane.setRightAnchor(title,255.0);
            AnchorPane.setBottomAnchor(title,575.0);

            main_page.getChildren().addAll(title,name,Password,ServerIP,SSID,security,Note,Password_add,name_tf,SSID_tf,Password_tf,security_tf,ServerIP_tf,Password_add_tf,Note_tf);

            Button ok = new Button("保存");
            Button cancel = new Button("取消");

            AnchorPane.setBottomAnchor(cancel,5.0);
            AnchorPane.setRightAnchor(cancel,166.0);

            cancel.setOnAction((ActionEvent action)->{
                main_page.getChildren().removeAll(title,name,Password,ServerIP,SSID,security,Note,Password_add,name_tf,SSID_tf,Password_tf,security_tf,ServerIP_tf,Password_add_tf,Note_tf);
                add_button.setDisable(false);
                bottom_page.getChildren().removeAll(cancel,ok);
            });

            ok.setOnAction((ActionEvent action2)->{
                String name_input = name_tf.getText();
                String Note_input = Note_tf.getText();
                if (name_input.equals("")) {
                    name_input = "无线路由器";
                }
                if (Note_input.equals("")) {
                    Note_input = "";
                }
                Util.WirelessRouter wr = new Util.WirelessRouter(name_input, Note_input);
                wr.setPassword(Password_tf.getText());
                wr.setPassword_add(Password_add_tf.getText());
                wr.setSecurity(security_tf.getText());
                wr.setSSID(SSID_tf.getText());
                wr.setServerIP(ServerIP_tf.getText());
                all_password.add(wr);
                add_list(wr);
                add_button.setDisable(false);
                main_page.getChildren().removeAll(title,name,Password,ServerIP,SSID,security,Note,Password_add,name_tf,SSID_tf,Password_tf,security_tf,ServerIP_tf,Password_add_tf,Note_tf);
                bottom_page.getChildren().removeAll(ok,cancel);
            });
            bottom_page.getChildren().addAll(cancel,ok);
            AnchorPane.setBottomAnchor(ok,5.0);
            AnchorPane.setRightAnchor(ok,100.0);
        });
    }


}

//设置右下角按钮单击后弹出的菜单
class GlobalMenu extends ContextMenu {
    public static MenuItem WiFiMenuItem = new MenuItem("无线路由器");
    private static GlobalMenu INSTANCE = null;
    private GlobalMenu() {
        //构造选项菜单，支持图片和文字同时展示

        //无线网络
        ImageView menuIcon = new ImageView(new Image("./Util/icon/wifi.png"));
        menuIcon.setFitWidth(8*2.5);
        menuIcon.setFitHeight(7*2.5);

        WiFiMenuItem.setGraphic(menuIcon);
//        Button button = new Button("hello");
//        WiFiMenuItem.setOnAction((ActionEvent event)-> {
//            Controller.main_page.getChildren().add(button);
//            AnchorPane.setTopAnchor(button,38.0);
//            AnchorPane.setLeftAnchor(button,44.0);
//        });




//        MenuItem updateMenuItem = new MenuItem("检查更新");
//        MenuItem feedbackMenuItem = new MenuItem("官方论坛");
//        MenuItem aboutMenuItem = new MenuItem("问题与建议");
//        MenuItem companyMenuItem = new MenuItem("关于");

        //弹出菜单有圆角，颜色
        setStyle("-fx-background-radius: 5; -fx-background-color: RGB(243,243,243);");

        getItems().add(WiFiMenuItem);
//        getItems().add(updateMenuItem);
//        getItems().add(companyMenuItem);
//        getItems().add(feedbackMenuItem);
//        getItems().add(aboutMenuItem);
    }

    /**
     * 获取实例
     * @return GlobalMenu
     */
    public static GlobalMenu getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GlobalMenu();
        }
        return INSTANCE;
    }
}
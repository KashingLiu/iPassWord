package Main_menu;

import Util.Password;
import Util.WirelessRouter;
import first_set.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    public ListView<String> list_view;      //左边的所有项目
    public Button add_button;               //+号的按钮
    public AnchorPane main_page;            //右边用来显示信息，和添加信息的面板
    public AnchorPane bottom_page;          //+号所在的下方的面板
    public ListView<Password> choice_list;  //中间的信息列表

    private final Image login_lock  = new Image("./Util/icon/lock_login.png");  //所有项目的图标
    private Image[] left_list_Image = {login_lock/*,two,three*/};                   //图标构成的数组

    private final Image router = new Image("./Util/icon/4.png");                //路由器图标
    private final Image ID = new Image("./Util/icon/id.png");

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
                    setText(name);
                    setGraphic(imageView);
                }
            }
        });

        mid_list_items = FXCollections.observableArrayList();
        mid_list_items.addAll(Main.user.all_passwords);
        choice_list.setItems(mid_list_items);

        choice_list.setCellFactory(param -> new ListCell<Password>() {
            private ImageView imageView = new ImageView();
            @Override
            public void updateItem(Password pwd, boolean empty) {
                super.updateItem(pwd, empty);
                AnchorPane cellpane = new AnchorPane();
                cellpane.setPrefSize(200.0,40.0);
                //设置左面所有项目那个图片的长和宽
                imageView.setFitHeight(35.0);
                imageView.setFitWidth(35.0);
                if (empty) {
                    setGraphic(cellpane);
                } else if(pwd.tag.equals("WiFi")) {
                    Text name = new Text(pwd.name);
                    Text title = new Text("无线路由器");
                    addIcon(cellpane, router, imageView, name, title);
                    setGraphic(cellpane);
                } else if (pwd.tag.equals("main")) {
                    Text name = new Text(pwd.name);
                    Text title = new Text("主密码");
                    addIcon(cellpane, ID, imageView, name, title);
                    setGraphic(cellpane);
                }
            }
        });

        choice_list.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue!=null && Main.user.all_passwords.get(newValue.intValue()).tag.equals("WiFi")) {
                main_page.getChildren().removeAll(WiFi_title,WiFi_name,WiFi_Password,WiFi_ServerIP,WiFi_SSID,WiFi_security,WiFi_Note,WiFi_Password_add,WiFi_name_tf,WiFi_SSID_tf,WiFi_Password_tf,WiFi_security_tf,WiFi_ServerIP_tf,WiFi_Password_add_tf,WiFi_Note_tf);
                display_WiFi((WirelessRouter)Main.user.all_passwords.get(newValue.intValue()));
            }
        });
    }

    //处理中间列表的每一个cell
    private void addIcon(AnchorPane cellpane, Image img, ImageView imageView, Text name,Text title) {
        imageView.setImage(img);
        title.setFont(Font.font(null, FontWeight.BOLD, 15));
        AnchorPane.setLeftAnchor(title,95.0);
        AnchorPane.setTopAnchor(title,3.5);
        name.setFont(Font.font(null,13));
        AnchorPane.setLeftAnchor(name,95.0);
        AnchorPane.setTopAnchor(name,23.0);
        AnchorPane.setLeftAnchor(imageView,25.0);
        AnchorPane.setTopAnchor(imageView,3.0);
        cellpane.getChildren().addAll(imageView, title, name);
    }

    //每当有新的保存时，都要调用add_list
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


    private TextField WiFi_title = new TextField("Wireless Router");
    private Label WiFi_name = new Label("全名");               //全名
    private Label WiFi_Password = new Label("无线网络密码");    //无线网络密码
    private Label WiFi_ServerIP = new Label("服务器/IP地址");   //服务器/IP地址
    private Label WiFi_SSID = new Label("网络名称");            //网络名称
    private Label WiFi_security = new Label("安全性");         //安全性
    private Label WiFi_Password_add = new Label("附加密码");    //附加密码
    private Label WiFi_Note = new Label("添加备注");
    private TextField WiFi_name_tf = new TextField();
    private PasswordField WiFi_Password_tf = new PasswordField();
    private TextField WiFi_ServerIP_tf = new TextField();
    private TextField WiFi_SSID_tf = new TextField();
    private MenuButton WiFi_security_mb = new MenuButton();
    private TextField WiFi_security_tf = new TextField();
    private TextField WiFi_Password_add_tf = new TextField();
    private TextArea WiFi_Note_tf = new TextArea();

    private void pre_set_WiFi() {
        WiFi_name_tf.setStyle("-fx-background-color: white");
        WiFi_Password_tf.setStyle("-fx-background-color: white");
        WiFi_ServerIP_tf.setStyle("-fx-background-color: white");
        WiFi_SSID_tf.setStyle("-fx-background-color: white");
        WiFi_security_mb.setStyle("-fx-background-color: white");
        WiFi_Password_add_tf.setStyle("-fx-background-color: white");
        WiFi_Note_tf.setStyle("-fx-background-color: white");
        WiFi_security_tf.setStyle("-fx-background-color: white");

        WiFi_name.setStyle("-fx-text-fill:#707070");
        WiFi_Password.setStyle("-fx-text-fill:#707070");
        WiFi_ServerIP.setStyle("-fx-text-fill:#707070");
        WiFi_SSID.setStyle("-fx-text-fill:#707070");
        WiFi_security.setStyle("-fx-text-fill:#707070");
        WiFi_Password_add.setStyle("-fx-text-fill:#707070");
        WiFi_Note.setStyle("-fx-text-fill:#707070");

        WiFi_name.setFont(new Font(15.0));
        WiFi_Password.setFont(new Font(15.0));
        WiFi_ServerIP.setFont(new Font(15.0));
        WiFi_SSID.setFont(new Font(15.0));
        WiFi_security.setFont(new Font(15.0));
        WiFi_Password_add.setFont(new Font(15.0));
        WiFi_Note.setFont(new Font(15.0));
        AnchorPane.setRightAnchor(WiFi_name,437.0);
        AnchorPane.setRightAnchor(WiFi_Password,437.0);
        AnchorPane.setRightAnchor(WiFi_ServerIP,437.0);
        AnchorPane.setRightAnchor(WiFi_SSID,437.0);
        AnchorPane.setRightAnchor(WiFi_security,437.0);
        AnchorPane.setRightAnchor(WiFi_Password_add,437.0);
        AnchorPane.setRightAnchor(WiFi_Note,437.0);
        AnchorPane.setTopAnchor(WiFi_name,162.0);
        AnchorPane.setTopAnchor(WiFi_SSID,190.0);
        AnchorPane.setTopAnchor(WiFi_Password,218.0);
        AnchorPane.setTopAnchor(WiFi_security,246.0);
        AnchorPane.setTopAnchor(WiFi_ServerIP,274.0);
        AnchorPane.setTopAnchor(WiFi_Password_add,302.0);
        AnchorPane.setTopAnchor(WiFi_Note,330.0);
        AnchorPane.setLeftAnchor(WiFi_name_tf,250.0);
        AnchorPane.setLeftAnchor(WiFi_Password_tf,250.0);
        AnchorPane.setLeftAnchor(WiFi_ServerIP_tf,250.0);
        AnchorPane.setLeftAnchor(WiFi_SSID_tf,250.0);
        AnchorPane.setLeftAnchor(WiFi_security_mb,250.0);
        AnchorPane.setLeftAnchor(WiFi_Password_add_tf,250.0);
        AnchorPane.setLeftAnchor(WiFi_Note_tf,250.0);
        AnchorPane.setTopAnchor(WiFi_name_tf,158.0);
        AnchorPane.setTopAnchor(WiFi_SSID_tf,186.0);
        AnchorPane.setTopAnchor(WiFi_Password_tf,214.0);
        AnchorPane.setTopAnchor(WiFi_security_mb,242.0);
        AnchorPane.setTopAnchor(WiFi_ServerIP_tf,271.0);
        AnchorPane.setTopAnchor(WiFi_Password_add_tf,298.0);
        AnchorPane.setTopAnchor(WiFi_Note_tf,329.0);
        WiFi_Note_tf.setPrefSize(350,138);
        WiFi_title.setStyle("-fx-background-color: white;");
        WiFi_title.fontProperty().setValue(new Font("System",20));
        WiFi_title.setLayoutX(244.0);
        WiFi_title.setLayoutY(94.0);

        AnchorPane.setTopAnchor(WiFi_title,64.0);
        AnchorPane.setLeftAnchor(WiFi_title,243.0);
        AnchorPane.setRightAnchor(WiFi_title,255.0);
        AnchorPane.setBottomAnchor(WiFi_title,575.0);
    }
    //点击WiFi那个menu之后进入的设置页面
    public void set_WiFi() {
        GlobalMenu.WiFiMenuItem.setOnAction((ActionEvent event1)->{
            pre_set_WiFi();
            add_button.setDisable(true);
            main_page.getChildren().addAll(WiFi_title,WiFi_name,WiFi_Password,WiFi_ServerIP,WiFi_SSID,WiFi_security,WiFi_Note,WiFi_Password_add,WiFi_name_tf,WiFi_SSID_tf,WiFi_Password_tf,WiFi_security_mb,WiFi_ServerIP_tf,WiFi_Password_add_tf,WiFi_Note_tf);

            Button ok = new Button("保存");
            Button cancel = new Button("取消");

            AnchorPane.setBottomAnchor(cancel,5.0);
            AnchorPane.setRightAnchor(cancel,166.0);

            //取消按钮
            cancel.setOnAction((ActionEvent action)->{
                main_page.getChildren().removeAll(WiFi_title,WiFi_name,WiFi_Password,WiFi_ServerIP,WiFi_SSID,WiFi_security,WiFi_Note,WiFi_Password_add,WiFi_name_tf,WiFi_SSID_tf,WiFi_Password_tf,WiFi_security_mb,WiFi_ServerIP_tf,WiFi_Password_add_tf,WiFi_Note_tf);
                add_button.setDisable(false);
                bottom_page.getChildren().removeAll(cancel,ok);
            });

            //保存按钮
            ok.setOnAction((ActionEvent action2)->{
                //获取输入内容->构造一个对象->将对象添加至password数组->更新列表(add_list)->其他构件消失
                String name_input = WiFi_name_tf.getText();
                String Note_input = WiFi_Note_tf.getText();
                if (name_input.equals("")) {
                    name_input = "无线路由器";
                }
                if (Note_input.equals("")) {
                    Note_input = "";
                }
                Util.WirelessRouter wr = new Util.WirelessRouter(name_input, Note_input);
                wr.setPassword(WiFi_Password_tf.getText());
                wr.setPassword_add(WiFi_Password_add_tf.getText());
                wr.setSecurity(WiFi_security_mb.getText());
                wr.setSSID(WiFi_SSID_tf.getText());
                wr.setServerIP(WiFi_ServerIP_tf.getText());
                Main.user.add_password(wr);
                add_list(wr);
                add_button.setDisable(false);
                main_page.getChildren().removeAll(WiFi_title,WiFi_name,WiFi_Password,WiFi_ServerIP,WiFi_SSID,WiFi_security,WiFi_Note,WiFi_Password_add,WiFi_name_tf,WiFi_SSID_tf,WiFi_Password_tf,WiFi_security_mb,WiFi_ServerIP_tf,WiFi_Password_add_tf,WiFi_Note_tf);
                bottom_page.getChildren().removeAll(ok,cancel);
            });
            bottom_page.getChildren().addAll(cancel,ok);
            AnchorPane.setBottomAnchor(ok,5.0);
            AnchorPane.setRightAnchor(ok,100.0);
        });
    }
    private void display_WiFi(WirelessRouter password) {
        pre_set_WiFi();
        main_page.getChildren().addAll(WiFi_title,WiFi_name,WiFi_Password,WiFi_ServerIP,WiFi_SSID,WiFi_security,WiFi_Note,WiFi_Password_add,WiFi_name_tf,WiFi_SSID_tf,WiFi_Password_tf,WiFi_security_tf,WiFi_ServerIP_tf,WiFi_Password_add_tf,WiFi_Note_tf);
        WiFi_name_tf.setEditable(false);
        WiFi_SSID_tf.setEditable(false);
        WiFi_Password_tf.setEditable(false);
        WiFi_security_tf.setEditable(false);
        WiFi_ServerIP_tf.setEditable(false);
        WiFi_Password_add_tf.setEditable(false);
        WiFi_Note_tf.setEditable(false);

        WiFi_name_tf.setText(password.getName());
        WiFi_SSID_tf.setText(password.getSSID());
        WiFi_Password_tf.setText("********");
        WiFi_security_tf.setText(password.getSecurity());
        WiFi_ServerIP_tf.setText(password.getServerIP());
        WiFi_Password_add_tf.setText("********");
        WiFi_Note_tf.setText(password.getNote());

        AnchorPane.setLeftAnchor(WiFi_security_tf,250.0);
        AnchorPane.setTopAnchor(WiFi_security_tf,242.0);

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

        //弹出菜单有圆角，颜色
        setStyle("-fx-background-radius: 5; -fx-background-color: RGB(243,243,243);");

        getItems().add(WiFiMenuItem);
    }

    /**
     * 获取实例
     */
    public static GlobalMenu getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GlobalMenu();
        }
        return INSTANCE;
    }
}
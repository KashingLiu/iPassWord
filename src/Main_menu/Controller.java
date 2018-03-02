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

    private ObservableList<Password> mid_list_items;

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

        //中间列表格子的内容
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

        //点击不同Cell时切换右侧main_page
        choice_list.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue!=null && Main.user.all_passwords.get(newValue.intValue()).tag.equals("WiFi")) {
                Set_WiFi.display_WiFi(main_page,(WirelessRouter)Main.user.all_passwords.get(newValue.intValue()));
            } else if (newValue!=null && Main.user.all_passwords.get(newValue.intValue()).tag.equals("main")) {
                main_page.getChildren().clear();
                System.out.println("main");
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

    @FXML
    //这是右下角的那个按钮
    public void press_button (ActionEvent event) {
        //在按钮上方添加一个弹出栏
        Set_WiFi.set_WiFi(choice_list,mid_list_items,add_button,main_page,bottom_page);
        GlobalMenu.getInstance().show(add_button, Side.TOP,0,0);
    }
}

//设置右下角按钮单击后弹出的菜单
class GlobalMenu extends ContextMenu {
    private static MenuItem WiFiMenuItem = new MenuItem("   无线路由器");
    private static MenuItem DBMenuItem = new MenuItem("   数据库");
    private static MenuItem ServerMenuItem = new MenuItem("   服务器");
    private static MenuItem LoginMenuItem = new MenuItem("   登录信息");
    private static MenuItem BankMenuItem = new MenuItem("   银行账户");
    private static MenuItem AppMenuItem = new MenuItem("   软件许可证");
    private static MenuItem PassMenuItem = new MenuItem("   护照信息");
    private static MenuItem GiftMenuItem = new MenuItem("   奖励活动");
    private static MenuItem VipMenuItem = new MenuItem("   会员信息");
    private static GlobalMenu INSTANCE = null;
    private GlobalMenu() {
        //构造选项菜单，支持图片和文字同时展示

        //无线网络
        ImageView WiFiIcon = new ImageView(new Image("./Util/icon/wifi_mini.png"));
        WiFiIcon.setFitWidth(8*2.5);
        WiFiIcon.setFitHeight(7*2.5);
        WiFiMenuItem.setGraphic(WiFiIcon);

        //数据库
        ImageView DBIcon = new ImageView(new Image("./Util/icon/database_mini.png"));
        DBIcon.setFitWidth(8*2.5);
        DBIcon.setFitHeight(7*2.5);
        DBMenuItem.setGraphic(DBIcon);

        //服务器
        ImageView ServerIcon = new ImageView(new Image("./Util/icon/server_mini.png"));
        ServerIcon.setFitWidth(8*2.5);
        ServerIcon.setFitHeight(7*2.5);
        ServerMenuItem.setGraphic(ServerIcon);

        //登录信息
        ImageView LoginIcon = new ImageView(new Image("./Util/icon/login_mini.png"));
        LoginIcon.setFitWidth(8*2.5);
        LoginIcon.setFitHeight(7*2.5);
        LoginMenuItem.setGraphic(LoginIcon);

        //银行账户信息
        ImageView BankIcon = new ImageView(new Image("./Util/icon/bankcard_mini.png"));
        BankIcon.setFitWidth(8*2.5);
        BankIcon.setFitHeight(7*2.5);
        BankMenuItem.setGraphic(BankIcon);

        ImageView AppIcon = new ImageView(new Image("./Util/icon/app_mini.png"));
        AppIcon.setFitWidth(8*2.5);
        AppIcon.setFitHeight(8*2.5);
        AppMenuItem.setGraphic(AppIcon);

        ImageView PassIcon = new ImageView(new Image("./Util/icon/passport_mini.png"));
        PassIcon.setFitWidth(8*2.5);
        PassIcon.setFitHeight(8*2.5);
        PassMenuItem.setGraphic(PassIcon);

        ImageView GiftIcon = new ImageView(new Image("./Util/icon/giftcard_mini.png"));
        GiftIcon.setFitWidth(8*2.5);
        GiftIcon.setFitHeight(8*2.5);
        GiftMenuItem.setGraphic(GiftIcon);

        ImageView VipIcon = new ImageView(new Image("./Util/icon/vipcard_mini.png"));
        VipIcon.setFitWidth(8*2.5);
        VipIcon.setFitHeight(8*2.5);
        VipMenuItem.setGraphic(VipIcon);

        //弹出菜单有圆角，颜色
        setStyle("-fx-background-radius: 5; -fx-background-color: RGB(243,243,243);");

        getItems().addAll(WiFiMenuItem,DBMenuItem,ServerMenuItem,LoginMenuItem,BankMenuItem,AppMenuItem,PassMenuItem,GiftMenuItem,VipMenuItem);
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


//GlobalMenu添加设置项
package Main_menu;

import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

//设置右下角按钮单击后弹出的菜单
class GlobalMenu extends ContextMenu {
    public static MenuItem WiFiMenuItem = new MenuItem("   无线路由器");  //
    public static MenuItem DBMenuItem = new MenuItem("   数据库");  //
    public static MenuItem ServerMenuItem = new MenuItem("   服务器");  //
    public static MenuItem LoginMenuItem = new MenuItem("   登录信息");
    public static MenuItem BankMenuItem = new MenuItem("   银行账户");  //
    public static MenuItem AppMenuItem = new MenuItem("   软件许可证");
    public static MenuItem PassMenuItem = new MenuItem("   护照信息");
    public static MenuItem GiftMenuItem = new MenuItem("   奖励活动"); //
    public static MenuItem VipMenuItem = new MenuItem("   会员信息");
    private static GlobalMenu INSTANCE = null;
    private GlobalMenu() {
        //构造选项菜单，支持图片和文字同时展示

        //无线网络
        ImageView WiFiIcon = new ImageView(new Image("Util/icon/wifi_mini.png"));
        WiFiIcon.setFitWidth(8*2.5);
        WiFiIcon.setFitHeight(7*2.5);
        WiFiMenuItem.setGraphic(WiFiIcon);

        //数据库
        ImageView DBIcon = new ImageView(new Image("Util/icon/database_mini.png"));
        DBIcon.setFitWidth(8*2.5);
        DBIcon.setFitHeight(7*2.5);
        DBMenuItem.setGraphic(DBIcon);

        //服务器
        ImageView ServerIcon = new ImageView(new Image("Util/icon/server_mini.png"));
        ServerIcon.setFitWidth(8*2.5);
        ServerIcon.setFitHeight(7*2.5);
        ServerMenuItem.setGraphic(ServerIcon);

        //登录信息
        ImageView LoginIcon = new ImageView(new Image("Util/icon/login_mini.png"));
        LoginIcon.setFitWidth(8*2.5);
        LoginIcon.setFitHeight(7*2.5);
        LoginMenuItem.setGraphic(LoginIcon);

        //银行账户信息
        ImageView BankIcon = new ImageView(new Image("Util/icon/bankcard_mini.png"));
        BankIcon.setFitWidth(8*2.5);
        BankIcon.setFitHeight(7*2.5);
        BankMenuItem.setGraphic(BankIcon);

        ImageView AppIcon = new ImageView(new Image("Util/icon/app_mini.png"));
        AppIcon.setFitWidth(8*2.5);
        AppIcon.setFitHeight(8*2.5);
        AppMenuItem.setGraphic(AppIcon);

        ImageView PassIcon = new ImageView(new Image("Util/icon/passport_mini.png"));
        PassIcon.setFitWidth(8*2.5);
        PassIcon.setFitHeight(8*2.5);
        PassMenuItem.setGraphic(PassIcon);

        ImageView GiftIcon = new ImageView(new Image("Util/icon/giftcard_mini.png"));
        GiftIcon.setFitWidth(8*2.5);
        GiftIcon.setFitHeight(8*2.5);
        GiftMenuItem.setGraphic(GiftIcon);

        ImageView VipIcon = new ImageView(new Image("Util/icon/vipcard_mini.png"));
        VipIcon.setFitWidth(8*2.5);
        VipIcon.setFitHeight(8*2.5);
        VipMenuItem.setGraphic(VipIcon);

        //弹出菜单有圆角，颜色
        setStyle("-fx-background-radius: 5; -fx-background-color: RGB(243,243,243);");

        getItems().addAll(WiFiMenuItem,DBMenuItem,ServerMenuItem,LoginMenuItem,BankMenuItem,AppMenuItem,PassMenuItem,GiftMenuItem,VipMenuItem);
    }
    public static GlobalMenu getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GlobalMenu();
        }
        return INSTANCE;
    }
}
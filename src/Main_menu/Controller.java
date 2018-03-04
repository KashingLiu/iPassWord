package Main_menu;

import Util.*;
import com.sun.javafx.robot.impl.FXRobotHelper;
import first_set.Main;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.Collator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Controller {
    @FXML
    public ListView<String> list_view;      //左边的所有项目的列表
    public Button add_button;               //+号的按钮
    public Button backup;                   //撤回按钮
    public Button lock;                     //锁定按钮
    public AnchorPane main_page;            //右边用来显示信息，和添加信息的面板
    public AnchorPane bottom_page;          //+号所在的，下方的面板
    public ListView<Password> choice_list;  //中间的信息列表
    public MenuButton sort_button;          //排序的按钮


    private final Image login_lock  = new Image("./Util/icon/lock_login.png");  //所有项目的图标
    private Image[] left_list_Image = {login_lock/*,two,three*/};                   //图标构成的数组

    private final Image router = new Image("./Util/icon/router.png");                //路由器图标
    private final Image ID = new Image("./Util/icon/id.png");
    private final Image database = new Image("./Util/icon/database.png");
    private final Image bankaccount = new Image("./Util/icon/bankaccount.png");
    private final Image server = new Image("./Util/icon/server.png");
    private final Image vip = new Image("./Util/icon/vip.png");
    private final Image gift_card = new Image("./Util/icon/giftcard.png");
    private final Image passport = new Image("./Util/icon/passport.png");
    private final Image software = new Image("./Util/icon/software.png");
    private final Image login = new Image("./Util/icon/login.png");
    private ObservableList<Password> mid_list_items;

    //快速排序
    public static int partition_title(List<Password> array, int lo, int hi){
        Collator cmp = Collator.getInstance(java.util.Locale.CHINA);
        //固定的切分方式
        Password key=array.get(lo);
        while(lo<hi){
            while(cmp.compare(array.get(hi).name.substring(0,1),key.name.substring(0,1))>=0&&hi>lo){
                hi--;
            }
            array.set(lo,array.get(hi));
            while(cmp.compare(key.name.substring(0,1),array.get(lo).name.substring(0,1))>=0&&hi>lo){
                lo++;
            }
            array.set(hi,array.get(lo));
        }
        array.set(hi,key);
        return hi;
    }
    public static int partition_type(List<Password> array, int lo, int hi) {
        Collator cmp = Collator.getInstance(java.util.Locale.CHINA);
        //固定的切分方式
        Password key=array.get(lo);
        while(lo<hi){
            while(cmp.compare(array.get(hi).tag.substring(0,1),key.tag.substring(0,1))>=0&&hi>lo){
                hi--;
            }
            array.set(lo,array.get(hi));
            while(cmp.compare(key.tag.substring(0,1),array.get(lo).tag.substring(0,1))>=0&&hi>lo){
                lo++;
            }
            array.set(hi,array.get(lo));
        }
        array.set(hi,key);
        return hi;
    }
    public static int partition_date(List<Password> array, int lo, int hi) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Password key=array.get(lo);
        Date bt=sdf.parse(key.getSetUpDate());
        Date et=sdf.parse(array.get(hi).getSetUpDate());
        while(lo<hi){
            while(et.before(bt)&&hi>lo){
                hi--;
            }
            array.set(lo,array.get(hi));
            while(et.after(bt)&&hi>lo){
                lo++;
            }
            array.set(hi,array.get(lo));
        }
        array.set(hi,key);
        return hi;
    }
    public static void sort(List<Password> array,int lo ,int hi,String type) throws ParseException{
        if(lo>=hi){
            return ;
        }
        if (type.equals("1"))
        {
            int index=partition_title(array,lo,hi);
            sort(array,lo,index-1,type);
            sort(array,index+1,hi,type);
        } else if (type.equals("2")) {
            int index = partition_type(array,lo,hi);
            sort(array,lo,index-1,type);
            sort(array,index+1,hi,type);
        } else if (type.equals("3")) {
            int index = partition_date(array,lo,hi);
            sort(array,lo,index-1,type);
            sort(array,index+1,hi,type);
        }
    }

    @FXML
    //初始化
    public void initialize() throws ParseException {
        MenuItem im1 = new MenuItem("标题");
        MenuItem im2 = new MenuItem("类别");
        MenuItem im3 = new MenuItem("创建日期");
        MenuItem im4 = new MenuItem("密码强度");
        MenuItem im5 = new MenuItem("显示重复密码");
        sort_button.getItems().addAll(im1,im2,im3,im4,im5);

        im1.setOnAction((ae)->{
            try {
                sort_button.setText("按" + im1.getText() + "排序");
                sort(mid_list_items, 0, mid_list_items.size() - 1, "1");
                sort(Main.user.all_passwords, 0, Main.user.all_passwords.size() - 1, "1");
                choice_list.setItems(mid_list_items);
            } catch (ParseException e) {

            }
        });
        im2.setOnAction((ae)->{
            try {
                sort_button.setText("按"+im2.getText()+"排序");
                sort(mid_list_items,0,mid_list_items.size()-1,"2");
                sort(Main.user.all_passwords, 0, Main.user.all_passwords.size() - 1, "2");
                choice_list.setItems(mid_list_items);
            } catch (ParseException e) {

            }
        });
        im3.setOnAction((ae)->{
            try {
                sort_button.setText("按"+im3.getText()+"排序");
                sort(mid_list_items,0,mid_list_items.size()-1,"3");
                sort(Main.user.all_passwords, 0, Main.user.all_passwords.size() - 1, "3");
                choice_list.setItems(mid_list_items);
            } catch (ParseException e) {

            }
        });
        im4.setOnAction((ae)->{
            sort_button.setText("按"+im4.getText()+"排序");
        });
        im5.setOnAction((ae)->{
            sort_button.setText("按"+im5.getText()+"排序");
        });

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
                } else if (pwd.tag.equals("Database")) {
                    Text name = new Text(pwd.name);
                    Text title = new Text("数据库");
                    addIcon(cellpane, database, imageView, name, title);
                    setGraphic(cellpane);
                } else if (pwd.tag.equals("BankAccount")) {
                    Text name = new Text(pwd.name);
                    Text title = new Text("银行账户");
                    addIcon(cellpane, bankaccount, imageView, name, title);
                    setGraphic(cellpane);
                } else if (pwd.tag.equals("Server")) {
                    Text name = new Text(pwd.name);
                    Text title = new Text("服务器");
                    addIcon(cellpane, server, imageView, name, title);
                    setGraphic(cellpane);
                } else if (pwd.tag.equals("GiftCard")) {
                    Text name = new Text(pwd.name);
                    Text title = new Text("奖励信息");
                    addIcon(cellpane, gift_card, imageView, name, title);
                    setGraphic(cellpane);
                } else if (pwd.tag.equals("Membership")) {
                    Text name = new Text(pwd.name);
                    Text title = new Text("会员信息");
                    addIcon(cellpane, vip, imageView, name, title);
                    setGraphic(cellpane);
                } else if (pwd.tag.equals("Software")) {
                    Text name = new Text(pwd.name);
                    Text title = new Text("软件许可证");
                    addIcon(cellpane, software, imageView, name, title);
                    setGraphic(cellpane);
                } else if (pwd.tag.equals("Passport")) {
                    Text name = new Text(pwd.name);
                    Text title = new Text("护照信息");
                    addIcon(cellpane, passport, imageView, name, title);
                    setGraphic(cellpane);
                } else if (pwd.tag.equals("Login")) {
                    Text name = new Text(pwd.name);
                    Text title = new Text("登录信息");
                    addIcon(cellpane, login, imageView, name, title);
                    setGraphic(cellpane);
                }
            }
        });

        //点击不同Cell时切换右侧main_page
        choice_list.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue!=null && Main.user.all_passwords.get(newValue.intValue()).tag.equals("WiFi")) {
                Set_WiFi.display_WiFi(choice_list,mid_list_items,add_button,main_page,bottom_page,(WirelessRouter)Main.user.all_passwords.get(newValue.intValue()));
            } else if (newValue!=null && Main.user.all_passwords.get(newValue.intValue()).tag.equals("main")) {

                main_page.getChildren().clear();
                bottom_page.getChildren().removeAll();
                System.out.println("main");

            } else if (newValue!=null && Main.user.all_passwords.get(newValue.intValue()).tag.equals("Database")) {
                Set_Database.display_Database(choice_list,mid_list_items,add_button,main_page,bottom_page,(Database)Main.user.all_passwords.get(newValue.intValue()));
            } else if (newValue!=null && Main.user.all_passwords.get(newValue.intValue()).tag.equals("BankAccount")) {
                Set_Bankaccount.display_bankaccount(choice_list,mid_list_items,add_button,main_page,bottom_page,(BankAccount) Main.user.all_passwords.get(newValue.intValue()));
            } else if (newValue!=null && Main.user.all_passwords.get(newValue.intValue()).tag.equals("Server")) {
                Set_server.display_Server(choice_list,mid_list_items,add_button,main_page,bottom_page,(Server) Main.user.all_passwords.get(newValue.intValue()));
            } else if (newValue!=null && Main.user.all_passwords.get(newValue.intValue()).tag.equals("Software")) {
                Set_Software.display_software(choice_list,mid_list_items,add_button,main_page,bottom_page,(Software) Main.user.all_passwords.get(newValue.intValue()));
            } else if (newValue!=null && Main.user.all_passwords.get(newValue.intValue()).tag.equals("Passport")) {
                Set_Passport.display_passport(choice_list,mid_list_items,add_button,main_page,bottom_page,(Passport) Main.user.all_passwords.get(newValue.intValue()));
            } else if (newValue!=null && Main.user.all_passwords.get(newValue.intValue()).tag.equals("Membership")) {
                Set_Membership.display_membership(choice_list,mid_list_items,add_button,main_page,bottom_page,(Membership) Main.user.all_passwords.get(newValue.intValue()));
            } else if (newValue!=null && Main.user.all_passwords.get(newValue.intValue()).tag.equals("Login")) {
                Set_Login.display_login(choice_list,mid_list_items,add_button,main_page,bottom_page,(Login) Main.user.all_passwords.get(newValue.intValue()));
            } else if (newValue!=null && Main.user.all_passwords.get(newValue.intValue()).tag.equals("GiftCard")) {
                Set_Giftcard.display_giftcard(choice_list,mid_list_items,add_button,main_page,bottom_page,(GiftCard) Main.user.all_passwords.get(newValue.intValue()));
            } else if (newValue == null || oldValue == null) {
                System.out.println("hello");
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

    @FXML
    //这是右下角的那个按钮
    public void press_button (ActionEvent event) {
        //给那个menulist中的menu添加监听事件
        Set_WiFi.set_WiFi(choice_list,mid_list_items,add_button,main_page,bottom_page);
        Set_Database.set_Database(choice_list,mid_list_items,add_button,main_page,bottom_page);
        Set_Bankaccount.set_bankaccount(choice_list,mid_list_items,add_button,main_page,bottom_page);
        Set_server.set_Server(choice_list,mid_list_items,add_button,main_page,bottom_page);
        Set_Giftcard.set_Giftcard(choice_list,mid_list_items,add_button,main_page,bottom_page);
        Set_Login.set_login(choice_list,mid_list_items,add_button,main_page,bottom_page);
        Set_Membership.set_membership(choice_list,mid_list_items,add_button,main_page,bottom_page);
        Set_Passport.set_passport(choice_list,mid_list_items,add_button,main_page,bottom_page);
        Set_Software.set_software(choice_list,mid_list_items,add_button,main_page,bottom_page);

        //add_button是来源, 在按钮上方添加一个弹出栏
        GlobalMenu.getInstance().show(add_button, Side.TOP,0,0);
    }

    public void press_back_up (ActionEvent event) {
        Password mid = Main.back_up.pop();
        Main.user.all_passwords.add(mid);
        mid_list_items.add(mid);
        choice_list.setItems(mid_list_items);
    }

    public void press_lock (ActionEvent event) {
        Platform.runLater(() -> {
            try {
                ObservableList<Stage> stage = FXRobotHelper.getStages();
                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("../verify/verify.fxml")));
                stage.get(0).setScene(scene);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }
}


//GlobalMenu添加设置项
//编写新的类->annotation/constructor/getter/setter/tag
//Set_class
//加image
//加到cellfactory
//加到press_button
package Util;

public class WirelessRouter extends Password {
//    private String name;            //全名
    private String Password;        //无线网络密码
    private String ServerIP;        //服务器/IP地址
    private String SSID;            //网络名称
    private String security;        //安全性
    private String Password_add;    //附加密码
    public WirelessRouter(String input, String Note) {
        super(input, Note, "WiFi");
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        Password = password;
    }
    public void setPassword_add(String password_add) {
        Password_add = password_add;
    }
    public void setSecurity(String security) {
        this.security = security;
    }
    public void setServerIP(String serverIP) {
        ServerIP = serverIP;
    }
    public void setSSID(String SSID) {
        this.SSID = SSID;
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return Password;
    }
    public String getPassword_add() {
        return Password_add;
    }
    public String getSecurity() {
        return security;
    }
    public String getServerIP() {
        return ServerIP;
    }
    public String getSSID() {
        return SSID;
    }

}

package Util;

public class Login extends Password {
    //name 网站名称
    private String username;        //用户名
    private String password;        //密码
    private String site;            //站点
    public Login(String name, String Note) {
        super(name, Note, "Login");
    }

    public String getUsername() {
        return username;
    }

    public String getname() {
        return name;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}

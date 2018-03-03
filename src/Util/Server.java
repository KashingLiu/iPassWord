package Util;

public class Server extends Password {
    //name 名称
    private String username;
    private String password;
    private String IP;
    private String console_username;
    private String console_password;

    public Server(String name, String Note) {
        super(name, Note, "Server");
    }

    public String getUsername() {
        return username;
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

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getConsole_username() {
        return console_username;
    }

    public void setConsole_username(String console_username) {
        this.console_username = console_username;
    }

    public String getConsole_password() {
        return console_password;
    }

    public void setConsole_password(String console_password) {
        this.console_password = console_password;
    }

    public String getname() {
        return name;
    }
}

package Util;

public class Database extends Password {
    private String type;        //数据库类型
    private String server;      //服务器ip
    private String port;        //端口号
    private String username;
    private String password;
    private String connection_options;
    public Database(String name, String Note) {
        super(name, Note, "Database");
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setConnection_options(String connection_options) {
        this.connection_options = connection_options;
    }
    public void setPort(String port) {
        this.port = port;
    }
    public void setServer(String server) {
        this.server = server;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public String getConnection_options() {
        return connection_options;
    }
    public String getPort() {
        return port;
    }
    public String getServer() {
        return server;
    }
    public String getType() {
        return type;
    }
    public String getUsername() {
        return username;
    }
    public String getname() {
        return name;
    }
}

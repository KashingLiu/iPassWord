package Util;

public class Database extends Password {
    private String type;
    private String server;
    private String port;
    private String database;
    private String username;
    private String password;
    private String connection_options;
    private String alias;
    Database(String name,String Note, String tag) {
        super(name,Note, tag);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setConnection_options(String connection_options) {
        this.connection_options = connection_options;
    }

    public void setDatabase(String database) {
        this.database = database;
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

    public String getAlias() {
        return alias;
    }

    public String getConnection_options() {
        return connection_options;
    }

    public String getDatabase() {
        return database;
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
}

package Util;

import java.io.Serializable;
import java.util.LinkedList;

public class Users implements Serializable {
    private String main_password;   //主密码信息
    public LinkedList<Password> all_passwords = new LinkedList<>();
    public Password main = new Password("主密码","","main");
    public void setMain_password(String main_password) {
        this.main_password = main_password;
        all_passwords.add(main);
    }
    public void change_password(String main_password) {
        this.main_password = main_password;
    }

    public String getMain_password() {
        return main_password;
    }

    public void add_password(Password password) {
        all_passwords.add(password);
    }

}


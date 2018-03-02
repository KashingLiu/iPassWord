package Util;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class Users {
    private String main_password;   //主密码信息
    public LinkedList<Password> all_passwords = new LinkedList<>();

    public void setMain_password(String main_password) {
        this.main_password = main_password;
        Password main = new Password("主密码","","main");
        all_passwords.add(main);
    }

    public String getMain_password() {
        return main_password;
    }

    public void add_password(Password password) {
        all_passwords.add(password);
    }

    public void del_password(Password password) {
        all_passwords.remove(password);
    }
}


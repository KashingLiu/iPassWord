package Util;

public class BankAccount extends Password {
//    private String name;      银行名称
    private String account;         //账户名称
    private String type;            //账户类型
    private String alias;           //银行代号
    private String account_number;  //账号
    private String PIN;             //PIN码
    private String Swift;           //swift代码
    private String Phone;           //分行电话号
    private String address;         //分行地址
    public BankAccount(String name, String Note) {
        super(name,Note,"BankAccount");
    }

    public String getAccount() {
        return account;
    }

    public String getType() {
        return type;
    }

    public String getAlias() {
        return alias;
    }

    public String getAccount_number() {
        return account_number;
    }

    public String getPIN() {
        return PIN;
    }

    public String getSwift() {
        return Swift;
    }

    public String getPhone() {
        return Phone;
    }

    public String getAddress() {
        return address;
    }

    public String getname() {
        return name;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public void setSwift(String swift) {
        Swift = swift;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}

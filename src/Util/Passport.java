package Util;

public class Passport extends Password {
    //name 签发国家
    private String full_name;       //全名
    private String nationality;     //国籍
    private String authority;       //签发机关
    private String birthday;        //出生日期
    private String address;         //出生地
    private String issued_date;     //签发日期
    private String expiry_date;     //有效期
    public Passport(String name, String Note) {
        super(name, Note, "Passport");
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getNationality() {
        return nationality;
    }

    public String getname() {
        return name;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIssued_date() {
        return issued_date;
    }

    public void setIssued_date(String issued_date) {
        this.issued_date = issued_date;
    }

    public String getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(String expiry_date) {
        this.expiry_date = expiry_date;
    }
}

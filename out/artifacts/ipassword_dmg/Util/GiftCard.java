package Util;

public class GiftCard extends Password {
    //name 公司名称
    private String memberName;      //会员姓名
    private String memberID;        //会员号
    private String PIN;             //PIN
    private String memberID_att;    //附加会员号
    private String In_date;         //入会日期
    private String Phone;           //电话号
    private String site;            //网站
    public GiftCard(String name, String Note) {
        super(name, Note, "GiftCard");
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public String getMemberID_att() {
        return memberID_att;
    }

    public void setMemberID_att(String memberID_att) {
        this.memberID_att = memberID_att;
    }

    public String getIn_date() {
        return In_date;
    }

    public void setIn_date(String in_date) {
        In_date = in_date;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String  getname() {
        return name;
    }
}

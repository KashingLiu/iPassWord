package Util;

import java.util.Date;

public class Password {
    private Date date = new Date();
    public String name;
    public String Note;                    //备注
    public String tag;                     //项目标识
    public String SetUpDate;               //添加这个项目的日期
    Password(String name, String Note, String tag) {
        this.name = name;
        this.Note = Note;
        this.SetUpDate = date.toString();
        this.tag = tag;
    }
    public String getNote() {
        return Note;
    }
    public String getSetUpDate() {
        return SetUpDate;
    }
    public String getTag() {
        return tag;
    }
}

package Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Password {
    private Date date = new Date();
    public String name;
    public String Note;                    //备注
    public String tag;                     //项目标识
    public String SetUpDate;               //添加这个项目的日期
    public String lastDate;                 //上次修改日期
    public Password(String name, String Note, String tag) {
        this.name = name;
        this.Note = Note;
        SimpleDateFormat df=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        this.SetUpDate = df.format(date);
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
    public String getLastDate() {
        return lastDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNote(String note) {
        Note = note;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setSetUpDate(String setUpDate) {
        SetUpDate = setUpDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }
}

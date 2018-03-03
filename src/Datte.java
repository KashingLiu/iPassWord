import java.text.SimpleDateFormat;
import java.util.Date;

public class Datte {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=df.format(date);
        System.out.println(time);
    }
}
